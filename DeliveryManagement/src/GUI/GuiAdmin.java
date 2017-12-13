package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dmSystem.DbUser;
import dmSystem.FnAdmin;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.SwingConstants;

public class GuiAdmin extends JFrame implements ActionListener {

	private JPanel AdminPanel;
	private JTextField RegisterUsernameText;
	private JTextField RegisterPasswordText;
	private JTextField DeleteUsernameText;
	private JButton DeleteUserButton, RegisterUserButton,managerFunction,clerkFunction,outSystem,payment2Button;
	private JComboBox RegisterUserTypeComboBox;
	private FnAdmin af = new FnAdmin();
	private JTextField UpdateUsernameText;
	private JTextField UpdatePasswordText;
	private JComboBox UpdateUserTypeComboBox;
	private JButton UpdateUserButton;
	private JTable UserTable;
	private DbUser ud = new DbUser();
	private DefaultTableModel dtm;
	public GuiAdmin() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 665);
		AdminPanel = new JPanel();
		AdminPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(AdminPanel);
		AdminPanel.setLayout(null);
		setVisible(true);
		
		JPanel AdminMainMenuPanel = new JPanel();
		AdminMainMenuPanel.setBounds(0, 0, 619, 733);
		AdminPanel.add(AdminMainMenuPanel);
		AdminMainMenuPanel.setLayout(null);
		
		JTabbedPane UserManagementTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		UserManagementTabbedPane.setBounds(35, 78, 342, 305);
		AdminMainMenuPanel.add(UserManagementTabbedPane);
		
		JPanel RegisterUserPanel = new JPanel();
		UserManagementTabbedPane.addTab("REGISTER", null, RegisterUserPanel, null);
		RegisterUserPanel.setLayout(null);
		
		JLabel RegisterUsername = new JLabel("USERNAME");
		RegisterUsername.setBounds(40, 69, 75, 35);
		RegisterUserPanel.add(RegisterUsername);
		RegisterUsername.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel RegisterPassword = new JLabel("PASSWORD");
		RegisterPassword.setBounds(40, 108, 75, 35);
		RegisterUserPanel.add(RegisterPassword);
		RegisterPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel RegisterUserType = new JLabel("TYPE");
		RegisterUserType.setBounds(40, 143, 75, 35);
		RegisterUserPanel.add(RegisterUserType);
		RegisterUserType.setFont(new Font("Arial", Font.PLAIN, 12));
		
		RegisterUsernameText = new JTextField();
		RegisterUsernameText.setBounds(138, 75, 139, 25);
		RegisterUserPanel.add(RegisterUsernameText);
		RegisterUsernameText.setColumns(10);
		
		RegisterPasswordText = new JTextField();
		RegisterPasswordText.setBounds(138, 114, 139, 25);
		RegisterUserPanel.add(RegisterPasswordText);
		RegisterPasswordText.setColumns(10);
		
		RegisterUserTypeComboBox = new JComboBox();
		RegisterUserTypeComboBox.setBounds(138, 150, 84, 20);
		RegisterUserPanel.add(RegisterUserTypeComboBox);
		RegisterUserTypeComboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		RegisterUserTypeComboBox.addItem("CLERK");
		RegisterUserTypeComboBox.addItem("MANAGER");
		
		JLabel lblAdminMenu = new JLabel("ADD NEW USER");
		lblAdminMenu.setForeground(Color.DARK_GRAY);
		lblAdminMenu.setBounds(106, 23, 160, 35);
		RegisterUserPanel.add(lblAdminMenu);
		lblAdminMenu.setFont(new Font("Arial", Font.BOLD, 14));
		
		RegisterUserButton = new JButton("REGISTER");
		RegisterUserButton.setFont(new Font("Arial", Font.PLAIN, 12));
		RegisterUserButton.setBounds(157, 211, 115, 35);
		RegisterUserButton.addActionListener(this);
		RegisterUserPanel.add(RegisterUserButton);
		
		JPanel UpdateUserPanel = new JPanel();
		UserManagementTabbedPane.addTab("UPDATE", null, UpdateUserPanel, null);
		UpdateUserPanel.setLayout(null);
		
		JLabel UpdateUsername = new JLabel("USERNAME");
		UpdateUsername.setFont(new Font("Arial", Font.PLAIN, 12));
		UpdateUsername.setBounds(40, 69, 90, 35);
		UpdateUserPanel.add(UpdateUsername);
		
		JLabel UpdatePassword = new JLabel("PASSWORD");
		UpdatePassword.setFont(new Font("Arial", Font.PLAIN, 12));
		UpdatePassword.setBounds(40, 108, 90, 35);
		UpdateUserPanel.add(UpdatePassword);
		
		UpdateUsernameText = new JTextField();
		UpdateUsernameText.setBounds(140, 75, 150, 25);
		UpdateUserPanel.add(UpdateUsernameText);
		UpdateUsernameText.setColumns(10);
		
		UpdatePasswordText = new JTextField();
		UpdatePasswordText.setBounds(140, 114, 150, 25);
		UpdateUserPanel.add(UpdatePasswordText);
		UpdatePasswordText.setColumns(10);
		
		JLabel UpdateUserType = new JLabel("TYPE");
		UpdateUserType.setFont(new Font("Arial", Font.PLAIN, 12));
		UpdateUserType.setBounds(40, 143, 90, 35);
		UpdateUserPanel.add(UpdateUserType);
		
		UpdateUserTypeComboBox = new JComboBox();
		UpdateUserTypeComboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		UpdateUserTypeComboBox.setBounds(140, 150, 100, 20);
		UpdateUserPanel.add(UpdateUserTypeComboBox);
		UpdateUserTypeComboBox.addItem("CLERK");
		UpdateUserTypeComboBox.addItem("MANAGER");
		
		
		JLabel lblNewLabel_3 = new JLabel("UPDATE USER");
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setBounds(106, 23, 120, 35);
		UpdateUserPanel.add(lblNewLabel_3);
		
		UpdateUserButton = new JButton("UPDATE");
		UpdateUserButton.setFont(new Font("Arial", Font.PLAIN, 12));
		UpdateUserButton.setBounds(175, 214, 115, 35);
		UpdateUserPanel.add(UpdateUserButton);
		UpdateUserButton.addActionListener(this);
		
		
		
		JPanel DeleteUserPanel = new JPanel();
		UserManagementTabbedPane.addTab("DELETE", null, DeleteUserPanel, null);
		DeleteUserPanel.setLayout(null);
		
		JLabel DeleteAdminMenuTitle = new JLabel("DELETE MENU");
		DeleteAdminMenuTitle.setForeground(Color.DARK_GRAY);
		DeleteAdminMenuTitle.setFont(new Font("Arial", Font.BOLD, 14));
		DeleteAdminMenuTitle.setBounds(115, 24, 120, 35);
		DeleteUserPanel.add(DeleteAdminMenuTitle);
		
		JLabel DeleteUsername = new JLabel("USERNAME");
		DeleteUsername.setFont(new Font("Arial", Font.PLAIN, 12));
		DeleteUsername.setBounds(70, 70, 90, 35);
		DeleteUserPanel.add(DeleteUsername);
		
		DeleteUsernameText = new JTextField();
		DeleteUsernameText.setColumns(10);
		DeleteUsernameText.setBounds(170, 75, 150, 25);
		DeleteUserPanel.add(DeleteUsernameText);
		
		DeleteUserButton = new JButton("DELETE");
		DeleteUserButton.addActionListener(this);
		DeleteUserButton.setFont(new Font("Arial", Font.PLAIN, 15));
		DeleteUserButton.setBounds(115, 185, 115, 35);
		DeleteUserButton.addActionListener(this);
		DeleteUserPanel.add(DeleteUserButton);
		
		dtm = (DefaultTableModel) DbUtils.resultSetToTableModel(ud.resultset());
		
		JLabel TitleAdminControlPanel = new JLabel("MANAGE USER");
		TitleAdminControlPanel.setForeground(Color.DARK_GRAY);
		TitleAdminControlPanel.setFont(new Font("Arial", Font.BOLD, 16));
		TitleAdminControlPanel.setBounds(45, 27, 254, 35);
		AdminMainMenuPanel.add(TitleAdminControlPanel);
		
		JScrollPane UserScrollPane = new JScrollPane();
		UserScrollPane.setBounds(35, 453, 548, 149);
		AdminMainMenuPanel.add(UserScrollPane);
		UserTable = new JTable(dtm);
		UserScrollPane.setViewportView(UserTable);
		
		managerFunction = new JButton("PRODUCT MANAGEMENT");
		managerFunction.setBounds(387, 229, 181, 35);
		AdminMainMenuPanel.add(managerFunction);
		managerFunction.setFont(new Font("Arial", Font.BOLD, 11));
		managerFunction.addActionListener(this);
		
		clerkFunction = new JButton("MANAGE CUSTOMER/ORDER");
		clerkFunction.setBounds(387, 183, 181, 35);
		AdminMainMenuPanel.add(clerkFunction);
		clerkFunction.setFont(new Font("Arial", Font.BOLD, 11));
		clerkFunction.addActionListener(this);
		
		payment2Button = new JButton("MANAGE PAYMENT");
		payment2Button.setBounds(387, 276, 181, 35);
		AdminMainMenuPanel.add(payment2Button);
		payment2Button.setFont(new Font("Arial", Font.BOLD, 11));
		payment2Button.addActionListener(this);
		
		outSystem = new JButton("LOGOUT");
		outSystem.setBounds(473, 32, 98, 26);
		AdminMainMenuPanel.add(outSystem);
		outSystem.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel label = new JLabel("______________________________________________________________________________");
		label.setForeground(Color.GRAY);
		label.setFont(new Font("Arial", Font.PLAIN, 12));
		label.setBounds(35, 382, 646, 35);
		AdminMainMenuPanel.add(label);
		
		JLabel label_1 = new JLabel("______________________________________________________________________________");
		label_1.setForeground(Color.GRAY);
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setBounds(35, 51, 556, 26);
		AdminMainMenuPanel.add(label_1);
		
		JLabel lblUserDatabase = new JLabel("USER DATABASE");
		lblUserDatabase.setForeground(Color.DARK_GRAY);
		lblUserDatabase.setFont(new Font("Arial", Font.BOLD, 16));
		lblUserDatabase.setBounds(45, 417, 254, 35);
		AdminMainMenuPanel.add(lblUserDatabase);
		outSystem.addActionListener(this);
	}
	public void clearAllField(){
		DeleteUsernameText.getText();
		
		RegisterUsernameText.getText();
		RegisterPasswordText.getText();
		
		UpdateUsernameText.getText();
		UpdatePasswordText.getText();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == DeleteUserButton){
			String [] info = new String[1];
			info [0] = DeleteUsernameText.getText();
			af.deleteUser(info);
			reloadTable();
			clearAllField();
		}
		
		if(e.getSource() == managerFunction){
			GuiManager mgr = new GuiManager();
			mgr.setVisible(true);
			setVisible(true);
		}
		
		if(e.getSource() == outSystem){
			GuiLogin keluar = new GuiLogin();
			keluar.setVisible(true);
			setVisible(false);
		}
		
		
		if(e.getSource() == clerkFunction){
			GuiClerk clk = new GuiClerk();
			clk.setVisible(true);
			setVisible(true);
		}
		
		if(e.getSource() == payment2Button){
			GuiPayment payments = new GuiPayment();
			payments.setVisible(true);
			setVisible(true);
		}
		
		if(e.getSource() == RegisterUserButton){
			String[] info = new String[3];
			info [0] = RegisterUsernameText.getText();
			info [1] = RegisterPasswordText.getText();
			info [2] = RegisterUserTypeComboBox.getSelectedItem().toString();
			af.registerUser(info);
			reloadTable();
			clearAllField();
		}
		if(e.getSource() == UpdateUserButton){
			String[] info = new String [3];
			info [0] = UpdateUsernameText.getText();
			info [1] = UpdatePasswordText.getText();
			info [2] = UpdateUserTypeComboBox.getSelectedItem().toString();
			af.updateUser(info);
			reloadTable();
			clearAllField();
		}
		
	}
	private void reloadTable(){
		dtm=(DefaultTableModel) DbUtils.resultSetToTableModel(ud.resultset());
		UserTable.setModel(dtm);
   }
}
