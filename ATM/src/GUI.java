import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.List;
import java.awt.Button;
import javax.swing.JComboBox;
import java.awt.ScrollPane;
import java.awt.Label;
import java.awt.Panel;
import javax.swing.Icon;
import java.awt.TextArea;

public class GUI {

//	check if logged in
	public static boolean loggedIn = false;

	private JFrame frame;
	private CardLayout layout = new CardLayout(0, 0);
	final String MAIN_VIEW_ID = "MAIN VIEW";
	final String LOGIN_VIEW_ID = "LOGIN VIEW";
	final String REGISTER_VIEW_ID = "REGISTER VIEW";
	final String ACCT_VIEW_ID = "ACCOUNT INFORMATION VIEW";
	final String HISTORY_VIEW_ID = "HISTORY VIEW";
	final String WITHDRAW_VIEW_ID = "WITHDRAW VIEW";
	final String DEPOSIT_VIEW_ID = "DEPOSIT VIEW";
	final String TRANSFER_VIEW_ID = "TRANSFER VIEW";


	// Banks
	BankAccountManager bam = new BankAccountManager();
	BankAccount currentAccount = null;
	private JTextField acctNumInput;
	private JTextField pswdInput;
	private JTextField newFirstNameInput;
	private JTextField newLastNameInput;
	private JTextField newPswdInput;
	private JTextField withdrawalInput;
	private JTextField depositAmountInput;
	private JTextField transferTextInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
		BankAccount b1 = new BankAccount("Darth", "Vader");
		BankAccount b2 = new BankAccount("Obi", "Wan");
		BankAccount b3 = new BankAccount("Luke", "Skywalker");
		

		bam.addAcct(b1);
		bam.addAcct(b2);
		bam.addAcct(b3);
		bam.display();
		b1.display();
		b2.display();


	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(layout);

		// Login Panel
		JPanel LoginJP = new JPanel();
		LoginJP.setForeground(new Color(255, 215, 0));
		LoginJP.setBackground(new Color(0, 0, 128));
		frame.getContentPane().add(LoginJP, LOGIN_VIEW_ID);
		LoginJP.setLayout(null);

		// Account Number Input for Login
		final JTextField acctNumInput = new JTextField();
		acctNumInput.setBounds(175, 72, 161, 20);
		LoginJP.add(acctNumInput);
		acctNumInput.setColumns(10);
		// Account Number Label
		JLabel acctNum = new JLabel("Account Number:");
		acctNum.setFont(new Font("Tahoma", Font.BOLD, 13));
		acctNum.setForeground(new Color(255, 215, 0));
		acctNum.setBounds(41, 73, 124, 17);
		LoginJP.add(acctNum);
		// Password Input for Login
		pswdInput = new JPasswordField();
		pswdInput.setBounds(175, 104, 161, 20);
		LoginJP.add(pswdInput);
		pswdInput.setColumns(10);
		// Password Label
		JLabel pswdLabel = new JLabel("Password:");
		pswdLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		pswdLabel.setForeground(new Color(255, 215, 0));
		pswdLabel.setBounds(84, 105, 97, 17);
		LoginJP.add(pswdLabel);

