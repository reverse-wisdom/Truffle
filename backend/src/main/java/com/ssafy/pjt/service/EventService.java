package com.ssafy.pjt.service;

import java.util.List;

import com.ssafy.pjt.dto.EventDto;
import com.ssafy.pjt.dto.EventUserRequestDto;
import com.ssafy.pjt.dto.SearchDto;

public interface EventService {
	public List<EventDto> all() throws Exception;

	public List<EventDto> detail(int event_id) throws Exception;

	public List<EventDto> selectByGender(int gender) throws Exception;

	public List<EventDto> selectByAge(int age) throws Exception;

	public List<EventDto> selectByProduct(String product) throws Exception;

	public List<EventDto> selectByCategory(String category) throws Exception;

	public boolean update(EventDto eventDto) throws Exception;

	public boolean insert(EventDto eventDto) throws Exception;

	public boolean joinEvent(int event_id) throws Exception;

	public List<EventUserRequestDto> selectWinListByEventId(int event_id) throws Exception;

	public List<EventUserRequestDto> selectParticipationListByEventId(int event_id) throws Exception;

	public List<SearchDto> selectSearchHit() throws Exception;

}
