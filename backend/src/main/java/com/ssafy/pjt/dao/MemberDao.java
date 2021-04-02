package com.ssafy.pjt.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.pjt.dto.Member;

public interface MemberDao {
	public List<Member> all() throws SQLException;

}
