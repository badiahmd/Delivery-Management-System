package dmSystem;

public class FnManager {
	private DbManagePrice mpd = new DbManagePrice();
	
	public double[] getDiscount(){
		return mpd.getDiscount();
	}
	public double[] weightPrice(){
		return mpd.weightPrice();
	}
	public boolean updateDiscountRates(String[] data){
		mpd.updateDiscountRates(data);
		return true;
	}
	public boolean updateWeightPrice(String[] data){
		mpd.updateWeightPrice(data);
		return true;
	}
	
	
	
	
	
}
