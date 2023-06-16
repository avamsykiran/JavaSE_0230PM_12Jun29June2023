package com.cts.exceptionsdemo.service;

import com.cts.exceptionsdemo.exception.DepositeException;
import com.cts.exceptionsdemo.exception.WithdrawException;
import com.cts.exceptionsdemo.model.BankAccount;

public class BankingServiceImpl implements BankingService {
	
	public static final double MIN_BAL=5000;

	@Override
	public void deposit(BankAccount account, double amount) throws DepositeException {
		
		if(account==null) {
			throw new DepositeException("No Such Account Exists");
		}
		
		if(amount<0) {
			throw new DepositeException("Invalid amount. Amount is expected to be a positive number");
		}
		
		account.setBalance(account.getBalance()+amount);
	}

	@Override
	public void withdraw(BankAccount account, double amount) throws WithdrawException {
		if(account==null) {
			throw new WithdrawException("No Such Account Exists");
		}
		
		if(amount<0) {
			throw new WithdrawException("Invalid amount. Amount is expected to be a positive number");
		}
		
		if(account.getBalance()-amount<MIN_BAL) {
			throw new WithdrawException("Insufficient Funds");
		}
		
		account.setBalance(account.getBalance()-amount);
	}

}
