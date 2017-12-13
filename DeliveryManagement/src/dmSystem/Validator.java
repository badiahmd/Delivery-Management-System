package dmSystem;

import java.util.Date;

public class Validator {

	public boolean validateName (String name){
		if(name.matches("[a-zA-z]{3,15}")){
			return true;
		}
		else {
			return false;
		}
	}
	public boolean validateNotNull (String text){
		if(text.equals("")){
			return false;
		}
		else{
			return true;
		}
	}
	public boolean validateDouble (String number){
		if(number.matches("^[0-9]+")){
			return true;
		}
		else if(number.matches("^[0-9]+\\.[0-9]+{0-4}")){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean validatePhoneNumber(String phonenumber){
		if(phonenumber.matches("[0-9][0-9-]{8-14}")){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean validateEmailAddress (String emailaddress){
		if(emailaddress.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"));
		   return true;
		}
	}

