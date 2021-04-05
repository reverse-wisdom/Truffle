package com.ssafy.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.pjt.dto.AccountDto;
import com.ssafy.pjt.dto.EventDto;
import com.ssafy.pjt.dto.LoginRequestDto;
import com.ssafy.pjt.service.AccountServiceImpl;
import com.ssafy.pjt.service.TokenProvider;

import io.swagger.annotations.ApiOperation;

/**
 * http://localhost:8000/truffle/swagger-ui.html
 */

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private TokenProvider tokenProvider;

	@Autowired
	private AccountServiceImpl accountService;


	@ApiOperation(value = "로그인")
	@PostMapping("/login")
	private ResponseEntity<Map<String, Object>> login(@RequestBody final LoginRequestDto loginRequestDto) {
		Map<String, Object> resultMap = new HashMap<>();
		AccountDto accountDto = new AccountDto();
		accountDto.setEmail(loginRequestDto.getEmail());
		accountDto.setPassword(loginRequestDto.getPassword());
		try {
			AccountDto loginUser = accountService.login(accountDto);
			if (loginUser != null) {
				String token = tokenProvider.createToken();
				System.out.println(token);
				resultMap.put("access-token", token);
				resultMap.put("message", "SUCCESS");
				resultMap.put("uuid", loginUser.getUuid());
				return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
			} else {
				resultMap.put("message", "FAIL");
			}
		} catch (SQLException e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "회원정보조회", notes = "x-auth-token, email 값 필수")
	@GetMapping("/accountInfo")
	private ResponseEntity<AccountDto> accountInfo(@RequestParam(required = true) final String email,
			HttpServletRequest request) {
		AccountDto accountDto;

		if (tokenProvider.validateToken(request.getHeader("x-auth-token"))) {
			try {
				accountDto = accountService.accountInfo(email);
				return new ResponseEntity<>(accountDto, HttpStatus.OK);
			} catch (SQLException e) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}
		} else {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "회원가입", notes = "uuid값 제외한값으로 입력")
	@PostMapping("/signUp")
	private ResponseEntity<String> signUp(@RequestBody final AccountDto accountDto) {
		
		try {
			boolean result = accountService.signUp(accountDto);
			if (result) {
				return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
			}
		} catch (SQLException e) {
			return new ResponseEntity<>("FAIL", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>("FAIL", HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "회원탈퇴", notes = "x-auth-token, email값 필수")
	@DeleteMapping("/delete")
	private ResponseEntity<String> delete(@RequestParam(required = true) final String email,
			HttpServletRequest request) {
		if (tokenProvider.validateToken(request.getHeader("x-auth-token"))) {
			try {
				boolean result = accountService.delete(email);
				if (result) {
					return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
				}
			} catch (SQLException e) {
				return new ResponseEntity<>("FAIL", HttpStatus.NO_CONTENT);
			}
		} else {
			return new ResponseEntity<>("FAIL", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>("FAIL", HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "회원수정", notes = "x-auth-token, email값 필수, 수정가능한값: address,address_detail,age,business_number,gender,nickname,password,phone")
	@PutMapping("/update")
	private ResponseEntity<String> update(@RequestBody final AccountDto accountDto, HttpServletRequest request) {
		if (tokenProvider.validateToken(request.getHeader("x-auth-token"))) {
			try {
				boolean result = accountService.update(accountDto);
				System.out.println(result);
				if (result) {
					return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
				}
			} catch (SQLException e) {
				return new ResponseEntity<>("FAIL", HttpStatus.NO_CONTENT);
			}
		} else {
			return new ResponseEntity<>("FAIL", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>("FAIL", HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "회원이메일로 당첨기록 조회", notes = "email 값 필수")
	@GetMapping("/selectEventWinnerByEmail")
	private ResponseEntity<List<EventDto>> selectEventWinnerByEmail(@RequestParam(required = true) final String email) {
		try {
			List<EventDto> list = accountService.selectEventWinnerByEmail(email);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "회원이메일로 진행중인 참여조회", notes = "email 값 필수")
	@GetMapping("/selectEventParticipationByEmail")
	private ResponseEntity<List<EventDto>> selectEventParticipationByEmail(
			@RequestParam(required = true) final String email) {
		try {
			List<EventDto> list = accountService.selectEventParticipationByEmail(email);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "리테일러UUID로 리테일러가 등록한 이벤트 리스트 조회", notes = "uuid 값 필수")
	@GetMapping("/selectCreateEventListByID")
	private ResponseEntity<List<EventDto>> selectCreateEventListByID(@RequestParam(required = true) final int uuid) {
		try {
			List<EventDto> list = accountService.selectCreateEventListByID(uuid);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}

}
