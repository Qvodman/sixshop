package Entity;

/**
 * 用户信息类
 * @author Qvodman
 *
 */

public class UserInfo {
	private String ID;
	private String name;
	private String pw;
	private int power;
	private String email;
	private String phone;
	private String people;
	private String add;
	private String CartID;
	
	
	public String getUserID() {
		return ID;
	}
	public void setUserID(String ID) {
		this.ID = ID;
	}
	
	public String getUserName() {
		return name;
	}
	public void setUserName(String name) {
		this.name = name;
	}
	
	public String getUserPassWord() {
		return pw;
	}
	public void setUserPassWord(String pw) {
		this.pw = pw;
	}
	
	public int getUserPower() {
		return power;
	}
	public void setUserPower(int power) {
		this.power = power;
	}
	
	public String getUserEmail() {
		return email;
	}
	public void setUserEmail(String email) {
		this.email = email;
	}
	
	public String getUserPhone() {
		return phone;
	}
	public void setUserPhone(String phone) {
		this.phone = phone;
	}
	
	public String getUserPeople() {
		return people;
	}
	public void setUserPeople(String people) {
		this.people = people;
	}
	
	public String getUserAdd() {
		return add;
	}
	public void setUserAdd(String add) {
		this.add = add;
	}
	
	public String getUserCartID() {
		return CartID;
	}
	public void setUserCartID(String CartID) {
		this.CartID = CartID;
	}
}
