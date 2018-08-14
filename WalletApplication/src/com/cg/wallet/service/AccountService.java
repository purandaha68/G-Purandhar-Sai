package com.cg.wallet.service;

import java.util.List;

import com.cg.wallet.account.Account;
import com.cg.wallet.account.AccountException;
import com.cg.wallet.account.Transaction;
public interface AccountService {
String AccountEntry(Account account );
int AccountDeposit(String mobile,int d) throws AccountException ;
List<Account> getAll1();

List<Transaction> getAll();

public boolean validation(Account account) throws AccountException;
int AccountWithdrawl(String Mobile, int w) throws AccountException;
int MoneyTransfer(String mobile1, String mobile2, int amount)throws AccountException;
int showBalance(String mobile) throws AccountException;

}
