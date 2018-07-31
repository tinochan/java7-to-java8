package com.tinochan.java8.optional;

import java.util.Optional;

import com.tinochan.dto.Address;
import com.tinochan.dto.User;

public class BasicUsage {
	
	public String nullCheckingInJava7(User user) {
		if (user != null) {
		    Address address = user.getAddress();
		    if (address != null) {
		        String street = address.getStreet();
		        if (street != null) {
		            return street;
		        }
		    }
		}
		return "not specified";
	}
	
	public String nullCheckingInJava8(User user) {
		Optional<User> nullableUser = Optional.ofNullable(user);
		String result = nullableUser
		  .map(User::getAddress)
		  .map(Address::getStreet)
		  .orElse("not specified");
		return result;
	}

}
