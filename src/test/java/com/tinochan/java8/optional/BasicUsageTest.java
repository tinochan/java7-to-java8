package com.tinochan.java8.optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.tinochan.dto.Address;
import com.tinochan.dto.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicUsageTest {
	
	static BasicUsage basicUsage;
	static User user;
	static User user2;
	
	@BeforeAll
	private static void setUp() {
		basicUsage = new BasicUsage();
		Address address = new Address(1, "Test Street", 5);
		user = new User(1, "Test User", address);
		user2 = new User(2, "Test User2", null);
	}
	
	@Test
	public void testNullCheckingInJava7(){
		String street = basicUsage.nullCheckingInJava7(user);
		assertEquals("Test Street", street);
	}
	
	@Test
	public void testNullCheckingInJava8(){
		String street = basicUsage.nullCheckingInJava8(user);
		assertEquals("Test Street", street);
	}
	
	@Test
	public void testNullCheckingInJava7_null_address(){
		String street = basicUsage.nullCheckingInJava7(user2);
		assertEquals("not specified", street);
	}

	@Test
	public void testNullCheckingInJava8_null_address(){
		String street = basicUsage.nullCheckingInJava8(user2);
		assertEquals("not specified", street);
	}
}
