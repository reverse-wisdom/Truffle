package com.ssafy.pjt.service;

import java.util.List;

import com.ssafy.pjt.dto.EventQnADto;
import com.ssafy.pjt.dto.EventQnAUserRequestDto;

public interface EventQnAService {
	public List<EventQnADto> selectEventQnAByEventID(int event_id) throws Exception;

	public boolean insert(EventQnADto eventQnADto) throws Exception;

	public boolean updateQnaAnswer(EventQnADto eventQnADto) throws Exception;

	public List<EventQnAUserRequestDto> selectEventQnAByUserID(int uuid) throws Exception;

	public boolean delete(int qna_id) throws Exception;

}
