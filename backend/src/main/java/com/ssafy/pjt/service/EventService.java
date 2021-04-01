package com.ssafy.pjt.service;

import java.util.List;

import com.ssafy.pjt.dto.EventDto;

public interface EventService {
	public List<EventDto> all() throws Exception;

	public List<EventDto> detail(int event_id) throws Exception;

	public List<EventDto> selectByGender(int gender) throws Exception;

	public List<EventDto> selectByAge(int age) throws Exception;

	public List<EventDto> selectByProduct(String product) throws Exception;

	public List<EventDto> selectByCategory(String category) throws Exception;
}
