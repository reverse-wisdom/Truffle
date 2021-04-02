package com.ssafy.pjt.service;

import com.ssafy.pjt.dto.AccountDto;
import com.ssafy.pjt.dto.EventDto;
import com.ssafy.pjt.dto.LoginRequestDto;

public interface AccountService {
	public AccountDto login(LoginRequestDto loginRequestDto) throws Exception;

	public AccountDto accountInfo(String email) throws Exception;

	public boolean signUp(AccountDto accountDto) throws Exception;

	public boolean delete(String email) throws Exception;

	public boolean update(AccountDto accountDto) throws Exception;

	public EventDto selectEventWinnerByEmail(String email) throws Exception;

	public EventDto selectEventParticipationByEmail(String email) throws Exception;
}
