package com.ssafy.pjt.service;

import java.util.List;

import com.ssafy.pjt.dto.EventDto;

public interface EventService {
	public List<EventDto> all() throws Exception;

	public List<EventDto> detail(int event_id) throws Exception;
}
