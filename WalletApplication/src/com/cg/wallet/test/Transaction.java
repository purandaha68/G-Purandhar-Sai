package com.cg.wallet.test;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

import com.cg.wallet.account.Account;
import com.cg.wallet.account.AccountException;
import com.cg.wallet.service.AccountService;
import com.cg.wallet.service.AccountServiceImpl;

public class Transaction {
	Scanner sc=new Scanner(System.in);
	String s=sc.next();
Account a=new Account("Anubhav","9712354883",5000);
Account a1=new Account("Mani","9598033993",5000);

AccountService s1=new AccountServiceImpl();

	@Test
	public void test()  {
		s1.AccountEntry(a);
		s1.AccountEntry(a1);
		try {
			assertEquals(4500,s1.MoneyTransfer(a.getNumber(), a1.getNumber(), 500));
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
					}
	}

}
