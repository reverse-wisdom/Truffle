package com.ssafy.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.pjt.dto.EventDto;
import com.ssafy.pjt.dto.EventUserRequestDto;
import com.ssafy.pjt.service.EventServiceImpl;

import io.swagger.annotations.ApiOperation;

/**
 * http://localhost:8000/truffle/swagger-ui.html
 */

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/event")
public class EventController {

	@Autowired
	private EventServiceImpl eventService;

	@ApiOperation(value = "이벤트 전체 조회")
	@GetMapping("/all")
	private ResponseEntity<List<EventDto>> all() {

		List<EventDto> list;
		try {
			list = eventService.all();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "이벤트 상세 조회")
	@GetMapping("/detail")
	private ResponseEntity<List<EventDto>> detail(@RequestParam(required = true) final int event_id) {
		List<EventDto> list;
		try {
			list = eventService.detail(event_id);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "성별 상세 조회(남성:1, 여성:2)")
	@GetMapping("/selectByGender")
	private ResponseEntity<List<EventDto>> selectByGender(@RequestParam(required = true) final int gender) {
		List<EventDto> list;
		try {
			list = eventService.selectByGender(gender);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "나이별 상세 조회(입력값:10,20,30,40,50,60)")
	@GetMapping("/selectByAge")
	private ResponseEntity<List<EventDto>> selectByAge(@RequestParam(required = true) final int age) {
		List<EventDto> list;
		try {
			list = eventService.selectByAge(age);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "상품명별 조회")
	@GetMapping("/selectByProduct")
	private ResponseEntity<List<EventDto>> selectByProduct(@RequestParam(required = true) final String product) {
		List<EventDto> list;
		try {
			list = eventService.selectByProduct(product);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "카테고리별 조회")
	@GetMapping("/selectByCategory")
	private ResponseEntity<List<EventDto>> selectByCategory(@RequestParam(required = true) final String category) {
		List<EventDto> list;
		try {
			list = eventService.selectByCategory(category);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "이벤트 페이지 수정", notes = "event_id필드 고정 / 수정가능한 필드: age category detail end_date gender(남:1,여:2) open_date price product win_num")
	@PutMapping("/update")
	private ResponseEntity<String> update(@RequestBody(required = true) final EventDto eventDto) {
		try {
			boolean result = eventService.update(eventDto);
			if (result) {
				return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
			}

		} catch (SQLException e) {
			return new ResponseEntity<>("FAIL", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>("FAIL", HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "이벤트 페이지 작성", notes = "작성가능한 필드: age category detail end_date gender(남:1,여:2) open_date price product win_num")
	@PostMapping("/insert")
	private ResponseEntity<String> insert(@RequestBody(required = true) final EventDto eventDto) {
		try {
			boolean result = eventService.insert(eventDto);
			if (result) {
				return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
			}

		} catch (SQLException e) {
			return new ResponseEntity<>("FAIL", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>("FAIL", HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "이벤트 참여자수 증가")
	@PutMapping("/joinEvent")
	private ResponseEntity<String> joinEvent(@RequestBody(required = true) final int event_id) {
		try {
			boolean result = eventService.joinEvent(event_id);
			if (result) {
				return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
			}

		} catch (SQLException e) {
			return new ResponseEntity<>("FAIL", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>("FAIL", HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "당첨자 전체조회")
	@GetMapping("/selectWinListByEventId")
	private ResponseEntity<List<EventUserRequestDto>> selectWinListByEventId(
			@RequestParam(required = true) final int event_id) {
		List<EventUserRequestDto> list;
		try {
			list = eventService.selectWinListByEventId(event_id);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "참여자 전체조회")
	@GetMapping("/selectParticipationListByEventId")
	private ResponseEntity<List<EventUserRequestDto>> selectParticipationListByEventId(
			@RequestParam(required = true) final int event_id) {
		List<EventUserRequestDto> list;
		try {
			list = eventService.selectParticipationListByEventId(event_id);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}

}
