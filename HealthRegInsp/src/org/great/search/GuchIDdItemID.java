package org.great.search;

public class GuchIDdItemID {
	private String guChId;//导检单号
	private int itemId;   //项目id
	private String doctor;//医生
	private String sumCont;//小结内容
	
	private String item;//项目名
	
	public GuchIDdItemID() {
		
	}

	public GuchIDdItemID(String guChId, int itemId, String doctor, String sumCont, String item) {
		super();
		this.guChId = guChId;
		this.itemId = itemId;
		this.doctor = doctor;
		this.sumCont = sumCont;
		this.item = item;
	}

	public String getGuChId() {
		return guChId;
	}

	public void setGuChId(String guChId) {
		this.guChId = guChId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getSumCont() {
		return sumCont;
	}

	public void setSumCont(String sumCont) {
		this.sumCont = sumCont;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	
}
