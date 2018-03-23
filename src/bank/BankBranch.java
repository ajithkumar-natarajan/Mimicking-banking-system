package bank;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class BankBranch {
	private String code;
	Map<Customer, CustomerAccounts> accounts;
	private Scanner sc=new Scanner(System.in);
	
	public BankBranch(String code) {
		this.code=code;
		accounts=new HashMap<Customer, CustomerAccounts>();
	}
	
	private void addAccount(Customer customer) {
		CustomerAccounts CustomerAccounts=new CustomerAccounts();
		accounts.put(customer, CustomerAccounts);
		return;
	}
	
	public void openSavingsAccount(Customer customer) {
		if(accounts.containsKey(customer)) {	
			System.out.println("Enter Savings account number");
			SavingsAccount savingsAccount=new SavingsAccount(sc.nextLine());
			accounts.get(customer).addSavingsAccount(savingsAccount);
			System.out.println("Savings Account created...!!!");
		}else {
			addAccount(customer);
			openSavingsAccount(customer);
		}
	}
	
	public void openCurrentAccount(Customer customer) {
		if(accounts.containsKey(customer)) {	
			System.out.println("Enter Current account number");
			CurrentAccount currentAccount=new CurrentAccount(sc.nextLine());
			accounts.get(customer).addCurrentAccount(currentAccount);
			System.out.println("Current Account created...!!!");
		}else {
			addAccount(customer);
			openCurrentAccount(customer);
		}
	}
	
	public void openLoanAccount(Customer customer) {
		if(accounts.containsKey(customer)) {
			System.out.println("Enter Loan Account Number and Amount ");
			LoanAccount loanAccount=new LoanAccount(sc.nextLine(), sc.nextDouble());
			accounts.get(customer).addLoanAccount(loanAccount);
			System.out.println("Loan Account created...!!!");
		}else System.out.println("The Customer is not registered with the bank");
	}
	
	public void getTransactionCustomer(Customer customer) {
		CustomerAccounts ca=accounts.get(customer);
		System.out.println("Enter the type of account for transactions\n1.Savings\n2.Current\n3.Loan\n");
		switch(sc.nextInt()) {	
		case 1:
			if(ca.getSavingsAccount()!=null) {
				this.getTransactionAccount(ca.getSavingsAccount());
			}else System.out.println("The Customer does not have a savings account");
			break;
		case 2:
			if(ca.getCurrentAccount()!=null) {
				this.getTransactionAccount(ca.getCurrentAccount());
			}else System.out.println("The Customer does not have a current account");
			break;
		case 3:
			if(ca.getLoanAccounts()!=null) {
				LinkedList<LoanAccount> loanAccountList=ca.getLoanAccounts();
				System.out.println("---- Available Loan Accounts ----");
				Iterator<LoanAccount> it=loanAccountList.iterator();
				while(it.hasNext()) {
					LoanAccount temp=it.next();
					System.out.println("Account Number : "+temp.getAccountNumber()+"  (y/n)?");
					if(sc.next().equals("y")) {
						this.getTransactionAccount(temp);
						break;
					}
				}
			}
			break;
		}
	}
	
	private void getTransactionAccount(Account account) {
		LinkedList<Transaction> transactions=account.getTransactions();
		Iterator<Transaction> it=transactions.iterator();
		System.out.println("------------------- TRANSACTIONS AC No: "+account.getAccountNumber()+" -------------------");
		while(it.hasNext()) {
			Transaction temp=it.next();
			if(temp instanceof Deposit) {
				System.out.print("CREDIT : ");
			}else if(temp instanceof Withdraw) {
				System.out.print("DEBIT : ");
			}
			System.out.println(temp.getAmount()+"     BALANCE : "+temp.getBalance());
		}
		System.out.println("------------------- END OF TRANSACTIONS -------------------");
	}
	
	public void withdraw(Customer customer) {
		CustomerAccounts ca=accounts.get(customer);
		System.out.println("Enter the type of account to withdraw\n1.Savings\n2.Current\n");
		switch(sc.nextInt()) {
		case 1:
			if(ca.getSavingsAccount()!=null) {
				System.out.println("Enter the amount to withdraw from Saving account : "+ca.getSavingsAccount().getAccountNumber());
				ca.getSavingsAccount().withdraw(sc.nextDouble());
			}else System.out.println("The customer does not have a Savings Account ");
			break;
		case 2:
			if(ca.getCurrentAccount()!=null) {
				System.out.println("Enter the amount to withdraw from Current account : "+ca.getCurrentAccount().getAccountNumber());
				ca.getCurrentAccount().withdraw(sc.nextDouble());
			}else System.out.println("The Customer does not have Current Account ");
			break;
		}
	}
	
	public void deposit(Customer customer) {
		CustomerAccounts ca=accounts.get(customer);
		System.out.println("Enter the type of account to deposit\n1.Savings\n2.Current\n3.Loan Account");
		switch(sc.nextInt()) {
		case 1:
			if(ca.getSavingsAccount()!=null) {
				System.out.println("Enter the amount to deposit to Savings account : "+ca.getSavingsAccount().getAccountNumber());
				ca.getSavingsAccount().deposit(sc.nextDouble());
			}else System.out.println("The customer does not have a Savings Account ");
			break;
		case 2:
			if(ca.getCurrentAccount()!=null) {
				System.out.println("Enter amount to deposit to Current Account : "+ca.getCurrentAccount().getAccountNumber());
				ca.getCurrentAccount().deposit(sc.nextDouble());
			}else System.out.println("The customer does not have a current Account ");
			break;
		case 3:
			if(ca.getLoanAccounts()!=null) {
				LinkedList<LoanAccount> loanList=ca.getLoanAccounts();
				System.out.println("---- Available Loan Accounts ----");
				Iterator<LoanAccount> it=loanList.iterator();
				while(it.hasNext()) {
					LoanAccount temp=it.next();
					System.out.println("Account Number : "+temp.getAccountNumber()+"  (y/n)?");
					if(sc.next().equals("y")) {
						System.out.println("Enter the due amount to be paid : Available due : "+temp.getBalance());
						temp.deposit(sc.nextDouble());
						break;
					}
				}
			}
			break;
		}
	}
}
