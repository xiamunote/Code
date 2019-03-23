package com.tarena.tts.abs.vo;

/**
 * 用于index.jsp 推荐航线
 * @ file_name Flight02.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 3, 20126:36:51 PM
 * @ description
 * @ reviewed_by 
 */
public class Flight02 {
	
	private String fid;			
	private String flDate;
	private String fromCity;
	private String toCity;
	private double currentDiscount;
	private double currentPrice;
	
	public String getFid() {return fid;}
	public void setFid(String fid) {this.fid = fid;}
	public String getFlDate() {return flDate;}
	public void setFlDate(String flDate) {
		this.flDate = flDate;}
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public double getCurrentDiscount() {
		return currentDiscount;
	}
	public void setCurrentDiscount(double currentDiscount) {
		this.currentDiscount = currentDiscount;
	}
	public double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fid == null) ? 0 : fid.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Flight02 other = (Flight02) obj;
		if (fid == null) {
			if (other.fid != null)
				return false;
		} else if (!fid.equals(other.fid))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "fid:"+fid+"\n"+
		"flDate:"+flDate+"\n"+
		"fromCity:"+fromCity+"\n"+
		"toCity:"+toCity+"\n"+
		"currentDiscount:"+currentDiscount+"\n"+
		"currentPrice:"+currentPrice+"\n";
	}
}
