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
	private int Numble;
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
	
	public int getNumble() {
		return Numble;
	}
	public void setUserID(int Numble) {
		this.Numble = Numble;
	}
	
	public float getCount() {
		return Count;
	}
	public void setUserID(float Count) {
		this.Count = Count;
	}
	
	public int getPaid() {
		return Paid;
	}
	public void setPaid(int Paid) {
		this.Paid = Paid;
	}
}
