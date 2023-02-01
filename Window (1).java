import java.awt.EventQueue;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Panel;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.Color;

import java.util.HashMap;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.text.SimpleDateFormat;  
import java.util.Date;  

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window {
	private JFrame frame;
	private String Admin_Code = "azsxdcfvgbhnjm"; //encryption of admin code.

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
//		Connect();
		table_load();
//		layeredPane layeredPane = new layeredPane();
	}
	
	Popup p;
	PopupFactory pf;
	JPanel p2;
	
	Popup p_stock;
	PopupFactory pf_stock;
	
	Popup p_stocks;
	PopupFactory pf_stocks;
	
	String Fuel;
	String Price;
	Connection con;
	PreparedStatement pstm;
	PreparedStatement recom_stm;
	PreparedStatement recom_now;
	
	
	Statement stmt;
	String pst;
	String rec;
	String user_database;
	ResultSet rs;

	ResultSet rss;
	
	ResultSet resc;
	
	ResultSet result_now;
	JTable table = new JTable();
	JTable table_people = new JTable();
	JTable table_tot = new JTable();
	JTable table_history_user = new JTable();
	JTable table_All_History = new JTable();
	JTable table_dealer = new JTable();
	
	String Username_signup;
	String Password_signup;
	
	String Username_login;
	String Password_login;
	
	int customer_id;
	String Admin_signup;
	
	String textFieldValue;
	String jobs;
//	ResultSet rs;
	private JTextField textField_1_username_su;
	private JTextField textField_3_pass_su;
	private JTextField textField_4_admin_su;
	
	private JTextField BrandtxtField;
	private JTextField ModeltxtField;
	private JTextField username_log;
	private JTextField FueltxtField;
	private JTextField PricetxtField;
	private HashMap<Object, Object> hm = new HashMap<>();
	private JTextField txtReccomendationForYou;
	private JTextField CarID_Stock;
	private JTextField Amount_Stock;
	
	private JTextField CarID_Stocks;
	private JTextField Amount_Stocks;
	
	private JTextField CarID_Stockss;
	private JTextField Amount_Stockss;
	
	int c_ID = 0;
	int car_ID = 0;
	int dealer_ID = 0;
	int t_ID = 0;
	
	String tempor;
	
	private JTextField passwordField;
	private JTextField passwordField_1;
	private JTextField Engine;
	private JTextField change_pw;
	private JTextField StockAdd;
	private JTextField Brand_Dealer;
	private JTextField From_Dealer;
	private JTextField Phone_Dealer;
	private JTextField Mail_Dealer;
	private JTextField Sales_Dealer;
	
	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/TestData","root","");
		}
		catch (ClassNotFoundException ex) {
			
		}
		catch (SQLException ex) {
			
		}
	}
	
	public void table_load() {
		try
		{	
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/Automotive2","root","");
		
			pst = ("Select * from car");
			rec = ("Select Brand,Model,Price,EngineSize,Fuel FROM car WHERE Price < 49000");
			user_database = ("Select custID,Username,CarPreference,Job from customer");
				
			pstm = con.prepareStatement(pst);
			stmt = con.createStatement();
			recom_stm = con.prepareStatement(rec);
			recom_now = con.prepareStatement(user_database);
			
			resc = recom_stm.executeQuery(rec);
			rs = stmt.executeQuery(pst);
			rss = pstm.executeQuery(pst);
			result_now =recom_now.executeQuery(user_database);
			
//			 while (rs.next()) {
//		         hm.put(rs.getInt("Price"));
//			 }
//			 System.out.println(hm);
			
			System.out.print(rs);
			
			
			table.setModel(DbUtils.resultSetToTableModel(rss));
			table_people.setModel(DbUtils.resultSetToTableModel(resc));
			table_tot.setModel(DbUtils.resultSetToTableModel(result_now));
			
			//DEALER TABLE
			Statement statement = con.createStatement();
			pst = ("Select * from brand");
			pstm = con.prepareStatement(pst);
			
			rss = pstm.executeQuery(pst);
			table_dealer.setModel(DbUtils.resultSetToTableModel(rss));
			//DEALER TABLE
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1133, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 10, 1062, 663);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		final JPanel LogIn = new JPanel();
		LogIn.setBackground(new Color(250, 170, 5));
		layeredPane.add(LogIn, "name_2204709660598400");
		LogIn.setLayout(null);
		
		final JPanel Profile = new JPanel();
		layeredPane.add(Profile, "name_13452570935800");
		Profile.setLayout(null);
		
		final JPanel User_Transaction = new JPanel();
		layeredPane.add(User_Transaction, "name_32415589152000");
		User_Transaction.setLayout(null);
		
		final JPanel Dealer_Info = new JPanel();
		layeredPane.add(Dealer_Info, "name_33214383097100");
		Dealer_Info.setLayout(null);
		
		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setFont(new Font("Tahoma", Font.PLAIN, 99));
		lblProfile.setBounds(375, 22, 292, 170);
		Profile.add(lblProfile);
		
		JLabel lblNewLabel_1_doi = new JLabel("Username :");
		lblNewLabel_1_doi.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_1_doi.setBounds(31, 333, 170, 43);
		Profile.add(lblNewLabel_1_doi);
		
		final JLabel lblNewLabel_1_1_doi = new JLabel("a");
		lblNewLabel_1_1_doi.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_1_1_doi.setBounds(243, 333, 170, 43);
		Profile.add(lblNewLabel_1_1_doi);
		
		///////////////////////////////////////////////////////////////////
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@///////////////////////////////////////////////////////////////////
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		final JPanel SignUp = new JPanel();
		SignUp.setBackground(new Color(236, 160, 19));
		layeredPane.add(SignUp, "name_2204709669107000");
		JButton btnNewButton_1DIO = new JButton("Log In");
		btnNewButton_1DIO.setBackground(new Color(128, 128, 128));
		btnNewButton_1DIO.setFont(new Font("Tahoma", Font.BOLD, 27));
		
		final JPanel panel = new JPanel();
		layeredPane.add(panel, "name_1837848829924800");
		panel.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 40));
		passwordField.setBounds(340, 434, 232, 81);
		LogIn.add(passwordField);
		
		SignUp.setLayout(null);
		
		final JPanel MainUser = new JPanel();
		layeredPane.add(MainUser, "name_13452566314300");
		MainUser.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_doi = new JLabel("Password :");
		lblNewLabel_1_1_1_doi.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_1_1_1_doi.setBounds(34, 425, 170, 43);
		Profile.add(lblNewLabel_1_1_1_doi);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    System.out.println(formatter.format(date));  
		
		btnNewButton_1DIO.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
		 
//				String varName = (String)comboBox.getSelectedItem();
//				String value = comboBox.getSelectedItem().toString();
//				System.out.print(value);
				
				Username_login = username_log.getText();
				Password_login = passwordField.getText();
				
				System.out.println(Username_signup+ Password_signup+Admin_signup);
				
				
				String for_cid = "SELECT Pin from customer where Username = '" + Username_login +"'";
				String for_cidd = "SELECT Job from customer where Username = '" + Username_login +"'";
				String get_custID = "SELECT custID from customer where Username = '" + Username_login + "'";
