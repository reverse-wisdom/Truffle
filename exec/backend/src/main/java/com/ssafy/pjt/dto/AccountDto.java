package com.ssafy.pjt.dto;

import lombok.Data;

@Data
public class AccountDto {
	int uuid;
	String email;
	String password;
	String phone;
	String address;
	String address_detail;
	String business_number;
	String nickname;
	int type;
	int gender;
	int age;

}