		// Login Button
//		JButton loginButton = new JButton("Login");
//		loginButton.setForeground(new Color(0, 0, 128));
//		loginButton.setBackground(new Color(255, 215, 0));
//		loginButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String inputText = acctNumInput.getText();
//				String inputText2 = pswdInput.getText();
//				System.out.println(inputText);
//				System.out.println(inputText2);
//
//
//				if (!inputText.isEmpty() && !inputText2.isEmpty()) {
//					int inputAtLogin = Integer.parseInt(inputText);
//					int numDigits = String.valueOf(inputAtLogin).length();
//
//					if (numDigits >= 9 && numDigits <= 11) {
//						currentAccount = bam.getAccount(inputAtLogin);
////						System.out.println("Check Pass " + currentAccount.getPswd() + " " + inputText2);
//						if (currentAccount != null && currentAccount.getPswd().equals(inputText2)) {
//							acctNumInput.setText("");
//							pswdInput.setText("");
//							
////							set status as logged in
//							loggedIn = true;
//							layout.show(frame.getContentPane(), MAIN_VIEW_ID);
//						} else {
////							System.out.print(currentAccount.getPswd().equals(inputText2) + "\n ");
////							System.out.print(currentAccount.getPswd() + " " + inputText2);
//							JOptionPane.showMessageDialog(frame, "Invalid Credentials: Please Try Again",
//									"Invalid Credentials", JOptionPane.ERROR_MESSAGE);
//							acctNumInput.setText("");
//							pswdInput.setText("");
//						}
//					}
//
//					else {
//						JOptionPane.showMessageDialog(frame, "Invalid Credentials: Please Try Again",
//								"Invalid Credentials", JOptionPane.ERROR_MESSAGE);
//						acctNumInput.setText("");
//						pswdInput.setText("");
//
//					}
//				} else if (inputText.isEmpty()){
//					JOptionPane.showMessageDialog(frame, "Please Enter An Account Number", "Empty Credentials",
//							JOptionPane.WARNING_MESSAGE);
//					acctNumInput.setText("");
//				}
//				else if(inputText2.isEmpty()) {
//					JOptionPane.showMessageDialog(frame, "Please Enter A Password", "Empty Credentials",
//							JOptionPane.WARNING_MESSAGE);
//					acctNumInput.setText("");
//				}
//
//			}
//		});
//
//		loginButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
//		loginButton.setBounds(158, 141, 100, 23);
//		LoginJP.add(loginButton);

		// Register Button
		JButton registerButton = new JButton("Register");
		registerButton.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		registerButton.setBackground(new Color(255, 215, 0));
		registerButton.setForeground(new Color(0, 0, 128));
		registerButton.setBorderPainted(false);
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(frame.getContentPane(), REGISTER_VIEW_ID);

			}
		});

		registerButton.setBounds(213, 207, 89, 23);
		LoginJP.add(registerButton);

//		Deposit Panel
		JPanel depositJP = new JPanel();
		depositJP.setBackground(new Color(0, 0, 128));
		frame.getContentPane().add(depositJP, DEPOSIT_VIEW_ID);
		depositJP.setLayout(null);

		Button backButton_1_1_1 = new Button("Back");
		backButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(frame.getContentPane(), MAIN_VIEW_ID);
			}
		});
		backButton_1_1_1.setForeground(new Color(0, 0, 128));
		backButton_1_1_1.setFont(new Font("Dialog", Font.BOLD, 13));
		backButton_1_1_1.setBackground(new Color(255, 215, 0));
		backButton_1_1_1.setBounds(335, 229, 70, 22);
		depositJP.add(backButton_1_1_1);

