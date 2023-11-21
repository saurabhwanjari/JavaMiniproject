package com.moduleend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AccountMain 
{

	public static void main(String[] args) 
	{
		ArrayList<Account> accList = new ArrayList<>();
		
		accList.add(new Account("SBI0004", 1000));
		accList.add(new Account("SBI0002", 1500));
		accList.add(new Account("SBI0003", 1100));
		
		Collections.sort(accList);
		
		System.out.println("Sorted Account List :");
		for(Account account :accList )
		{
			System.out.println(account);
		}
		
		System.out.println("-------------------------------------------------------");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER Account Details to Check ( balance, acc_number) : ");
		String userAccNumber = sc.next();
		int userBalnace = sc.nextInt();
		
		Account userAccount = new Account(userAccNumber, userBalnace);
		
		if(accList.contains(userAccount))
		{
			System.out.println("Account is already present in the List. ");
		}
		else
		{
			System.out.println("Account is not present in the list.");
		}
	}
}