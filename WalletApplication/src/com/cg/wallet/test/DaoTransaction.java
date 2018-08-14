package com.cg.wallet.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.wallet.account.Account;
import com.cg.wallet.account.AccountException;
import com.cg.wallet.dao.AccountDao;
import com.cg.wallet.dao.AccountDaoImpl;

public class DaoTransaction {
Account a=new Account("Anubhav","9712354883",5000);
Account a1=new Account("Mani","9598033993",5000);
AccountDao adao=new AccountDaoImpl();
	@Test
	public void test() {
		adao.AccountEntry(a);
		adao.AccountEntry(a1);
		try {
			assertEquals(4500,adao.MoneyTransfer(a.getNumber(), a1.getNumber(), 500));
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

}
