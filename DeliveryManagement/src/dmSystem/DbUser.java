package dmSystem;

import java.sql.ResultSet;

public class DbUser extends Db {
	
	 public String login (String checkUser, String checkPass){
	       	try {
	            resultSet = statement.executeQuery("SELECT * FROM user");
	            while (resultSet.next()){
	        	String user = resultSet.getString("USERNAME");
	        	String pass = resultSet.getString("PASSWORD");
	        	if (user.equals(checkUser) && pass.equals(checkPass)){
	        		return resultSet.getString("TYPE");
	        	}
	        }
	        resultSet.close();
	       	}
	       	catch (Exception E){
	    	   E.printStackTrace();
	       	}
	       	
	       	return "Invalid";
	    }
	    @Override
	    public boolean insert(String[] user){
	    	try{
	    		preparedStatement = connect.prepareStatement("INSERT INTO `mydatabase`.`user` (`USERNAME`, `PASSWORD`, `TYPE`) values (? , ? , ?)");
	    		preparedStatement.setString(1, user[0]);
	    		preparedStatement.setString(2, user[1]);
	    		preparedStatement.setString(3, user[2]);
	    		preparedStatement.executeUpdate();
	    		return true;
	    	}
	    	catch (Exception E){
	    		E.printStackTrace();
	    	}
	    		return false;
	    }
	    @Override
	    public boolean delete(String[] user){
	       try{
	    	   preparedStatement = connect.prepareStatement("DELETE FROM `mydatabase`.`user` WHERE `user`.`USERNAME` = ?");
	    	   preparedStatement.setString(1, user[0]);
	    	   preparedStatement.executeUpdate();
	    	   return true;
	       }
	       catch (Exception E){
	    	   E.printStackTrace();
	       }
	       	   return false;
	    }
	    @Override
	   public boolean update(String[] user){
		  try{
			    preparedStatement = connect.prepareStatement("UPDATE `mydatabase`.`user` SET `PASSWORD` = ?, TYPE = ? WHERE `user`.`USERNAME` = ?;");
	    		preparedStatement.setString(1, user [1]);
	    		preparedStatement.setString(2, user [2]);
	    		preparedStatement.setString(3, user [0]);
	    		preparedStatement.executeUpdate();
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
		  
	          rs = statement.executeQuery("SELECT * FROM user");
		
		}
	    catch (Exception E){
 	    E.printStackTrace();
	    }
	   	    return rs;
	} 
	

}
