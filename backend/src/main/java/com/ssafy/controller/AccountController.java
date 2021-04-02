package com.ssafy.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.pjt.dto.AccountDto;
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
		System.out.println(loginRequestDto);

		Map<String, Object> resultMap = new HashMap<>();
		try {
			AccountDto loginUser = accountService.login(loginRequestDto);
			System.out.println(loginUser);
			if (loginUser != null) {
				System.out.println("check");
				String token = tokenProvider.createToken();

				System.out.println(token);
				resultMap.put("access-token", token);
				resultMap.put("message", "SUCCESS");
			} else {
				resultMap.put("message", "FAIL");
			}
		} catch (SQLException e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			resultMap.put("message", e.getMessage());
		}

		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);

	}

	@ApiOperation(value = "회원정보조회", notes = "x-auth-token, email 값 필수")
	@GetMapping("/accountInfo")
	private ResponseEntity<AccountDto> accountInfo(@RequestParam(required = true) final String email,
			HttpServletRequest request) {
		AccountDto accountDto;

		if (tokenProvider.validateToken(request.getHeader("x-auth-token"))) {
			try {
				accountDto = accountService.accountInfo(email);
				System.out.println(accountDto);
				return new ResponseEntity<>(accountDto, HttpStatus.OK);
			} catch (SQLException e) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}
		} else {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}

	}

}
