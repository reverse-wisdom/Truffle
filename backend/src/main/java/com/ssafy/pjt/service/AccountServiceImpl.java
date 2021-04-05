package com.ssafy.pjt.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.pjt.dao.AccountDao;
import com.ssafy.pjt.dto.AccountDto;
import com.ssafy.pjt.dto.EventDto;
import com.ssafy.security.PasswordEncoding;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;

	PasswordEncoding passwordEncoding = new PasswordEncoding();

	@Override
	public AccountDto login(AccountDto accountDto) throws SQLException {
		if (accountDto.getEmail() == null || accountDto.getPassword() == null)
			return null;
		String password = accountDao.accountInfo(accountDto.getEmail()).getPassword();
		if (passwordEncoding.matches(accountDto.getPassword(), password))
			return accountDao.accountInfo(accountDto.getEmail());
		else
			return null;
	}

	@Override
	public AccountDto accountInfo(String email) throws SQLException {
		return accountDao.accountInfo(email);
	}

	@Override
	public boolean signUp(AccountDto accountDto) throws SQLException {
		accountDto.setPassword(passwordEncoding.encode(accountDto.getPassword()));
		return accountDao.signUp(accountDto) == 1;
	}

	@Override
	public boolean delete(String email) throws SQLException {
		return accountDao.delete(email) == 1;
	}

	@Override
	public boolean update(AccountDto accountDto) throws SQLException {
		accountDto.setPassword(passwordEncoding.encode(accountDto.getPassword()));
		return accountDao.update(accountDto) == 1;
	}

	@Override
	public List<EventDto> selectEventWinnerByEmail(String email) throws SQLException {
		return accountDao.selectEventWinnerByEmail(email);
	}

	@Override
	public List<EventDto> selectEventParticipationByEmail(String email) throws SQLException {
		return accountDao.selectEventParticipationByEmail(email);
	}

	@Override
	public List<EventDto> selectCreateEventListByID(int uuid) throws SQLException {
		return accountDao.selectCreateEventListByID(uuid);
	}

}
