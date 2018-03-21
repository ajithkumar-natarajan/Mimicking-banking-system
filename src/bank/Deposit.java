package bank;

public class Deposit implements Transaction{
	
	private double amount;
	private double balance;
	
	public Deposit(double amount, double balance) {
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
