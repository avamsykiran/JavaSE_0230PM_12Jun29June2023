package com.cts.iosd;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.cts.iosd.model.Transaction;
import com.cts.iosd.model.TxnType;

public class App6 {

	public static void main(String[] args) {

		Path filePath = Paths.get("./txns.csv");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		Function<String, Transaction> mapper = line -> {
			String[] fields = line.split(",");
			return new Transaction(0L, fields[1], LocalDate.parse(fields[0], formatter), Double.parseDouble(fields[2]), TxnType.valueOf(fields[3]));
		};

		try {
			List<String> data = Files.readAllLines(filePath);
			
			List<Transaction> txns = data.stream().map(mapper).collect(Collectors.toList());
			
			Collections.sort(txns, (t1,t2) -> t1.getTxnDate().compareTo(t2.getTxnDate()));
			
			txns.stream().forEach( t -> t.setTxnId(txns.indexOf(t)+1) );
			
			double totalCredit = txns.stream().filter(t -> t.getType()==TxnType.CREDIT).mapToDouble(Transaction::getAmount).sum();
			double totalDebit = txns.stream().filter(t -> t.getType()==TxnType.DEBIT).mapToDouble(Transaction::getAmount).sum();
			double balance = totalCredit-totalDebit;
			
			txns.stream().forEach(System.out::println);
			
			System.out.println("Total Credit: "+totalCredit);
			System.out.println("Total Debit: "+totalDebit);
			System.out.println("Balance: "+balance);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		
	}
}
