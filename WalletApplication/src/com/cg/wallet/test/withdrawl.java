package com.cg.wallet.test;
import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.wallet.account.Account;
import com.cg.wallet.account.AccountException;
import com.cg.wallet.service.AccountService;
import com.cg.wallet.service.AccountServiceImpl;


public class withdrawl {
AccountService a=new AccountServiceImpl();
Account a1=new Account("Anubhav","9598033993",5000);
	@Test
	public void test(){
		a.AccountEntry(a1);
		try {
			assertEquals(6500,a.AccountWithdrawl(a1.getNumber(), 500));
		} catch (AccountException e) {
			// TODO Auto-generated catch block
		System.out.println(e);
		}
	}

}
