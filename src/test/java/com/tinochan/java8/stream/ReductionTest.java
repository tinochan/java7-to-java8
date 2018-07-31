package com.tinochan.java8.stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tinochan.dto.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class ReductionTest {
	
	static Reduction reduction;
	static List<Product> productList;
	
	@BeforeAll
	private static void setUp() {
		reduction = new Reduction();
		productList = new ArrayList<>();
	}
	
	@BeforeEach
	private void setUpForEachTest() {
		productList.clear();
		for(int i=1; i<=10; i++) {
			Product product = new Product(i, "product"+i, i);
			productList.add(product);
		}
	}
	
	@Test
	public void testValueAddInJava7() {
		int result = reduction.valueAddInJava7(1, 4, 10);
		assertEquals(16, result);
	}
	
	@Test
	public void testValueAddInJava8() {
		int result = reduction.valueAddInJava8(1, 4, 10);
		assertEquals(16, result);
	}

	@Test
	public void testAveragingInJava7() {
		double result = reduction.averagingInJava7(productList);
		assertEquals(5.5, result);
	}
	
	@Test
	public void testAveragingInJava8() {
		double result = reduction.averagingInJava8(productList);
		assertEquals(5.5, result);
	}
}
