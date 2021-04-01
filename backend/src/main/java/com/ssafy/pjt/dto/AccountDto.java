package com.ssafy.pjt.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AccountDto {
	int uuid;
	@ApiModelProperty(required = true)
	String email;
	@ApiModelProperty(required = true)
	String password;
	@ApiModelProperty(required = true)
	String phone;
	@ApiModelProperty(required = true)
	String address;
	@ApiModelProperty(required = true)
	String address_detail;
	String business_number;
	String nickname;
	@ApiModelProperty(required = true)
	int type;
	int gender;
	int age;

}
