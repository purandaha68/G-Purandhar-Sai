package com.cg.wallet.client;


import java.util.List;
import java.util.Scanner;

import com.cg.wallet.account.Account;
import com.cg.wallet.account.AccountException;
import com.cg.wallet.account.Transaction;
import com.cg.wallet.service.AccountService;
import com.cg.wallet.service.AccountServiceImpl;

public class Client {

	public static void main(String[] args) {
		
AccountService aser=new AccountServiceImpl();
Scanner sc=new Scanner(System.in);

do{
	System.out.println("Welcome to the wallet:");
	System.out.println("What are the actions you want to preform:");
	System.out.println("Enter 1 for account entry");
	System.out.println("Enter 2 for showing balance");
	System.out.println("Enter 3 for withdraw");
	System.out.println("Enter 4 for deposit");
	System.out.println("Enter 5 for money transfer");
	System.out.println("Enter 6 for Wallet Details");
	System.out.println("Enter 7 for Transaction Details");
	System.out.println("_______________________________");
	int choice=sc.nextInt();
	switch(choice){
		case 1:
		{
			
			System.out.println("Enter the name of costumer: ");
			sc.nextLine();
			String cname=sc.nextLine();
			System.out.println("Enter mobile number: ");
			String cmobile=sc.nextLine();
			System.out.println("Enter initial balance: ");
			int cbal=sc.nextInt();
			Account a=new Account(cname,cmobile,cbal);
			try{
				if(aser.validation(a))
					aser.AccountEntry(a);
				System.out.println("Congrats your account is created");
				System.out.println("________________________________");
					
			}
			catch(AccountException e){
				System.out.println(e);
			}
		
				
		}	
		break;
		
		case 2:{
			System.out.println("Enter Mobile number for balance: ");
			sc.nextLine();
			String mob=sc.nextLine();
			try {
			int k=aser.showBalance(mob);
			System.out.println("The balance in the account of given mobile number is: "+k);
			System.out.println("_________________________________________________________");
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			System.out.println("________________________");
		}
		   
		}
		break;
		
		case 3:{
			
			System.out.println("Enter Mobile number you want to withdraw from: ");
			sc.nextLine();
			String acc=sc.next();
			sc.nextLine();
			System.out.println("Enter amount you want to withdraw: ");
			int aw=sc.nextInt();
		 
		try {
			int bal = aser.AccountWithdrawl(acc,aw);
			System.out.println("The balance remaining balance is: "+bal);
			System.out.println("__________________________________________");
		} catch (AccountException e) {
			// TODO Auto-generated catch block
		System.out.println(e);
		}
			
		break;
		}
		
		case 4:{
			System.out.println("Enter mobile number you want to deposit");
			sc.nextLine();
			String acc=sc.nextLine();
			
			System.out.println("Enter amount you want to deposit: ");
			int ad=sc.nextInt();
			int bal;
			try {
				bal = aser.AccountDeposit(acc,ad);
				System.out.println("The amount in your account is: "+bal);
			} catch (AccountException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
		
		}
		break;
		
		case 5:{
			System.out.println("Enter the account ids you want to do transfer between");
			sc.nextLine();
			String acc1=sc.nextLine();
			String acc2=sc.nextLine();
			System.out.println("Enter amount you want to deposit: ");
			int bal=sc.nextInt();
			int k;
			
			try {
				k = aser.MoneyTransfer(acc1, acc2,bal);
				System.out.println("Money Transfer Complete");
				//System.out.println("The remaining account balance in account 1 is: "+k);
			 } catch (AccountException e) 
			  {
				System.out.println(e);
			  }
			}
			//System.out.println("The account balance in account 2 is: "+ );
			break;
			
		case 6:{
			System.out.println("The Account Details are as follows: ");
			System.out.println("_____________________________________");
			List<Account> clist=aser.getAll1();
			for(Account acc:clist)
			{
				System.out.println(acc);	
			}
			
			break;
		}
		
		case 7:{
			System.out.println("The tansaction details are as follows");
			System.out.println("_________________________________________");
			sc.nextLine();
		    List<Transaction> tlist=aser.getAll();
		    for(Transaction t:tlist)
		        {
		    	System.out.println(t);
		    	System.out.println("_________________________________");
		        }
		    
		     break;
			
		      }
	      
	      }
      
        } while(true);

	}

}
