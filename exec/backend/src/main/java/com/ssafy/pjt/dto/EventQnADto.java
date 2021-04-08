package com.ssafy.pjt.dto;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EventQnADto {
	int qna_id;
	String writter;
	String detail;
	int event_id;
	Date create_date;
	String answer;
	int status;
	Date answer_date;
}
