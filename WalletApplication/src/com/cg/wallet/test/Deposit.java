package com.cg.wallet.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.wallet.account.Account;
import com.cg.wallet.account.AccountException;
import com.cg.wallet.service.AccountService;
import com.cg.wallet.service.AccountServiceImpl;

public class Deposit {
Account a=new Account("Anubhav","9712354883",5000);
AccountService a1=new AccountServiceImpl();
	@Test
	public void test() {
		a1.AccountEntry(a);
		try {
			assertEquals(6500,a1.AccountDeposit(a.getNumber(), 500));
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

}