//				ResultSet result;
				String checking = "a";
				
				try {
					ResultSet result;
					ResultSet results;
					
					Statement stmt = con.prepareStatement(for_cid);
					Statement stmts = con.prepareStatement(for_cidd);
					Statement statement_cid = con.prepareStatement(get_custID);
					
					result = stmt.executeQuery(for_cid);
					results = stmts.executeQuery(for_cidd);
					ResultSet result_cid = statement_cid.executeQuery(get_custID);
					if (result_cid.next()) {
						customer_id = result_cid.getInt("custID");
						System.out.print(customer_id);
					}
					if (result.next()) {
					    checking = result.getString(1);
					    
					}
					if (checking.equals(Password_login)) {
						if (results.next()) {
						    jobs = results.getString(1);
						    
						    if (jobs.equals("Admin")) {
						    	layeredPane.removeAll(); 
								layeredPane.add(panel);
								layeredPane.repaint();
								layeredPane.revalidate();
						    }else {
						    	layeredPane.removeAll(); 
								layeredPane.add(MainUser);
								layeredPane.repaint();
								layeredPane.revalidate();
						    }
						    
						}
					}
					
					//HISTORY USER
					String rec_history = ("Select Date,Brand,Model,Price FROM transaction WHERE CustID =" +customer_id);
					Statement history_user;

						history_user = con.prepareStatement(pst);
						ResultSet execute_user_history = history_user.executeQuery(rec_history);
						table_history_user.setModel(DbUtils.resultSetToTableModel(execute_user_history));
					
					System.out.println("CHECKING " + customer_id + " CHECKING");

					//HISTORY USER
					
					//ALL HISTORY(MOD)
					String all_history = ("Select * FROM transaction");
					Statement history_all;

						history_all = con.prepareStatement(pst);
						ResultSet execute_all_history = history_all.executeQuery(all_history);
						table_All_History.setModel(DbUtils.resultSetToTableModel(execute_all_history));
					
					System.out.println("CHECKING " + customer_id + " CHECKING");
					
					//ALL HISTORY(MOD)
	
					System.out.print(checking);
					
				}catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				if (checking.equals(Password_login)) {
					
				}
			}
		});
		btnNewButton_1DIO.setBounds(643, 239, 216, 112);
		LogIn.add(btnNewButton_1DIO);
		
		JButton btnSignUp_1 = new JButton("Sign Up");
		btnSignUp_1.setBackground(Color.LIGHT_GRAY);
		btnSignUp_1.setFont(new Font("Tahoma", Font.BOLD, 27));
		btnSignUp_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(SignUp);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnSignUp_1.setBounds(645, 421, 216, 112);
		LogIn.add(btnSignUp_1);
		
		final JPanel User_Reccomendation = new JPanel();
		layeredPane.add(User_Reccomendation, "name_1858884586652100");
		User_Reccomendation.setLayout(null);
		
		JLabel lblNewLabel_1DIO = new JLabel("Username");
		lblNewLabel_1DIO.setBounds(177, 276, 216, 37);
		lblNewLabel_1DIO.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		LogIn.add(lblNewLabel_1DIO);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setBounds(182, 451, 169, 54);
		lblPassword_1.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		LogIn.add(lblPassword_1);
		
		username_log = new JTextField();
		username_log.setFont(new Font("Tahoma", Font.PLAIN, 40));
		username_log.setBounds(340, 257, 232, 71);
		username_log.setColumns(10);
		LogIn.add(username_log);
		
		JLabel CR1 = new JLabel("CAR");
		CR1.setFont(new Font("Times New Roman", Font.PLAIN, 60));
		CR1.setBounds(443, 56, 139, 81);
		LogIn.add(CR1);
		
		JLabel CR2 = new JLabel("RECOMMENDATION");
		CR2.setFont(new Font("Times New Roman", Font.PLAIN, 60));
		CR2.setBounds(243, 134, 659, 81);
		LogIn.add(CR2);
		
		final JPanel Admin_Mod_1 = new JPanel();
		Admin_Mod_1.setLayout(null);
		Admin_Mod_1.setBorder(new TitledBorder(null, "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		layeredPane.add(Admin_Mod_1, "name_1837842991765700");
		
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Username");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(279, 93, 81, 22);
		SignUp.add(lblNewLabel_1_1);
		
		textField_1_username_su = new JTextField(); //username signup
		textField_1_username_su.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textField_1_username_su.setColumns(10);
		textField_1_username_su.setBounds(207, 126, 240, 94);
		SignUp.add(textField_1_username_su);
	
		
		JLabel lblPassword_1_1 = new JLabel("Password");
		lblPassword_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword_1_1.setBounds(284, 261, 76, 22);
		SignUp.add(lblPassword_1_1);
		
//		textField_3_pass_su = new JTextField(); //Password signup
//		textField_3_pass_su.setColumns(10);
//		textField_3_pass_su.setBounds(233, 263, 220, 70);
//		SignUp.add(textField_3_pass_su);
//		
//		JLabel lblPassword_1_1_1 = new JLabel("Admin Code");
//		lblPassword_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
//		lblPassword_1_1_1.setBounds(579, 126, 139, 22);
//		SignUp.add(lblPassword_1_1_1);
		
		textField_4_admin_su = new JTextField();
		textField_4_admin_su.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textField_4_admin_su.setColumns(10);
		textField_4_admin_su.setBounds(579, 126, 240, 94);
		SignUp.add(textField_4_admin_su);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Car Preference");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(635, 261, 162, 22);
		SignUp.add(lblNewLabel_1_1_1);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.DARK_GRAY);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 28));
		comboBox.setBounds(579, 294, 240, 104);
		comboBox.addItem("Practical Car");
		comboBox.addItem("Performance Car");
		SignUp.add(comboBox);
		
		JButton btnNewButtonDIO = new JButton("Create");
		btnNewButtonDIO.setFont(new Font("Tahoma", Font.PLAIN, 34));
		btnNewButtonDIO.setBounds(404, 440, 265, 135);
		btnNewButtonDIO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String varName = (String)comboBox.getSelectedItem();
				String value = comboBox.getSelectedItem().toString();
				System.out.print(value);
				
				Username_signup = textField_1_username_su.getText();
				Password_signup = textField_3_pass_su.getText();
				Admin_signup = textField_4_admin_su.getText();
				
				System.out.println(Username_signup+ Password_signup+Admin_signup);
				String for_cid = "SELECT MAX(custID)FROM customer";
