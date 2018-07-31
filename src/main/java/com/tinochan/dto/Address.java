package com.tinochan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Address {

	public Integer id;
	public String street;
	public Integer floor;
}
