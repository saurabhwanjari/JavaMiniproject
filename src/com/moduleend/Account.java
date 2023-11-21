package com.moduleend;


import java.util.Objects;

public class Account implements Comparable<Account>
{
	private int balance;  
	private String acct_number;
	
	public Account(String acct_number, int balance) 
	{
		this.balance = balance;
		this.acct_number = acct_number;
	}

	public int getBalance() 
	{
		return balance;
	}
	
	public String getAcct_number() 
	{
		return acct_number;
	}

	@Override
	public String toString()  
	{
		return "Account [acct_number = " + acct_number + ", balance = " + balance + "]";
	}
	
	public int compareTo(Account other)
	{
		return this.acct_number.compareTo(other.acct_number);
	}

	@Override
	public int hashCode() 
	{
		return Objects.hash(acct_number, balance);
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj) 
		{
			return true;
		}
		if (obj == null) 
		{
			return false;
		}
		if (getClass() != obj.getClass()) 
		{
			return false; 
		}
		Account other = (Account) obj;
		return Objects.equals(acct_number, other.acct_number) && balance == other.balance;
	}	
}