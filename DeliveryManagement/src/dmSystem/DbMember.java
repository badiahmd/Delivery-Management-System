package dmSystem;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import dmSystem.Db;


	public class DbMember extends Db{
		public String[] Name = null;
		public String[] PhoneNumber = null;
		public String[] EmailAddress = null;
		public String[] Address = null;
		public String[] Type = null;
	
  
	
	@Override
	public boolean insert(String [] data){
		try {
	 		   preparedStatement = connect.prepareStatement("INSERT INTO `mydatabase`.`membership_createmember` (`MemberID`, `Name`, `PhoneNumber`, `EmailAddress`, `Address`, `MembershipType`) VALUES (NULL, ?, ?, ?, ?, ?)");
	 		   preparedStatement.setString(1, data[0]);
	 		   preparedStatement.setString(2, data[1]);
	 		   preparedStatement.setString(3, data[2]);
	 		   preparedStatement.setString(4, data[3]);
	 		   preparedStatement.setString(5, data[4]);
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
	public boolean update(String [] data){
		try {
	           preparedStatement = connect.prepareStatement("UPDATE `membership_createmember` SET `Name` = ?, `PhoneNumber` = ?, `EmailAddress` = ?, `Address` = ?, `MembershipType` = ? WHERE `MemberID` = ? ");
	 		   preparedStatement.setString(1, data[0]);
	 		   preparedStatement.setString(2, data[1]);
	 		   preparedStatement.setString(3, data[2]);
	 		   preparedStatement.setString(4, data[3]);
	 		   preparedStatement.setString(5, data[4]);
	 		   preparedStatement.setString(6, data[5]);
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
		  
	          rs = statement.executeQuery("SELECT * FROM membership_createmember");
		
		} 
	    catch (Exception E){
  	          E.printStackTrace();
	    }
	   	      return rs;
	}   
	@Override
	public boolean delete(String [] data){
		try{
	          preparedStatement = connect.prepareStatement("DELETE FROM membership_createmember WHERE MemberID = ? ");
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
	
	public String getMemberType(String ID){
		String memberType = null;
		try {
			preparedStatement = connect.prepareStatement("SELECT MembershipType FROM `membership_createmember` WHERE MemberID = ?");
			preparedStatement.setString(1, ID);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				memberType = resultSet.getString("MembershipType");
			}
		}
		catch (Exception E){
	    	E.printStackTrace();
	 	}
		return memberType;
	}
	
	public int getMemberID(){
		int memberid = 0;
		try{
			preparedStatement = connect.prepareStatement("SELECT MAX(MemberID) as ID FROM `standingorder_membership` ");
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				memberid = resultSet.getInt("ID");
		}
	}
		catch (Exception E){
	    	E.printStackTrace();
	 	}
		return memberid;
}
	}





	
	