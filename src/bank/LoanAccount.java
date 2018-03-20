package bank;

import java.util.LinkedList;

public class LoanAccount extends Account {
	
	public LoanAccount(String accountNumber, double amount) {
		super(accountNumber);
		this.amount=amount;
	}
	
	public boolean deposit(double amount) {
		if(this.amount>=amount) {
			this.amount-=amount;
			Transaction deposit=new Deposit(amount, this.amount);
			this.addTransaction(deposit);
			return true;
		}else {
			System.out.println("Due amount Exceeded...!!!");
			return false;
		}
		
	}
}
