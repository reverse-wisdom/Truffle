package com.ssafy.pjt.dto;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchQnADto {
	int qna_id;
	String writter;
	String detail;
	int event_id;
	Date create_date;
	String answer;
	int status;
	Date answer_date;
}
