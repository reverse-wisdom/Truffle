package com.ssafy.pjt.service;

import java.util.List;

import com.ssafy.pjt.dto.AccountDto;
import com.ssafy.pjt.dto.EventDto;
import com.ssafy.pjt.dto.ParticipationDto;

public interface AccountService {
	public AccountDto login(AccountDto accountDto) throws Exception;

	public AccountDto accountInfo(String email) throws Exception;

	public boolean signUp(AccountDto accountDto) throws Exception;

	public boolean delete(String email) throws Exception;

	public boolean update(AccountDto accountDto) throws Exception;

	public List<EventDto> selectEventWinnerByEmail(String email) throws Exception;

	public List<EventDto> selectEventParticipationByEmail(String email) throws Exception;

	public List<EventDto> selectCreateEventListByID(int uuid) throws Exception;

	public boolean cancelParticipation(ParticipationDto ParticipationDto) throws Exception;
}
