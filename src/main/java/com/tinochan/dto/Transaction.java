package com.tinochan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Transaction {
	
	public enum Type
	{
		GROCERY, MEAT, VEGETABLE, BEVERAGE
	}

	public Integer id;
	public Type type;
	public Long value;
}
