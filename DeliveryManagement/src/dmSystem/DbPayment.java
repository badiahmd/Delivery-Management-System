package dmSystem;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DbPayment extends Db{
	public ResultSet resultset() {
	      ResultSet rs = null;
       try {
	  
          rs = statement.executeQuery("SELECT * FROM payment");
	
	}
    catch (Exception E){
	      E.printStackTrace();
    }
 	      return rs;
  }
	@Override
	public boolean insert(String [] data ){
		try {
		      preparedStatement = connect.prepareStatement("INSERT INTO `mydatabase`.`payment` (`DeliveryNumber`, `MemberID`, `Service`, `AmmountPaid`, `AmmountCollected`, `LastPaid`, `Status`) VALUES (?, ?, ?, ?, ?, ?, ?);");
		      for(int i = 0; i < data.length; i++){
				   System.out.println(data[i]);
			   }
		      preparedStatement.setInt(1, Integer.parseInt(data[0]));
		      preparedStatement.setString(2, data[1]);
		      preparedStatement.setString(3, data[2]);
		      preparedStatement.setString(4, data[3]);
		      preparedStatement.setDouble(5, 0);
		      preparedStatement.setDate(6, null);
		      preparedStatement.setString(7, data[6]);
		      preparedStatement.execute();
		      preparedStatement.close();
		  
		   
		      return true;
		}
	 	catch (Exception E){
	    	  E.printStackTrace();
	 	}
		      return false;
	}
	
	public boolean insertMembershipPaymentData(String [] data ){
		try {
		      preparedStatement = connect.prepareStatement("INSERT INTO `mydatabase`.`payment` (`DeliveryNumber`, `MemberID`, `Service`, `AmmountPaid`, `AmmountCollected`, `LastPaid`, `Status`) VALUES (?, ?, ?, ?, ?, ?, ?);");
		      for(int i = 0; i < data.length; i++){
				   System.out.println(data[i]);
			   }
		      preparedStatement.setInt(1, 0);
		      preparedStatement.setString(2, data[1]);
		      preparedStatement.setString(3, data[2]);
		      preparedStatement.setString(4, data[3]);
		      preparedStatement.setDouble(5, 0);
		      preparedStatement.setDate(6, null);
		      preparedStatement.setString(7, data[6]);
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
			  Date parsed = format.parse(data[1]);
			  java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
			 
		      preparedStatement = connect.prepareStatement("UPDATE payment SET AmmountCollected = ?, LastPaid = ?, Status = ? WHERE PaymentID = ?;");
		      for(int i = 0; i < data.length; i++){
				   System.out.println(data[i]);
			   }
		      preparedStatement.setDouble(1, Double.parseDouble(data[0]));
		      preparedStatement.setDate(2, sqlDate);
		      preparedStatement.setString(3, data[2]);
		      preparedStatement.setString(4, data[3]);
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
	public boolean delete(String[] data) {
		// TODO Auto-generated method stub
		return false;
	}	

}
