package com.ssafy.pjt.service;


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
	public AccountDto login(LoginRequestDto loginRequestDto) throws Exception {
		if (loginRequestDto.getEmail() == null || loginRequestDto.getPassword() == null)
			return null;
		return accountDao.login(loginRequestDto);
	}

	@Override
	public AccountDto accountInfo(String email) throws Exception {
		return accountDao.accountInfo(email);
	}

}
