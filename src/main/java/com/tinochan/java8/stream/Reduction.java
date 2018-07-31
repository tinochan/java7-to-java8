package com.tinochan.java8.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.tinochan.dto.Product;

public class Reduction {

	public int valueAddInJava7(int begin, int end, int initial){
		int result = initial;
		for(int i=begin; i<end; i++){
			result += i;
		}
		return result;
	}
	
	public int valueAddInJava8(int begin, int end, int initial){
		return IntStream.range(begin, end).reduce(initial, (a, b) -> a + b);
	}
	
	public double averagingInJava7(List<Product> productList){
		double totalPrice = 0;
		for(Product product : productList){
			totalPrice += product.getPrice();
		}
		return totalPrice/productList.size();
	}
	
    public double averagingInJava8(List<Product> productList){
    	return productList.stream()
    			  .collect(Collectors.averagingDouble(Product::getPrice));
	}
}