//				ResultSet result;
				try {
					ResultSet result;
					Statement stmt = con.prepareStatement(for_cid);
					result = stmt.executeQuery(for_cid);
					if (result.next()) {
					    c_ID = result.getInt(1);
					}
					System.out.println(c_ID);
//					Insert INTO car Values (1,'acura','a',300,'bbb',1);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
//				System.out.print(result);
				try {
					Statement statement = con.createStatement();
//					System.out.print("INSERT INTO customer " + "VALUES (" + c_ID + "'"+Username_signup+"'" + ","+ "'"+Password_signup+"'" +","+ "'"+value+"'" + ","+ "'Admin'"+")");
					boolean a = true;
					ResultSet results_info = statement.executeQuery("SELECT Username FROM customer");
					 while (results_info.next()) {
				         String Model = results_info.getString("Username");
				         if (Model.equals(Username_signup)) {
				        	 a = false;
				         }
					 }

					
					if (a) {
						if(Admin_signup.equals("dewagua")) {
							c_ID ++;
							statement.executeUpdate("INSERT INTO customer " + "VALUES (" + c_ID +","+ "'"+Username_signup+"'" + ","+ "'"+Password_signup+"'" +","+ "'"+value+"'" + ","+ "'Admin'"+")");
							layeredPane.removeAll(); 
							layeredPane.add(panel);
							layeredPane.repaint();
							layeredPane.revalidate();
						}else {
							if(Username_signup.equals("")) {
								
							}else {
								layeredPane.removeAll(); 
								layeredPane.add(MainUser);
								layeredPane.repaint();
								layeredPane.revalidate();
	//							String Username_signup;
	//							String Password_signup;
	//							
								Username_login = Username_signup;
								Password_login = Password_signup;
								c_ID ++;
								statement.executeUpdate("INSERT INTO customer " + "VALUES (" + c_ID +","+ "'"+Username_signup+"'" + ","+ "'"+Password_signup+"'" +","+ "'"+value+"'" + "," + "'Customer'"+")");
							}
							
							
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block 
					e1.printStackTrace();
				}
				
			}
		});
		
		SignUp.add(btnNewButtonDIO);
		
		textField_3_pass_su = new JPasswordField();
		textField_3_pass_su.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textField_3_pass_su.setBounds(207, 294, 240, 104);
		SignUp.add(textField_3_pass_su);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Admin_Code");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_2.setBounds(658, 93, 100, 22);
		SignUp.add(lblNewLabel_1_1_2);
		
		JButton btnNewButton_4 = new JButton("Back");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(LogIn);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_4.setBounds(10, 11, 100, 32);
		SignUp.add(btnNewButton_4);
		
		JLabel lblNewLabel_4 = new JLabel("!Disclaimer! FOR ADMIN ONLY");
		lblNewLabel_4.setForeground(new Color(188, 67, 67));
		lblNewLabel_4.setBounds(633, 221, 144, 14);
		SignUp.add(lblNewLabel_4);
///////////////////////////////////////////////////////////////////
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@///////////////////////////////////////////////////////////////////
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Model");
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_5_1.setBounds(24, 203, 77, 24);
		Admin_Mod_1.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("Brand");
		lblNewLabel_1_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_3_1.setBounds(24, 103, 112, 24);
		Admin_Mod_1.add(lblNewLabel_1_1_3_1);
		
		BrandtxtField = new JTextField();
		BrandtxtField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		BrandtxtField.setColumns(10);
		BrandtxtField.setBounds(194, 91, 178, 53);
		Admin_Mod_1.add(BrandtxtField);
		
		ModeltxtField = new JTextField();
		ModeltxtField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		ModeltxtField.setColumns(10);
		ModeltxtField.setBounds(192, 191, 180, 53);
		Admin_Mod_1.add(ModeltxtField);
		
		FueltxtField = new JTextField();
		FueltxtField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		FueltxtField.setColumns(10);
		FueltxtField.setBounds(192, 400, 180, 53);
		Admin_Mod_1.add(FueltxtField);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("Fuel");
		lblNewLabel_1_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4_1_1.setBounds(25, 412, 134, 24);
		Admin_Mod_1.add(lblNewLabel_1_4_1_1);
		
		PricetxtField = new JTextField();
		PricetxtField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		PricetxtField.setColumns(10);
		PricetxtField.setBounds(192, 297, 180, 53);
		Admin_Mod_1.add(PricetxtField);
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Price");
		lblNewLabel_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2_1_1.setBounds(24, 309, 148, 24);
		Admin_Mod_1.add(lblNewLabel_1_1_2_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Admin Mod");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(456, 0, 102, 44);
		Admin_Mod_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Car Modifier");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(Admin_Mod_1);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnNewButton.setBounds(208, 453, 612, 179);
		panel.add(btnNewButton);
		
		final JPanel User_Data = new JPanel();
		layeredPane.add(User_Data, "name_1840243717249900");
		User_Data.setLayout(null);
		
		JButton btnUserDatabase = new JButton("User Database");
		btnUserDatabase.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnUserDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(User_Data);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnUserDatabase.setBounds(208, 241, 612, 160);
		panel.add(btnUserDatabase);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(LogIn);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
			
			
		});
		btnNewButton_1.setBounds(10, 11, 121, 49);
		panel.add(btnNewButton_1);
		
		JButton btnDealerInfo = new JButton("Dealer Info");
		btnDealerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(Dealer_Info);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnDealerInfo.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnDealerInfo.setBounds(208, 24, 612, 160);
		panel.add(btnDealerInfo);
		
		JButton btnNewButton_1_1_1 = new JButton("Back");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(panel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnNewButton_1_1_1.setBounds(12, 27, 89, 23);
		Admin_Mod_1.add(btnNewButton_1_1_1);
		
		final JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(422, 69, 630, 473);
		Admin_Mod_1.add(scrollPane_1);
		scrollPane_1.setViewportView(table);
//		scrollPane_1.setModel(DbUtils.resultSetToTableModel(rs));
//		scrollPane_1.add(2);
		
		
		JButton btnNewButton_2 = new JButton("ADD");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String brand = BrandtxtField.getText();
				String model = ModeltxtField.getText();
				String fuel = FueltxtField.getText();
				int stock = Integer.parseInt(StockAdd.getText());
				int engine = Integer.parseInt(Engine.getText());
				int price = Integer.parseInt(PricetxtField.getText());
				
				String for_cid = "SELECT MAX(cID)FROM car";
//				ResultSet result;
				try {

					ResultSet result;
					ResultSet resulttran;
					
					Statement stmt = con.prepareStatement(for_cid);
					
					result = stmt.executeQuery(for_cid);
					if (result.next()) {
					    car_ID = result.getInt(1);
					    
					}
					System.out.println(car_ID);
					System.out.println(t_ID);
					
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			
				try {
					Statement statement = con.createStatement();
						car_ID ++;
						
						pst = ("Select * from car");
					
						pstm = con.prepareStatement(pst);
						
						statement.executeUpdate("INSERT INTO car " + "VALUES (" + car_ID +","+ "'"+fuel+"'" + ","+ "'"+brand+"'" +","+"'"+model+"'"+","+price  +","+engine+","+stock+")");
						
						rss = pstm.executeQuery(pst);
						table.setModel(DbUtils.resultSetToTableModel(rss));
						scrollPane_1.setViewportView(table);			
				} catch (SQLException e1) {
					// TODO Auto-generated catch block 
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(422, 553, 197, 82);
		Admin_Mod_1.add(btnNewButton_2);
		
		JButton btnNewButton_1_2 = new JButton("DELETE");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				int row = scrollPane_1.getMinSelectionIndex();
				String for_cid = "SELECT MAX(cID)FROM car";
//				ResultSet result;
				try {

					ResultSet result;
					
					Statement stmt = con.prepareStatement(for_cid);

					result = stmt.executeQuery(for_cid);

					if (result.next()) {
					    car_ID = result.getInt(1);
					    
					}
				}catch (SQLException e2) {
					e2.printStackTrace();
				}
				try {
					String delete = "DELETE FROM car WHERE cID = " + car_ID;
					
					car_ID --;
					t_ID --;
					
					con = DriverManager.getConnection("jdbc:mysql://localhost/Automotive2","root","");
					
					pst = ("Select * from car");
				
					pstm = con.prepareStatement(pst);
					
					Statement stmt = con.createStatement();
					String SQL = delete;
					stmt.executeUpdate(SQL);
					
					rss = pstm.executeQuery(pst);
					table.setModel(DbUtils.resultSetToTableModel(rss));
					scrollPane_1.setViewportView(table);


				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_2.setBounds(855, 553, 197, 82);
		Admin_Mod_1.add(btnNewButton_1_2);
		
		JLabel Engine_Laberl = new JLabel("Engine Size");
		Engine_Laberl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Engine_Laberl.setBounds(24, 517, 134, 24);
		Admin_Mod_1.add(Engine_Laberl);
		
		Engine = new JTextField();
		Engine.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Engine.setColumns(10);
		Engine.setBounds(192, 505, 180, 53);
		Admin_Mod_1.add(Engine);
		
		StockAdd = new JTextField();
		StockAdd.setFont(new Font("Tahoma", Font.PLAIN, 25));
		StockAdd.setColumns(10);
		StockAdd.setBounds(192, 599, 180, 53);
		Admin_Mod_1.add(StockAdd);
		
		JLabel Stock_L = new JLabel("Stock");
		Stock_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Stock_L.setBounds(24, 611, 134, 24);
		Admin_Mod_1.add(Stock_L);
		
//////POPUP STOCK UPDATE
		
        pf_stock = new PopupFactory();
        final JPanel addpanel;
        // create a panel
        addpanel = new JPanel();
        
        addpanel.setBackground(Color.pink);
        
        
        addpanel.setLayout(new GridLayout(4, 4));

        JLabel CarID_stock = new JLabel("CarID : ");
        CarID_stock.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        addpanel.add(CarID_stock);
        
    	CarID_Stocks = new JTextField();
    	Amount_Stocks = new JTextField();
    	
		CarID_Stocks.setFont(new Font("Tahoma", Font.PLAIN, 25));
		addpanel.add(CarID_Stocks);
		
		JLabel Amountadd = new JLabel("Amount to add : ");
		Amountadd.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        addpanel.add(Amountadd);
        
        Amount_Stocks.setFont(new Font("Tahoma", Font.PLAIN, 25));
		addpanel.add(Amount_Stocks);
		
		JLabel CarID_stocks = new JLabel("       ");
        CarID_stocks.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        addpanel.add(CarID_stocks);
        JLabel CarID_stockss = new JLabel("       ");
        CarID_stockss.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        addpanel.add(CarID_stockss);
//        JLabel CarID_stocksss = new JLabel("       ");
//        CarID_stocksss.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//        addpanel.add(CarID_stocksss);
        
        
        p_stock = pf_stock.getPopup(Admin_Mod_1, addpanel, 550, 215);
        
        JButton cancelStock_button = new JButton("Cancel");
        cancelStock_button.setBounds(100, 100, 100, 80);
        cancelStock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p_stock.hide();
				p_stock = pf_stock.getPopup(Admin_Mod_1, addpanel, 550, 215);
			}
			});
        addpanel.add(cancelStock_button);
        JButton AddStock_button = new JButton("Add");
        AddStock_button.setBounds(100, 100, 100, 80);
        
        AddStock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String carid = CarID_Stocks.getText();
				String amount = Amount_Stocks.getText();
				Integer caridss =  Integer.parseInt(carid);
				Integer amountss =  Integer.parseInt(amount);
				
				try {
					Statement stmt = con.createStatement();
					String lol = ("SELECT Stock FROM car WHERE cID = "+caridss); 
					int stock = 0;
					ResultSet resultss = stmt.executeQuery(lol); 
					
					if(resultss.next()) {
						stock = resultss.getInt("Stock");
					}
					///////
					String plus_stock = ("UPDATE car c SET c.Stock = "+(amountss + stock)+" WHERE cID = "+caridss);
					stmt = con.createStatement();
					stmt.executeUpdate(plus_stock);
					
					pst = ("Select * from car");
					rss = pstm.executeQuery(pst);
					table.setModel(DbUtils.resultSetToTableModel(rss));
					scrollPane_1.setViewportView(table);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Success Transaction","Buy", 1);
				p_stock.hide();
				p_stock = pf_stock.getPopup(Admin_Mod_1, addpanel, 550, 215);
				
			}
		});
		addpanel.add(AddStock_button);
        
        
        //////
		JButton StockAdd_Button = new JButton("+Stock");
		StockAdd_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p_stock.show();
			}
		});
		StockAdd_Button.setBounds(952, 45, 77, 23);
		Admin_Mod_1.add(StockAdd_Button);
		
