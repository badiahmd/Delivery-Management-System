package dmSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DbMemberOrder extends Db{


	@Override
	public boolean insert(String [] data ){
		try {
			
			  SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
			  Date parsed = format.parse(data[7]);
			  java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
		
		      preparedStatement = connect.prepareStatement("INSERT INTO `mydatabase`.`standingorder_membership` (`MemberID`, `DeliveryNumber`, `RecipientName`, `RecipientPhone`, `RecipientAddress`, `ItemDescription`, `ItemWeightage`, `DeliveryStatus`, `DeliveryDate`) VALUES (?, NULL, ?, ?, ?, ?, ?, ?, ?)");
		      preparedStatement.setString(1, data[0]);
		      preparedStatement.setString(2, data[1]);
		      preparedStatement.setString(3, data[2]);
		      preparedStatement.setString(4, data[3]);
		      preparedStatement.setString(5, data[4]);
		      preparedStatement.setDouble(6, Double.parseDouble(data[5]));
		      preparedStatement.setString(7, data[6]);
		      preparedStatement.setDate(8, sqlDate);
		      preparedStatement.execute();
		      preparedStatement.close();
		  
		   
		      return true;
		}
	 	catch (Exception E){
	    	  E.printStackTrace();
	 	}
		      return false;
	}
	@Override
	public boolean update(String [] data ){
		try {
			  
			  SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
			  Date parsed = format.parse(data[7]);
			  java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());

			  preparedStatement = connect.prepareStatement("UPDATE standingorder_membership SET MemberID = ?, RecipientName = ?, RecipientPhone = ?, RecipientAddress = ?, ItemDescription = ?, ItemWeightage = ?, DeliveryStatus = ?, DeliveryDate = ? WHERE DeliveryNumber = ?");
			  preparedStatement.setString(1, data[0]);
			  preparedStatement.setString(2, data[1]);
			  preparedStatement.setString(3, data[2]);
			  preparedStatement.setString(4, data[3]);
			  preparedStatement.setString(5, data[4]);
			  preparedStatement.setDouble(6, Double.parseDouble(data[5]));
			  preparedStatement.setString(7, data[6]);
			  preparedStatement.setDate(8, sqlDate);
			  preparedStatement.setString(9, data[8]);
			  preparedStatement.execute();
			  preparedStatement.close();
			   
			  return true;
	   }
	   catch (Exception E){
	    	  E.printStackTrace();
	   }
		      return false;
	}
	@Override
	public boolean delete(String[] data){
	    try{
	    	  preparedStatement = connect.prepareStatement("DELETE FROM standingorder_membership WHERE DeliveryNumber = ? ");
	 		  preparedStatement.setString(1, data[0]);
	 		  preparedStatement.execute();
	 		  preparedStatement.close();
	 		  return true;
	    }
	    catch (Exception E){
	    	  E.printStackTrace();
	 	}
		      return false;
	}
	
	public ResultSet resultset() {	
		      ResultSet rs = null;
	    try {
		  
	          rs = statement.executeQuery("SELECT * FROM standingorder_membership");
		
		}
	    catch (Exception E){
    	    E.printStackTrace();
	    }
	   	    return rs;
	}
	
	public int getDeliveryNumber(){
		int deliverynumber = 0;
		try {
			preparedStatement = connect.prepareStatement("SELECT MAX(DeliveryNumber) as ID FROM `standingorder_membership` ");
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				deliverynumber = resultSet.getInt("ID");
			}
		}
		catch (Exception E){
	    	E.printStackTrace();
	 	}
		return deliverynumber;
	}
	
	
}
		   
	  
		

	
