package Entity;

/**
 * 购物车信息类
 * @author Qvodman
 *
 */

public class CartInfo {
	private String ID;
	private String UserID;
	private String GoodsID;
	private int number;
	
	public String getCartID() {
		return ID;
	}
	public void setCartID(String ID) {
		this.ID = ID;
	}
	
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String UserID) {
		this.UserID = UserID;
	}
	
	public String getGoodsID() {
		return GoodsID;
	}
	public void setGoodsID(String GoodsID) {
		this.GoodsID = GoodsID;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
