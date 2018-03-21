package bank;

public class Withdraw implements Transaction {
	private double amount;
	private double balance;
	
	public Withdraw(double amount, double balance) {
		this.amount=amount;
		this.balance=balance;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public double getBalance() {
		return balance;
	}
}
