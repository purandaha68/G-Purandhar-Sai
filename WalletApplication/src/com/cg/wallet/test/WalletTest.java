package com.cg.wallet.test;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

import com.cg.wallet.account.Account;
import com.cg.wallet.account.AccountException;
import com.cg.wallet.account.Transaction;
import com.cg.wallet.client.Client;
import com.cg.wallet.dao.AccountDao;
import com.cg.wallet.dao.AccountDaoImpl;
import com.cg.wallet.service.AccountService;
import com.cg.wallet.service.AccountServiceImpl;

public class WalletTest {
	
	Account c=new Account();
	Account c2=new Account("Manikanth","9712354883",5000);
	Account c1=new Account("Anubhav","9598033993",5000);
	Transaction t=new Transaction(c1.getNumber(),c2.getName(),500);
	AccountService aser=new AccountServiceImpl();
	AccountDao adao=new AccountDaoImpl();
	
    
	
	@Test
	public void test()  {
		adao.AccountEntry(c1);
		adao.AccountEntry(c2);
		c.setName("Arpit");
		assertEquals("Arpit",c.getName());
		c.setAccBalance(5000);
		assertEquals(5000,c.getAccBalance());
		c.setNumber("9712354883");
		assertEquals("9712354883",c.getNumber());
		t.setFromMobile("9598033993");
		assertEquals("9598033993",t.getFromMobile());
		t.setToMobile("7376600629");
		assertEquals("7376600629",t.getToMobile());
		assertEquals( "Anubhav" ,c1.getName());

			}

}
