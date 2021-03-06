package com.cg.wallet.account;

import java.time.LocalDate;

public class Transaction {
	private int trans_id;
	static int id=101;
	LocalDate trans_date;
	private String fromAccount;
	private String toAccount;
	private double amount;
	
  public Transaction()
  {
	trans_id=id++;
	trans_date=LocalDate.now();
  }
  
  public Transaction(String fromAccount,String toAccount,double amount)
  {
	this();
	this.fromAccount=fromAccount;
	this.toAccount=toAccount;
	this.amount=amount;	
  }
  
  
public long getTrans_id() {
	return trans_id;
}
public void setTrans_id(int trans_id) {
	this.trans_id = trans_id;
}

public String getFromMobile() {
	return fromAccount;
}
public void setFromMobile(String fromMobile) {
	this.fromAccount = fromMobile;
}
public String getToMobile() {
	return toAccount;
}
public void setToMobile(String toMobile) {
	this.toAccount = toMobile;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public String toString(){
	return "Transaction id "+trans_id+" [ From Mobile: ] "+fromAccount+" [ To Mobile: ] "+toAccount+" [ Amount:] "+amount+"  "+" [ Date: ]"+trans_date;
	
}

}