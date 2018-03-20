package bank;

import java.util.LinkedList;

public abstract class Account {
	protected String accountNumber;
	protected double amount;
	protected LinkedList<Transaction> transactions;
	
	public Account(String accountNumber) {
		this.accountNumber=accountNumber;
		amount=0;
		transactions=new LinkedList<Transaction>();
	}
	
	protected boolean withdraw(double amount) {
		if(this.amount>=amount) {
			this.amount-=amount;
			Transaction withdraw=new Withdraw(amount, this.amount);
			this.addTransaction(withdraw);
			System.out.println("Withdraw Successful..!!");
			return true;
		}else {
			System.out.println("Low on balance ..!!!");
			return false;
		}
	}
	
	protected boolean deposit(double amount) {
		this.amount+=amount;
		Transaction deposit=new Deposit(amount, this.amount);
		this.addTransaction(deposit);
		System.out.println("Deposit Successful..!! on "+this.getAccountNumber());
		return true;
	}
	
	protected void addTransaction(Transaction transaction) {
		this.transactions.add(transaction);
	}
	
	protected LinkedList<Transaction> getTransactions(){
		return transactions;
	}
	
	protected String getAccountNumber() {
		return accountNumber;
	}
	
	protected double getBalance() {
		return amount;
	}
}
