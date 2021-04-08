package com.ssafy.pjt.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.pjt.dao.EventQnADao;
import com.ssafy.pjt.dto.EventQnADto;
import com.ssafy.pjt.dto.EventQnAUserRequestDto;

@Service
public class EventQnAServiceImpl implements EventQnAService {

	@Autowired
	private EventQnADao eventQnADao;

	@Override
	public List<EventQnADto> selectEventQnAByEventID(int event_id) throws SQLException {
		return eventQnADao.selectEventQnAByEventID(event_id);
	}

	@Override
	public boolean insert(EventQnADto eventQnADto) throws SQLException {
		return eventQnADao.insert(eventQnADto) == 1;
	}

	@Override
	public boolean updateQnaAnswer(EventQnADto eventQnADto) throws SQLException {
		return eventQnADao.updateQnaAnswer(eventQnADto) == 1;
	}

	@Override
	public List<EventQnAUserRequestDto> selectEventQnAByUserID(int uuid) throws SQLException {
		return eventQnADao.selectEventQnAByUserID(uuid);
	}

	@Override
	public boolean delete(int qna_id) throws SQLException {
		return eventQnADao.delete(qna_id) == 1;
	}
}
