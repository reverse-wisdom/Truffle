package com.ssafy.pjt.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.pjt.dto.EventDto;
import com.ssafy.pjt.dto.EventImgFileDto;
import com.ssafy.pjt.dto.EventUserRequestDto;
import com.ssafy.pjt.dto.ParticipationDto;
import com.ssafy.pjt.dto.SearchDto;
import com.ssafy.pjt.dto.WinDto;

public interface EventDao {
	public List<EventDto> all() throws SQLException;

	public List<EventDto> detail(int event_id) throws SQLException;

	public List<EventDto> selectByGender(int gender) throws SQLException;

	public List<EventDto> selectByAge(int age) throws SQLException;

	public List<EventDto> selectByProduct(String product) throws SQLException;

	public List<EventDto> selectByCategory(String category) throws SQLException;

	public int update(EventDto eventDto) throws SQLException;

	public int insert(EventDto eventDto) throws SQLException;

	public int joinEvent(int event_id) throws SQLException;

	public List<EventUserRequestDto> selectWinListByEventId(int event_id) throws SQLException;

	public List<EventUserRequestDto> selectParticipationListByEventId(int event_id) throws SQLException;

	public int upsertSearchHit(String word) throws SQLException;

	public List<SearchDto> selectSearchHit() throws SQLException;

	public int insertUserIdToParticipation(ParticipationDto participationDto) throws SQLException;

	public int insertUserIdWinParticipation(WinDto winDto) throws SQLException;
	
	public int insertEventImg(EventImgFileDto eventImgFileDto) throws SQLException;

}
