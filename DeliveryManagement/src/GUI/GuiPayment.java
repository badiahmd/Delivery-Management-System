package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.io.*;
import java.lang.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import dmSystem.FnClerk;
import dmSystem.FnInvoice;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import java.awt.Color;

public class GuiPayment extends JFrame implements ActionListener {
	private JTable PaymentTable;
	private DefaultTableModel dtm;
	private FnClerk cf = new FnClerk();
	private TableRowSorter<TableModel> rowSorter;
	private String PaymentID;
	private String DeliveryNumber;
	private String MemberID;
	private String Service;
	private String AmmountPaid;
	private String AmmountCollected;
	private String LastPaid;
	private String Status;
	private JTextField SearchText;
	private JTextField ModifyPaymentAmmountCollectedText;
	private JTextField ModifyPaymentStatusText;
	private JTextField ModifyPaymentAmmountPaidText;
	private JTextField ModifyPaymentServiceText;
	private JTextField ModifyPaymentMemberIDText;
	private JTextField ModifyPaymentDeliveryNumberText;
	private JTextField ModifyPaymentIDText;
	private UtilDateModel model  = new UtilDateModel();
	private JDatePanelImpl datePanel = new JDatePanelImpl(model);
	private JDatePickerImpl ModifyPaymentLastPaidDatePicker;
	private Date date;
	private JButton UpdatePaymentButton;
	private DecimalFormat dfo = new DecimalFormat("#0.00");
	private double Collected;
	private JButton CreateInvoiceButton;
	private String currentDate;
	private DateFormat dformat = new SimpleDateFormat ("EEEE, dd MM yyyy");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiPayment frame = new GuiPayment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiPayment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 620);
		JPanel PaymentPanel = new JPanel();
		PaymentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PaymentPanel);
		PaymentPanel.setLayout(null);
		
		JScrollPane PaymentScrollPane = new JScrollPane();
		PaymentScrollPane.setBounds(39, 374, 452, 197);
		PaymentPanel.add(PaymentScrollPane);
		
		dtm = (DefaultTableModel) DbUtils.resultSetToTableModel(cf.resultset());
		PaymentTable = new JTable(dtm);
		PaymentScrollPane.setViewportView(PaymentTable);
		rowSorter = new TableRowSorter<>(PaymentTable.getModel());
		PaymentTable.setRowSorter(rowSorter);
		PaymentTable.addMouseListener(new jtableSelection());
		
		UpdatePaymentButton = new JButton("UPDATE PAYMENT");
		UpdatePaymentButton.setFont(new Font("Arial", Font.PLAIN, 12));
		UpdatePaymentButton.setBounds(322, 238, 172, 36);
		PaymentPanel.add(UpdatePaymentButton);
		UpdatePaymentButton.addActionListener(this);
		
		CreateInvoiceButton = new JButton("CREATE INVOICE");
		CreateInvoiceButton.setFont(new Font("Arial", Font.PLAIN, 12));
		CreateInvoiceButton.setBounds(322, 290, 172, 35);
		PaymentPanel.add(CreateInvoiceButton);
		CreateInvoiceButton.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("UPDATE PAYMENT / CREATE INVOICE");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(49, 19, 264, 35);
		PaymentPanel.add(lblNewLabel);
		
		JLabel TitleSearch = new JLabel("Search :");
		TitleSearch.setFont(new Font("Arial", Font.BOLD, 12));
		TitleSearch.setBounds(322, 57, 66, 35);
		PaymentPanel.add(TitleSearch);
		
		SearchText = new JTextField();
		SearchText.setBounds(392, 65, 100, 20);
		PaymentPanel.add(SearchText);
		SearchText.getDocument().addDocumentListener(new search());
		SearchText.setColumns(10);
		
		JLabel ModifyPaymentID = new JLabel("Payment ID");
		ModifyPaymentID.setFont(new Font("Arial", Font.PLAIN, 12));
		ModifyPaymentID.setBounds(39, 57, 80, 35);
		PaymentPanel.add(ModifyPaymentID);
		
		JLabel ModifyPaymentDeliveryNumber = new JLabel("Delivery Number");
		ModifyPaymentDeliveryNumber.setFont(new Font("Arial", Font.PLAIN, 12));
		ModifyPaymentDeliveryNumber.setBounds(39, 87, 120, 35);
		PaymentPanel.add(ModifyPaymentDeliveryNumber);
		
		JLabel ModifyPaymentMemberID = new JLabel("Member ID");
		ModifyPaymentMemberID.setFont(new Font("Arial", Font.PLAIN, 12));
		ModifyPaymentMemberID.setBounds(39, 120, 85, 35);
		PaymentPanel.add(ModifyPaymentMemberID);
		
		JLabel ModifyPaymentService = new JLabel("Service");
		ModifyPaymentService.setFont(new Font("Arial", Font.PLAIN, 12));
		ModifyPaymentService.setBounds(39, 157, 50, 35);
		PaymentPanel.add(ModifyPaymentService);
		
		JLabel ModifyPaymentAmmountPaid = new JLabel("Amount Paid");
		ModifyPaymentAmmountPaid.setFont(new Font("Arial", Font.PLAIN, 12));
		ModifyPaymentAmmountPaid.setBounds(39, 192, 130, 35);
		PaymentPanel.add(ModifyPaymentAmmountPaid);
		
		JLabel ModifyPaymentAmmountCollected = new JLabel("Amount Collected");
		ModifyPaymentAmmountCollected.setFont(new Font("Arial", Font.PLAIN, 12));
		ModifyPaymentAmmountCollected.setBounds(39, 227, 130, 35);
		PaymentPanel.add(ModifyPaymentAmmountCollected);
		
		JLabel ModifyPaymentStatus = new JLabel("Status");
		ModifyPaymentStatus.setFont(new Font("Arial", Font.PLAIN, 12));
		ModifyPaymentStatus.setBounds(39, 297, 50, 35);
		PaymentPanel.add(ModifyPaymentStatus);
		
		ModifyPaymentAmmountCollectedText = new JTextField();
		ModifyPaymentAmmountCollectedText.setBounds(163, 238, 100, 20);
		PaymentPanel.add(ModifyPaymentAmmountCollectedText);
		ModifyPaymentAmmountCollectedText.setColumns(10);
		
		ModifyPaymentStatusText = new JTextField();
		ModifyPaymentStatusText.setColumns(10);
		ModifyPaymentStatusText.setBounds(163, 305, 100, 20);
		PaymentPanel.add(ModifyPaymentStatusText);
		
		ModifyPaymentAmmountPaidText = new JTextField();
		ModifyPaymentAmmountPaidText.setColumns(10);
		ModifyPaymentAmmountPaidText.setBounds(163, 200, 100, 20);
		PaymentPanel.add(ModifyPaymentAmmountPaidText);
		
		ModifyPaymentServiceText = new JTextField();
		ModifyPaymentServiceText.setColumns(10);
		ModifyPaymentServiceText.setBounds(163, 165, 116, 20);
		PaymentPanel.add(ModifyPaymentServiceText);
		
		ModifyPaymentMemberIDText = new JTextField();
		ModifyPaymentMemberIDText.setColumns(10);
		ModifyPaymentMemberIDText.setBounds(163, 128, 66, 20);
		PaymentPanel.add(ModifyPaymentMemberIDText);
		
		ModifyPaymentDeliveryNumberText = new JTextField();
		ModifyPaymentDeliveryNumberText.setColumns(10);
		ModifyPaymentDeliveryNumberText.setBounds(163, 95, 66, 20);
		PaymentPanel.add(ModifyPaymentDeliveryNumberText);
		
		ModifyPaymentIDText = new JTextField();
		ModifyPaymentIDText.setColumns(10);
		ModifyPaymentIDText.setBounds(163, 65, 66, 20);
		PaymentPanel.add(ModifyPaymentIDText);
		
		JLabel lblNewLabel_1 = new JLabel("Last Paid");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(39, 262, 60, 35);
		PaymentPanel.add(lblNewLabel_1);
		
	
		model.setValue(date);
		ModifyPaymentLastPaidDatePicker = new JDatePickerImpl(datePanel);
		ModifyPaymentLastPaidDatePicker.setBounds(163, 274, 130, 20);
		PaymentPanel.add(ModifyPaymentLastPaidDatePicker);
		
		JLabel label = new JLabel("__________________________________________________________________");
		label.setForeground(Color.LIGHT_GRAY);
		label.setFont(new Font("Arial", Font.PLAIN, 12));
		label.setBounds(39, 30, 468, 35);
		PaymentPanel.add(label);
		
		JLabel label_1 = new JLabel("__________________________________________________________________");
		label_1.setForeground(Color.LIGHT_GRAY);
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setBounds(39, 321, 468, 35);
		PaymentPanel.add(label_1);
		
		JLabel lblAccountsReceivable = new JLabel("ACCOUNTS RECEIVABLE");
		lblAccountsReceivable.setForeground(Color.GRAY);
		lblAccountsReceivable.setFont(new Font("Arial", Font.BOLD, 14));
		lblAccountsReceivable.setBounds(49, 342, 264, 35);
		PaymentPanel.add(lblAccountsReceivable);
	}
	
  private class search implements DocumentListener {

	@Override
	public void changedUpdate(DocumentEvent e) {
		searchTable(SearchText);
		
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		searchTable(SearchText);
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		searchTable(SearchText);
		
	}
  private void searchTable(JTextField textField){
	  String text = textField.getText();
	  
	  if(text.trim().length() == 0 ){
		  rowSorter.setRowFilter(null);
	  } else {
		  rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
	  }
  }
	  
  }
  private class jtableSelection implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == PaymentTable) {
		  int rowIndex = PaymentTable.getSelectedRow();
		  PaymentID = PaymentTable.getValueAt(rowIndex, 0) .toString();
		  DeliveryNumber = PaymentTable.getValueAt(rowIndex, 1) .toString();
		  MemberID = PaymentTable.getValueAt(rowIndex, 2) .toString();
		  Service = (String)PaymentTable.getValueAt(rowIndex, 3);
		  AmmountPaid = PaymentTable.getValueAt(rowIndex, 4).toString();
		  AmmountCollected = PaymentTable.getValueAt(rowIndex, 5).toString();
		  if (PaymentTable.getValueAt(rowIndex, 6) == null){
			  model.setSelected(true);
		  }
		  else{
			  LastPaid = PaymentTable.getValueAt(rowIndex, 6).toString();
			  SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
			  Date parsed = null;
			  try{
				  parsed = format.parse(LastPaid);
			  }
			  catch (Exception E){
		    	  E.printStackTrace();
		  }
			  date = new Date (parsed.getTime());
		  }
		 
		  Status = (String)PaymentTable.getValueAt(rowIndex, 7);
		  
		  ModifyPaymentIDText.setText(PaymentID);
		  ModifyPaymentDeliveryNumberText.setText(DeliveryNumber);
		  ModifyPaymentMemberIDText.setText(MemberID);
		  ModifyPaymentServiceText.setText(Service);
		  ModifyPaymentAmmountPaidText.setText(AmmountPaid);
		  ModifyPaymentAmmountCollectedText.setText(AmmountCollected);
		  ModifyPaymentStatusText.setText(Status);
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}
	  
  }
