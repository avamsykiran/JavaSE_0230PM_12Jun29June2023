package com.cts.exceptionsdemo;

import java.util.Scanner;
import java.util.stream.Stream;

import com.cts.exceptionsdemo.exception.DepositeException;
import com.cts.exceptionsdemo.exception.WithdrawException;
import com.cts.exceptionsdemo.model.BankAccount;
import com.cts.exceptionsdemo.service.BankingService;
import com.cts.exceptionsdemo.service.BankingServiceImpl;

public class Application {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		BankingService bankingService = new BankingServiceImpl();
		
		BankAccount account = new BankAccount("12345678",6700.0);
		
		Options opt = null;
		
		String optionsStr = Stream.of(Options.values()).map(op -> op.toString()).reduce((s1,s2)->s1+","+s2).orElse("");
		
		while(opt!=Options.QUIT) {
			System.out.println(optionsStr + "? ");
			String optEntered = scan.next().toUpperCase();
			
			if(optionsStr.indexOf(optEntered)==-1) {
				System.out.println("Invalid Option");
				continue;
			}
			
			opt = Options.valueOf(optEntered);
			
			try {
				switch(opt) {
				case WITHDRAW:
					System.out.println("Withdraw Amount? ");
					double withdrawAmt = scan.nextDouble();
					bankingService.withdraw(account, withdrawAmt);
					System.out.println("Amount withdrawn successfully");
					break;
				case DIPOSITE:
					System.out.println("Diposite Amount? ");
					double depositeAmt = scan.nextDouble();
					bankingService.deposit(account, depositeAmt);
					System.out.println("Amount deposited successfully");
					break;
				case BALANCE:
					System.out.println(account.getBalance());
					break;
				case QUIT:
					System.out.println("ThankQ! BYE");
					break;
				}
			}catch(WithdrawException | DepositeException exp) {
				System.out.println(exp.getMessage());
			}
		}
		
		scan.close();
	}

}
