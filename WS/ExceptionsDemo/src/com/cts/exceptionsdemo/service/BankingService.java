package com.cts.exceptionsdemo.service;

import com.cts.exceptionsdemo.exception.DepositeException;
import com.cts.exceptionsdemo.exception.WithdrawException;
import com.cts.exceptionsdemo.model.BankAccount;

public interface BankingService {
	void deposit(BankAccount account,double amount) throws DepositeException;
	void withdraw(BankAccount account,double amount) throws WithdrawException;
}
