package com.ssafy.pjt.dto;


import lombok.Data;

@Data
public class EventImgFileDto {
	int file_id;
	int event_id;
	int type;
	String uuid_file;
	String orignal_file;

}
