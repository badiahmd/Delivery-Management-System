package dmSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbWeightRate {
	 public static Connection connect = null;
	    public static Statement statement = null;
	    public static PreparedStatement preparedStatement = null;
	    public static ResultSet resultSet = null;
	    
	    public DbWeightRate(){
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

}
