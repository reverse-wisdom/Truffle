package com.ssafy.pjt.service;

import com.ssafy.pjt.dto.OrderDto;

public interface OrderService {
	public boolean completePayment(OrderDto orderDto) throws Exception;

}
