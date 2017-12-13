package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dmSystem.Db;
import dmSystem.DbUser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;

public class GuiLogin extends JFrame implements ActionListener{

	private JPanel LoginPanel;
	private JTextField UsernameText;
	private JTextField PasswordText;
	private JButton LoginButton;

	public GuiLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 297);
		LoginPanel = new JPanel();
		LoginPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(LoginPanel);
		LoginPanel.setLayout(null);
		
		setVisible(true);
		JPanel LoginMainMenuPanel = new JPanel();
		LoginMainMenuPanel.setBounds(0, 0, 439, 259);
		LoginPanel.add(LoginMainMenuPanel);
		LoginMainMenuPanel.setLayout(null);
		
		JLabel LoginUsername = new JLabel("USERNAME");
		LoginUsername.setFont(new Font("Arial", Font.PLAIN, 12));
		LoginUsername.setBounds(59, 92, 70, 35);
		LoginMainMenuPanel.add(LoginUsername);
		
		JLabel LoginPassword = new JLabel("PASSWORD");
		LoginPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		LoginPassword.setBounds(59, 134, 70, 35);
		LoginMainMenuPanel.add(LoginPassword);
		
		UsernameText = new JTextField();
		UsernameText.setBounds(186, 98, 164, 25);
		LoginMainMenuPanel.add(UsernameText);
		UsernameText.setColumns(10);
		
		PasswordText = new JTextField();
		PasswordText.setBounds(186, 140, 164, 25);
		LoginMainMenuPanel.add(PasswordText);
		PasswordText.setColumns(10);
		
		LoginButton = new JButton("LOGIN");
		LoginButton.setFont(new Font("Arial", Font.BOLD, 14));
		LoginButton.setBounds(239, 199, 107, 35);
		LoginMainMenuPanel.add(LoginButton);
		LoginButton.addActionListener(this);
		
		JLabel TitleEliteDeliveryManagementSystem = new JLabel("DELIVERY MANAGEMENT SYSTEM");
		TitleEliteDeliveryManagementSystem.setForeground(Color.DARK_GRAY);
		TitleEliteDeliveryManagementSystem.setFont(new Font("Arial", Font.BOLD, 14));
		TitleEliteDeliveryManagementSystem.setBounds(90, 38, 247, 35);
		LoginMainMenuPanel.add(TitleEliteDeliveryManagementSystem);
		
		JLabel label = new JLabel("____________________________________________");
		label.setForeground(Color.GRAY);
		label.setFont(new Font("Arial", Font.PLAIN, 12));
		label.setBounds(59, 60, 329, 15);
		LoginMainMenuPanel.add(label);
		
		
	}

	//@Override
	public void actionPerformed(ActionEvent x) {
		try{
		if (x.getSource()==LoginButton) {
			DbUser db = new DbUser();
			String type = db.login(UsernameText.getText(), PasswordText.getText());
			if(type.equals("Invalid")){
				JOptionPane.showMessageDialog(null,"Wrong Username / Password");
			}else{
				System.out.println("You are"+ type);
				if(type.equals("ADMIN")){
					GuiAdmin adm = new GuiAdmin();
					setVisible(false);
				}else if(type.equals("MANAGER")){
					GuiManager mgr = new GuiManager();
					mgr.setVisible(true);
					setVisible(false);
				}else if(type.equals("CLERK")){
					GuiClerk clk = new GuiClerk();
					clk.setVisible(true);
					setVisible(false);
				}
			
				
			}
			
			
		}
        
    }
    catch(Exception e){
        System.out.println(e.getMessage());
    }
}
		
}