//		Deposit Panel
		Label label_3_1_1_1 = new Label("Deposit");
		label_3_1_1_1.setForeground(new Color(0, 0, 128));
		label_3_1_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		label_3_1_1_1.setBackground(new Color(255, 215, 0));
		label_3_1_1_1.setAlignment(Label.CENTER);
		label_3_1_1_1.setBounds(0, 0, 434, 44);
		depositJP.add(label_3_1_1_1);

		JLabel depositAmountLabel = new JLabel("Deposit Amount:");
		depositAmountLabel.setForeground(new Color(255, 215, 0));
		depositAmountLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		depositAmountLabel.setBackground(new Color(255, 215, 0));
		depositAmountLabel.setBounds(27, 123, 166, 22);
		depositJP.add(depositAmountLabel);

		depositAmountInput = new JTextField();
		depositAmountInput.setColumns(10);
		depositAmountInput.setBounds(213, 125, 86, 20);
		depositJP.add(depositAmountInput);
		
		JButton depositAmountButton = new JButton("Confirm");
		depositAmountButton.setForeground(new Color(0, 0, 128));
		depositAmountButton.setBackground(new Color(255, 215, 0));
		depositAmountButton.setBounds(213, 169, 89, 23);
		depositJP.add(depositAmountButton);

		JLabel lblCurrentBalance_1 = new JLabel("Current Balance: $0");
		lblCurrentBalance_1.setForeground(new Color(255, 215, 0));
		lblCurrentBalance_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCurrentBalance_1.setBackground(new Color(255, 215, 0));
		lblCurrentBalance_1.setBounds(27, 81, 195, 22);
		depositJP.add(lblCurrentBalance_1);

		depositAmountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!depositAmountInput.equals("")) {
					String depositAmount = depositAmountInput.getText();
					
					double depositNum = Double.parseDouble(depositAmount);

					currentAccount.deposit(depositNum);
					lblCurrentBalance_1.setText("Current Balance: $" + currentAccount.getBalance());
					depositAmountInput.setText("");
					currentAccount.display();
					SwingUtilities.updateComponentTreeUI(depositJP);

				}
			}
		});


		// Withdraw Panel
		JPanel withdrawJP = new JPanel();
		frame.getContentPane().add(withdrawJP, WITHDRAW_VIEW_ID);
		withdrawJP.setLayout(null);

		// WITHDRAW Panel 2
		JPanel withdrawJP2 = new JPanel();
		withdrawJP2.setLayout(null);
		withdrawJP2.setBackground(new Color(0, 0, 128));
		withdrawJP2.setBounds(0, 0, 434, 261);
		withdrawJP.add(withdrawJP2);

		Button backButton_1_1 = new Button("Back");
		backButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(frame.getContentPane(), MAIN_VIEW_ID);

			}
		});
		backButton_1_1.setForeground(new Color(0, 0, 128));
		backButton_1_1.setFont(new Font("Dialog", Font.BOLD, 13));
		backButton_1_1.setBackground(new Color(255, 215, 0));
		backButton_1_1.setBounds(335, 229, 70, 22);
		withdrawJP2.add(backButton_1_1);

		Label label_3_1_1 = new Label("Withdraw");
		label_3_1_1.setForeground(new Color(0, 0, 128));
		label_3_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		label_3_1_1.setBackground(new Color(255, 215, 0));
		label_3_1_1.setAlignment(Label.CENTER);
		label_3_1_1.setBounds(0, 0, 434, 44);
		withdrawJP2.add(label_3_1_1);

		JLabel lblWithdrawalAmount = new JLabel("Withdrawal Amount:");
		lblWithdrawalAmount.setForeground(new Color(255, 215, 0));
		lblWithdrawalAmount.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblWithdrawalAmount.setBackground(new Color(255, 215, 0));
		lblWithdrawalAmount.setBounds(27, 123, 166, 22);
		withdrawJP2.add(lblWithdrawalAmount);

		withdrawalInput = new JTextField();
		withdrawalInput.setBounds(213, 125, 86, 20);
		withdrawJP2.add(withdrawalInput);
		withdrawalInput.setColumns(10);

		JButton withdrawAmountButton = new JButton("Confirm");
		
		JLabel lblCurrentBalance = new JLabel("Current Balance: $");
		lblCurrentBalance.setForeground(new Color(255, 215, 0));
		lblCurrentBalance.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCurrentBalance.setBackground(new Color(255, 215, 0));
		lblCurrentBalance.setBounds(27, 81, 195, 22);
		withdrawJP2.add(lblCurrentBalance);

		withdrawAmountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!withdrawalInput.equals("")) {
					String withdrawalAmount = withdrawalInput.getText();

					double withdrawNum = Double.parseDouble(withdrawalAmount);

					currentAccount.withdraw(withdrawNum);
					lblCurrentBalance.setText("Current Balance: $" + currentAccount.getBalance());

					withdrawalInput.setText("");
					SwingUtilities.updateComponentTreeUI(depositJP);
				}
			}
		});
		withdrawAmountButton.setForeground(new Color(0, 0, 128));
		withdrawAmountButton.setBackground(new Color(255, 215, 0));
		withdrawAmountButton.setBounds(213, 169, 89, 23);
		withdrawJP2.add(withdrawAmountButton);

		
		// Register Label
		JLabel newToBankLbl = new JLabel("Don't Have An Account?");
		newToBankLbl.setForeground(new Color(255, 255, 255));
		newToBankLbl.setHorizontalAlignment(SwingConstants.CENTER);
		newToBankLbl.setBounds(175, 175, 161, 21);
		LoginJP.add(newToBankLbl);

		JPanel mainJP = new JPanel();
		mainJP.setBackground(new Color(255, 215, 0));
		frame.getContentPane().add(mainJP, MAIN_VIEW_ID);
		mainJP.setLayout(null);

		// Logout Button
		JButton logoutButton = new JButton("Logout");
		logoutButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		logoutButton.setForeground(new Color(255, 255, 255));
		logoutButton.setBackground(new Color(0, 0, 128));
		logoutButton.setBorderPainted(false);
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(frame.getContentPane(), LOGIN_VIEW_ID);

			}
		});

		JButton withdrawButton = new JButton("Withdraw");
		withdrawButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		withdrawButton.setForeground(new Color(255, 255, 255));
		withdrawButton.setBorderPainted(false);
		withdrawButton.setBackground(new Color(0, 0, 128));
		withdrawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(frame.getContentPane(), WITHDRAW_VIEW_ID);
				lblCurrentBalance.setText("Current Balance: $" + currentAccount.getBalance());

			}
		});

		Label label = new Label("Welcome To Seaquam Banking");
		label.setForeground(new Color(255, 215, 0));
		label.setBackground(new Color(0, 0, 128));
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		label.setBounds(10, 10, 395, 22);
		mainJP.add(label);
		withdrawButton.setBounds(44, 167, 109, 23);
		mainJP.add(withdrawButton);
		logoutButton.setBounds(268, 201, 109, 23);
		mainJP.add(logoutButton);
		

		JPanel historyJP = new JPanel();
		historyJP.setBackground(new Color(0, 0, 128));
		frame.getContentPane().add(historyJP, HISTORY_VIEW_ID);
		historyJP.setLayout(null);

		Button backButton_1 = new Button("Back");
		backButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(frame.getContentPane(), MAIN_VIEW_ID);

			}
		});
		backButton_1.setForeground(new Color(0, 0, 128));
		backButton_1.setFont(new Font("Dialog", Font.BOLD, 13));
		backButton_1.setBackground(new Color(255, 215, 0));
		backButton_1.setBounds(335, 229, 70, 22);
		historyJP.add(backButton_1);

		
		Label label_3_1 = new Label("History");
		label_3_1.setForeground(new Color(0, 0, 128));
		label_3_1.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		label_3_1.setBackground(new Color(255, 215, 0));
		label_3_1.setAlignment(Label.CENTER);
		label_3_1.setBounds(0, 0, 434, 44);
		historyJP.add(label_3_1);

		JLabel lblTransactionLog = new JLabel("Transaction Log:");
		lblTransactionLog.setForeground(new Color(255, 215, 0));
		lblTransactionLog.setBackground(new Color(255, 215, 0));
		lblTransactionLog.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		lblTransactionLog.setBounds(10, 63, 121, 22);
		historyJP.add(lblTransactionLog);
		
		TextArea hist = new TextArea();
		hist.setEditable(false);
		hist.setBounds(153, 68, 252, 144);
		historyJP.add(hist);

		JButton viewTranButton = new JButton("History");
		viewTranButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		viewTranButton.setForeground(new Color(255, 255, 255));
		viewTranButton.setBackground(new Color(0, 0, 128));
		viewTranButton.setBorderPainted(false);
		viewTranButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(frame.getContentPane(), HISTORY_VIEW_ID);
				hist.setText("Transaction History: \n" + currentAccount.getLog());
				

			}
		});
		viewTranButton.setBounds(44, 99, 109, 23);
		mainJP.add(viewTranButton);

		JButton depositButton = new JButton("Deposit");
		depositButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		depositButton.setForeground(new Color(255, 255, 255));
		depositButton.setBackground(new Color(0, 0, 128));
		depositButton.setBorderPainted(false);
		depositButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCurrentBalance_1.setText("Current Balance: $" + currentAccount.getBalance());
				layout.show(frame.getContentPane(), DEPOSIT_VIEW_ID);

			}
		});
		depositButton.setBounds(44, 133, 109, 23);
		mainJP.add(depositButton);
		
