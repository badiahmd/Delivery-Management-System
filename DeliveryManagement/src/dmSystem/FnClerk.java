package dmSystem;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.net.ssl.SSLEngineResult.Status;

public class FnClerk {
	private DbMemberOrder odm = new DbMemberOrder();
	private DbMember md = new DbMember();
	private DbNonOrder owd = new DbNonOrder();
	private DbWeightRate wrd = new DbWeightRate();
	private DbPrice pd = new DbPrice();
	private DbPayment pyd = new DbPayment();
	private DbInvoice invoDb = new DbInvoice();
	private String status;
	private Validator valid = new Validator();
	
	public boolean createMemberOrder(String[] data){
		odm.insert(data);
		return true;
	}
	
	public boolean createMembership(String[] data){
		md.insert(data);
		return true;
	}
	
	public boolean modifyMembership(String[] data){
		md.update(data);
		return true;
	}
	
	public boolean deleteMembership(String[] data){
		md.delete(data);
		return true;
	}
	
	public boolean modifyMemberOrder(String[] data){
		odm.update(data);
		return true;
	}
	
	public boolean createWalkInOrder(String[] data){
		owd.insert(data);
		return true;
	}
	
	public boolean deleteMemberOrder(String[] data){
		odm.delete(data);
		return true;
	}
	
	public boolean enterPaymentData(String[] data){
		pyd.insert(data);
		return true;
		
	}
	public boolean insertMembershipPricePaymentData(String[]data){
		pyd.insertMembershipPaymentData(data);
		return true;
	}
	
	public int getMembershipID(){
		return md.getMemberID();
	}
	
	public enum Weight {
		LIGHTWEIGHT, MIDDLEWEIGHT, LIGHT_HEAVYWEIGHT, HEAVYWEIGHT;
	}
	
	public Weight getWeightType(double weight){
		Weight type = Weight.LIGHTWEIGHT;
		if (weight <=1.0){
			type = Weight.LIGHTWEIGHT;
		}
		else if (weight <=5.0){
			type = Weight.MIDDLEWEIGHT;
		}
		else if (weight <=10.0){
			type = Weight.LIGHT_HEAVYWEIGHT;
		}
		else{
			type = Weight.HEAVYWEIGHT;
		}
		return type;
	}
	
	public double getMemberOrderPrice(double weight, String ID){
		double firstprice, discountprice, lastprice;
		String weighttype = getWeightType(weight).toString();
		double weightprice = wrd.getWeightPrice(weighttype);
		String membershiptype = md.getMemberType(ID);
		double discount = pd.getDiscount(membershiptype);
		
		firstprice = weight * weightprice;
		discountprice = firstprice * discount;
		lastprice = firstprice - discountprice;
		return lastprice;
	}
	
	public double getWalkInOrderPrice(double weight){
		String type = "STANDARD_WEIGHT";
		double weightprice = wrd.getWeightPrice(type);
		double totalprice = weight * weightprice;
		return totalprice;
	}
	
	public double getMembershipPrice(String type){
		double memberprice = pd.getMembershipPrice(type);
		return memberprice;
		
		
	}
	
	public boolean insertPaymentData(String[] memberOrder){
		return pyd.insert(memberOrder);
	}
	
	public boolean updatePaymentData(String[] memberOrder){
		return pyd.update(memberOrder);
	}
	
	public ResultSet resultset() {
		return pyd.resultset();
	}
	
	public ArrayList<String> getInvoiceData(String custID){
		ArrayList<String> invoice = new ArrayList<String> (invoDb.getInvoice(custID));
		return invoice;
	}
	
	public String validation(String name, String phoneNumber, String Address, String emailAddress, String date){
		status = "";
		status = name;
		if (valid.validateName(name)){
			status = phoneNumber;
			if (valid.validatePhoneNumber(phoneNumber)){
				status = Address;
				if (valid.validateNotNull(Address)){
					status = emailAddress;
					if (valid.validateEmailAddress(emailAddress)){	
					}
				}
			}
		}
		return status;
	}
	
}