//////POPUP change STOCK UPDATE
		
        pf_stocks = new PopupFactory();
        final JPanel addpanels;
        // create a panel
        addpanels = new JPanel();
        
        addpanels.setBackground(Color.pink);
        
        
        addpanels.setLayout(new GridLayout(4, 4));

        JLabel CarID_stocksz = new JLabel("CarID : ");
        CarID_stocksz.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        addpanels.add(CarID_stocksz);
        
    	CarID_Stockss = new JTextField();
    	Amount_Stockss = new JTextField();
    	
		CarID_Stockss.setFont(new Font("Tahoma", Font.PLAIN, 25));
		addpanels.add(CarID_Stockss);
		
		JLabel Amountadds = new JLabel("Change to : ");
		Amountadds.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        addpanels.add(Amountadds);
        
        Amount_Stockss.setFont(new Font("Tahoma", Font.PLAIN, 25));
		addpanels.add(Amount_Stockss);
		
		JLabel CarID_stockssz = new JLabel("       ");
        CarID_stockssz.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        addpanels.add(CarID_stockssz);
        JLabel CarID_stocksssz = new JLabel("       ");
        CarID_stocksssz.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        addpanels.add(CarID_stocksssz);
//        JLabel CarID_stocksss = new JLabel("       ");
//        CarID_stocksss.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//        addpanel.add(CarID_stocksss);
        
        
        p_stocks = pf_stocks.getPopup(Admin_Mod_1, addpanels, 550, 215);
        
        JButton cancelStock_buttons = new JButton("Cancel");
        cancelStock_buttons.setBounds(100, 100, 100, 80);
        cancelStock_buttons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p_stocks.hide();
				p_stocks = pf_stocks.getPopup(Admin_Mod_1, addpanels, 550, 215);
			}
			});
        addpanels.add(cancelStock_buttons);
        JButton AddStock_buttons = new JButton("Change");
        AddStock_buttons.setBounds(100, 100, 100, 80);
        
        AddStock_buttons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String carid = CarID_Stockss.getText();
				String amount = Amount_Stockss.getText();
				Integer carids =  Integer.parseInt(carid);
				Integer amounts =  Integer.parseInt(amount);
				
				try {
					///////
					String plus_stock = ("UPDATE car c SET c.Stock = "+amounts+" WHERE cID = "+carids);
					stmt = con.createStatement();
					stmt.executeUpdate(plus_stock);
					
					pst = ("Select * from car");
					rss = pstm.executeQuery(pst);
					table.setModel(DbUtils.resultSetToTableModel(rss));
					scrollPane_1.setViewportView(table);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Success Transaction","Buy", 1);
				p_stocks.hide();
				p_stocks = pf_stocks.getPopup(Admin_Mod_1, addpanels, 550, 215);
				
			}
		});
		addpanels.add(AddStock_buttons);
		
		////////////////
		JButton StockAdd_Button_1 = new JButton("Change");
		StockAdd_Button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p_stocks.show();
			}
		});
		StockAdd_Button_1.setBounds(952, 15, 77, 23);
		Admin_Mod_1.add(StockAdd_Button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 63, 923, 452);
		User_Data.add(scrollPane);
		
		scrollPane.setViewportView(table_tot);
		
		JButton Back_lol = new JButton("Back");
		Back_lol.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Back_lol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(panel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		Back_lol.setBounds(10, 11, 98, 41);
		User_Data.add(Back_lol);
		
		JButton GoToTransaction = new JButton("Transaction ->");
		GoToTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(User_Transaction);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		GoToTransaction.setFont(new Font("Tahoma", Font.BOLD, 20));
		GoToTransaction.setBounds(849, 562, 187, 77);
		User_Data.add(GoToTransaction);
		
		JLabel lblNewLabel_2 = new JLabel("User Database");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(435, 21, 174, 31);
		User_Data.add(lblNewLabel_2);
		
		final JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 111, 1042, 510);
		User_Reccomendation.add(scrollPane_2);
		scrollPane_2.setViewportView(table_people);
		
		txtReccomendationForYou = new JTextField();
		txtReccomendationForYou.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtReccomendationForYou.setText("Reccomendation For You");
		txtReccomendationForYou.setBounds(348, 32, 341, 53);
		User_Reccomendation.add(txtReccomendationForYou);
		txtReccomendationForYou.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("Back");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(MainUser);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnNewButton_5.setBounds(10, 11, 143, 41);
		User_Reccomendation.add(btnNewButton_5);
		
		//////////////////////////////////////////////////
		
		final JPanel Shop = new JPanel();
		layeredPane.add(Shop, "name_13452576098400");
		
		final JPanel History = new JPanel();
		layeredPane.add(History, "name_13640975769800");
		History.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome !!!");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 99));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(206, 32, 631, 237);
		MainUser.add(lblNewLabel);
		
		JButton btnNewButton_pelir = new JButton("Profile");
		btnNewButton_pelir.setFont(new Font("Tahoma", Font.PLAIN, 32));
		btnNewButton_pelir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1_1_doi.setText(Username_login);
				layeredPane.removeAll(); 
				layeredPane.add(Profile);
				layeredPane.repaint();
				layeredPane.revalidate();
				
			}
		});
		btnNewButton_pelir.setBounds(32, 367, 276, 117);
		MainUser.add(btnNewButton_pelir);
		
		JButton btnShop = new JButton("Shop");
		btnShop.setFont(new Font("Tahoma", Font.PLAIN, 32));
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(Shop);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnShop.setBounds(391, 367, 272, 117);
		MainUser.add(btnShop);
		
		JButton Reccomender = new JButton("Reccomendation");
		Reccomender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(User_Reccomendation);
				layeredPane.repaint();
				layeredPane.revalidate();
				
				String for_cidd = "SELECT CarPreference from customer where Username = '" + Username_login +"'";
