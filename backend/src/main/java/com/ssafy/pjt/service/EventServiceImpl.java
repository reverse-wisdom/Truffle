package com.ssafy.pjt.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.pjt.dao.EventDao;
import com.ssafy.pjt.dto.EventDto;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDao eventDao;

	@Override
	public List<EventDto> all() throws SQLException {
		System.out.println("test");
		return eventDao.all();
	}

	@Override
	public List<EventDto> detail(int event_id) throws SQLException {
		return eventDao.detail(event_id);
	}

}
