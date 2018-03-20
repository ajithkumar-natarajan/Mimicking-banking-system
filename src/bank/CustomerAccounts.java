package bank;

import java.util.LinkedList;

public class CustomerAccounts {
	private SavingsAccount savingsAccount;
	private CurrentAccount currentAccount;
	private LinkedList<LoanAccount> loanAccounts;
	
	public CustomerAccounts() {
		this.savingsAccount=null;
		this.currentAccount=null;
		this.loanAccounts=new LinkedList<LoanAccount>();
	}
	
	public SavingsAccount getSavingsAccount() {
		return savingsAccount;
	}
	
	public CurrentAccount getCurrentAccount() {
		return currentAccount;
	}
	
	public LinkedList<LoanAccount> getLoanAccounts(){
		return loanAccounts;
	}
	
	private boolean checkSavingsEligiblity(){
		if(savingsAccount==null) {
			return true;
		}else return false;
	}
	
	public boolean checkCurrentEligibility() {
		if(currentAccount==null) {
			return true;
		}else return false;
	}
	
	public boolean addSavingsAccount(SavingsAccount savingsAccount) {
		if(checkSavingsEligiblity()) {
			this.savingsAccount=savingsAccount;
			return true;
		}else {
			System.out.println("Customer already has a savings account");
			return false;
		}
	}
	
	public boolean addCurrentAccount(CurrentAccount currentAccount) {
		if(checkCurrentEligibility()) {
			this.currentAccount=currentAccount;
			return true;
		}else {
			System.out.println("Customer already has a Current Account");
			return false;
		}
	}
	
	public boolean addLoanAccount(LoanAccount loanAccount) {
		loanAccounts.add(loanAccount);
		return true;
	}
}
