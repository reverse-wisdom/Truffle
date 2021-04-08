package com.ssafy.pjt.dto;

import lombok.Data;

@Data
public class OrderUpdateRequestDto {
	int event_id;
	int ship_status;
	int pay_status;
	int uuid;

}
