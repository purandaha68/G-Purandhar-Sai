package com.cg.wallet.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.wallet.account.Account;
import com.cg.wallet.account.AccountException;
import com.cg.wallet.service.AccountService;
import com.cg.wallet.service.AccountServiceImpl;

public class validationTest {
AccountService aser=new AccountServiceImpl();
Account a=new Account("Anubhav","9598033993",5000);
	@Test
	public void test() {
		try {
			assertEquals(true,aser.validation(a));
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

}
