package com.ssafy.pjt.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class EventInsertRequestDto {
	String product;
	String detail;
	String category;
	Date open_date;
	Date end_date;
	int win_num;
	int price;
	int gender;
	int age;
	int uuid;

	public EventInsertRequestDto(String product, String detail, String category, Date open_date, Date end_date,
			int win_num, int price, int gender, int age, int uuid) {
		super();
		this.product = product;
		this.detail = detail;
		this.category = category;
		this.open_date = open_date;
		this.end_date = end_date;
		this.win_num = win_num;
		this.price = price;
		this.gender = gender;
		this.age = age;
		this.uuid = uuid;
	}

}
