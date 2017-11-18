package code;

/**
 * This is an object class that receive date and time,order,member status, and promotion status.
 * 
 * @author Korawit Rupanya
 *
 */

public class OrderRecord {
	private String dateTime;
	private String allOrder;
	private String member;
	private String promotion;
	
	public OrderRecord(String dateTime,String allOrder,String member,String promotion) {
		this.dateTime = dateTime;
		this.allOrder = allOrder;
		this.member = member;
		this.promotion = promotion;
	}

	public String getMember() {
		return member;
	}

	public String getPromotion() {
		return promotion;
	}
	
	public String getDateTime() {
		return dateTime;
	}

	public String getAllOrder() {
		return allOrder;
	}

}