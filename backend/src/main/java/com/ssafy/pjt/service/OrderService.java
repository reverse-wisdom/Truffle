package com.ssafy.pjt.service;

import com.ssafy.pjt.dto.OrderDto;

public interface OrderService {
	public boolean completePayment(OrderDto orderDto) throws Exception;

	public OrderDto selectOrderByEventId(int event_id) throws Exception;
	
	public boolean deleteOrderByEventId(int event_id) throws Exception;

}