//				ResultSet result;
				String checking = "a";
				
				try {
					ResultSet results;
					
					Statement stmts = con.prepareStatement(for_cidd);
					
					results = stmts.executeQuery(for_cidd);
					if (results.next()) {
					    checking = results.getString(1);
					    
					}
			
					System.out.println(checking);
					if (checking.equals("Practical Car")) {
						rec = ("Select Brand,Model,Price,Fuel FROM car WHERE Price <= 40000");
					}else {
						rec = ("Select Brand,Model,Price,Fuel FROM car WHERE Price > 40000");
					}
					recom_stm = con.prepareStatement(rec);
					resc = recom_stm.executeQuery(rec);

					table_people.setModel(DbUtils.resultSetToTableModel(resc));
					scrollPane_2.setViewportView(table_people);

				}
				catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		Reccomender.setFont(new Font("Tahoma", Font.PLAIN, 32));
		Reccomender.setBounds(753, 367, 276, 117);
		MainUser.add(Reccomender);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(LogIn);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
			
		});
		btnNewButton_3.setBounds(10, 16, 114, 45);
		MainUser.add(btnNewButton_3);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Preference");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_1_2_1.setBounds(535, 339, 170, 43);
		Profile.add(lblNewLabel_1_2_1);
		
		final JComboBox comboBox_dio = new JComboBox();
		comboBox_dio.setFont(new Font("Tahoma", Font.PLAIN, 26));
		comboBox_dio.setModel(new DefaultComboBoxModel(new String[] {"Practical", "Performance"}));
		comboBox_dio.setToolTipText("");
		comboBox_dio.setBounds(742, 325, 162, 65);
		Profile.add(comboBox_dio);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(MainUser);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnBack.setBounds(10, 10, 100, 43);
		Profile.add(btnBack);
		
		final JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String change = change_pw.getText();
				JOptionPane.showMessageDialog(null,"Updated","Successfully Added", 1);
				String varName = (String)comboBox_dio.getSelectedItem();
				String value = comboBox_dio.getSelectedItem().toString();
				
				String delete = "UPDATE customer SET CarPreference = " + "'"+value+" Car'" + "WHERE Username = " + "'"+Username_login+"'";
				String changine = ("UPDATE customer c SET c.Pin = "+"'"+change+"' WHERE Username = "+"'"+Username_login+"'");
				System.out.print(delete);
				
				try {
					Statement stmt = con.createStatement();
					String SQL = delete;
					stmt.executeUpdate(SQL);
					
					stmt.executeUpdate(changine);
					
					rss = pstm.executeQuery(pst);
					table.setModel(DbUtils.resultSetToTableModel(rss));
					scrollPane_1.setViewportView(table);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
				
			}
		});
		btnSave.setBounds(34, 527, 259, 108);
		Profile.add(btnSave);
		
		JButton btnHistory_1 = new JButton("History");
		btnHistory_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(History);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnHistory_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		btnHistory_1.setBounds(31, 185, 259, 115);
		Profile.add(btnHistory_1);
		
		change_pw = new JTextField();
		change_pw.setFont(new Font("Tahoma", Font.PLAIN, 32));
		change_pw.setBounds(198, 423, 259, 65);
		Profile.add(change_pw);
		change_pw.setColumns(10);
		Shop.setLayout(null);
		
		JLabel lblShop = new JLabel("Shop");
		lblShop.setBounds(441, -15, 292, 133);
		lblShop.setHorizontalAlignment(SwingConstants.CENTER);
		lblShop.setFont(new Font("Tahoma", Font.PLAIN, 40));
		Shop.add(lblShop);
		
		JLabel lblNewLabel_1_3 = new JLabel("Brand");
		lblNewLabel_1_3.setBounds(207, 133, 170, 43);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Shop.add(lblNewLabel_1_3);
		
		final JLabel shopprice_info = new JLabel("price");
		shopprice_info.setBounds(317, 368, 170, 43);
		shopprice_info.setFont(new Font("Tahoma", Font.PLAIN, 32));
		Shop.add(shopprice_info);
		
		final JLabel shopfuel_info = new JLabel("fuel type");
		shopfuel_info.setBounds(387, 300, 275, 43);
		shopfuel_info.setFont(new Font("Tahoma", Font.PLAIN, 32));
		Shop.add(shopfuel_info);
		
		final JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(432, 186, 176, 65);
		Shop.add(comboBox_1_1);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(207, 186, 187, 65);
		Shop.add(comboBox_1);
		
