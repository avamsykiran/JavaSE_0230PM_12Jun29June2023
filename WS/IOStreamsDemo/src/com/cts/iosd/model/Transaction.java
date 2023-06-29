package com.cts.iosd.model;

import java.time.LocalDate;

public class Transaction {

	private long txnId;
	private String header;
	private LocalDate txnDate;
	private double amount;
	private TxnType type;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(long txnId, String header, LocalDate txnDate, double amount, TxnType type) {
		super();
		this.txnId = txnId;
		this.header = header;
		this.txnDate = txnDate;
		this.amount = amount;
		this.type = type;
	}

	public long getTxnId() {
		return txnId;
	}

	public void setTxnId(long txnId) {
		this.txnId = txnId;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public LocalDate getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(LocalDate txnDate) {
		this.txnDate = txnDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public TxnType getType() {
		return type;
	}

	public void setType(TxnType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Transaction [txnId=" + txnId + ", header=" + header + ", amount=" + amount + ", type=" + type + "]";
	}
	
	
}