//		transfer page
		JPanel transferJP = new JPanel();
		frame.getContentPane().add(transferJP, TRANSFER_VIEW_ID);
		transferJP.setLayout(null);
		
		JPanel transferJP_1 = new JPanel();
		transferJP_1.setLayout(null);
		transferJP_1.setBounds(0, 0, 434, 261);
		transferJP.add(transferJP_1);
		
		JPanel transferJP2_1 = new JPanel();
		transferJP2_1.setLayout(null);
		transferJP2_1.setBackground(new Color(0, 0, 128));
		transferJP2_1.setBounds(0, 0, 434, 261);
		transferJP_1.add(transferJP2_1);
		
		Button backButton_1_1_2 = new Button("Back");
		backButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(frame.getContentPane(), MAIN_VIEW_ID);
			}
		});
		backButton_1_1_2.setForeground(new Color(0, 0, 128));
		backButton_1_1_2.setFont(new Font("Dialog", Font.BOLD, 13));
		backButton_1_1_2.setBackground(new Color(255, 215, 0));
		backButton_1_1_2.setBounds(335, 229, 70, 22);
		transferJP2_1.add(backButton_1_1_2);
		
		Label transferTitleLabel = new Label("Transfer");
		transferTitleLabel.setForeground(new Color(0, 0, 128));
		transferTitleLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		transferTitleLabel.setBackground(new Color(255, 215, 0));
		transferTitleLabel.setAlignment(Label.CENTER);
		transferTitleLabel.setBounds(0, 0, 434, 44);
		transferJP2_1.add(transferTitleLabel);
		
		JLabel transferAmountLabel = new JLabel("Transfer Amount:");
		transferAmountLabel.setForeground(new Color(255, 215, 0));
		transferAmountLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		transferAmountLabel.setBackground(new Color(255, 215, 0));
		transferAmountLabel.setBounds(27, 150, 166, 22);
		transferJP2_1.add(transferAmountLabel);
		
		transferTextInput = new JTextField();
		transferTextInput.setColumns(10);
		transferTextInput.setBounds(203, 152, 86, 20);
		transferJP2_1.add(transferTextInput);
		
		
		
		JLabel lblCurrentBalance_2 = new JLabel("Current Balance: $0");
		lblCurrentBalance_2.setForeground(new Color(255, 215, 0));
		lblCurrentBalance_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCurrentBalance_2.setBackground(new Color(255, 215, 0));
		lblCurrentBalance_2.setBounds(27, 63, 195, 22);
		transferJP2_1.add(lblCurrentBalance_2);
		
		
		JLabel lblSelectPayee = new JLabel("Select Payee:");
		lblSelectPayee.setForeground(new Color(255, 215, 0));
		lblSelectPayee.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelectPayee.setBackground(new Color(255, 215, 0));
		lblSelectPayee.setBounds(27, 109, 166, 22);
		transferJP2_1.add(lblSelectPayee);
		
		Choice choice = new Choice();
		choice.setBounds(203, 109, 86, 20);
		transferJP2_1.add(choice);
		BankAccount[] allAccounts = bam.showAllAccounts();
		
		JButton transferButton = new JButton("Transfer");
		transferButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCurrentBalance_2.setText("Current Balance: $" + currentAccount.getBalance());
				layout.show(frame.getContentPane(), TRANSFER_VIEW_ID);
				for(int i = 0; i < 100; i++) {
					if(allAccounts[i] != null && allAccounts[i] != currentAccount) {
						System.out.println(allAccounts[i] + " " + currentAccount.getAccNum() );
						choice.add(String.valueOf(allAccounts[i].getAccNum()));
					}

				}
			}
		});
		
		JButton confirmTransferButton = new JButton("Confirm");
		confirmTransferButton.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		confirmTransferButton.setBorderPainted(false);
		confirmTransferButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!transferTextInput.equals("")) {
					String transferAmount = transferTextInput.getText();

					double transferNum = Double.parseDouble(transferAmount);

					currentAccount.transferTo(transferNum, bam.getAccount(Integer.parseInt(choice.getSelectedItem())));
					lblCurrentBalance_2.setText("Current Balance: $" + currentAccount.getBalance());
					
					transferTextInput.setText("");
					JOptionPane.showMessageDialog(frame,
							"Your Tranfer Of $" + transferNum + " To " + choice.getSelectedItem() + " Has Been Successfull."
									,
							"Success", JOptionPane.PLAIN_MESSAGE);
					SwingUtilities.updateComponentTreeUI(transferJP);
				}

			}
		});
		confirmTransferButton.setForeground(new Color(0, 0, 128));
		confirmTransferButton.setBackground(new Color(255, 215, 0));
		confirmTransferButton.setBounds(328, 151, 77, 23);
		transferJP2_1.add(confirmTransferButton);
		transferButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		transferButton.setForeground(new Color(255, 255, 255));
		transferButton.setBackground(new Color(0, 0, 128));
		transferButton.setBorderPainted(false);
		transferButton.setBounds(44, 201, 109, 23);
		mainJP.add(transferButton);

		JButton acctInfo = new JButton("Account");
		acctInfo.setFont(new Font("Tahoma", Font.BOLD, 13));
		acctInfo.setForeground(new Color(255, 255, 255));
		acctInfo.setBackground(new Color(0, 0, 128));
		acctInfo.setBorderPainted(false);
		acctInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(frame.getContentPane(), ACCT_VIEW_ID);

			}
		});
		acctInfo.setBounds(44, 65, 109, 23);
		mainJP.add(acctInfo);

		Canvas canvas = new Canvas();
		canvas.setBackground(new Color(0, 0, 139));
		canvas.setBounds(0, 0, 434, 42);
		mainJP.add(canvas);
		JLabel picLabel = new JLabel(new ImageIcon("C:\\Users\\vijay\\eclipse-workspace\\ATM\\src\\res\\logo.jpg"));
		picLabel.setLocation(244, 69);
		picLabel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 128)));
		mainJP.add(picLabel);
		picLabel.setSize(152, 121);

		JPanel registerJP = new JPanel();
		registerJP.setBackground(new Color(0, 0, 128));
		frame.getContentPane().add(registerJP, REGISTER_VIEW_ID);
		registerJP.setLayout(null);

		// Register First Name Label
		JLabel frstNameLabel = new JLabel("First Name:");
		frstNameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		frstNameLabel.setForeground(new Color(255, 215, 0));
		frstNameLabel.setBounds(63, 75, 90, 14);
		registerJP.add(frstNameLabel);

		// Register Last Name Label
		JLabel lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lastNameLabel.setForeground(new Color(255, 215, 0));
		lastNameLabel.setBounds(63, 106, 79, 14);
		registerJP.add(lastNameLabel);

		// Register Password Label
		JLabel newPswdLabel = new JLabel("Password:");
		newPswdLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		newPswdLabel.setForeground(new Color(255, 215, 0));
		newPswdLabel.setBounds(63, 139, 79, 14);
		registerJP.add(newPswdLabel);

		// Register First Name Input
		newFirstNameInput = new JTextField();
		newFirstNameInput.setBounds(141, 73, 174, 20);
		registerJP.add(newFirstNameInput);
		newFirstNameInput.setColumns(10);

		// Register Last Name Input
		newLastNameInput = new JTextField();
		newLastNameInput.setBounds(141, 104, 174, 20);
		registerJP.add(newLastNameInput);
		newLastNameInput.setColumns(10);

		// Register Password Input
		newPswdInput = new JPasswordField();
		newPswdInput.setBounds(141, 137, 174, 20);
		registerJP.add(newPswdInput);
		newPswdInput.setColumns(10);

		// Register Sign Up Button
		JButton signUpButton = new JButton("Register");
		signUpButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		signUpButton.setBackground(new Color(255, 215, 0));
		signUpButton.setForeground(new Color(0, 0, 128));
		signUpButton.setBorderPainted(false);
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankAccount b4 = new BankAccount();
				bam.addAcct(b4);
				String frstName = newFirstNameInput.getText();
				String lstName = newLastNameInput.getText();
				String newPswd = newPswdInput.getText();

				if (!frstName.isEmpty() && !lstName.isEmpty() && !newPswd.isEmpty()) {
					b4.setFName(frstName);
					b4.setLName(lstName);
					b4.resetPswd(b4.getPswd(), newPswd);

					layout.show(frame.getContentPane(), LOGIN_VIEW_ID);
					JOptionPane.showMessageDialog(frame,
							"Your Account Has Been Successfully Created! Here Is Your Account Number: "
									+ b4.getAccNum(),
							"New Account", JOptionPane.PLAIN_MESSAGE);
					b4.display();
				} else if (frstName.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Please Enter A First Name", "Empty Credentials",
							JOptionPane.WARNING_MESSAGE);
					acctNumInput.setText("");
				} else if (lstName.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Please Enter A Last Name", "Empty Credentials",
							JOptionPane.WARNING_MESSAGE);
					acctNumInput.setText("");
				} else if (newPswd.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Please Enter A Password", "Empty Credentials",
							JOptionPane.WARNING_MESSAGE);
					acctNumInput.setText("");
				}

			}
		});
		signUpButton.setBounds(141, 188, 174, 23);
		registerJP.add(signUpButton);

		Label label_3 = new Label("Create An Account");
		label_3.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		label_3.setAlignment(Label.CENTER);
		label_3.setBackground(new Color(255, 215, 0));
		label_3.setForeground(new Color(0, 0, 128));
		label_3.setBounds(0, 0, 434, 44);
		registerJP.add(label_3);

		Button backButton = new Button("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(frame.getContentPane(), LOGIN_VIEW_ID);

			}
		});
		backButton.setBackground(new Color(255, 215, 0));
		backButton.setForeground(new Color(0, 0, 128));
		backButton.setFont(new Font("Dialog", Font.BOLD, 13));

		backButton.setBounds(339, 214, 70, 22);
		registerJP.add(backButton);

		JPanel acctInfoJP = new JPanel();
		acctInfoJP.setBackground(new Color(255, 215, 0));
		acctInfoJP.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(acctInfoJP, ACCT_VIEW_ID);
		acctInfoJP.setLayout(null);

		JButton changePswdButton = new JButton("Change Password");
		changePswdButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		changePswdButton.setForeground(new Color(255, 215, 0));
		changePswdButton.setBackground(new Color(0, 0, 128));
		changePswdButton.setBorderPainted(false);
		changePswdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass= JOptionPane.showInputDialog("New Password: ");

		        String firmPass= JOptionPane.showInputDialog("Confirm New Password: ");
		        
		        if(firmPass.equals(pass)) {
					currentAccount.resetPswd(currentAccount.getPswd(), firmPass);
					JOptionPane.showMessageDialog(frame, "Password Reset Successful",
							"Success", JOptionPane.PLAIN_MESSAGE);

					}else {
						JOptionPane.showMessageDialog(frame, "Your Passwords Do Not Match",
								"Error", JOptionPane.WARNING_MESSAGE);
					}
		       }

		});
		changePswdButton.setBounds(154, 205, 119, 23);
		acctInfoJP.add(changePswdButton);

		JButton deleteAccButton = new JButton("Delete Account");
		deleteAccButton.setFont(new Font("Trebuchet MS", Font.BOLD, 10));
		deleteAccButton.setForeground(new Color(255, 215, 0));
		deleteAccButton.setBackground(new Color(0, 0, 128));
		deleteAccButton.setBorderPainted(false);
		deleteAccButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(frame, "ARE YOU SURE YOU WANT TO DELETE YOUR ACCOUNT? IT WILL BE PERMANENTLY LOST" + currentAccount.getPswd(),
//						"Invalid Credentials", JOptionPane.WARNING_MESSAGE);
//				
				if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				    bam.rmAcct(currentAccount);
					layout.show(frame.getContentPane(), LOGIN_VIEW_ID);

				} else {
				    // no option
				}
			}
		});
		deleteAccButton.setBounds(283, 205, 119, 23);
		acctInfoJP.add(deleteAccButton);

		JButton homeButton = new JButton("Home Page");
		homeButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layout.show(frame.getContentPane(), MAIN_VIEW_ID);
			}
		});
		homeButton.setForeground(new Color(255, 215, 0));
		homeButton.setBackground(new Color(0, 0, 128));
		homeButton.setBorderPainted(false);
		homeButton.setBounds(24, 205, 119, 23);
		acctInfoJP.add(homeButton);
		System.out.print("Here is the current account: " + currentAccount);
