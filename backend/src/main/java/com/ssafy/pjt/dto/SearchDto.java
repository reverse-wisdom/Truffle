package com.ssafy.pjt.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchDto {
	int hit;
	String word;
}
