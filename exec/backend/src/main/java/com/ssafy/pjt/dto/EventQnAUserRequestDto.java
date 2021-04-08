package com.ssafy.pjt.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class EventQnAUserRequestDto {
	int uuid;
	String email;
	int event_id;
	String detail;
	Date create_date;
	String answer;
	int status;
	Date answer_date;

}