//		if(loggedIn) {
//			JLabel firstNameAcctLabel = new JLabel("First Name: " + currentAccount.getFName());
//			firstNameAcctLabel.setBounds(185, 100, 196, 14);
//			acctInfoJP.add(firstNameAcctLabel);
//			
//			JLabel lastNameAcctLabel = new JLabel("Last Name: " + currentAccount.getLName());
//			lastNameAcctLabel.setBounds(185, 125, 196, 14);
//			acctInfoJP.add(lastNameAcctLabel);
//			
//			JLabel acctNumAcctInfoLabel = new JLabel("Account Number: " + currentAccount.getAccNum());
//			acctNumAcctInfoLabel.setBounds(185, 151, 196, 14);
//			acctInfoJP.add(acctNumAcctInfoLabel);
//		}

		JLabel firstNameAcctLabel = new JLabel("First Name: ");
		firstNameAcctLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		firstNameAcctLabel.setBounds(203, 79, 196, 14);
		acctInfoJP.add(firstNameAcctLabel);

		JLabel lastNameAcctLabel = new JLabel("Last Name: ");
		lastNameAcctLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lastNameAcctLabel.setBounds(206, 122, 196, 14);
		acctInfoJP.add(lastNameAcctLabel);

		JLabel acctNumAcctInfoLabel = new JLabel("Account Number: ");
		acctNumAcctInfoLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		acctNumAcctInfoLabel.setBounds(203, 168, 196, 14);
		acctInfoJP.add(acctNumAcctInfoLabel);

		Label label_2 = new Label("Account Information");
		label_2.setAlignment(Label.CENTER);
		label_2.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		label_2.setForeground(new Color(255, 215, 0));
		label_2.setBackground(new Color(0, 0, 128));
		label_2.setBounds(0, 0, 434, 58);
		acctInfoJP.add(label_2);

		JLabel picLabel_1 = new JLabel(new ImageIcon("C:\\Users\\vijay\\eclipse-workspace\\ATM\\src\\res\\logo.jpg"));
		picLabel_1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 128)));
		picLabel_1.setBounds(24, 79, 119, 103);
		acctInfoJP.add(picLabel_1);


		// Login Button
		JButton loginButton = new JButton("Login");
		loginButton.setForeground(new Color(0, 0, 128));
		loginButton.setBackground(new Color(255, 215, 0));
		loginButton.setBorderPainted(false);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputText = acctNumInput.getText();
				String inputText2 = pswdInput.getText();
				System.out.println(inputText);
				System.out.println(inputText2);

				if (!inputText.isEmpty() && !inputText2.isEmpty()) {
					int inputAtLogin = Integer.parseInt(inputText);
					int numDigits = String.valueOf(inputAtLogin).length();

					if (numDigits >= 9 && numDigits <= 11) {
						currentAccount = bam.getAccount(inputAtLogin);
						
//						TEMPORARILY MADE PASSWORD CHECK NULL
						if (currentAccount != null && currentAccount.getPswd().equals(inputText2)) {
							acctNumInput.setText("");
							pswdInput.setText("");

//							set the account info page...
							firstNameAcctLabel.setText("First Name: " + currentAccount.getFName());
							lastNameAcctLabel.setText("Last Name: " + currentAccount.getLName());
							acctNumAcctInfoLabel.setText("Account Number: " + currentAccount.getAccNum());

//							set the history for the user
							System.out.print("\n" + currentAccount.getLog());
							lblTransactionLog.setText("Transaction History: " + currentAccount.getLog());
//							set the balance
							lblCurrentBalance.setText("Current Balance: $" + currentAccount.getBalance());
							lblCurrentBalance_1.setText("Current Balance: $" + currentAccount.getBalance());
//							load the main page
							layout.show(frame.getContentPane(), MAIN_VIEW_ID);
						} else {
							JOptionPane.showMessageDialog(frame, "Invalid Credentials: Please Try Again",
									"Invalid Credentials", JOptionPane.ERROR_MESSAGE);
							acctNumInput.setText("");
							pswdInput.setText("");
						}
					}

					else {
						JOptionPane.showMessageDialog(frame, "Invalid Credentials: Please Try Again",
								"Invalid Credentials", JOptionPane.ERROR_MESSAGE);
						acctNumInput.setText("");
						pswdInput.setText("");

					}
				} else if (inputText.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Please Enter An Account Number", "Empty Credentials",
							JOptionPane.WARNING_MESSAGE);
					acctNumInput.setText("");
				} else if (inputText2.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Please Enter A Password", "Empty Credentials",
							JOptionPane.WARNING_MESSAGE);
					acctNumInput.setText("");
				}

			}
		});

		loginButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		loginButton.setBounds(175, 141, 161, 23);
		LoginJP.add(loginButton);

		Label label_1 = new Label("Seaquam Banking");
		label_1.setForeground(new Color(0, 0, 128));
		label_1.setBackground(new Color(255, 215, 0));
		label_1.setAlignment(Label.CENTER);
		label_1.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		label_1.setBounds(0, 0, 434, 52);
		LoginJP.add(label_1);
		

	}
}
