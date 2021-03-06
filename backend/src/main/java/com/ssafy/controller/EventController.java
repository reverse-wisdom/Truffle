package com.ssafy.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
	
	private static final String SUCCESS = "SUCCESS";
	private static final String FAIL = "FAIL";
	
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
				return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
			}

		} catch (SQLException e) {
			return new ResponseEntity<>(FAIL, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "이벤트 페이지 작성", notes = "작성가능한 필드: age category detail end_date gender(남:1,여:2) open_date price product win_num, uuid")
	@PostMapping(value = "/insert", consumes = { "multipart/form-data" })
	private ResponseEntity<String> test(@RequestPart("age") final String age,
			@RequestPart("category") final String category, @RequestPart("detail") final String detail,
			@RequestPart("end_date") final String end_date, @RequestPart("gender") final String gender,
			@RequestPart("open_date") final String open_date, @RequestPart("price") final String price,
			@RequestPart("product") final String product, @RequestPart("uuid") final String uuid,
			@RequestPart("win_num") final String win_num, @RequestPart("썸네일이미지") final MultipartFile imgFile) {
		EventDto eventDto = new EventDto();
		eventDto.setAge(Integer.parseInt(age));
		eventDto.setCategory(category);
		eventDto.setDetail(detail);
		eventDto.setEnd_date(Date.valueOf(end_date));
		eventDto.setGender(Integer.parseInt(gender));
		eventDto.setOpen_date(Date.valueOf(open_date));
		eventDto.setPrice(Integer.parseInt(price));
		eventDto.setProduct(product);
		eventDto.setUuid(Integer.parseInt(uuid));
		eventDto.setWin_num(Integer.parseInt(win_num));

		String os = System.getProperty("os.name").toLowerCase();
		String FILE_PATH;

		if (os.contains("win"))
			FILE_PATH = "C:\\SSAFY\\upload\\img\\"; // 환경에맞게 파일경로 수정
		else
			FILE_PATH = "/volumes/data/"; // 환경에맞게 파일경로 수정

		String fileName = null;
		EventImgFileDto eventImgFileDto = null;

		if (imgFile.isEmpty()) {
			return new ResponseEntity<>("썸네일파일을 업로드해주세요.", HttpStatus.NO_CONTENT);
		} else {
			String originalFileName = imgFile.getOriginalFilename();

			String ext = FilenameUtils.getExtension(originalFileName); // 파일 확장자 구하기
			UUID fileUUID = UUID.randomUUID(); // UUID 구하기
			fileName = fileUUID + "." + ext;
			try {
				imgFile.transferTo(new File(FILE_PATH + fileName)); // 실제 업로드부분
				eventImgFileDto = new EventImgFileDto();
				eventImgFileDto.setOrignal_file(originalFileName);
				eventImgFileDto.setUuid_file(fileName);
			} catch (IllegalStateException e) {
				return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
			} catch (IOException e) {
				return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
			}

			try {
				boolean result = eventService.insert(eventDto, eventImgFileDto);

				if (result) {
					return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
				}

			} catch (SQLException e) {
				return new ResponseEntity<>(FAIL, HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(FAIL, HttpStatus.NO_CONTENT);
		}

	}

	@ApiOperation(value = "이벤트 참여자수 1 증가")
	@PutMapping("/joinEvent")
	private ResponseEntity<String> joinEvent(@RequestBody(required = true) final int event_id) {
		try {
			boolean result = eventService.joinEvent(event_id);
			if (result) {
				return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
			}

		} catch (SQLException e) {
			return new ResponseEntity<>(FAIL, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(FAIL, HttpStatus.NO_CONTENT);
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
				return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
			}

		} catch (SQLException e) {
			return new ResponseEntity<>(FAIL, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "당첨자 당첨테이블 등록", notes = "필수작성필드: uuid, event_id")
	@PostMapping("/insertUserIdWinParticipation")
	private ResponseEntity<String> insertUserIdWinParticipation(@RequestBody(required = true) final WinDto winDto) {
		try {
			boolean result = eventService.insertUserIdWinParticipation(winDto);
			if (result) {
				return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
			}

		} catch (SQLException e) {
			return new ResponseEntity<>(FAIL, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "이벤트 아이디를 통해 이미지 파일 썸네일 출력(base64)")
	@GetMapping("/selectEventFileBase64ByEventID")
	private ResponseEntity<String> selectEventFileBase64ByEventID(@RequestParam(required = true) final int event_id) {
		EventImgFileDto img;

		String os = System.getProperty("os.name").toLowerCase();
		String FILE_PATH;

		if (os.contains("win"))
			FILE_PATH = "C:\\SSAFY\\upload\\img\\"; // 환경에맞게 파일경로 수정
		else
			FILE_PATH = "/volumes/data/"; // 환경에맞게 파일경로 수정

		try {
			img = eventService.selectEventFileNameByEventID(event_id);
			byte[] file = getFileBinary(FILE_PATH + img.getUuid_file());
			if (file == null)
				return new ResponseEntity<>("지정된 파일을 찾을수 없습니다.", HttpStatus.NO_CONTENT);

			String base64Img = Base64.getEncoder().encodeToString(file);

			return new ResponseEntity<>(base64Img, HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "이벤트아이디를 통해 이미지 파일 요청, 이미지파일 자체로 반환")
	@GetMapping(value = "/selectEventImgFileEventID", produces = MediaType.IMAGE_JPEG_VALUE)
	private ResponseEntity<?> selectEventImgFileEventID(@RequestParam(required = true) final int event_id) {

		String os = System.getProperty("os.name").toLowerCase();
		String FILE_PATH;
		if (os.contains("win"))
			FILE_PATH = "C:\\SSAFY\\upload\\img\\"; // 환경에맞게 파일경로 수정
		else
			FILE_PATH = "/volumes/data/"; // 환경에맞게 파일경로 수정
		EventImgFileDto img;
		byte[] media;
		HttpHeaders headers = new HttpHeaders();
		InputStream in;

		try {
			img = eventService.selectEventFileNameByEventID(event_id);
			if (img == null)
				return new ResponseEntity<>("지정된 파일을 찾을수 없습니다.", HttpStatus.NO_CONTENT);
			File file = new File(FILE_PATH + img.getUuid_file());
			in = new FileInputStream(file);
			media = IOUtils.toByteArray(in);
			headers.setCacheControl(CacheControl.noCache().getHeaderValue());

			return new ResponseEntity<>(media, headers, HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} catch (FileNotFoundException e) {
			return new ResponseEntity<>("지정된 파일을 찾을수 없습니다.", HttpStatus.NO_CONTENT);
		} catch (IOException e) {
			return new ResponseEntity<>("지정된 파일을 찾을수 없습니다.", HttpStatus.NO_CONTENT);
		}
	}

	private static byte[] getFileBinary(String filepath) {
		File file = new File(filepath);
		byte[] data = new byte[(int) file.length()];
		try (FileInputStream stream = new FileInputStream(file)) {
			stream.read(data, 0, data.length);
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e1) {
			return null;
		}
		return data;
	}

}
