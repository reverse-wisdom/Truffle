package com.ssafy.pjt.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.pjt.dao.MemberDao;
import com.ssafy.pjt.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;

	@Override
	public List<Member> all() throws SQLException {
		return memberDao.all();
	}

}
