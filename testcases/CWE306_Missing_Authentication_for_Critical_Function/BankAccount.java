package testcases.CWE306_Missing_Authentication_for_Critical_Function;

public class BankAccount {
	
	int accountNumber;
	String toPerson;
	int balance;

	public void setAccountNumber(int accountNumber) {
		this.accountNumber= accountNumber;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = Integer.parseInt(accountNumber);
	}
	
	public void setToPerson(String toPerson) {
		this.toPerson = toPerson;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void setBalance(String balance) {
		this.balance = Integer.parseInt(balance);
	}
	
	public int send() {
		return 0;
	}		
}
