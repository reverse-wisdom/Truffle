package com.ssafy.pjt.dto;

import lombok.Data;

@Data
public class OrderDto {
	int order_id;
	int uuid;
	int event_id;
	int ship_status;
	int pay_status;
	String imp_uid; 
}