//////POPUP FUEL
		
        pf = new PopupFactory();
 
        // create a panel
        p2 = new JPanel();
        JPanel p3 = new JPanel();
        
        p2.add(p3);
        p2.setBackground(Color.white);
        
        p3.setBackground(Color.white);
        
        p2.setLayout(new GridLayout(2, 1));
        p3.setLayout(new GridLayout(4, 1));
        
//        layeredPane.add(p2);
//        p3.setLayout(null);
        JLabel lblNewLabel_31 = new JLabel("Model :");
        lblNewLabel_31.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblNewLabel_31.setBounds(271, 51, 51, 20);
        p3.add(lblNewLabel_31);
        
        final JLabel model_info1 = new JLabel(" Speedz");
        model_info1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        model_info1.setBounds(534, 108, 23, 14);
        p3.add(model_info1);
        
        
        JLabel lblNewLabel_3 = new JLabel("Price/L : \n");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblNewLabel_3.setBounds(271, 51, 51, 20);
        p3.add(lblNewLabel_3);
        
        final JLabel octaneLevel_1 = new JLabel(" 92");
        octaneLevel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        octaneLevel_1.setBounds(534, 108, 23, 14);
        p3.add(octaneLevel_1);
        
        JLabel lblNewLabel_3_1_2 = new JLabel("CO2 Emission :");
        lblNewLabel_3_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblNewLabel_3_1_2.setBounds(471, 82, 116, 14);
        p3.add(lblNewLabel_3_1_2);
        
        final JLabel co2Emis_1 = new JLabel(" 222");
        co2Emis_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        co2Emis_1.setBounds(574, 83, 77, 14);
        p3.add(co2Emis_1);
        
        JLabel lblNewLabel_3_1_1_1 = new JLabel("Octane :");
        lblNewLabel_3_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblNewLabel_3_1_1_1.setBounds(471, 107, 116, 14);
        p3.add(lblNewLabel_3_1_1_1);
        
        final JLabel FuelPrice_1 = new JLabel(" 32");
        FuelPrice_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        FuelPrice_1.setBounds(545, 54, 77, 14);
        p3.add(FuelPrice_1);
        
        p = pf.getPopup(Shop, p2, 765, 430);
        
        JButton btnNewButton_61 = new JButton("Close");
		btnNewButton_61.setBounds(511, 291, 30, 23);
		btnNewButton_61.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.hide();
				p = pf.getPopup(Shop, p2, 765, 430);
				
			}
		});
		p2.add(btnNewButton_61);
        
        
        //////
		
		final String fuel_i;
		String price_i;
		final String[] array = new String[20];
		final String[] array_compare = new String[20];
		try {				
			con = DriverManager.getConnection("jdbc:mysql://localhost/Automotive2","root",""); //not
			Statement stm = con.createStatement();
			
			ResultSet result = stm.executeQuery("select Brand from brand");
			
			 while (result.next()) {
		         String name = result.getString("Brand");
		         comboBox_1.addItem(name);
			 }
			 
			 String varName1 = (String)comboBox_1.getSelectedItem();
			 String value1 = comboBox_1.getSelectedItem().toString();
			 System.out.print(value1);
			 
			 int i = 0;
			 ResultSet results = stm.executeQuery("select Model from car where Brand = " +"'"+value1+"'");
			 while (results.next()) {
		         String Model = results.getString("Model");
		         comboBox_1_1.addItem(Model);
		         array[i] = (Model);
//		         System.out.print(Model);
		         i++;
			 }
			 
			 String varName12 = (String)comboBox_1_1.getSelectedItem();
			 String value12 = comboBox_1_1.getSelectedItem().toString();
			 
			 ResultSet resultss = stm.executeQuery("select Fuel from car where Brand = " +"'"+value1+"' AND Model = " + "'" + value12+"'");
		 
			 while (resultss.next()) {
		         Fuel = resultss.getString("Fuel");  

			 }
			 shopfuel_info.setText(Fuel);
			 
			 ResultSet results_price = stm.executeQuery("select Price from car where Brand = " +"'"+value1+"' AND Model = " + "'" + value12+"'");
			 
			 if (results_price.next()) {
		         Price = results_price.getString("Price");  
			 }

			 shopprice_info.setText(Price);
			 
			 ResultSet results_info = stm.executeQuery("SELECT c.Model,f.Price, f.CO2Emmision,F.Octane FROM car c JOIN fuel f ON c.Fuel = f.Fuel WHERE c.Model = "+ "'"+value12+"' AND c.Brand = '"+value1+"'");
			 
			 while (results_info.next()) {
		         String Model_info = results_info.getString("Model");  
		         String Price_info = results_info.getString("Price");  
		         String CO2_info = results_info.getString("CO2Emmision");  
		         String Octane_info = results_info.getString("Octane");  
		         
		         model_info1.setText(Model_info);
		         octaneLevel_1.setText(Price_info);
		         co2Emis_1.setText(CO2_info);
		         FuelPrice_1.setText(Octane_info);
			 }
			 
//			 System.out.println(hm);
		}catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		comboBox_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {							
//					System.out.print("afakkkkkkkkkk");
					
					con = DriverManager.getConnection("jdbc:mysql://localhost/Automotive2","root","");
					Statement stm = con.createStatement();
					
					String varName1 = (String)comboBox_1.getSelectedItem();
					 String value1 = comboBox_1.getSelectedItem().toString();
					ResultSet results = stm.executeQuery("select Model from car where Brand = " +"'"+value1+"'");
					
					 int i = 0;
					 while (results.next()) {
				         String Model = results.getString("Model");
				         array_compare[i] = Model;
				         i++;
					 }
					 if (array[0].equals(array_compare[0])) {

					 }else {
						 results = stm.executeQuery("select Model from car where Brand = " +"'"+value1+"'");
						 comboBox_1_1.removeAllItems();
						 i = 0;
						 while (results.next()) {
					         String Model = results.getString("Model");
					         comboBox_1_1.addItem(Model);
					         array[i] = Model;
					         i++;
						 }
					 }
					 
					 
//					 String varName12 = (String)comboBox_1_1.getSelectedItem();
//					 String value12 = comboBox_1_1.getSelectedItem().toString();
					 
					 try {
						 
						 String varName12 = (String)comboBox_1_1.getSelectedItem();
						 String value12 = comboBox_1_1.getSelectedItem().toString();
					 }catch (Exception ee) {
						 System.out.println("salahbro");
						 results = stm.executeQuery("select Model from car where Brand = " +"'"+value1+"'");
						 comboBox_1_1.removeAllItems();
						 i = 0;
						 while (results.next()) {
					         String Model = results.getString("Model");
					         comboBox_1_1.addItem(Model);
					         array[i] = Model;
					         i++;
						 }
//					         varName12 = (String)comboBox_1_1.getSelectedItem();
//					         value12 = comboBox_1_1.getSelectedItem().toString();
					 }
					 String varName12 = (String)comboBox_1_1.getSelectedItem();
			         String value12 = comboBox_1_1.getSelectedItem().toString();
					 
					 ResultSet resultss = stm.executeQuery("select Fuel from car where Brand = " +"'"+value1+"' AND Model = " + "'" + value12+"'");
				 
					 System.out.println(value12);
					 if (resultss.next()) {
				         Fuel = resultss.getString("Fuel");  
					 }
					 shopfuel_info.setText(Fuel);
					 
					 ResultSet results_price = stm.executeQuery("select Price from car where Brand = " +"'"+value1+"' AND Model = " + "'" + value12+"'");
					 
					 if (results_price.next()) {
				         Price = results_price.getString("Price");  
					 }

					 shopprice_info.setText(Price);
					 
					 ResultSet results_info = stm.executeQuery("SELECT c.Model,f.Price, f.CO2Emmision,F.Octane FROM car c JOIN fuel f ON c.Fuel = f.Fuel WHERE c.Model = "+ "'"+value12+"' AND c.Brand = '"+value1+"'");
					 
					 while (results_info.next()) {
				         String Model_info = results_info.getString("Model");  
				         String Price_info = results_info.getString("Price");  
				         String CO2_info = results_info.getString("CO2Emmision");  
				         String Octane_info = results_info.getString("Octane");  
				         
				         model_info1.setText(Model_info);
				         octaneLevel_1.setText(Price_info);
				         co2Emis_1.setText(CO2_info);
				         FuelPrice_1.setText(Octane_info);
					 }
					 
					 
				}catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}});

		comboBox_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {						
					con = DriverManager.getConnection("jdbc:mysql://localhost/Automotive2","root","");
					Statement stm = con.createStatement();
					 
					 String varName1 = (String)comboBox_1.getSelectedItem();
					 String value1 = comboBox_1.getSelectedItem().toString();
					 
					 comboBox_1_1.removeAllItems();

					 String varName12 = (String)comboBox_1_1.getSelectedItem();
					 String value12 = comboBox_1_1.getSelectedItem().toString();
					 
					 ResultSet resultss = stm.executeQuery("select Fuel from car where Brand = " +"'"+value1+"' AND Model = " + "'" + value12+"'");
				 
					 
					 if (resultss.next()) {
				         Fuel = resultss.getString("Fuel");  
					 }
					 shopfuel_info.setText(Fuel);
					 
					 ResultSet results_price = stm.executeQuery("select Price from car where Brand = " +"'"+value1+"' AND Model = " + "'" + value12+"'");
					 
					 if (results_price.next()) {
				         Price = results_price.getString("Price");  
					 }
					 shopprice_info.setText(Price);
//					 shopfuel_info.setText(Fuel);

		 
//					 System.out.println(hm);
				}catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}});

		JLabel lblNewLabel_1_3_1 = new JLabel("Model");
		lblNewLabel_1_3_1.setBounds(432, 133, 170, 43);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Shop.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Fuel Type :");
		lblNewLabel_1_3_2.setBounds(207, 300, 170, 43);
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		Shop.add(lblNewLabel_1_3_2);
		
		JLabel lblNewLabel_1_3_2_2 = new JLabel("Price :");
		lblNewLabel_1_3_2_2.setBounds(207, 368, 170, 43);
		lblNewLabel_1_3_2_2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		Shop.add(lblNewLabel_1_3_2_2);
		
		JButton btnNewButton_1_pelir = new JButton("Buy");
		btnNewButton_1_pelir.setBounds(744, 512, 275, 121);
		btnNewButton_1_pelir.setFont(new Font("Tahoma", Font.PLAIN, 60));
		btnNewButton_1_pelir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Success Transaction","Buy", 1);
				Statement stm;
				
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
			    Date date = new Date();  
			    
			    String date_now = formatter.format(date).toString();
			    System.out.print(date_now);
			    
				String varName1 = (String)comboBox_1.getSelectedItem();
				String value1 = comboBox_1.getSelectedItem().toString();
				
				 
				String varName12 = (String)comboBox_1_1.getSelectedItem();
				String value12 = comboBox_1_1.getSelectedItem().toString();
				
				System.out.print("LOL "+Price+" LOL");
				
				
				 
				try {
					Statement stmt = con.createStatement();
					int stock = 0;
					ResultSet resultss = stmt.executeQuery("SELECT Stock FROM car WHERE Brand = "+"'"+value1+"' AND Model ="+"'"+value12+"'"); 
					
					if(resultss.next()) {
						stock = resultss.getInt("Stock");
					}
					
					//TAKE TOTAL SALES
					int sales = 0;
					ResultSet results_total_sales = stmt.executeQuery("SELECT TotalSales FROM brand WHERE Brand = "+"'"+value1+"'"); 
					
					if(results_total_sales.next()) {
						sales = results_total_sales.getInt("TotalSales");
					}
					//TAKE TOTAL SALES
					
					String delete = ("UPDATE car c SET c.Stock = "+(stock - 1)+" WHERE Brand = "+"'"+value1+"' AND Model ="+"'"+value12+"'");
					stmt = con.createStatement();
					String SQL = delete;
					stmt.executeUpdate(SQL);
					
					//PLUS TOTAL SALES 
					String plus_totalsales = ("UPDATE brand b SET b.TotalSales = "+(sales + 1)+" WHERE Brand = "+"'"+value1+"'");
					stmt = con.createStatement();
					stmt.executeUpdate(plus_totalsales);
					//PLUS TOTAL SALES WHEN BUY
					
					String insert_history = ("INSERT INTO transaction " + "VALUES (" + customer_id +","+ "'"+date_now+"'" + ","+ "'"+value1+"'" +","+ "'"+value12+"'" + ","+ Price+")");
					stmt.executeUpdate(insert_history);
					
					//HISTORY USER
					String rec_history = ("Select Date,Brand,Model,Price FROM transaction WHERE CustID =" +customer_id);
					Statement history_user;

					history_user = con.prepareStatement(pst);
					ResultSet execute_user_history = history_user.executeQuery(rec_history);
					table_history_user.setModel(DbUtils.resultSetToTableModel(execute_user_history));
					
					System.out.println("CHECKING " + customer_id + " CHECKING");

					//HISTORY USER
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Shop.add(btnNewButton_1_pelir);
		
		JButton btnBack_1 = new JButton("back");
		btnBack_1.setBounds(10, 10, 69, 26);
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(MainUser);
				layeredPane.repaint();
				layeredPane.revalidate();
				p.hide();
				p = pf.getPopup(Shop, p2, 765, 430);
			}
		});
		Shop.add(btnBack_1);

		JButton btnNewButton_6 = new JButton("!");
		btnNewButton_6.setBounds(173, 289, 30, 23);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.show();
			}
		});
		btnNewButton_6.setBorder(new RoundedBorder(10));
		Shop.add(btnNewButton_6);
		
		
		JScrollPane scrollPane_pelir = new JScrollPane();
		scrollPane_pelir.setBounds(89, 82, 882, 534);
		History.add(scrollPane_pelir);
		scrollPane_pelir.setViewportView(table_history_user);
		
		JLabel lblHistory = new JLabel("History");
		lblHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistory.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblHistory.setBounds(368, -31, 292, 133);
		History.add(lblHistory);
		
		JButton btnBack_2 = new JButton("back");
		btnBack_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(MainUser);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnBack_2.setBounds(10, 10, 89, 36);
		History.add(btnBack_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(68, 76, 923, 452);
		User_Transaction.add(scrollPane_3);
		scrollPane_3.setViewportView(table_All_History);
		
		JButton Back_lol_1 = new JButton("Back");
		Back_lol_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(panel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		Back_lol_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Back_lol_1.setBounds(10, 11, 98, 41);
		User_Transaction.add(Back_lol_1);
		
		JButton GoToTransaction_1 = new JButton("<- User Data");
		GoToTransaction_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(User_Data);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		GoToTransaction_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		GoToTransaction_1.setBounds(25, 575, 187, 77);
		User_Transaction.add(GoToTransaction_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Transaction Database");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2_1.setBounds(398, 28, 254, 31);
		User_Transaction.add(lblNewLabel_2_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Back");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(panel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_1_1_1_1.setBounds(10, 11, 102, 44);
		Dealer_Info.add(btnNewButton_1_1_1_1);
		
		JLabel lblNewLabel_1_1_3_1_1 = new JLabel("Brand");
		lblNewLabel_1_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_3_1_1.setBounds(22, 114, 112, 24);
		Dealer_Info.add(lblNewLabel_1_1_3_1_1);
		
		Brand_Dealer = new JTextField();
		Brand_Dealer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Brand_Dealer.setColumns(10);
		Brand_Dealer.setBounds(192, 102, 178, 53);
		Dealer_Info.add(Brand_Dealer);
		
		JLabel lblNewLabel_1_2 = new JLabel("DealerInfo");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_2.setBounds(454, 11, 197, 44);
		Dealer_Info.add(lblNewLabel_1_2);
		
		final JScrollPane Scroll_Dealer = new JScrollPane();
		Scroll_Dealer.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		Scroll_Dealer.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		Scroll_Dealer.setBounds(420, 80, 630, 473);
		Dealer_Info.add(Scroll_Dealer);
		Scroll_Dealer.setViewportView(table_dealer);
		
		From_Dealer = new JTextField();
		From_Dealer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		From_Dealer.setColumns(10);
		From_Dealer.setBounds(190, 202, 180, 53);
		Dealer_Info.add(From_Dealer);
		
		JLabel lblNewLabel_1_5_1_1 = new JLabel("From");
		lblNewLabel_1_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_5_1_1.setBounds(22, 214, 77, 24);
		Dealer_Info.add(lblNewLabel_1_5_1_1);
		
		JLabel lblNewLabel_1_1_2_1_1_1 = new JLabel("DealerPhone");
		lblNewLabel_1_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2_1_1_1.setBounds(22, 320, 148, 24);
		Dealer_Info.add(lblNewLabel_1_1_2_1_1_1);
		
		Phone_Dealer = new JTextField();
		Phone_Dealer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Phone_Dealer.setColumns(10);
		Phone_Dealer.setBounds(190, 308, 180, 53);
		Dealer_Info.add(Phone_Dealer);
		
		JLabel lblNewLabel_1_4_1_1_1 = new JLabel("DealerMail");
		lblNewLabel_1_4_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4_1_1_1.setBounds(23, 423, 134, 24);
		Dealer_Info.add(lblNewLabel_1_4_1_1_1);
		
		Mail_Dealer = new JTextField();
		Mail_Dealer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Mail_Dealer.setColumns(10);
		Mail_Dealer.setBounds(190, 411, 180, 53);
		Dealer_Info.add(Mail_Dealer);
		
		Sales_Dealer = new JTextField();
		Sales_Dealer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Sales_Dealer.setColumns(10);
		Sales_Dealer.setBounds(190, 516, 180, 53);
		Dealer_Info.add(Sales_Dealer);
		
		JLabel Engine_Laberl_1 = new JLabel("Total Sales");
		Engine_Laberl_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Engine_Laberl_1.setBounds(22, 528, 134, 24);
		Dealer_Info.add(Engine_Laberl_1);
		
		JButton btnNewButton_2_1 = new JButton("ADD");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String brand = Brand_Dealer.getText();
				String from = From_Dealer.getText();
				String phone = Phone_Dealer.getText();
				String mail = Mail_Dealer.getText();
				String sales = Sales_Dealer.getText();
				
				Integer sale = Integer.parseInt(sales);
				
				//TAKING HIGHEST DEALER ID
				String for_cid = "SELECT MAX(DealerID)FROM brand";
				try {

					ResultSet result;
					
					Statement stmt = con.prepareStatement(for_cid);
					
					result = stmt.executeQuery(for_cid);
					if (result.next()) {
					    dealer_ID = result.getInt(1);
					    
					}
					
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				//TAKING HIGHEST DEALER ID
			
				try {
					Statement statement = con.createStatement();
						pst = ("Select * from brand");
						pstm = con.prepareStatement(pst);
						
						dealer_ID++;
						
						statement.executeUpdate("INSERT INTO brand " + "VALUES (" +dealer_ID+","+ "'"+brand+"'" + ","+ "'"+from+"'" +","+"'"+phone+"'"+","+"'"+mail+"'"  +","+sale+")");
						
						rss = pstm.executeQuery(pst);
						table_dealer.setModel(DbUtils.resultSetToTableModel(rss));
						Scroll_Dealer.setViewportView(table_dealer);
						
						
			
				} catch (SQLException e1) {
					// TODO Auto-generated catch block 
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2_1.setBounds(420, 564, 197, 82);
		Dealer_Info.add(btnNewButton_2_1);
		
		JButton btnNewButton_1_2_1 = new JButton("DELETE");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TAKING HIGHEST DEALER ID
				String for_cid = "SELECT MAX(DealerID)FROM brand";
				try {

					ResultSet result;
					
					Statement stmt = con.prepareStatement(for_cid);
					
					result = stmt.executeQuery(for_cid);
					if (result.next()) {
					    dealer_ID = result.getInt(1);
					    
					}
					
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				//TAKING HIGHEST DEALER ID
				
				//DELETING LAST ROW NOW
				
				try {
					String delete = "DELETE FROM brand WHERE DealerID = " + dealer_ID;
					
					dealer_ID --;
					
					con = DriverManager.getConnection("jdbc:mysql://localhost/Automotive2","root","");
					
					pst = ("Select * from brand");
				
					pstm = con.prepareStatement(pst);
					
					Statement stmt = con.createStatement();
					String SQL = delete;
					stmt.executeUpdate(SQL);
					
					rss = pstm.executeQuery(pst);
					table_All_History.setModel(DbUtils.resultSetToTableModel(rss));
					Scroll_Dealer.setViewportView(table_All_History);


				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//DELETING LAST ROW NOW
			}
		});
		btnNewButton_1_2_1.setBounds(853, 564, 197, 82);
		Dealer_Info.add(btnNewButton_1_2_1);
		
		JPanel Stock_Update = new JPanel();
		layeredPane.add(Stock_Update, "name_39715919289700");
		Stock_Update.setLayout(null);
		
		////////////////////////////////////////////////
		
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}