package com.ssafy.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.pjt.dto.EventDto;
import com.ssafy.pjt.dto.EventImgFileDto;
import com.ssafy.pjt.dto.EventUserRequestDto;
import com.ssafy.pjt.dto.ParticipationDto;
import com.ssafy.pjt.dto.SearchDto;
import com.ssafy.pjt.dto.WinDto;
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

	@ApiOperation(value = "상품명별 조회(검색어 상승(hit)포함)", notes = "response body에 아무것도 없을경우 검색어 상승만함")
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

	@ApiOperation(value = "이벤트 페이지 작성", notes = "작성가능한 필드: age category detail end_date gender(남:1,여:2) open_date price product win_num, uuid")
	@PostMapping("/insert")
	private ResponseEntity<String> insert(@Valid final EventDto eventDto,
			@RequestPart(required = true) final MultipartFile imgFile) {

		String os = System.getProperty("os.name").toLowerCase();
		String FILE_PATH;

		if (os.contains("win"))
			FILE_PATH = "C:\\SSAFY\\upload\\img\\"; // 환경에맞게 파일경로 수정
		else
			FILE_PATH = "/volumes/data"; // 환경에맞게 파일경로 수정

		String fileName = null;
		EventImgFileDto eventImgFileDto = null;

		if (imgFile.isEmpty()) {
			return new ResponseEntity<>("썸네일파일을 업로드해주세요.", HttpStatus.NO_CONTENT);
		} else {
			String originalFileName = imgFile.getOriginalFilename();
			System.out.println(originalFileName);

			String ext = FilenameUtils.getExtension(originalFileName); // 파일 확장자 구하기
			UUID uuid = UUID.randomUUID(); // UUID 구하기
			fileName = uuid + "." + ext;
			try {
				imgFile.transferTo(new File(FILE_PATH + fileName)); // 실제 업로드부분
				eventImgFileDto = new EventImgFileDto();
				eventImgFileDto.setOrignal_file(originalFileName);
				eventImgFileDto.setUuid_file(fileName);
			} catch (IllegalStateException e) {
				e.printStackTrace();
				return new ResponseEntity<String>("FAIL", HttpStatus.NO_CONTENT);
			} catch (IOException e) {
				e.printStackTrace();
				return new ResponseEntity<String>("FAIL", HttpStatus.NO_CONTENT);
			}

			try {
				boolean result = eventService.insert(eventDto, eventImgFileDto);

				if (result) {
					return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
				}

			} catch (SQLException e) {
				return new ResponseEntity<>("FAIL", HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>("FAIL", HttpStatus.NO_CONTENT);
		}

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

	@ApiOperation(value = "검색어랭킹조회(검색어,조회수 내림차순")
	@GetMapping("/selectSearchHit")
	private ResponseEntity<List<SearchDto>> selectSearchHit() {
		List<SearchDto> list;
		try {
			list = eventService.selectSearchHit();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "참여자 참여자테이블 등록", notes = "필수작성필드: uuid, event_id")
	@PostMapping("/insertUserIdToParticipation")
	private ResponseEntity<String> insertUserIdToParticipation(
			@RequestBody(required = true) final ParticipationDto participationDto) {
		try {
			boolean result = eventService.insertUserIdToParticipation(participationDto);
			if (result) {
				return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
			}

		} catch (SQLException e) {
			return new ResponseEntity<>("FAIL", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>("FAIL", HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "당첨자 당첨테이블 등록", notes = "필수작성필드: uuid, event_id")
	@PostMapping("/insertUserIdWinParticipation")
	private ResponseEntity<String> insertUserIdWinParticipation(@RequestBody(required = true) final WinDto winDto) {
		try {
			boolean result = eventService.insertUserIdWinParticipation(winDto);
			if (result) {
				return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
			}

		} catch (SQLException e) {
			return new ResponseEntity<>("FAIL", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>("FAIL", HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "이벤트 아이디를 통해 이미지 파일명 조회")
	@GetMapping("/selectEventFileNameByEventID")
	private ResponseEntity<EventImgFileDto> selectEventFileNameByEventID(
			@RequestParam(required = true) final int event_id) {
		EventImgFileDto img;
		try {
			img = eventService.selectEventFileNameByEventID(event_id);
			return new ResponseEntity<>(img, HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}

}
