package com.ssafy.pjt.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.pjt.dto.EventDto;

public interface EventDao {
	public List<EventDto> all() throws SQLException;

	public List<EventDto> detail(int event_id) throws SQLException;

	public List<EventDto> selectByGender(int gender) throws SQLException;

	public List<EventDto> selectByAge(int age) throws SQLException;

	public List<EventDto> selectByProduct(String product) throws SQLException;

	public List<EventDto> selectByCategory(String category) throws SQLException;

}
