package com.ssafy.pjt.dao;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.ssafy.pjt.dto.Member;

public interface MemberDao {
	public List<Member> all() throws SQLException;

}
