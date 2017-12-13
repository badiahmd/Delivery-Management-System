package dmSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbManagePrice {
	public double[] discount = new double[4];
	public double[] weightprice = new double[6];
	public static Connection connect = null;
	public static Statement statement = null;
    public static PreparedStatement preparedStatement = null;
	public static ResultSet resultSet = null;
	public DbManagePrice(){
		try {

            Class.forName("com.mysql.jdbc.Driver");

            connect = DriverManager
              .getConnection("jdbc:mysql://localhost:3306/mydatabase?"
                  + "user=root&password=");


            statement = connect.createStatement();

           
            
        }
        catch(Exception E){
            E.printStackTrace();
        }
    
	}
	
	public double getMembershipPrice(String type){
		double memberprice = 0;
		try{
			preparedStatement = connect.prepareStatement("SELECT MembershipPrice FROM `price` WHERE MembershipType = ?");
			preparedStatement.setString(1, type);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				memberprice = resultSet.getDouble("MembershipPrice");
			}
		}
		catch (Exception E){
	    	E.printStackTrace();
	}
		return memberprice;
   }
	
	public double getWeightPrice(String type){
		double price = 0;
		try {
			preparedStatement = connect.prepareStatement("SELECT Price FROM `weightrates` WHERE Category = ?");
			preparedStatement.setString(1, type);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				price = resultSet.getDouble("Price");
			}
		}
		catch (Exception E){
	    	E.printStackTrace();
	 	}
		return price;
	}
	
	public double[] getDiscount(){
		int counter = 0;
		try {
				resultSet = statement.executeQuery("SELECT DiscountRates FROM `price`");
				while(resultSet.next()){
					discount[counter] = resultSet.getDouble("DiscountRates");
					counter ++;
				}
			}
			catch (Exception E){
		    	E.printStackTrace();
		 	}
			return discount;
			}
		
	


	public double[] weightPrice(){
		int counter = 0;
		try {
				resultSet = statement.executeQuery("SELECT Price FROM `weightrates`");
				while(resultSet.next()){
				weightprice[counter] = resultSet.getDouble("Price");
				counter ++;
			}
		}
				catch (Exception E){
				E.printStackTrace();
	 	}
				return weightprice;
		}
	
	public boolean updateDiscountRates(String[] data){
		try{
			preparedStatement = connect.prepareStatement("UPDATE `price` SET `DiscountRates` = ? WHERE `MembershipType` = ?");
			preparedStatement.setString(1, data[0]);
			preparedStatement.setString(2, data[1]);
			preparedStatement.execute();
			preparedStatement.close();
			return true;
		}
		catch (Exception E){
	    	   E.printStackTrace();
	 	}
		    return false;
		}
	public boolean updateWeightPrice(String[] data){
		try{
			preparedStatement = connect.prepareStatement("UPDATE `weightrates` SET `Price` = ? WHERE `Category` = ?");
			preparedStatement.setString(1, data[0]);
			preparedStatement.setString(2, data[1]);
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



}
   

