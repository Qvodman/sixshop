package Entity;

/**
 * 后台管理员信息类
 * @author Qvodman
 *
 */

public class AdminInfo {
	private String name;
	private String pw;
	private String email;
	private int power;
	
	public String getAdminName() {
		return name;
	}
	public void setAdminName(String name) {
		this.name = name;
	}
	
	public String getAdminPassWord() {
		return pw;
	}
	public void setAdminPassWord(String pw) {
		this.pw = pw;
	}
	
	public String getAdminEmail() {
		return email;
	}
	public void setAdminEmail(String email) {
		this.email = email;
	}
	
	public int getAdminPower() {
		return power;
	}
	public void setAdminPower(int power) {
		this.power = power;
	}
}

