package net.wms.bean;

public class Goods {
	private int id;
	private String goodsname;
	private String goodsstyle;
	private int goodsnumber;
	private String storageID;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getGoodsstyle() {
		return goodsstyle;
	}
	public void setGoodsstyle(String goodsstyle) {
		this.goodsstyle = goodsstyle;
	}
	public int getGoodsnumber() {
		return goodsnumber;
	}
	public void setGoodsnumber(int goodsnumber) {
		this.goodsnumber = goodsnumber;
	}
	public String getStorageID() {
		return storageID;
	}
	public void setStorageID(String storageID) {
		this.storageID = storageID;
	}
	
}
