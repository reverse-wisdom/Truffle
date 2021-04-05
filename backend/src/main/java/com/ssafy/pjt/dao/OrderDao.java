package com.ssafy.pjt.dao;

import java.sql.SQLException;

import com.ssafy.pjt.dto.OrderDto;

public interface OrderDao {
	public int completePayment(OrderDto orderDto) throws SQLException;
}
