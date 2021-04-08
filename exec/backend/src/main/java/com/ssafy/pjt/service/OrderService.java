package com.ssafy.pjt.service;

import java.util.List;

import com.ssafy.pjt.dto.OrderDto;
import com.ssafy.pjt.dto.OrderUpdateRequestDto;

public interface OrderService {
	public boolean completePayment(OrderDto orderDto) throws Exception;

	public List<OrderDto> selectOrderByEventId(int event_id) throws Exception;

	public boolean deleteOrderByEventId(int event_id) throws Exception;

	public boolean updateOrderStatus(OrderUpdateRequestDto orderUpdateRequestDto) throws Exception;

}
