package com.cg.wallet.service;

import java.util.List;

import com.cg.wallet.account.Account;
import com.cg.wallet.account.AccountException;
import com.cg.wallet.account.Transaction;
import com.cg.wallet.dao.AccountDao;
import com.cg.wallet.dao.AccountDaoImpl;

public  class AccountServiceImpl implements AccountService {
AccountDao adao=new AccountDaoImpl();
	@Override
	public String AccountEntry(Account account) {
	return adao.AccountEntry(account);
	}

	@Override
	public int AccountDeposit(String Mobile,int d) throws AccountException  {
		return adao.AccountDeposit(Mobile, d);
	}

	@Override
	public List<Account> getAll1() {
		return adao.getAllAccount();
	}

	@Override
	public int AccountWithdrawl(String Mobile, int w) throws AccountException  {
		return adao.AccountWithdrawl(Mobile, w);
	}

	@Override
	public int MoneyTransfer(String mobile1, String mobile2, int amount)throws AccountException 
			 {
		return adao.MoneyTransfer(mobile1, mobile2, amount);
	}

	@Override
	public List<Transaction> getAll() {
		return adao.getAllTransaction();
	}

	@Override
	public boolean validation(Account account) throws AccountException {
		if(!account.getName().matches("[A-Za-z]{3,15}")){
			throw new AccountException("Wrong Name");
		}
		if(!account.getNumber().matches("[7-90-9]{10}")){
			throw new AccountException("Invalid Mobile Number Format");
		}
		
		
		return true;
	}

	@Override
	public int showBalance(String mobile) throws AccountException {
		
		return adao.showBalance(mobile);
	}
	
	}

	


