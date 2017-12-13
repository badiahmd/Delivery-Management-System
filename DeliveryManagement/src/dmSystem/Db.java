package dmSystem;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.Statement;

import javax.swing.JOptionPane;


	public abstract class Db {
	    public static Connection connect = null;
	    public static Statement statement = null;
	    public static PreparedStatement preparedStatement = null;
	    public static ResultSet resultSet = null;
	    public String[] username; 
	    public String[] password;
	    private String[] type;

	public Db(){
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
	public abstract boolean insert(String[] data); 
	public abstract boolean update(String[] data); 
	public abstract boolean delete(String[] data); 
	
		
	
}
	    
		
	
