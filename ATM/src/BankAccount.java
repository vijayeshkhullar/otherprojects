import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Date;
import java.util.Scanner;

public class BankAccount {

	// Constant
	static private int MAX_PASSWORD_LENGTH = 5;

	// Members
	private int acctNum;
	private double balance;
	private String fName;
	private String lName;
	private String pswd;
	private String log;

	// Constructors
	BankAccount() {
		acctNum = genAccNum(10);
		balance = 0;
		fName = null;
		lName = null;
		pswd = genPswd(8);
		log = "";
	}

	BankAccount(String first, String last) {
		acctNum = genAccNum(10);
		balance = 0;
		fName = first;
		lName = last;
		pswd = genPswd(8);
		log = "";
	}

	BankAccount(int a, double b, String first, String last, int c, String d) {
		acctNum = genAccNum(a);
		balance = b;
		fName = first;
		lName = last;
		pswd = genPswd(c);
		log = d;
	}

	// Signature of Methods
	boolean deposit(double a) {
		String time = genTimeStamp();
		if (a > 0) {
			balance += a;
			log += time + " Deposit Successful [" + a + "]\n";
			return true;
		} else {
			log += time + " ERROR: Deposit Unsuccessful [" + a + "]\n";
			return false;
		}

	}

	// Withdraw Money
	boolean withdraw(double a) {
		if (a > 0) {
			balance -= a;
			log += genTimeStamp() + " Withdrawal Successful! [" + a + "]\n";
			return true;
		} else {
			log += genTimeStamp() + " ERROR: Deposit Unsuccessful! [" + a + "]\n";
			return false;
		}

	}

	boolean transferTo(double a, BankAccount b) {
		if (withdraw(a) == true) {
			b.deposit(a);
			log += (genTimeStamp() + " Transfer [" + a + " to Account " + b.getAccNum() + "]\n");
			b.log += (genTimeStamp() + " Transfer [" + a + " to recieved " + getAccNum() + "]\n");

			return true;
		} else {
			return false;
		}

	}

	// Check Password
	boolean checkPswd(String a) {
		if (a == pswd) {
			return true;
		} else {
			log += genTimeStamp() + " ERROR: Password Incorrect! [" + a + "]\n";

			return false;
		}
	}

	// Reset Password
	boolean resetPswd(String current, String newer) {
		if (checkPswd(current) == true) {
			log += genTimeStamp() + " Password Successfully Changed!\n";
			pswd = newer;
			return true;
		} else {
			log += genTimeStamp() + " ERROR: Reset Password Failed!\n";

			return false;
		}
	}

	// Reset Account Number
	void resetAcctNum() {
		acctNum = 0;
		acctNum = genAccNum(10);
		return;
	}

	// Set Account First Name
	void setFName(String first) {
		fName = first;
		return;
	}

	// Set Account Last Name
	void setLName(String last) {
		lName = last;
		return;
	}

	// Get Information
	String getFName() {
		return fName;
	}

	String getLName() {
		return lName;
	}

	String getLog() {
		return log;
	}

	double getBalance() {
		return balance;
	}

	int getAccNum() {
		return acctNum;
	}

	String getPswd() {
		return pswd;
	}

	// Generates Account Number
	private int genAccNum(int a) {


//
//		for (int i = a; i > 0; i--) {
//			Random randomGenerator = new Random();
//			int randomInt1 = randomGenerator.nextInt();
//
//			if (randomInt1 > 0) {
//				acctNum = randomInt1;
//			} else {
//
//			}
//		}
//		for (int i = a; i > 0; i--) {
//			Random randomGenerator = new Random();
//			int randomInt2 = randomGenerator.nextInt(a);
//			acctNum += randomInt2;
//		}
		acctNum += (long) (Math.random()*Math.pow(10,10));
		if (acctNum < 0) {
			acctNum *= -1;
		}
		return acctNum;

	}

	// Generates A Password
	private String genPswd(int a) {
		pswd = "";
		Random randomGenerator = new Random();
		String[] strArray = { "a", "b", "c",
				"d", "e", "f", "g", "h", "i",
				"j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z", "A",
				"B", "C", "D", "E", "F", "G", "H", "I", "J",
				"K", "L", "M", "N", "O", "P", "Q", "R", "S",
				"T", "U", "V", "W", "X", "Y", "Z", "1", "2",
				"3", "4", "5", "6", "7", "8", "9", "0" };

		for (int i = a; i > 0; i--) {
			int randomInt = randomGenerator.nextInt(strArray.length);
			pswd += strArray[randomInt];
		}
		return pswd;

	}

	// Date and Time Stamp
	private String genTimeStamp() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		return timeStamp;
	}

	// Display
	void display() {
		System.out.println("Account Number: " + getAccNum());
		System.out.println("Balance: " + getBalance());
		System.out.println("First Name: " + getFName());
		System.out.println("Last Name: " + getLName());
		System.out.println("Password: " + getPswd());
		System.out.println("Log: " + getLog());

	}

	public static void main(String[] args) {
//		Scanner inputing = new Scanner(System.in);
//		System.out.println("Enter First and Last Name");
//		String first = inputing.next();
//		String last = inputing.nextLine();
//		inputing.close();
//		BankAccount a = new BankAccount(10, 500.00, first, last, 8, "");
//
//		BankAccount b = new BankAccount(10, 1000.00, "Jim", "Jones", 8, "");
//
//		a.display();
	}

}



