package com.ebrain.hashmap;

import java.util.*;

public class Server {
	
	interface Bank {		
		
		void deposit();
		void withdraw();
		void balanceEnquiry();
	}
	
	abstract class Account implements Bank {
		private String name;
		private String accountNumber;
		private Double balance;
		
		public Account (String name , String accountNumber , Double balance) {
			
			this.name = name;
			this.accountNumber = accountNumber;
			this.balance = balance;
			
		}
		
		public String getName() {
			
			return name;
		}
		
		public String getAccountNumber() {
			
			return accountNumber;
		}
		
		public Double getBalance() {
			return balance;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public void setaccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}
		
		public void setBalance(Double balance) {
			
			this.balance = balance;
		}
		public void deposit() {
			System.out.println("summa");
		}
		
		public void withdraw() {
			System.out.println("sample");
		}
		  
		public void balanceEnquiry() {
			
			System.out.println("something");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String , Integer> sampleOne = new HashMap<String , Integer>();
		
	
	}

}
