package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import GUI.GuiManager.Button;
import dmSystem.DbMember;
import dmSystem.DbMemberOrder;
import dmSystem.DbNonOrder;
import dmSystem.FnClerk;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.util.*;
import java.util.Calendar;
import java.util.Date;

import net.proteanit.sql.DbUtils;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;



public class GuiClerk extends JFrame implements ActionListener {

	private JPanel ClerkPanel;
	private JTextField CreateMemberIDText;
	private JTextField CreateMemberRecipientNameText;
	private JTextField CreateMemberRecipientPhoneText;
	private JTextField CreateMemberItemDescriptionText;
	private JTextField CreateMemberItemWeightageText;
	private JTextField CreateWalkInCustomerNameText;
	private JTextField CreateWalkInCustomerPhoneText;
	private JTextField CreateWalkInRecipientNameText;
	private JTextField CreateWalkInRecipientPhoneText;
	private JTextField CreateWalkInItemDescriptionText;
	private JTextField CreateWalkInItemWeightageText;
	private JTextField CreateMembershipNameText;
	private JTextField CreateMembershipPhoneNumberText;
	private JTextField DeleteMembershipIdentificationNumberText;
	private JTextField DeleteMembershipMemberNameText;

	private JComboBox CreateMembershipTypeComboBox;
	private JComboBox ModifyMembershipTypeComboBox;
	private JComboBox ModifyMemberDeliveryStatusComboBox;
	private JComboBox CreateMemberDeliveryStatusComboBox;
	private JComboBox CreateWalkInDeliveryStatusComboBox;
	private JTextField DeleteMemberIDText;
	private JTextField DeleteMemberDeliveryNumberText;
	private UtilDateModel model = new UtilDateModel();
	private JDatePanelImpl datePanel = new JDatePanelImpl(model);
	private JDatePickerImpl ModifyMemberDeliveryDatePicker;
	private JDatePickerImpl ChooseMemberDeliveryDatePicker;
	private JDatePickerImpl ChooseWalkInDeliveryDatePicker;
	private JTextField ModifyMemberIDText;
	private JTextField ModifyMemberRecipientNameText;
	private JTextField ModifyMemberRecipientPhoneText;
	private JTextField ModifyMemberItemDescriptionText;
	private JTextField ModifyMemberItemWeightageText;
	private JTextField ModifyMembershipNameText;
	private JTextField ModifyMembershipPhoneNumberText;
	private JTable DisplayMemberOrderTable;
	private DefaultTableModel dtm;
	private JTextField CreateMembershipEmailAddressText;
	private DbMemberOrder odm = new DbMemberOrder();
	private JButton CreateMembershipButton;
	private JTextArea CreateMembershipAddressText;
	private DbMember md = new DbMember();
	private JTextField ModifyMembershipEmailAddressText;
	private DbNonOrder owd = new DbNonOrder();
	private FnClerk clerk = new FnClerk();
	
	private JButton ModifyMembershipButton;
	private JButton DeleteMembershipButton;
	private JButton OutsButton;
	private JButton PaymentssButton;
	private JTextField ModifyMembershipIdentificationNumberText;
	private JTable DisplayMembershipTable;
	private JScrollPane scrollPane;
	private JTextArea ModifyMembershipAddressText;
	
