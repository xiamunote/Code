package com.tarena.tts.abs.vo;


public class Flight03 {
	
	private String fid;			
	private String flDate;
	private String fromCity;
	private String toCity;
	private double currentDiscount;
	private double currentPrice;
	private double tax1Price;	//机场税
	private double tax2Price;	//燃油税
	
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
	public double getTax1Price() {
		return tax1Price;
	}
	public void setTax1Price(double tax1Price) {
		this.tax1Price = tax1Price;
	}
	public double getTax2Price() {
		return tax2Price;
	}
	public void setTax2Price(double tax2Price) {
		this.tax2Price = tax2Price;
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
		final Flight03 other = (Flight03) obj;
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
