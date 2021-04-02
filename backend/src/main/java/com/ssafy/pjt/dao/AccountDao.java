package com.ssafy.pjt.dao;

import java.sql.SQLException;

import com.ssafy.pjt.dto.AccountDto;
import com.ssafy.pjt.dto.LoginRequestDto;

public interface AccountDao {
	public AccountDto login(LoginRequestDto loginRequestDto) throws SQLException;
	public AccountDto accountInfo(String email) throws SQLException;
}
