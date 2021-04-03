package com.ssafy.pjt.dto;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EventDto {
	int event_id;
	String product;
	String detail;
	String category;
	Date open_date;
	Date end_date;
	int join_num;
	int win_num;
	int price;
	int gender;
	int age;
	int uuid;

}
