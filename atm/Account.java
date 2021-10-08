package atm;

/**
 * @author savant
 * This class is responsible for performing all ATM operations.
 */
public class Account {
	
	private String accountNo;
	private int amount = 0;
	
	/**
	 * Sets Account Number
	 * @param accountNo	Account number of that particular customer
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	/**
	 * Sets Amount
	 * @param amount Amount of that customer
	 */
	public void setAmount(int amount ) {
		this.amount = amount;
	}
	
	/**
	 * Returns Account Number
	 * @return Account number
	 */
	public String getAccountNo() {
		return accountNo;
	}
	
	/**
	 * Returns Amount
	 * @return	Amount
	 */
	public int getAmount() {
		return amount;
	}

}