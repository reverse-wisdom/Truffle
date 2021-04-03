package com.ssafy.pjt.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.pjt.dto.EventQnADto;
import com.ssafy.pjt.dto.EventQnAUserRequestDto;

public interface EventQnADao {
	public List<EventQnADto> selectEventQnAByEventID(int event_id) throws SQLException;

	public int insert(EventQnADto eventQnADto) throws SQLException;

	public int updateQnaAnswer(EventQnADto eventQnADto) throws SQLException;

	public List<EventQnAUserRequestDto> selectEventQnAByUserID(int uuid) throws SQLException;

	public int delete(int qna_id) throws SQLException;

}