	private JButton CreateOrderMemberButton;
	private JTextArea CreateMemberRecipientAddressTextArea;
	private JButton ModifyOrderButton;
	private JTextArea ModifyMemberRecipientAddressText;
	private JTextField ModifyDeliveryNumberText;
	private JButton CreateOrderWalkInButton;
	private JTextArea CreateWalkInCustomerAddressText;
	private JTextArea CreateWalkInRecipientAddressText;
	private JTable DisplayWalkInOrderTable;
	private JButton DeleteMemberOrderButton;
	private JTextField MemberTotalPriceText;
	private JTextField WalkInTotalPriceText;
	private JButton MemberCalculatePriceButton;
	private JButton WalkInCalculatePriceButton;
	private DecimalFormat dfo = new DecimalFormat("#0.00");

	
	public GuiClerk() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1130, 747);
		ClerkPanel = new JPanel();
		ClerkPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ClerkPanel);
		ClerkPanel.setLayout(null);
		setVisible(true);
		
		JTabbedPane StandingOrderPanel = new JTabbedPane(JTabbedPane.TOP);
		StandingOrderPanel.setBounds(10, 81, 585, 604);
		ClerkPanel.add(StandingOrderPanel);
		
		JPanel CreateOrderPanel = new JPanel();
		StandingOrderPanel.addTab("CREATE ORDER", null, CreateOrderPanel, null);
		CreateOrderPanel.setLayout(null);
		
		JTabbedPane CreateOrderTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		CreateOrderTabbedPane.setBounds(10, 0, 504, 576);
		CreateOrderPanel.add(CreateOrderTabbedPane);
		
		JPanel CreateMemberOrderPanel = new JPanel();
		CreateOrderTabbedPane.addTab("MEMBER", null, CreateMemberOrderPanel, null);
		CreateMemberOrderPanel.setLayout(null);
		
		JLabel CreateMemberRecipientName = new JLabel("RECIPIENT NAME");
		CreateMemberRecipientName.setFont(new Font("Arial", Font.PLAIN, 12));
		CreateMemberRecipientName.setBounds(60, 89, 120, 35);
		CreateMemberOrderPanel.add(CreateMemberRecipientName);
		
		JLabel CreateMemberRecipientPhone = new JLabel("RECIPIENT PHONE");
		CreateMemberRecipientPhone.setFont(new Font("Arial", Font.PLAIN, 12));
		CreateMemberRecipientPhone.setBounds(60, 120, 120, 35);
		CreateMemberOrderPanel.add(CreateMemberRecipientPhone);
		
		JLabel CreateMemberRecipientAddress = new JLabel("RECIPIENT ADDRESS");
		CreateMemberRecipientAddress.setFont(new Font("Arial", Font.PLAIN, 12));
		CreateMemberRecipientAddress.setBounds(60, 147, 130, 47);
		CreateMemberOrderPanel.add(CreateMemberRecipientAddress);
		
		JLabel CreateMemberItemDescription = new JLabel("ITEM DESCRIPTION");
		CreateMemberItemDescription.setFont(new Font("Arial", Font.PLAIN, 12));
		CreateMemberItemDescription.setBounds(60, 205, 130, 35);
		CreateMemberOrderPanel.add(CreateMemberItemDescription);
		
		JLabel CreateMemberItemWeightage = new JLabel("ITEM WEIGHTAGE");
		CreateMemberItemWeightage.setFont(new Font("Arial", Font.PLAIN, 12));
		CreateMemberItemWeightage.setBounds(60, 240, 130, 35);
		CreateMemberOrderPanel.add(CreateMemberItemWeightage);
		
		JLabel CreateMemberDeliveryStatus = new JLabel("DELIVERY STATUS");
		CreateMemberDeliveryStatus.setFont(new Font("Arial", Font.PLAIN, 12));
		CreateMemberDeliveryStatus.setBounds(60, 276, 130, 35);
		CreateMemberOrderPanel.add(CreateMemberDeliveryStatus);
		
		JLabel CreateMemberDeliveryDate = new JLabel("DELIVERY DATE");
		CreateMemberDeliveryDate.setFont(new Font("Arial", Font.PLAIN, 12));
		CreateMemberDeliveryDate.setBounds(60, 305, 120, 35);
		CreateMemberOrderPanel.add(CreateMemberDeliveryDate);
		
		ChooseMemberDeliveryDatePicker = new JDatePickerImpl(datePanel);
		ChooseMemberDeliveryDatePicker.setBounds(194, 315, 200, 25);
		CreateMemberOrderPanel.add(ChooseMemberDeliveryDatePicker);
		
		CreateMemberRecipientNameText = new JTextField();
		CreateMemberRecipientNameText.setColumns(10);
		CreateMemberRecipientNameText.setBounds(194, 97, 150, 20);
		CreateMemberOrderPanel.add(CreateMemberRecipientNameText);
		
		CreateMemberRecipientPhoneText = new JTextField();
		CreateMemberRecipientPhoneText.setColumns(10);
		CreateMemberRecipientPhoneText.setBounds(194, 128, 130, 20);
		CreateMemberOrderPanel.add(CreateMemberRecipientPhoneText);
		
		CreateMemberItemDescriptionText = new JTextField();
		CreateMemberItemDescriptionText.setColumns(10);
		CreateMemberItemDescriptionText.setBounds(194, 217, 200, 20);
		CreateMemberOrderPanel.add(CreateMemberItemDescriptionText);
		
		CreateMemberItemWeightageText = new JTextField();
		CreateMemberItemWeightageText.setColumns(10);
		CreateMemberItemWeightageText.setBounds(194, 248, 69, 20);
		CreateMemberOrderPanel.add(CreateMemberItemWeightageText);
		
		CreateMemberRecipientAddressTextArea = new JTextArea();
		CreateMemberRecipientAddressTextArea.setBounds(194, 159, 200, 47);
		CreateMemberOrderPanel.add(CreateMemberRecipientAddressTextArea);
		
		CreateOrderMemberButton = new JButton("CREATE ORDER");
		CreateOrderMemberButton.setFont(new Font("Arial", Font.PLAIN, 12));
		CreateOrderMemberButton.setBounds(105, 424, 150, 35);
		CreateMemberOrderPanel.add(CreateOrderMemberButton);
		CreateOrderMemberButton.addActionListener(this);
		
		CreateMemberDeliveryStatusComboBox = new JComboBox();
		CreateMemberDeliveryStatusComboBox.setBounds(194, 284, 100, 20);
		CreateMemberOrderPanel.add(CreateMemberDeliveryStatusComboBox);
		CreateMemberDeliveryStatusComboBox.addItem("ON-HOLD");
		CreateMemberDeliveryStatusComboBox.addItem("IN DELIVERY");
		
		JLabel MemberTotalPrice = new JLabel("TOTAL PRICE");
		MemberTotalPrice.setFont(new Font("Arial", Font.PLAIN, 12));
		MemberTotalPrice.setBounds(60, 351, 100, 35);
		CreateMemberOrderPanel.add(MemberTotalPrice);
		
		MemberTotalPriceText = new JTextField();
		MemberTotalPriceText.setBounds(193, 359, 100, 20);
		CreateMemberOrderPanel.add(MemberTotalPriceText);
		MemberTotalPriceText.setColumns(10);
		
		MemberCalculatePriceButton = new JButton("CALCULATE PRICE");
		MemberCalculatePriceButton.setFont(new Font("Arial", Font.PLAIN, 12));
		MemberCalculatePriceButton.setBounds(281, 424, 180, 35);
		CreateMemberOrderPanel.add(MemberCalculatePriceButton);
		
		JLabel CreateMemberID = new JLabel("MEMBER ID");
		CreateMemberID.setBounds(60, 57, 80, 35);
		CreateMemberOrderPanel.add(CreateMemberID);
		CreateMemberID.setFont(new Font("Arial", Font.PLAIN, 12));
		
		CreateMemberIDText = new JTextField();
		CreateMemberIDText.setBounds(193, 66, 50, 20);
		CreateMemberOrderPanel.add(CreateMemberIDText);
		CreateMemberIDText.setColumns(10);
		
		JLabel lblMemberOrder = new JLabel("MEMBER ORDER");
		lblMemberOrder.setForeground(Color.DARK_GRAY);
		lblMemberOrder.setFont(new Font("Arial", Font.BOLD, 14));
		lblMemberOrder.setBounds(40, 20, 150, 35);
		CreateMemberOrderPanel.add(lblMemberOrder);
		
		JLabel label_5 = new JLabel("___________________________________________________________");
		label_5.setForeground(Color.LIGHT_GRAY);
		label_5.setFont(new Font("Arial", Font.PLAIN, 12));
		label_5.setBounds(34, 30, 413, 35);
		CreateMemberOrderPanel.add(label_5);
		MemberCalculatePriceButton.addActionListener(this);
		
		
		JPanel CreateWalkInCustomerPanel = new JPanel();
		CreateOrderTabbedPane.addTab("WALK-IN CUSTOMER", null, CreateWalkInCustomerPanel, null);
		CreateWalkInCustomerPanel.setLayout(null);
		
		JLabel CreateWalkInCustomerName = new JLabel("CUSTOMER NAME");
		CreateWalkInCustomerName.setFont(new Font("Arial", Font.PLAIN, 12));
		CreateWalkInCustomerName.setBounds(62, 57, 120, 47);
		CreateWalkInCustomerPanel.add(CreateWalkInCustomerName);
		
		JLabel CreateWalkInCustomerPhone = new JLabel("CUSTOMER PHONE");
		CreateWalkInCustomerPhone.setFont(new Font("Arial", Font.PLAIN, 12));
		CreateWalkInCustomerPhone.setBounds(62, 95, 120, 35);
		CreateWalkInCustomerPanel.add(CreateWalkInCustomerPhone);
		
		JLabel CreateWalkInCustomerAddress = new JLabel("CUSTOMER ADDRESS");
		CreateWalkInCustomerAddress.setFont(new Font("Arial", Font.PLAIN, 12));
		CreateWalkInCustomerAddress.setBounds(62, 131, 140, 35);
		CreateWalkInCustomerPanel.add(CreateWalkInCustomerAddress);
		
		JLabel CreateWalkInRecipientName = new JLabel("RECIPIENT NAME");
		CreateWalkInRecipientName.setFont(new Font("Arial", Font.PLAIN, 12));
		CreateWalkInRecipientName.setBounds(62, 187, 120, 35);
		CreateWalkInCustomerPanel.add(CreateWalkInRecipientName);
		
		JLabel CreateWalkInRecipientPhone = new JLabel("RECIPIENT PHONE");
		CreateWalkInRecipientPhone.setFont(new Font("Arial", Font.PLAIN, 12));
		CreateWalkInRecipientPhone.setBounds(62, 218, 130, 35);
		CreateWalkInCustomerPanel.add(CreateWalkInRecipientPhone);
		
		JLabel CreateWalkInRecipientAddress = new JLabel("RECIPIENT ADDRESS");
		CreateWalkInRecipientAddress.setFont(new Font("Arial", Font.PLAIN, 12));
		CreateWalkInRecipientAddress.setBounds(62, 251, 130, 35);
		CreateWalkInCustomerPanel.add(CreateWalkInRecipientAddress);
		
		JLabel CreateWalkInItemDescription = new JLabel("ITEM DESCRIPTION");
		CreateWalkInItemDescription.setFont(new Font("Arial", Font.PLAIN, 12));
		CreateWalkInItemDescription.setBounds(62, 310, 130, 35);
		CreateWalkInCustomerPanel.add(CreateWalkInItemDescription);
		
		JLabel CreateWalkInItemWeightage = new JLabel("ITEM WEIGHTAGE");
		CreateWalkInItemWeightage.setFont(new Font("Arial", Font.PLAIN, 12));
		CreateWalkInItemWeightage.setBounds(62, 340, 130, 35);
		CreateWalkInCustomerPanel.add(CreateWalkInItemWeightage);
		
		JLabel CreateWalkInDeliveryStatus = new JLabel("DELIVERY STATUS");
		CreateWalkInDeliveryStatus.setFont(new Font("Arial", Font.PLAIN, 12));
		CreateWalkInDeliveryStatus.setBounds(62, 371, 130, 35);
		CreateWalkInCustomerPanel.add(CreateWalkInDeliveryStatus);
		
		JLabel CreateWalkInDeliveryDate = new JLabel("DELIVERY DATE");
		CreateWalkInDeliveryDate.setFont(new Font("Arial", Font.PLAIN, 12));
		CreateWalkInDeliveryDate.setBounds(62, 401, 135, 35);
		CreateWalkInCustomerPanel.add(CreateWalkInDeliveryDate);
		
		ChooseWalkInDeliveryDatePicker = new JDatePickerImpl(datePanel);
		ChooseWalkInDeliveryDatePicker.setBounds(197, 413, 200, 23);
		CreateWalkInCustomerPanel.add(ChooseWalkInDeliveryDatePicker);
		
		CreateWalkInCustomerNameText = new JTextField();
		CreateWalkInCustomerNameText.setColumns(10);
		CreateWalkInCustomerNameText.setBounds(197, 71, 155, 20);
		CreateWalkInCustomerPanel.add(CreateWalkInCustomerNameText);
		
		CreateWalkInCustomerPhoneText = new JTextField();
		CreateWalkInCustomerPhoneText.setColumns(10);
		CreateWalkInCustomerPhoneText.setBounds(197, 103, 140, 20);
		CreateWalkInCustomerPanel.add(CreateWalkInCustomerPhoneText);
		
		CreateWalkInRecipientNameText = new JTextField();
		CreateWalkInRecipientNameText.setColumns(10);
		CreateWalkInRecipientNameText.setBounds(197, 195, 155, 20);
		CreateWalkInCustomerPanel.add(CreateWalkInRecipientNameText);
		
		CreateWalkInRecipientPhoneText = new JTextField();
		CreateWalkInRecipientPhoneText.setColumns(10);
		CreateWalkInRecipientPhoneText.setBounds(197, 226, 140, 20);
		CreateWalkInCustomerPanel.add(CreateWalkInRecipientPhoneText);
		
		CreateWalkInItemDescriptionText = new JTextField();
		CreateWalkInItemDescriptionText.setColumns(10);
		CreateWalkInItemDescriptionText.setBounds(197, 315, 155, 20);
		CreateWalkInCustomerPanel.add(CreateWalkInItemDescriptionText);
		
		CreateWalkInItemWeightageText = new JTextField();
		CreateWalkInItemWeightageText.setColumns(10);
		CreateWalkInItemWeightageText.setBounds(197, 348, 78, 20);
		CreateWalkInCustomerPanel.add(CreateWalkInItemWeightageText);
		
		CreateWalkInCustomerAddressText = new JTextArea();
		CreateWalkInCustomerAddressText.setBounds(197, 137, 200, 47);
		CreateWalkInCustomerPanel.add(CreateWalkInCustomerAddressText);
		
		CreateWalkInRecipientAddressText = new JTextArea();
		CreateWalkInRecipientAddressText.setBounds(197, 257, 200, 47);
		CreateWalkInCustomerPanel.add(CreateWalkInRecipientAddressText);
		
		CreateWalkInDeliveryStatusComboBox = new JComboBox();
		CreateWalkInDeliveryStatusComboBox.setBounds(197, 379, 100, 20);
		CreateWalkInCustomerPanel.add(CreateWalkInDeliveryStatusComboBox);
		CreateWalkInDeliveryStatusComboBox.addItem("DELIVERY");
		
		JLabel WalkInTotalPrice = new JLabel("TOTAL PRICE");
		WalkInTotalPrice.setFont(new Font("Arial", Font.PLAIN, 12));
		WalkInTotalPrice.setBounds(61, 434, 110, 47);
		CreateWalkInCustomerPanel.add(WalkInTotalPrice);
		
		WalkInTotalPriceText = new JTextField();
		WalkInTotalPriceText.setBounds(197, 447, 100, 23);
		CreateWalkInCustomerPanel.add(WalkInTotalPriceText);
		WalkInTotalPriceText.setColumns(10);
		
		WalkInCalculatePriceButton = new JButton("CALCULATE PRICE");
		WalkInCalculatePriceButton.setFont(new Font("Arial", Font.PLAIN, 12));
		WalkInCalculatePriceButton.setBounds(142, 492, 155, 35);
		CreateWalkInCustomerPanel.add(WalkInCalculatePriceButton);
		
		CreateOrderWalkInButton = new JButton("CREATE ORDER");
		CreateOrderWalkInButton.setBounds(309, 492, 130, 35);
		CreateWalkInCustomerPanel.add(CreateOrderWalkInButton);
		CreateOrderWalkInButton.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel label_6 = new JLabel("___________________________________________________________");
		label_6.setForeground(Color.LIGHT_GRAY);
		label_6.setFont(new Font("Arial", Font.PLAIN, 12));
		label_6.setBounds(44, 31, 413, 35);
		CreateWalkInCustomerPanel.add(label_6);
		
		JLabel lblWalkinCustomerOrder = new JLabel("WALK-IN CUSTOMER ORDER");
		lblWalkinCustomerOrder.setForeground(Color.DARK_GRAY);
		lblWalkinCustomerOrder.setFont(new Font("Arial", Font.BOLD, 14));
		lblWalkinCustomerOrder.setBounds(50, 21, 263, 35);
		CreateWalkInCustomerPanel.add(lblWalkinCustomerOrder);
		CreateOrderWalkInButton.addActionListener(this);
		WalkInCalculatePriceButton.addActionListener(this);
		
		
		JPanel ModifyOrderPanel = new JPanel();
		StandingOrderPanel.addTab("MODIFY ORDER", null, ModifyOrderPanel, null);
		ModifyOrderPanel.setLayout(null);
		
		JTabbedPane ModifyMemberOrderTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		ModifyMemberOrderTabbedPane.setBounds(10, 0, 516, 517);
		ModifyOrderPanel.add(ModifyMemberOrderTabbedPane);
		
		JPanel ModifyMemberOrderPanel = new JPanel();
		ModifyMemberOrderTabbedPane.addTab("MEMBER", null, ModifyMemberOrderPanel, null);
		ModifyMemberOrderPanel.setLayout(null);
		
		JLabel ModifyMemberID = new JLabel("MEMBER ID");
		ModifyMemberID.setFont(new Font("Arial", Font.PLAIN, 12));
		ModifyMemberID.setBounds(74, 68, 120, 35);
		ModifyMemberOrderPanel.add(ModifyMemberID);
		
		JLabel ModifyMemberRecipientName = new JLabel("RECIPIENT NAME");
		ModifyMemberRecipientName.setFont(new Font("Arial", Font.PLAIN, 12));
		ModifyMemberRecipientName.setBounds(74, 130, 130, 35);
		ModifyMemberOrderPanel.add(ModifyMemberRecipientName);
		
		JLabel ModifyMemberRecipientPhone = new JLabel("RECIPIENT PHONE");
		ModifyMemberRecipientPhone.setFont(new Font("Arial", Font.PLAIN, 12));
		ModifyMemberRecipientPhone.setBounds(74, 161, 135, 35);
		ModifyMemberOrderPanel.add(ModifyMemberRecipientPhone);
		
		JLabel ModifyMemberRecipientAddress = new JLabel("RECIPIENT ADDRESS");
		ModifyMemberRecipientAddress.setFont(new Font("Arial", Font.PLAIN, 12));
		ModifyMemberRecipientAddress.setBounds(74, 196, 130, 35);
		ModifyMemberOrderPanel.add(ModifyMemberRecipientAddress);
		
		JLabel ModifyMemberItemDescription = new JLabel("ITEM DESCRIPTION");
		ModifyMemberItemDescription.setFont(new Font("Arial", Font.PLAIN, 12));
		ModifyMemberItemDescription.setBounds(74, 252, 130, 35);
		ModifyMemberOrderPanel.add(ModifyMemberItemDescription);
		
		JLabel ModifyMemberItemWeightage = new JLabel("ITEM WEIGHTAGE");
		ModifyMemberItemWeightage.setFont(new Font("Arial", Font.PLAIN, 12));
		ModifyMemberItemWeightage.setBounds(74, 283, 130, 35);
		ModifyMemberOrderPanel.add(ModifyMemberItemWeightage);
		
		JLabel lblDeliveryStatus = new JLabel("DELIVERY STATUS");
		lblDeliveryStatus.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDeliveryStatus.setBounds(74, 308, 130, 47);
		ModifyMemberOrderPanel.add(lblDeliveryStatus);
		
		JLabel ModifyMemberDeliveryDate = new JLabel("DELIVERY DATE");
		ModifyMemberDeliveryDate.setFont(new Font("Arial", Font.PLAIN, 12));
		ModifyMemberDeliveryDate.setBounds(74, 341, 130, 35);
		ModifyMemberOrderPanel.add(ModifyMemberDeliveryDate);
		
		ModifyMemberDeliveryDatePicker = new JDatePickerImpl(datePanel);
		ModifyMemberDeliveryDatePicker.setBounds(225, 353, 200, 23);
		ModifyMemberOrderPanel.add(ModifyMemberDeliveryDatePicker);
		
		
		ModifyMemberIDText = new JTextField();
		ModifyMemberIDText.setColumns(10);
		ModifyMemberIDText.setBounds(225, 76, 50, 20);
		ModifyMemberOrderPanel.add(ModifyMemberIDText);
		
		ModifyMemberRecipientNameText = new JTextField();
		ModifyMemberRecipientNameText.setColumns(10);
		ModifyMemberRecipientNameText.setBounds(225, 138, 200, 20);
		ModifyMemberOrderPanel.add(ModifyMemberRecipientNameText);
		
		ModifyMemberRecipientPhoneText = new JTextField();
		ModifyMemberRecipientPhoneText.setColumns(10);
		ModifyMemberRecipientPhoneText.setBounds(225, 169, 200, 20);
		ModifyMemberOrderPanel.add(ModifyMemberRecipientPhoneText);
		
		ModifyMemberRecipientAddressText = new JTextArea();
		ModifyMemberRecipientAddressText.setBounds(225, 202, 200, 47);
		ModifyMemberOrderPanel.add(ModifyMemberRecipientAddressText);
		
		ModifyMemberItemDescriptionText = new JTextField();
		ModifyMemberItemDescriptionText.setColumns(10);
		ModifyMemberItemDescriptionText.setBounds(225, 260, 200, 20);
		ModifyMemberOrderPanel.add(ModifyMemberItemDescriptionText);
		
		ModifyMemberItemWeightageText = new JTextField();
		ModifyMemberItemWeightageText.setColumns(10);
		ModifyMemberItemWeightageText.setBounds(225, 291, 200, 20);
		ModifyMemberOrderPanel.add(ModifyMemberItemWeightageText);
		
		ModifyOrderButton = new JButton("MODIFY ORDER");
		ModifyOrderButton.setFont(new Font("Arial", Font.PLAIN, 12));
		ModifyOrderButton.setBounds(275, 402, 150, 42);
		ModifyMemberOrderPanel.add(ModifyOrderButton);
		ModifyOrderButton.addActionListener(this);
		
		ModifyMemberDeliveryStatusComboBox = new JComboBox();
		ModifyMemberDeliveryStatusComboBox.setBounds(225, 322, 100, 20);
		ModifyMemberOrderPanel.add(ModifyMemberDeliveryStatusComboBox);
		ModifyMemberDeliveryStatusComboBox.addItem("ON-HOLD");
		ModifyMemberDeliveryStatusComboBox.addItem("IN DELIVERY");
		
		JLabel ModifyDeliveryNumber = new JLabel("DELIVERY NUMBER");
		ModifyDeliveryNumber.setFont(new Font("Arial", Font.PLAIN, 12));
		ModifyDeliveryNumber.setBounds(74, 101, 130, 35);
		ModifyMemberOrderPanel.add(ModifyDeliveryNumber);
		
		ModifyDeliveryNumberText = new JTextField();
		ModifyDeliveryNumberText.setBounds(225, 107, 200, 20);
		ModifyMemberOrderPanel.add(ModifyDeliveryNumberText);
		ModifyDeliveryNumberText.setColumns(10);
		
		JLabel lblModifyOrder = new JLabel("MODIFY ORDER");
		lblModifyOrder.setForeground(Color.DARK_GRAY);
		lblModifyOrder.setFont(new Font("Arial", Font.BOLD, 14));
		lblModifyOrder.setBounds(55, 27, 150, 35);
		ModifyMemberOrderPanel.add(lblModifyOrder);
		
		JLabel label_7 = new JLabel("___________________________________________________________");
		label_7.setForeground(Color.LIGHT_GRAY);
		label_7.setFont(new Font("Arial", Font.PLAIN, 12));
		label_7.setBounds(50, 35, 413, 35);
		ModifyMemberOrderPanel.add(label_7);
		
		dtm = (DefaultTableModel) DbUtils.resultSetToTableModel(odm.resultset());
		
		dtm = (DefaultTableModel) DbUtils.resultSetToTableModel(owd.resultset());
		
		JPanel DeleteOrderPanel = new JPanel();
		StandingOrderPanel.addTab("DELETE ORDER", null, DeleteOrderPanel, null);
		DeleteOrderPanel.setLayout(null);
		
		JTabbedPane DeleteMemberOrderTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		DeleteMemberOrderTabbedPane.setBounds(10, 11, 438, 231);
		DeleteOrderPanel.add(DeleteMemberOrderTabbedPane);
		
		JPanel DeleteMemberOrderPanel = new JPanel();
		DeleteMemberOrderTabbedPane.addTab("MEMBER", null, DeleteMemberOrderPanel, null);
		DeleteMemberOrderPanel.setLayout(null);
		
		JLabel DeleteMemberDeliveryNumber = new JLabel("DELIVERY NUMBER");
		DeleteMemberDeliveryNumber.setFont(new Font("Arial", Font.PLAIN, 12));
		DeleteMemberDeliveryNumber.setBounds(45, 51, 130, 35);
		DeleteMemberOrderPanel.add(DeleteMemberDeliveryNumber);
		
		JLabel DeleteMemberID = new JLabel("MEMBER ID");
		DeleteMemberID.setFont(new Font("Arial", Font.PLAIN, 12));
		DeleteMemberID.setBounds(45, 82, 135, 35);
		DeleteMemberOrderPanel.add(DeleteMemberID);
		
		DeleteMemberIDText = new JTextField();
		DeleteMemberIDText.setColumns(10);
		DeleteMemberIDText.setBounds(185, 90, 200, 20);
		DeleteMemberOrderPanel.add(DeleteMemberIDText);
		
		DeleteMemberDeliveryNumberText = new JTextField();
		DeleteMemberDeliveryNumberText.setColumns(10);
		DeleteMemberDeliveryNumberText.setBounds(185, 59, 200, 20);
		DeleteMemberOrderPanel.add(DeleteMemberDeliveryNumberText);
		
		DeleteMemberOrderButton = new JButton("DELETE ORDER");
		DeleteMemberOrderButton.setFont(new Font("Arial", Font.PLAIN, 12));
	    DeleteMemberOrderButton.setBounds(255, 144, 130, 35);
		DeleteMemberOrderPanel.add(DeleteMemberOrderButton);
		
		JLabel lblDeleteOrder = new JLabel("DELETE ORDER");
		lblDeleteOrder.setForeground(Color.DARK_GRAY);
		lblDeleteOrder.setFont(new Font("Arial", Font.BOLD, 14));
		lblDeleteOrder.setBounds(30, 13, 150, 35);
		DeleteMemberOrderPanel.add(lblDeleteOrder);
		
		JLabel label_8 = new JLabel("_____________________________________________________");
		label_8.setForeground(Color.LIGHT_GRAY);
		label_8.setFont(new Font("Arial", Font.PLAIN, 12));
		label_8.setBounds(25, 24, 413, 35);
		DeleteMemberOrderPanel.add(label_8);
		
		
		JPanel DisplayOrderPanel = new JPanel();
		StandingOrderPanel.addTab("DISPLAY ORDER", null, DisplayOrderPanel, null);
		DisplayOrderPanel.setLayout(null);
		
		JTabbedPane DisplayMemberOrderTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		DisplayMemberOrderTabbedPane.setBounds(10, 11, 565, 466);
		DisplayOrderPanel.add(DisplayMemberOrderTabbedPane);
		
		JPanel DisplayMemberOrderPanel = new JPanel();
		DisplayMemberOrderTabbedPane.addTab("MEMBER", null, DisplayMemberOrderPanel, null);
		DisplayMemberOrderPanel.setLayout(null);
		
		JScrollPane DisplayMemberOrderScrollPane = new JScrollPane();
		DisplayMemberOrderScrollPane.setBounds(10, 66, 540, 269);
		DisplayMemberOrderPanel.add(DisplayMemberOrderScrollPane);
		DisplayMemberOrderTable = new JTable(dtm);
		DisplayMemberOrderScrollPane.setViewportView(DisplayMemberOrderTable);
		
		JLabel lblOrderMemberDatabase = new JLabel("ORDER MEMBER DATABASE");
		lblOrderMemberDatabase.setForeground(Color.DARK_GRAY);
		lblOrderMemberDatabase.setFont(new Font("Arial", Font.BOLD, 14));
		lblOrderMemberDatabase.setBounds(32, 21, 218, 35);
		DisplayMemberOrderPanel.add(lblOrderMemberDatabase);
		
		JLabel label_9 = new JLabel("______________________________________________________________________");
		label_9.setForeground(Color.LIGHT_GRAY);
		label_9.setFont(new Font("Arial", Font.PLAIN, 12));
		label_9.setBounds(27, 29, 501, 35);
		DisplayMemberOrderPanel.add(label_9);
		
		JPanel DisplayWalkInOrderPanel = new JPanel();
		DisplayMemberOrderTabbedPane.addTab("WALK-IN CUSTOMER", null, DisplayWalkInOrderPanel, null);
		DisplayWalkInOrderPanel.setLayout(null);
		
		JScrollPane DisplayWalkInOrderScrollPane = new JScrollPane();
		DisplayWalkInOrderScrollPane.setBounds(10, 72, 550, 295);
		DisplayWalkInOrderPanel.add(DisplayWalkInOrderScrollPane);
		DisplayWalkInOrderTable = new JTable(dtm);
		DisplayWalkInOrderScrollPane.setViewportView(DisplayWalkInOrderTable);
		
		JLabel lblOrderWalkinCustomer = new JLabel("ORDER WALK-IN CUSTOMER DATABASE");
		lblOrderWalkinCustomer.setForeground(Color.DARK_GRAY);
		lblOrderWalkinCustomer.setFont(new Font("Arial", Font.BOLD, 14));
		lblOrderWalkinCustomer.setBounds(39, 28, 303, 35);
		DisplayWalkInOrderPanel.add(lblOrderWalkinCustomer);
		
		JLabel label_10 = new JLabel("______________________________________________________________________");
		label_10.setForeground(Color.LIGHT_GRAY);
		label_10.setFont(new Font("Arial", Font.PLAIN, 12));
		label_10.setBounds(34, 36, 501, 35);
		DisplayWalkInOrderPanel.add(label_10);
		DeleteMemberOrderButton.addActionListener(this);
		
		JTabbedPane MembershipPanel = new JTabbedPane(JTabbedPane.TOP);
		MembershipPanel.setBounds(605, 94, 500, 405);
		ClerkPanel.add(MembershipPanel);
		
		JPanel CreateMembershipPanel = new JPanel();
		MembershipPanel.addTab("CREATE MEMBER", null, CreateMembershipPanel, null);
		CreateMembershipPanel.setLayout(null);
		
		JLabel CreateMembershipName = new JLabel("NAME");
		CreateMembershipName.setFont(new Font("Arial", Font.PLAIN, 12));
		CreateMembershipName.setBounds(66, 85, 50, 35);
		CreateMembershipPanel.add(CreateMembershipName);
		
		JLabel CreateMembershipAddress = new JLabel("ADDRESS");
		CreateMembershipAddress.setFont(new Font("Arial", Font.PLAIN, 12));
		CreateMembershipAddress.setBounds(66, 180, 80, 35);
		CreateMembershipPanel.add(CreateMembershipAddress);
		
		JLabel CreateMembershipPhoneNumber = new JLabel("PHONE NUMBER");
		CreateMembershipPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 12));
		CreateMembershipPhoneNumber.setBounds(66, 116, 135, 35);
		CreateMembershipPanel.add(CreateMembershipPhoneNumber);
		
		CreateMembershipNameText = new JTextField();
		CreateMembershipNameText.setColumns(10);
		CreateMembershipNameText.setBounds(217, 93, 200, 20);
		CreateMembershipPanel.add(CreateMembershipNameText);
		
		CreateMembershipPhoneNumberText = new JTextField();
		CreateMembershipPhoneNumberText.setColumns(10);
		CreateMembershipPhoneNumberText.setBounds(217, 124, 200, 20);
		CreateMembershipPanel.add(CreateMembershipPhoneNumberText);
		
		CreateMembershipAddressText = new JTextArea();
		CreateMembershipAddressText.setBounds(217, 186, 200, 47);
		CreateMembershipPanel.add(CreateMembershipAddressText);
		
		JLabel CreateMembershipType = new JLabel("MEMBERSHIP TYPE");
		CreateMembershipType.setFont(new Font("Arial", Font.PLAIN, 12));
		CreateMembershipType.setBounds(66, 242, 155, 35);
		CreateMembershipPanel.add(CreateMembershipType);
		
		CreateMembershipTypeComboBox = new JComboBox();
		CreateMembershipTypeComboBox.setBounds(217, 250, 100, 20);
		CreateMembershipPanel.add(CreateMembershipTypeComboBox);
		CreateMembershipTypeComboBox.addItem("GOLD");
		CreateMembershipTypeComboBox.addItem("PREMIUM");
		CreateMembershipTypeComboBox.addItem("BASIC");
		
		CreateMembershipButton = new JButton("ADD MEMBER");
		CreateMembershipButton.setFont(new Font("Arial", Font.PLAIN, 12));
		CreateMembershipButton.setBounds(270, 281, 135, 35);
		CreateMembershipPanel.add(CreateMembershipButton);
		CreateMembershipButton.addActionListener(this);
		
		JLabel CreateMembershipEmailAddress = new JLabel("EMAIL ADDRESS");
		CreateMembershipEmailAddress.setFont(new Font("Arial", Font.PLAIN, 12));
		CreateMembershipEmailAddress.setBounds(66, 145, 135, 35);
		CreateMembershipPanel.add(CreateMembershipEmailAddress);
		
		CreateMembershipEmailAddressText = new JTextField();
		CreateMembershipEmailAddressText.setColumns(10);
		CreateMembershipEmailAddressText.setBounds(217, 155, 200, 20);
		CreateMembershipPanel.add(CreateMembershipEmailAddressText);
		
		JLabel De = new JLabel("ADD NEW MEMBER");
		De.setForeground(Color.DARK_GRAY);
		De.setFont(new Font("Arial", Font.BOLD, 14));
		De.setBounds(39, 39, 150, 35);
		CreateMembershipPanel.add(De);
		
		JLabel label_1 = new JLabel("___________________________________________________________");
		label_1.setForeground(Color.LIGHT_GRAY);
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setBounds(34, 47, 413, 35);
		CreateMembershipPanel.add(label_1);
		
		JPanel ModifyMembershipPanel = new JPanel();
		MembershipPanel.addTab("MODIFY MEMBER", null, ModifyMembershipPanel, null);
		ModifyMembershipPanel.setLayout(null);
		
		JLabel ModifyMembershipName = new JLabel("NAME");
		ModifyMembershipName.setFont(new Font("Arial", Font.PLAIN, 12));
		ModifyMembershipName.setBounds(64, 116, 55, 35);
		ModifyMembershipPanel.add(ModifyMembershipName);
		
		JLabel ModifyMembershipPhoneNumber = new JLabel("PHONE NUMBER");
		ModifyMembershipPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 12));
		ModifyMembershipPhoneNumber.setBounds(64, 147, 135, 35);
		ModifyMembershipPanel.add(ModifyMembershipPhoneNumber);
		
		JLabel ModifyMembershipAddress = new JLabel("ADDRESS");
		ModifyMembershipAddress.setFont(new Font("Arial", Font.PLAIN, 12));
		ModifyMembershipAddress.setBounds(64, 217, 90, 35);
		ModifyMembershipPanel.add(ModifyMembershipAddress);
		
		JLabel ModifyMembershipType = new JLabel("MEMBERSHIP TYPE");
		ModifyMembershipType.setFont(new Font("Arial", Font.PLAIN, 12));
		ModifyMembershipType.setBounds(65, 278, 140, 35);
		ModifyMembershipPanel.add(ModifyMembershipType);
		
		ModifyMembershipNameText = new JTextField();
		ModifyMembershipNameText.setColumns(10);
		ModifyMembershipNameText.setBounds(215, 124, 150, 20);
		ModifyMembershipPanel.add(ModifyMembershipNameText);
		
		ModifyMembershipPhoneNumberText = new JTextField();
		ModifyMembershipPhoneNumberText.setColumns(10);
		ModifyMembershipPhoneNumberText.setBounds(215, 155, 135, 20);
		ModifyMembershipPanel.add(ModifyMembershipPhoneNumberText);
		
		ModifyMembershipAddressText = new JTextArea();
		ModifyMembershipAddressText.setBounds(215, 217, 200, 47);
		ModifyMembershipPanel.add(ModifyMembershipAddressText);
		
		ModifyMembershipTypeComboBox = new JComboBox();
		ModifyMembershipTypeComboBox.setBounds(215, 286, 100, 20);
		ModifyMembershipPanel.add(ModifyMembershipTypeComboBox);
		ModifyMembershipTypeComboBox.addItem("GOLD");
		ModifyMembershipTypeComboBox.addItem("PREMIUM");
		ModifyMembershipTypeComboBox.addItem("BASIC");
		
		ModifyMembershipButton = new JButton("UPDATE MEMBER");
		ModifyMembershipButton.setFont(new Font("Arial", Font.PLAIN, 12));
		ModifyMembershipButton.setBounds(268, 317, 135, 35);
		ModifyMembershipPanel.add(ModifyMembershipButton);
		ModifyMembershipButton.addActionListener(this);
		
		JLabel ModifyMembershipEmailAddress = new JLabel("EMAIL ADDRESS");
		ModifyMembershipEmailAddress.setFont(new Font("Arial", Font.PLAIN, 12));
		ModifyMembershipEmailAddress.setBounds(64, 178, 135, 35);
		ModifyMembershipPanel.add(ModifyMembershipEmailAddress);
		
		ModifyMembershipEmailAddressText = new JTextField();
		ModifyMembershipEmailAddressText.setBounds(215, 186, 150, 20);
		ModifyMembershipPanel.add(ModifyMembershipEmailAddressText);
		ModifyMembershipEmailAddressText.setColumns(10);
		
		JLabel ModifyMembershipIdentificationNumber = new JLabel("ID NUMBER");
		ModifyMembershipIdentificationNumber.setFont(new Font("Arial", Font.PLAIN, 12));
		ModifyMembershipIdentificationNumber.setBounds(64, 85, 170, 35);
		ModifyMembershipPanel.add(ModifyMembershipIdentificationNumber);
		
		ModifyMembershipIdentificationNumberText = new JTextField();
		ModifyMembershipIdentificationNumberText.setBounds(215, 93, 50, 20);
		ModifyMembershipPanel.add(ModifyMembershipIdentificationNumberText);
		ModifyMembershipIdentificationNumberText.setColumns(10);
		
		JLabel lblModifyMember = new JLabel("MODIFY MEMBER");
		lblModifyMember.setForeground(Color.DARK_GRAY);
		lblModifyMember.setFont(new Font("Arial", Font.BOLD, 14));
		lblModifyMember.setBounds(43, 39, 150, 35);
		ModifyMembershipPanel.add(lblModifyMember);
		
		JLabel label = new JLabel("___________________________________________________________");
		label.setForeground(Color.LIGHT_GRAY);
		label.setFont(new Font("Arial", Font.PLAIN, 12));
		label.setBounds(34, 47, 413, 35);
		ModifyMembershipPanel.add(label);
		
		JPanel DeleteMembershipPanel = new JPanel();
		MembershipPanel.addTab("DELETE MEMBER", null, DeleteMembershipPanel, null);
		DeleteMembershipPanel.setLayout(null);
		
		JLabel DeleteMembershipIdentificationNumber = new JLabel("ID NUMBER");
		DeleteMembershipIdentificationNumber.setFont(new Font("Arial", Font.PLAIN, 12));
		DeleteMembershipIdentificationNumber.setBounds(76, 78, 120, 47);
		DeleteMembershipPanel.add(DeleteMembershipIdentificationNumber);
		
		DeleteMembershipIdentificationNumberText = new JTextField();
		DeleteMembershipIdentificationNumberText.setBounds(206, 92, 50, 20);
		DeleteMembershipPanel.add(DeleteMembershipIdentificationNumberText);
		DeleteMembershipIdentificationNumberText.setColumns(10);
		
		JLabel DeleteMembershipMemberName = new JLabel("MEMBER NAME");
		DeleteMembershipMemberName.setFont(new Font("Arial", Font.PLAIN, 12));
		DeleteMembershipMemberName.setBounds(76, 124, 130, 35);
		DeleteMembershipPanel.add(DeleteMembershipMemberName);
		
		DeleteMembershipMemberNameText = new JTextField();
		DeleteMembershipMemberNameText.setColumns(10);
		DeleteMembershipMemberNameText.setBounds(206, 132, 166, 20);
		DeleteMembershipPanel.add(DeleteMembershipMemberNameText);
		
		DeleteMembershipButton = new JButton("DELETE MEMBER");
		DeleteMembershipButton.setFont(new Font("Arial", Font.PLAIN, 12));
		DeleteMembershipButton.setBounds(222, 197, 150, 35);
		DeleteMembershipPanel.add(DeleteMembershipButton);
		
		JLabel lblDeleteMember = new JLabel("DELETE MEMBER");
		lblDeleteMember.setForeground(Color.DARK_GRAY);
		lblDeleteMember.setFont(new Font("Arial", Font.BOLD, 14));
		lblDeleteMember.setBounds(49, 44, 150, 35);
		DeleteMembershipPanel.add(lblDeleteMember);
		
		JLabel label_3 = new JLabel("___________________________________________________________");
		label_3.setForeground(Color.LIGHT_GRAY);
		label_3.setFont(new Font("Arial", Font.PLAIN, 12));
		label_3.setBounds(40, 52, 413, 35);
		DeleteMembershipPanel.add(label_3);
		DeleteMembershipButton.addActionListener(this);
		
		JPanel DisplayMembershipPanel = new JPanel();
		MembershipPanel.addTab("MEMBER INFO", null, DisplayMembershipPanel, null);
		DisplayMembershipPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 475, 300);
		DisplayMembershipPanel.add(scrollPane);
		dtm = (DefaultTableModel) DbUtils.resultSetToTableModel(md.resultset());
		
		DisplayMembershipTable = new JTable(dtm);
		scrollPane.setViewportView(DisplayMembershipTable);
		
		JLabel lblMemberDatabase = new JLabel("MEMBER DATABASE");
		lblMemberDatabase.setForeground(Color.DARK_GRAY);
		lblMemberDatabase.setFont(new Font("Arial", Font.BOLD, 14));
		lblMemberDatabase.setBounds(41, 25, 150, 35);
		DisplayMembershipPanel.add(lblMemberDatabase);
		
		JLabel label_4 = new JLabel("___________________________________________________________");
		label_4.setForeground(Color.LIGHT_GRAY);
		label_4.setFont(new Font("Arial", Font.PLAIN, 12));
		label_4.setBounds(32, 33, 413, 35);
		DisplayMembershipPanel.add(label_4);
		
		JLabel label_2 = new JLabel("_____________________________________________________________________________________________________________________________________________________");
		label_2.setForeground(Color.LIGHT_GRAY);
		label_2.setFont(new Font("Arial", Font.PLAIN, 12));
		label_2.setBounds(32, 35, 1052, 35);
		ClerkPanel.add(label_2);
		
		JLabel lblManageOrderAnd = new JLabel("MANAGE ORDER AND CUSTOMER");
		lblManageOrderAnd.setForeground(Color.DARK_GRAY);
		lblManageOrderAnd.setFont(new Font("Arial", Font.BOLD, 16));
		lblManageOrderAnd.setBounds(52, 25, 297, 35);
		ClerkPanel.add(lblManageOrderAnd);
		
		
		PaymentssButton = new JButton("MANAGE PAYMENT");
		PaymentssButton.setBounds(808, 570, 184, 35);
		ClerkPanel.add(PaymentssButton);
		PaymentssButton.setFont(new Font("Arial", Font.BOLD, 12));
		PaymentssButton.addActionListener(this);
		
		
		OutsButton = new JButton("LOGOUT");
		OutsButton.setBounds(939, 11, 107, 35);
		ClerkPanel.add(OutsButton);
		OutsButton.setFont(new Font("Arial", Font.BOLD, 12));
		OutsButton.addActionListener(this);
		
	}


	public void clearAllField(){
		CreateMemberIDText.setText("");
		CreateMemberRecipientNameText.setText("");
		CreateMemberRecipientPhoneText.setText("");
		CreateMemberRecipientAddressTextArea.setText("");
		CreateMemberItemDescriptionText.setText("");
		CreateMemberItemWeightageText.setText("");
		
		CreateWalkInCustomerNameText.setText("");
		CreateWalkInCustomerPhoneText.setText("");
		CreateWalkInCustomerAddressText.setText("");
		CreateWalkInRecipientNameText.setText("");
		CreateWalkInRecipientPhoneText.setText("");
		CreateWalkInRecipientAddressText.setText("");
		CreateWalkInItemDescriptionText.setText("");
		CreateWalkInItemWeightageText.setText("");
		
		ModifyMemberIDText.setText("");
		ModifyDeliveryNumberText.setText("");
		ModifyMemberRecipientNameText.setText("");
		ModifyMemberRecipientPhoneText.setText("");
		ModifyMemberRecipientAddressText.setText("");
		ModifyMemberItemDescriptionText.setText("");
		ModifyMemberItemWeightageText.setText("");
		
		DeleteMemberDeliveryNumberText.setText("");
		DeleteMemberIDText.setText("");
		
		CreateMembershipNameText.setText("");
		CreateMembershipPhoneNumberText.setText("");
		CreateMembershipAddressText.setText("");
		CreateMembershipEmailAddressText.setText("");
		
		ModifyMembershipIdentificationNumberText.setText("");
		ModifyMembershipNameText.setText("");
		ModifyMembershipPhoneNumberText.setText("");
		ModifyMembershipAddressText.setText("");
		ModifyMembershipEmailAddressText.setText("");
		
		DeleteMembershipIdentificationNumberText.setText("");
		DeleteMembershipMemberNameText.setText("");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == PaymentssButton){
			GuiPayment paymentss = new GuiPayment();
			paymentss.setVisible(true);
			setVisible(false);
		}
		if(e.getSource() == OutsButton){
			GuiLogin logout3 = new GuiLogin();
			logout3.setVisible(true);
			setVisible(true);
		}
		
		if(e.getSource()==CreateMembershipButton){
			String[] cm = new String[5];
			cm[0] = CreateMembershipNameText.getText();
			cm[1] = CreateMembershipPhoneNumberText.getText();
			cm[2] = CreateMembershipEmailAddressText.getText();
			cm[3] = CreateMembershipAddressText.getText();
			cm[4] = CreateMembershipTypeComboBox.getSelectedItem().toString();
			
		    if (clerk.createMembership(cm)){
			  JOptionPane.showMessageDialog(null, "Membership Registration Successful");
			   double mp = clerk.getMembershipPrice(cm[4]); 
			   int mid = clerk.getMembershipID();
			   String[] moc = new String[7];
			   moc[0] = null;
			   moc[1] = Integer.toString(mid);
			   moc[2] = "Membership";
			   moc[3] = dfo.format(mp);
			   moc[4] = null;
			   moc[5] = null;
			   moc[6] = "NOT PAID";
			   clerk.insertMembershipPricePaymentData(moc);
			 reloadTable();
			 clearAllField();
			}
			else {
			 JOptionPane.showMessageDialog(null, "Membership Registration Failed");
			}
		}
	       if(e.getSource()==ModifyMembershipButton){
		   String[] mm = new String[6];
		   mm[0] = ModifyMembershipNameText.getText();
		   mm[1] = ModifyMembershipPhoneNumberText.getText();
		   mm[2] = ModifyMembershipEmailAddressText.getText();
		   mm[3] = ModifyMembershipAddressText.getText();
		   mm[4] = ModifyMembershipTypeComboBox.getSelectedItem().toString();
		   mm[5] = ModifyMembershipIdentificationNumberText.getText();
		   
		   if (clerk.modifyMembership(mm)){
			 JOptionPane.showMessageDialog(null, "Modify Membership Successful");	 
			 reloadTable();
			 clearAllField();
		  }
		   else {
			 JOptionPane.showMessageDialog(null, "Modify Membership Failed");
		  }
		   
		  }
	       if(e.getSource()==DeleteMembershipButton){
		   String[] dm = new String[1];
		   dm[0] = DeleteMembershipIdentificationNumberText.getText();
		   
		   
		   if (clerk.deleteMembership(dm)){
			 JOptionPane.showMessageDialog(null, "Delete Membership Successful");
			 reloadTable();
			 clearAllField();
		   }
		   else {
			 JOptionPane.showMessageDialog(null, "Delete Membership Failed");
		   }
	   }
	  if(e.getSource()==CreateOrderMemberButton){
		  
		   Date selectedDate = (Date) ChooseMemberDeliveryDatePicker.getModel().getValue();
		   DateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
		   String reportDate = df.format(selectedDate);
		   String[] com = new String[8];
		   com[0] = CreateMemberIDText.getText();
		   com[1] = CreateMemberRecipientNameText.getText();
		   com[2] = CreateMemberRecipientPhoneText.getText();
		   com[3] = CreateMemberRecipientAddressTextArea.getText();
		   com[4] = CreateMemberItemDescriptionText.getText();
		   com[5] = CreateMemberItemWeightageText.getText();
		   com[6] = CreateMemberDeliveryStatusComboBox.getSelectedItem().toString();
		   com[7] = reportDate;
		   
		   if (clerk.createMemberOrder(com)){
			   JOptionPane.showMessageDialog(null, "Member Order Creation Successful");
			   
			   int ID = odm.getDeliveryNumber();
			   String[] moc = new String[7];
			   moc[0] = Integer.toString(ID);
			   moc[1] = CreateMemberIDText.getText();
			   moc[2] = "DeliveryOrder";
			   moc[3] = MemberTotalPriceText.getText();
			   moc[4] = null;
			   moc[5] = null;
			   moc[6] = "NOT PAID";
			   
			   if(clerk.enterPaymentData(moc)){
				   reloadOrderTable();
				   clearAllField();
			   }
			  else {
			   JOptionPane.showMessageDialog(null, "Member Order Creation Failed" );
			   }
		   }
		   
		   
	   }
	  if(e.getSource()==ModifyOrderButton){
		  Date selectedDate = (Date) ModifyMemberDeliveryDatePicker.getModel().getValue();
		  DateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
		  String reportDate = df.format(selectedDate);
		  String[] mo = new String[9];
		  mo[0] = ModifyMemberIDText.getText();
		  mo[1] = ModifyMemberRecipientNameText.getText();
		  mo[2] = ModifyMemberRecipientPhoneText.getText();
		  mo[3] = ModifyMemberRecipientAddressText.getText();
		  mo[4] = ModifyMemberItemDescriptionText.getText();
		  mo[5] = ModifyMemberItemWeightageText.getText();
		  mo[6] = ModifyMemberDeliveryStatusComboBox.getSelectedItem().toString();
		  mo[7] = reportDate;
		  mo[8] = ModifyDeliveryNumberText.getText();
				  
		  if (clerk.modifyMemberOrder(mo)){
			 JOptionPane.showMessageDialog(null, "Modify Member Order Successfull");
			 reloadOrderTable();
			 clearAllField();
		  }
		  else {
			 JOptionPane.showMessageDialog(null, "Modify Member Order Failed");
		  }
	  }
	  if (e.getSource()==CreateOrderWalkInButton){
		  Date selectedDate = (Date) ChooseWalkInDeliveryDatePicker.getModel().getValue();
		  DateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
		  String reportDate = df.format(selectedDate);
		  String[] cow = new String [10];
		  cow[0] = CreateWalkInCustomerNameText.getText();
		  cow[1] = CreateWalkInCustomerPhoneText.getText();
		  cow[2] = CreateWalkInCustomerAddressText.getText();
		  cow[3] = CreateWalkInRecipientNameText.getText();
		  cow[4] = CreateWalkInRecipientPhoneText.getText();
		  cow[5] = CreateWalkInRecipientAddressText.getText();
		  cow[6] = CreateWalkInItemDescriptionText.getText();
		  cow[7] = CreateWalkInItemWeightageText.getText();
		  cow[8] = CreateWalkInDeliveryStatusComboBox.getSelectedItem().toString();
		  cow[9] = reportDate;
		  
		  if (clerk.createWalkInOrder(cow)){
		   JOptionPane.showMessageDialog(null, "Create Walk-In Order Successfull");
		   
		   int ID = owd.getWalkInDeliveryNumber();
		   String[] woc = new String[7];
		   woc[0] = Integer.toString(ID);
		   woc[1] = null;
		   woc[2] = "DeliveryOrder";
		   woc[3] = WalkInTotalPriceText.getText();
		   woc[4] = null;
		   woc[5] = null;
		   woc[6] = "NOT PAID";
		   
		   if (clerk.enterPaymentData(woc)){
			  reloadWalkInOrderTable();
		      clearAllField();
		  }
		  }
	      
		  else {
		   JOptionPane.showMessageDialog(null, "Create Walk-In Order Failed" );
		  }
	  }
	  if (e.getSource()==DeleteMemberOrderButton){
		   String[] dmo = new String [1];
		   dmo[0] = DeleteMemberDeliveryNumberText.getText();
		
		if (clerk.deleteMemberOrder(dmo)){
		   JOptionPane.showMessageDialog(null, "Delete Member Order Successful");
		   reloadOrderTable();
		   clearAllField();
		}
		else {
		   JOptionPane.showMessageDialog(null, "Delete Member Order Successful");
		}
	  }
	  if (e.getSource()==MemberCalculatePriceButton){
		  double price = clerk.getMemberOrderPrice(Double.parseDouble(CreateMemberItemWeightageText.getText()), CreateMemberIDText.getText());
		  MemberTotalPriceText.setText(Double.toString(price));
	  }
	  if (e.getSource()==WalkInCalculatePriceButton){
		  double price = clerk.getWalkInOrderPrice(Double.parseDouble(CreateWalkInItemWeightageText.getText()));
		  WalkInTotalPriceText.setText(Double.toString(price));
	  }
	  
	  if(e.getSource() == OutsButton){
			GuiLogin logoutss = new GuiLogin();
			logoutss.setVisible(true);
			setVisible(false);
		}
		
	  if(e.getSource() == PaymentssButton){
			GuiPayment Paymentz = new GuiPayment();
			Paymentz.setVisible(true);
			setVisible(true);
		}
	   
	   
		
   }
	private void reloadTable(){
		dtm=(DefaultTableModel) DbUtils.resultSetToTableModel(md.resultset());
		DisplayMembershipTable.setModel(dtm);
	}
	private void reloadOrderTable(){
		dtm=(DefaultTableModel) DbUtils.resultSetToTableModel(odm.resultset());
		DisplayMemberOrderTable.setModel(dtm);
	}
	private void reloadWalkInOrderTable(){
		dtm = (DefaultTableModel) DbUtils.resultSetToTableModel(owd.resultset());
		DisplayWalkInOrderTable.setModel(dtm);
	}

}
