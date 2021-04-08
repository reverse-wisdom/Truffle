package com.ssafy.controller;

import java.sql.SQLException;
import java.util.List;

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

import com.ssafy.pjt.dto.EventQnADto;
import com.ssafy.pjt.dto.EventQnAUserRequestDto;
import com.ssafy.pjt.service.EventQnAServiceImpl;
import com.ssafy.pjt.service.TokenProvider;

import io.swagger.annotations.ApiOperation;

/**
 * http://localhost:8000/truffle/swagger-ui.html
 */
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/eventQnA")
public class EventQnAController {
	
	private static final String SUCCESS = "SUCCESS";
	private static final String FAIL = "FAIL";

	@Autowired
	private TokenProvider tokenProvider;

	@Autowired
	private EventQnAServiceImpl eventQnAServiceImpl;

	@ApiOperation(value = "event_id를 통해 해당 이벤트의 id qna 전체 조회")
	@GetMapping("/selectEventQnAByEventID")
	private ResponseEntity<List<EventQnADto>> selectEventQnAByEventID(
			@RequestParam(required = true) final int event_id) {
		List<EventQnADto> list;
		try {
			list = eventQnAServiceImpl.selectEventQnAByEventID(event_id);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "이벤트 QnA등록", notes = "필수 입력값 : answer, create_date, detail, event_id, writter")
	@PostMapping("insert")
	private ResponseEntity<String> insert(@RequestBody(required = true) final EventQnADto eventQnADto) {
		try {
			boolean result = eventQnAServiceImpl.insert(eventQnADto);
			if (result) {
				return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
			}

		} catch (SQLException e) {
			return new ResponseEntity<>(FAIL, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "이벤트 QnA 답변 등록", notes = "필수 입력값 : qna_id, answer, answer_date")
	@PutMapping("updateQnaAnswer")
	private ResponseEntity<String> updateQnaAnswer(@RequestBody(required = true) final EventQnADto eventQnADto) {
		try {
			boolean result = eventQnAServiceImpl.updateQnaAnswer(eventQnADto);
			if (result) {
				return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
			}

		} catch (SQLException e) {
			return new ResponseEntity<>(FAIL, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "uuid를 통해 회원이 등록한 이벤트 qna 리스트 전체 조회")
	@GetMapping("/selectEventQnAByUserID")
	private ResponseEntity<List<EventQnAUserRequestDto>> selectEventQnAByUserID(
			@RequestParam(required = true) final int uuid) {
		List<EventQnAUserRequestDto> list;
		try {
			list = eventQnAServiceImpl.selectEventQnAByUserID(uuid);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "이벤트 qna 삭제", notes = "x-auth-token, qna_id값 필수")
	@DeleteMapping("/delete")
	private ResponseEntity<String> delete(@RequestParam(required = true) final int qna_id, HttpServletRequest request) {
		
		if (tokenProvider.validateToken(request.getHeader("x-auth-token"))) {
			try {
				boolean result = eventQnAServiceImpl.delete(qna_id);
				if (result) {
					return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
				}
			} catch (SQLException e) {
				return new ResponseEntity<>(FAIL, HttpStatus.NO_CONTENT);
			}
		} else {
			return new ResponseEntity<>(FAIL, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(FAIL, HttpStatus.NO_CONTENT);
	}

}
