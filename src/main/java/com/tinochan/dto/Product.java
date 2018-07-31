package com.tinochan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {

	public Integer id;
	public String name;
	public double price;
}
