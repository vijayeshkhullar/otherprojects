public class BankAccountManager {

	//Members
	private int numAccts;
	private BankAccount[] acctArray = new BankAccount[MAX_ACCOUNT_NUM];
	
	//Constants
	private static final int MAX_ACCOUNT_NUM = 100;
	
	//Constructors
	BankAccountManager(){
		numAccts = 0;
		int accountArray[] = new int[MAX_ACCOUNT_NUM];
	}
	
	//Methods
	private int findFirstEmpty() {
		if(acctArray == null) {
			return 0;
		}
		for(int i = 0; i < MAX_ACCOUNT_NUM; i++) {
			if(acctArray[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	private boolean isAcctNumUnique(int a) {
		for(int i = 0; i < acctArray.length;) {
			if (acctArray[i] != null) {
				if(acctArray[i].getAccNum() == a) {
					return false;
				}	
			}
			
		i++;
		}
		return true;
	}
	
	boolean addAcct (BankAccount a) {
		int empty = findFirstEmpty();

		if (empty != -1 && isAcctNumUnique(a.getAccNum()) == true) {
			acctArray[empty] = a;
			numAccts +=1;
			return true;
							
		}
		else {
			a.resetAcctNum();
			addAcct(a);
			return false;
		}
		
		
//		// index of empty account
//		int b = findFirstEmpty();
//		System.out.println(b);
//		// getting the account number from bank account a
//		int c = a.getAccNum();
//		
//		// ensure that bank index is of an empty part of array
//		if(b != -1) {
//			
//			if (isAcctNumUnique(c)) {
//				System.out.print(acctArray[b]);
//				acctArray[b] = a;
//				numAccts += 1;
//				return true;
//			}
//			else if (!isAcctNumUnique(c)) {
//				a.resetAcctNum();
//			}
//		}
//		return false;
	}
	
	boolean rmAcct (BankAccount a) {
		for(int i = 0; i < MAX_ACCOUNT_NUM; i++) {
			if(acctArray[i] != null) {
				if(acctArray[i] == a) {
					acctArray[i] = null;
					return true;
				}
				
			}
		}
		return false;
	}			
		
	
	BankAccount getAccount (int a) {
		for(int i = 0; i < MAX_ACCOUNT_NUM; i++) {
			if(acctArray[i].getAccNum() == a) {
				return acctArray[i];
			}
		}
		return null;
	}
	
	void depositIntoAll (double a) {
		for(int i = 0; i < MAX_ACCOUNT_NUM; i++) {
			if(acctArray[i] != null) {
				acctArray[i].deposit(a);	
			}
		}
		return;
	}
	void withdrawFromAll (double a) {
		for(int i = 0; i < MAX_ACCOUNT_NUM; i++) {
			if(acctArray[i] != null) {
				acctArray[i].withdraw(a);
				
			}
		}
		return;
	}
	void clearAccts () {
		for(int i = 0; i < MAX_ACCOUNT_NUM; i++) {
			acctArray[i] = null;
			numAccts = 0;
		}
		return;
	}
	void display() {
		for(int i = 0; i < MAX_ACCOUNT_NUM; i++) {
			if(acctArray[i] == null) {
				return;
			}
			else{
				System.out.println(acctArray[i].getAccNum());
			}
		}

	}
	
	BankAccount[] showAllAccounts() {
		return acctArray;
	}
	
	
	public static void main(String[] args) {
//		BankAccountManager a = new BankAccountManager();
//		BankAccount b = new BankAccount(10, 0.00, "Joe", "Mama", 8, "");
//		BankAccount c = new BankAccount(10, 0.00, "Jim", "Forkey", 8, "");
//		BankAccount d = new BankAccount(10, 0.00, "Jerry", "Krim", 8, "");
//		BankAccount e = new BankAccount(10, 0.00, "Jill", "Ile", 8, "");
//
//		
//		b.display();
//		
//		//Adding Accounts
//		a.addAcct(b);
//		a.addAcct(c);
//		a.addAcct(d);
//		a.addAcct(e);
//
////		a.depositIntoAll(500);
////		a.withdrawFromAll(500);
//
//		a.display();
//		
//		a.rmAcct(b);
//		
//		a.display();		
//		
////		b.display();
////		c.display();
////		d.display();
////		e.display();


	}

}








