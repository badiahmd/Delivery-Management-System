package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dmSystem.DbManagePrice;
import dmSystem.FnManager;
import net.proteanit.sql.DbUtils;

import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

public class GuiManager extends JFrame implements ItemListener {

	private JPanel ManagerPanel;
	private JTextField SetNewRatesText;
	private JTextField OldDiscountRatesText;
	private JTextField WeightPriceText;
	private JTextField SetWeightNewPriceText;
	private JComboBox SetMembershipTypeComboBox;
	private JComboBox ServiceTypeComboBox;
	private JButton UpdateDiscountButton;
	private JButton UpdatePriceButton;
	private JButton ClerkPerspectiveButton;
	private JButton ManagePaymentButton;
	private JButton LogoutButton;

	
	private double[] rates = new double[4];
	private double[] weight = new double[6];
	private FnManager mff = new FnManager();
    private DecimalFormat formatter = new DecimalFormat("#0.00");
    private JLabel TitleProductServicesManagementPanel;
    private DefaultTableModel dtm;
    private DbManagePrice mpd = new DbManagePrice();
    
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiManager frame = new GuiManager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	public GuiManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 409);
		ManagerPanel = new JPanel();
		ManagerPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ManagerPanel);
		ManagerPanel.setLayout(null);
		
		JTabbedPane ServicesTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		ServicesTabbedPane.setBounds(40, 83, 577, 255);
		ManagerPanel.add(ServicesTabbedPane);
		
		JPanel ProductsServicesPanel = new JPanel();
		ServicesTabbedPane.addTab("PRODUCTS/SERVICES", null, ProductsServicesPanel, null);
		ProductsServicesPanel.setLayout(null);
		
		rates = mff.getDiscount();
		String[] type = {"Basic","Premium","Gold"};
		SetMembershipTypeComboBox = new JComboBox(type);
		SetMembershipTypeComboBox.setBounds(155, 134, 100, 20);
		ProductsServicesPanel.add(SetMembershipTypeComboBox);
		SetMembershipTypeComboBox.addItemListener(this);
		
		SetNewRatesText = new JTextField();
		SetNewRatesText.setBounds(155, 103, 100, 20);
		ProductsServicesPanel.add(SetNewRatesText);
		SetNewRatesText.setColumns(10);
		
		OldDiscountRatesText = new JTextField(formatter.format(rates[0]));
		OldDiscountRatesText.setBounds(155, 71, 100, 20);
		ProductsServicesPanel.add(OldDiscountRatesText);
		OldDiscountRatesText.setColumns(10);
		
		UpdateDiscountButton = new JButton("UPDATE RATES");
		UpdateDiscountButton.setFont(new Font("Arial", Font.PLAIN, 12));
		UpdateDiscountButton.setBounds(120, 165, 135, 35);
		ProductsServicesPanel.add(UpdateDiscountButton);
		UpdateDiscountButton.addActionListener(new Button());
		
		JLabel TitleUpdatePrice = new JLabel("PRICE CONTROL");
		TitleUpdatePrice.setForeground(Color.DARK_GRAY);
		TitleUpdatePrice.setFont(new Font("Arial", Font.BOLD, 14));
		TitleUpdatePrice.setBounds(20, 25, 173, 35);
		ProductsServicesPanel.add(TitleUpdatePrice);
		
		JLabel TitleOldDiscountRates = new JLabel("DISCOUNT RATES");
		TitleOldDiscountRates.setFont(new Font("Arial", Font.PLAIN, 12));
		TitleOldDiscountRates.setBounds(20, 71, 135, 20);
		ProductsServicesPanel.add(TitleOldDiscountRates);
		
		JLabel TitleSetNewDiscountRatesText = new JLabel("NEW RATES");
		TitleSetNewDiscountRatesText.setFont(new Font("Arial", Font.PLAIN, 12));
		TitleSetNewDiscountRatesText.setBounds(20, 102, 80, 20);
		ProductsServicesPanel.add(TitleSetNewDiscountRatesText);
		
		UpdatePriceButton = new JButton("UPDATE PRICE");
		UpdatePriceButton.setFont(new Font("Arial", Font.PLAIN, 12));
		UpdatePriceButton.setBounds(382, 165, 135, 35);
		ProductsServicesPanel.add(UpdatePriceButton);
		UpdatePriceButton.addActionListener(new Button());
		
		JLabel TitleWeightType = new JLabel("WEIGHT PRICE");
		TitleWeightType.setFont(new Font("Arial", Font.PLAIN, 12));
		TitleWeightType.setBounds(282, 71, 135, 20);
		ProductsServicesPanel.add(TitleWeightType);
		
		WeightPriceText = new JTextField(formatter.format(weight[0]));
		WeightPriceText.setColumns(10);
		WeightPriceText.setBounds(417, 71, 100, 20);
		ProductsServicesPanel.add(WeightPriceText);
		
		JLabel TitleSetNewServiceTypePrice = new JLabel("NEW PRICE");
		TitleSetNewServiceTypePrice.setFont(new Font("Arial", Font.PLAIN, 12));
		TitleSetNewServiceTypePrice.setBounds(282, 102, 80, 20);
		ProductsServicesPanel.add(TitleSetNewServiceTypePrice);
		
		SetWeightNewPriceText = new JTextField();
		SetWeightNewPriceText.setColumns(10);
		SetWeightNewPriceText.setBounds(417, 103, 100, 20);
		ProductsServicesPanel.add(SetWeightNewPriceText);
		
		weight = mff.weightPrice();
		String[] weighttype = {"HEAVYWEIGHT","LIGHTWEIGHT","LIGHT_HEAVYWEIGHT","MIDDLEWEIGHT"};
		ServiceTypeComboBox = new JComboBox(weighttype);
		ServiceTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"HEAVYWEIGHT", "LIGHTWEIGHT", "LIGHT_HEAVYWEIGHT", "MIDDLEWEIGHT"}));
		ServiceTypeComboBox.setBounds(417, 134, 100, 20);
		ProductsServicesPanel.add(ServiceTypeComboBox);
		
		TitleProductServicesManagementPanel = new JLabel("PRODUCT MANAGEMENT");
		TitleProductServicesManagementPanel.setForeground(Color.DARK_GRAY);
		TitleProductServicesManagementPanel.setFont(new Font("Arial", Font.BOLD, 16));
		TitleProductServicesManagementPanel.setBounds(60, 37, 280, 35);
		ManagerPanel.add(TitleProductServicesManagementPanel);
		
		dtm = (DefaultTableModel) DbUtils.resultSetToTableModel(mpd.resultset());
		
		LogoutButton = new JButton("LOGOUT");
		LogoutButton.setBounds(683, 23, 109, 35);
		ManagerPanel.add(LogoutButton);
		LogoutButton.setFont(new Font("Arial", Font.BOLD, 11));
		
		ManagePaymentButton = new JButton("MANAGE PAYMENT");
		ManagePaymentButton.setBounds(641, 153, 165, 35);
		ManagerPanel.add(ManagePaymentButton);
		ManagePaymentButton.setFont(new Font("Arial", Font.BOLD, 11));
		ManagePaymentButton.addActionListener(new Button());
		
		
		ClerkPerspectiveButton = new JButton("MANAGE CUSTOMER/ORDER ");
		ClerkPerspectiveButton.setBounds(627, 199, 189, 35);
		ManagerPanel.add(ClerkPerspectiveButton);
		ClerkPerspectiveButton.setFont(new Font("Arial", Font.BOLD, 11));
		ClerkPerspectiveButton.addActionListener(new Button());

		
		JLabel label = new JLabel("____________________________________________________________________________________________________________");
		label.setForeground(Color.GRAY);
		label.setFont(new Font("Arial", Font.PLAIN, 12));
		label.setBounds(40, 45, 766, 35);
		ManagerPanel.add(label);
		LogoutButton.addActionListener(new Button());
		ServiceTypeComboBox.addItemListener(this);
		
		
		
		
	}
	public void clearAllField(){
		SetNewRatesText.setText("");
		SetWeightNewPriceText.setText("");
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == SetMembershipTypeComboBox) {
				if(SetMembershipTypeComboBox.getSelectedItem().equals("Basic")){
					OldDiscountRatesText.setText(formatter.format(rates[0]));
				}
	
				if(SetMembershipTypeComboBox.getSelectedItem().equals("Premium")){
					OldDiscountRatesText.setText(formatter.format(rates[1]));
				}
	
				if(SetMembershipTypeComboBox.getSelectedItem().equals("Gold")){
					OldDiscountRatesText.setText(formatter.format(rates[2]));
				}
		}
		
		
		else
		if(e.getSource() == ServiceTypeComboBox){
			if(ServiceTypeComboBox.getSelectedItem().equals("HEAVYWEIGHT")){
				WeightPriceText.setText(formatter.format(weight[0]));
			}
			if(ServiceTypeComboBox.getSelectedItem().equals("LIGHTWEIGHT")){
				WeightPriceText.setText(formatter.format(weight[1]));
			}
			if(ServiceTypeComboBox.getSelectedItem().equals("LIGHT_HEAVYWEIGHT")){
				WeightPriceText.setText(formatter.format(weight[2]));
			}
			if(ServiceTypeComboBox.getSelectedItem().equals("MIDDLEWEIGHT")){
				WeightPriceText.setText(formatter.format(weight[3]));
			}
		
		}
	}


	public class Button implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == UpdateDiscountButton){
			String[] umd = new String[2];
			umd[0] = SetNewRatesText.getText();
			umd[1] = SetMembershipTypeComboBox.getSelectedItem().toString();
			if(mff.updateDiscountRates(umd)){
				rates[SetMembershipTypeComboBox.getSelectedIndex()] = Double.parseDouble(umd[0]);
				JOptionPane.showMessageDialog(null, "Update Discount Rates Successfull");
				clearAllField();
			}
			else{
				JOptionPane.showMessageDialog(null, "Update Discount Rates Failed");
			}
		}
			
			
			if(e.getSource() == ClerkPerspectiveButton){
				GuiClerk clrks = new GuiClerk();
				clrks.setVisible(true);
				setVisible(true);
			}
			
			if(e.getSource() == ManagePaymentButton){
				GuiPayment payment123 = new GuiPayment();
				payment123.setVisible(true);
				setVisible(true);
			}
			
			if(e.getSource() == LogoutButton){
				GuiLogin logout3 = new GuiLogin();
				logout3.setVisible(true);
				setVisible(false);
			}
			
			if(e.getSource() == UpdatePriceButton){
			String[] uwp = new String[2];
			uwp[0] = SetWeightNewPriceText.getText();
			uwp[1] = ServiceTypeComboBox.getSelectedItem().toString();
			if(mff.updateWeightPrice(uwp)){
				weight[ServiceTypeComboBox.getSelectedIndex()] = Double.parseDouble(uwp[0]);
				JOptionPane.showMessageDialog(null, "Update Weight Price Sucessfull");
				clearAllField();
			}
			else{
				JOptionPane.showMessageDialog(null, "Update Weight Price Failed");
			}
		}
	}
			
	}
}