@Override
	public void actionPerformed(ActionEvent e) throws NullPointerException, NumberFormatException {
 if(e.getSource()==UpdatePaymentButton){
		 
		 try { 
		  double totalammount = Double.parseDouble(AmmountCollected) + Double.parseDouble(ModifyPaymentAmmountCollectedText.getText());
		  Collected = Double.parseDouble(ModifyPaymentAmmountPaidText.getText());
		  Date selectedDate = (Date) ModifyPaymentLastPaidDatePicker.getModel().getValue();
		  DateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
		  String reportDate = df.format(selectedDate);
		  String status = updatePaymentStatus();
		  String[] up = new String[4];
		  up[0] = dfo.format(totalammount);
		  up[1] = reportDate;
		  up[2] = status;
		  up[3] = ModifyPaymentIDText.getText(); 
		 
		 
	if (cf.updatePaymentData(up)){
		JOptionPane.showMessageDialog(null, "Payment Update Successfull");
		reloadPaymentTable();
	}
	else{
		JOptionPane.showMessageDialog(null, "Payment Update Failed");
		}
	 
	 
	 if(e.getSource() == CreateInvoiceButton){
		 ArrayList<String> invoice = new ArrayList<String> (cf.getInvoiceData(MemberID));
		 Date recentDate = new Date();
		 currentDate = dformat.format(recentDate);
		 invoice.add(currentDate);
		 FnInvoice invoiceData = new FnInvoice (invoice);
		 JOptionPane.showMessageDialog(null, "Invoice Created", "Invoice", JOptionPane.INFORMATION_MESSAGE);
	 }  
	 } catch (NullPointerException n){
		 n.printStackTrace();
	 	}
	   catch (NumberFormatException f){
		  f.printStackTrace();
	   }
	 }
}
	private void reloadPaymentTable(){
	dtm=(DefaultTableModel) DbUtils.resultSetToTableModel(cf.resultset());
	PaymentTable.setModel(dtm);
}
	private String updatePaymentStatus(){
		double payable = 0;
		String status = null;
		payable = Double.parseDouble(ModifyPaymentAmmountCollectedText.getText());
		if (Collected >= payable){
			status = "PAID";
		} else {
			status = "NOT PAID";
		}
		return status;
	}
}
