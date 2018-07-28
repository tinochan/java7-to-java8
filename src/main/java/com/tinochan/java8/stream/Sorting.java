/**
 * 
 * The purpose of this class is to find all transactions of type GROCERY 
 * and return a list of transaction IDs sorted in decreasing order of transaction value
 * The origin of the example is based on the below article
 * https://www.oracle.com/technetwork/articles/java/ma14-java-se-8-streams-2177646.html
 * 
 */

package com.tinochan.java8.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.tinochan.dto.Transaction;

public class Sorting {
	
	public List<Integer> sortInJava7(List<Transaction> transactions) {
		List<Transaction> groceryTransactions = new ArrayList<>();
		for(Transaction t: transactions){
		  if(t.getType() == Transaction.Type.GROCERY){
		    groceryTransactions.add(t);
		  }
		}
		
		Collections.sort(groceryTransactions, new Comparator<Transaction>(){
		  public int compare(Transaction t1, Transaction t2){
		    return t2.getValue().compareTo(t1.getValue());
		  }
		});
		
		List<Integer> transactionIds = new ArrayList<>();
		for(Transaction t: groceryTransactions){
			transactionIds.add(t.getId());
		}
		return transactionIds;
	}
	
	public List<Integer> sortWithStreamInJava8(List<Transaction> transactions) {
		List<Integer> transactionIds =
				transactions.stream()
				.filter(t -> t.getType() == Transaction.Type.GROCERY)
				.sorted(Comparator.comparing(Transaction::getValue).reversed())
				.map(Transaction::getId)
				.collect(Collectors.toList());
		
		return transactionIds;
	}
	
}
