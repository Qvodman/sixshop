package Entity;

/**
 * 商品信息类
 * @author Qvodman
 *
 */

public class GoodsInfo {
	private String ID;
	private String name;
	private String type;
	private String image;
	private int kucun;
	private int yishou;
	private float price;
	private String miaosu;
	private int shangjia;
	
	public String getGoodsID() {
		return ID;
	}
	public void setGoodsID(String ID) {
		this.ID = ID;
	}
	
	public String getGoodsName() {
		return name;
	}
	public void setGoodsName(String name) {
		this.name = name;
	}
	
	public String getGoodsType() {
		return type;
	}
	public void setGoodsType(String type) {
		this.type = type;
	}
	
	public String getGoodsImage() {
		return image;
	}
	public void setGoodsImage(String image) {
		this.image = image;
	}
	
	public int getGoodsKucun() {
		return kucun;
	}
	public void setGoodsKucun(int kucun) {
		this.kucun = kucun;
	}
	
	public int getGoodsYishou() {
		return yishou;
	}
	public void setGoodsYishou(int yishou) {
		this.yishou = yishou;
	}
	
	public float getGoodsPrice(){
		return price;
	}
	public void setGoodsPrice(float price) {
		this.price = price;
	}
	
	public String getGoodsMiaosu() {
		return miaosu;
	}
	public void setGoodsMiaosu(String miaosu) {
		this.miaosu = miaosu;
	}
	
	public int getGoodsShangjia() {
		return shangjia;
	}
	public void setGoodsShangjia(int shangjia) {
		this.shangjia = shangjia;
	}

}
