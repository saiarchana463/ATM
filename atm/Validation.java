package atm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author savant
 * Check whether the customer exist or not 
 */
public class Validation {

	
	/**
	 * @throws IOException 
	 * 
	 */
	public static LinkedHashSet<Account> userObjectsCreation(LinkedHashSet<Account> customerList) throws IOException {
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader("CustomerDetails"));
		String line ;
		String[] lines = new String[2];
		while((line = reader.readLine()) != null) {
			lines = line.split(" ");
			Account accountObj = new Account();
			customerList.add(accountObj);
			accountObj.setAccountNo(lines[1]);
		}
		return customerList;
	}
	
	
	/**
	 * This method is to check is he first time user or not and based on that object is returned
	 * @param customerList 	contains all customer objects who visited ATM
	 * @param accountNo		Account number of that particular customer
	 * @return				returns new customer object if he is first time user else returns already created object 
	 */
	public static Account returnUserObject(LinkedHashSet<Account> customerList, String accountNo) {
		for(Account i : customerList) {
			if(i.getAccountNo().equals(accountNo)) {
				return i;
			}
		}
		return null;
	}
	
	/**
	 * Checks whether the notes are available for given withdrawal amount, if available then it returns count of each type of notes .
	 * @param withdrawAmount	amount to withdraw by customer
	 * @param notesInMachine	Total notes available in ATM machine
	 * @return					returns message based on withdrawal amount and notes available in machine
	 */
	public static String checkAvailablity(int withdrawAmount,Map<Integer,Integer> notesInMachine) {
		int[] noteCounter = new int[4];
		int[] notes = {2000,500,200,100};
		for(int i = 0;i<4;i++) {
			if(withdrawAmount >= notes[i]) {
				noteCounter[i] = withdrawAmount / notes[i];
				withdrawAmount = withdrawAmount - noteCounter[i] * notes[i];
			}
		}
		if(withdrawAmount == 0) {
			int i =0;
			for (Map.Entry<Integer, Integer> entry : notesInMachine.entrySet()) {
				if(noteCounter[i]>entry.getValue()) {
					return null;
				}
				i++;
	        }
			int j = 0;
			for (Map.Entry<Integer,Integer> entry : notesInMachine.entrySet()) {
			    notesInMachine.put(entry.getKey(),Integer.valueOf(entry.getValue()-noteCounter[j++]));
			}
			return "Please collect cash!\n2000:"+noteCounter[0]+"\t500:"+noteCounter[1]+"\t200:"+noteCounter[2]+"\t100:"+noteCounter[3];
		}
		return null;
	}

}