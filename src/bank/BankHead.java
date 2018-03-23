package bank;

import java.util.HashMap;
import java.util.Map;

public class BankHead {
	private String code;
	private Map<String,Customer> customers;
	private Map<String, BankBranch> branches;
	
	public BankHead() {
		customers= new HashMap<String, Customer>();
		branches=new HashMap<String, BankBranch>();
	}
	public boolean addCustomer(String name, Customer customer) {
		customers.put(name, customer);
		return true;
	}
	
	public boolean addBranch(String code, BankBranch branch) {
		branches.put(code, branch);
		return true;
	}
}
