package com.ssafy.pjt.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.pjt.dto.EventDto;

public interface EventDao {
	public List<EventDto> all() throws SQLException;

	public List<EventDto> detail(int event_id) throws SQLException;

}
