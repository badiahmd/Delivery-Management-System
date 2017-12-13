package dmSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbPrice {
	public static Connection connect = null;
    public static Statement statement = null;
    public static PreparedStatement preparedStatement = null;
    public static ResultSet resultSet = null;
    
    public DbPrice(){
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
	public double getDiscount(String type){
		double discount = 0;
		try {
			preparedStatement = connect.prepareStatement("SELECT DiscountRates FROM `price` WHERE MembershipType = ?");
			preparedStatement.setString(1, type);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				discount = resultSet.getDouble("DiscountRates");
			}
		}
		catch (Exception E){
	    	E.printStackTrace();
	 	}
		return discount;
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
   
	
	
} 
