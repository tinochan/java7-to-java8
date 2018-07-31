package com.tinochan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {

	public Integer id;
	public String name;
	public Address address;
}
