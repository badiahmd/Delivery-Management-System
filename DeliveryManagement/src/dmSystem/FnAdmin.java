package dmSystem;

public class FnAdmin {
private DbUser db = new DbUser();

	public void registerUser(String[] user){
		
		db.insert(user);
	}
	
	public void deleteUser(String[] user){
		
		db.delete(user);
	}
	
	public void updateUser(String[] user){
		
		db.update(user);
	}
}

