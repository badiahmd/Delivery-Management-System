package dmSystem;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DbInvoice extends Db{
	public ArrayList<String> getInvoice(String custID){
		ArrayList<String> invoiceData = new ArrayList<String>();
		
		try{
			ResultSet resultSet = statement.executeQuery("SELECT Name, PhoneNumber, EmailAddress, Address, MembershipType FROM membership_createmember"
					+ " Where MemberID = '"+ custID +"'");
			
			while(resultSet.next()){
				invoiceData.add(custID);
				invoiceData.add(resultSet.getString("Name"));
				invoiceData.add(resultSet.getString("PhoneNumber"));
				invoiceData.add(resultSet.getString("EmailAddress"));
				invoiceData.add(resultSet.getString("Address"));
				invoiceData.add(resultSet.getString("MembershipType"));
			}
			resultSet.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		try{
			ResultSet resultSet = statement.executeQuery("SELECT Service, AmmountPaid, AmmountCollected, LastPaid, Status"
					+ " FROM payment WHERE MemberID = '"+ custID +"'");
			
			while(resultSet.next()){
				invoiceData.add(resultSet.getString("Service"));
				invoiceData.add(resultSet.getString("AmmountPaid"));
				invoiceData.add(resultSet.getString("AmmountCollected"));
				invoiceData.add(resultSet.getString("LastPaid"));
				invoiceData.add(resultSet.getString("Status"));
			}
			resultSet.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return invoiceData;
	}

	@Override
	public boolean insert(String[] data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(String[] data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String[] data) {
		// TODO Auto-generated method stub
		return false;
	}
}
