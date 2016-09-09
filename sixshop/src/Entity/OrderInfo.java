package Entity;

/**
 * 订单信息类
 * @author Qvodman
 *
 */

public class OrderInfo {
	private String ID;
	private String GoodsID;
	private String UserID;
	private int Number;
	private float Count;
	private int Paid;
	
	public String getOrderID() {
		return ID;
	}
	public void setOrderID(String ID) {
		this.ID = ID;
	}
	
	public String getGoodsID() {
		return GoodsID;
	}
	public void setGoodsID(String GoodsID) {
		this.GoodsID = GoodsID;
	}
	
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String UserID) {
		this.UserID = UserID;
	}
	
	
	 public int getNumber() {
		return Number;
	}
	public void setNumber(int Number) {
		this.Number = Number;
	}
	
	
	public float getCount() {
		return Count;
	}
	public void setCount(float Count) {
		this.Count = Count;
	}
	
	
	 public int getPaid() {
		return Paid;
	}
	public void setPaid(int Paid) {
		this.Paid = Paid;
	}
	
}
