package com.ssafy.pjt.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.pjt.dao.AccountDao;
import com.ssafy.pjt.dto.AccountDto;
import com.ssafy.pjt.dto.LoginRequestDto;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;

	@Override
	public AccountDto login(LoginRequestDto loginRequestDto) throws SQLException {
		if (loginRequestDto.getEmail() == null || loginRequestDto.getPassword() == null)
			return null;
		return accountDao.login(loginRequestDto);
	}

	@Override
	public AccountDto accountInfo(String email) throws SQLException {
		return accountDao.accountInfo(email);
	}

	@Override
	public boolean signUp(AccountDto accountDto) throws SQLException {
		return accountDao.signUp(accountDto) == 1;
	}

	@Override
	public boolean delete(String email) throws SQLException {
		return accountDao.delete(email) == 1;
	}

	@Override
	public boolean update(AccountDto accountDto) throws SQLException {
		System.out.println(accountDao.update(accountDto));
		return accountDao.update(accountDto) == 1;
	}

}
