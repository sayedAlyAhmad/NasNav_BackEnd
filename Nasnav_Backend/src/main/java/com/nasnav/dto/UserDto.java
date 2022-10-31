package com.nasnav.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
	private Long id;
	private String email;
	private String address;
	private String password;
//	private long groupid;
}
