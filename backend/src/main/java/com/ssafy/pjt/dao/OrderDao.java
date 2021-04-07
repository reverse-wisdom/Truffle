package com.ssafy.pjt.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.pjt.dto.OrderDto;
import com.ssafy.pjt.dto.OrderUpdateRequestDto;

public interface OrderDao {
	public int completePayment(OrderDto orderDto) throws SQLException;

	public List<OrderDto> selectOrderByEventId(int event_id) throws SQLException;
	
	public int deleteOrderByEventId(int event_id) throws SQLException;
	
	public int updateOrderStatus(OrderUpdateRequestDto orderUpdateRequestDto) throws SQLException;

}
