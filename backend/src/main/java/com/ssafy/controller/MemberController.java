package com.ssafy.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.pjt.dto.Member;
import com.ssafy.pjt.service.MemberServiceImpl;


import io.swagger.annotations.ApiOperation;

/**
 * http://localhost:8000/swagger-ui.html
 */

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberServiceImpl memberService;
	
	@ApiOperation(value = "멤버 글 전체")
	@GetMapping("/all")
	private ResponseEntity<List<Member>> all() {
		System.out.println("??");
		List<Member> list;
		try {
			list = memberService.all();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}

}
