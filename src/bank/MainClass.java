package bank;

public class MainClass {
	public static void main(String[] args) {
		BankHead bank=new BankHead();
		BankBranch branch1=new BankBranch("b1");
		bank.addBranch("b1", branch1);
		Customer c1=new Customer("c1","customer1","address1","1234567890");
		Customer c2=new Customer("c2","customer2","address2","0987654321");
		bank.addCustomer("c1", c1);
		bank.addCustomer("c2", c2);
		branch1.openSavingsAccount(c1);
		branch1.deposit(c1);
		branch1.getTransactionCustomer(c1);
		branch1.withdraw(c1);
		branch1.getTransactionCustomer(c1);
	}
}
