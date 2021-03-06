package com.cg.wallet.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cg.wallet.account.Account;
import com.cg.wallet.account.AccountException;
import com.cg.wallet.account.Transaction;

public class AccountDaoImpl implements AccountDao {
	HashMap<String,Account> database=new HashMap<>();
	HashMap<Long,Transaction> database1=new HashMap<>();

	@Override
	public String AccountEntry(Account account) {
		database.put(account.getNumber(), account);
		return account.getNumber();
	}

	@Override
	public int AccountWithdrawl(String mobileNumber,int w) throws AccountException {
		// TODO Auto-generated method stub
		
		if(database.containsKey(mobileNumber))	{
		Account a=database.get(mobileNumber);
		if(w>0){
		int bal=a.getAccBalance();
		int newBal=bal-w;
		if(newBal>0){
		a.setAccBalance(newBal);
		return newBal;
		}
		else{
			throw new AccountException("Balance cannot be negetive");
		}
		}
		else{
			throw new AccountException("Withdrawal Amount cannot be negetive");
		}
		}
		else
		{
			throw new AccountException("Account number not found");
		}
		
	}

	@Override
	public int AccountDeposit(String mobileNumber,int d) throws AccountException {
		if(database.containsKey(mobileNumber)){
		Account a=database.get(mobileNumber);
		if(d>0){
		int bal=a.getAccBalance();
		int newBal=bal+d;
		a.setAccBalance(newBal);
		return newBal;
	}
		else{
			throw new AccountException("Deposited amount cannot be negetive");
		}
		}
		else{
			throw new AccountException("Account number not found");
		}
	}
	@Override
	public List<Account> getAllAccount() {
		List<Account> list=new ArrayList<>();
		for(String k:database.keySet()){
			list.add(database.get(k));
		}
		return list;
	}

	@Override
	public int MoneyTransfer(String fromAccount, String toAccount, int amount) throws AccountException {
	if(database.containsKey(fromAccount) && database.containsKey(toAccount)){	
		if(!fromAccount.equals(toAccount) && amount>0){
	Account a1=database.get(fromAccount);
	Account a2=database.get(toAccount);
	int oldBal1=a1.getAccBalance();
	int oldBal2=a2.getAccBalance();
	int newAmount1=oldBal1-amount;
	int newAmount2=oldBal2+amount;
	if(newAmount1<0){
		throw new AccountException("Amount cannot be in negetive");
   }
	else{
		 a1.setAccBalance(newAmount1);
			a2.setAccBalance(newAmount2);
	
	Transaction transaction=new Transaction(fromAccount,toAccount,amount);
	database1.put(transaction.getTrans_id(), transaction);
	return a1.getAccBalance();
	}
	}
		else{
			throw new AccountException("Transaction not possible");
		}
	}
	else{
	throw new AccountException("Account numbers not found");
	}
	}
@Override
	public List<Transaction> getAllTransaction() {
		List<Transaction> list=new ArrayList<>();
		for(Long k:database1.keySet()){
			list.add(database1.get(k));
		}
		return list;
	}

@Override
public  int showBalance(String mobile) throws AccountException {
	if(database.containsKey(mobile)){
		Account a=database.get(mobile);
		return a.getAccBalance();
	}
	
	else{
		throw new AccountException("Mobile number not present");
	}
}
	

	

}
