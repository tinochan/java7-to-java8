package com.tinochan.java8.stream;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.tinochan.dto.Transaction;

public class SortingTest {
	
	static Sorting sorting;
	static List<Transaction> transactions;

	@BeforeAll
	private static void setUp() {
		sorting = new Sorting();
		transactions = new ArrayList<>();
	}
	
	@BeforeEach
	private void setUpForEachTest() {
		transactions.clear();
		//Create 100 items for each type
		for(int i=1; i<=400; i++) {
			Transaction transaction = null;
			if(i % 4 == 0) {
			   transaction = new Transaction(i, Transaction.Type.GROCERY, new Long(i*2));
			} else if (i % 4 == 1) {
			   transaction = new Transaction(i, Transaction.Type.MEAT, new Long(i*2));
			} else if (i % 4 == 2) {
			   transaction = new Transaction(i, Transaction.Type.VEGETABLE, new Long(i*2));
			} else if (i % 4 == 3) {
			   transaction = new Transaction(i, Transaction.Type.BEVERAGE, new Long(i*2));
			} 
			transactions.add(transaction);
		}
	}
	
	@Test
	public void testSortInJava7() {
		List<Integer> result = sorting.sortInJava7(transactions);
		assertEquals(100, result.size());
		assertEquals(Integer.valueOf(400), result.get(0));
		assertEquals(Integer.valueOf(4), result.get(99));
	}
	
	@Test
	public void testSortWithStreamInJava8() {
		List<Integer> result = sorting.sortWithStreamInJava8(transactions);
		assertEquals(100, result.size());
		assertEquals(Integer.valueOf(400), result.get(0));
		assertEquals(Integer.valueOf(4), result.get(99));
	}
	
}
