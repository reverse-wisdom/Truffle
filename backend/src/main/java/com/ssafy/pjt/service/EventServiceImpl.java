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
		return eventDao.all();
	}

	@Override
	public List<EventDto> detail(int event_id) throws SQLException {
		return eventDao.detail(event_id);
	}

	@Override
	public List<EventDto> selectByGender(int gender) throws SQLException {
		return eventDao.selectByGender(gender);
	}

	@Override
	public List<EventDto> selectByAge(int age) throws SQLException {
		return eventDao.selectByAge(age);
	}

	@Override
	public List<EventDto> selectByProduct(String product) throws SQLException {
		return eventDao.selectByProduct(product);
	}

	@Override
	public List<EventDto> selectByCategory(String category) throws SQLException {
		return eventDao.selectByCategory(category);
	}

}
