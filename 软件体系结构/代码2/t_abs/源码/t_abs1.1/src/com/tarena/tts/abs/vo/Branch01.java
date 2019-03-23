package com.tarena.tts.abs.vo;

/**
 * 封装了网点名称、所属地区(城市)、详细地址、联系电话
 * @ file_name Branch01.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 14, 20123:31:14 PM
 * @ description
 * @ reviewed_by 
 */
public class Branch01 {
	
	private int branchId;
	private String branchName;
	private String city;
	private String branchAddress;
	private String branchTelephone1;
	
	@Override
	public String toString() {
		return "branchId:"+branchId+"\n"+
		"branchName:"+branchName+"\n"+
		"city:"+city+"\n"+
		"branchAddress:"+branchAddress+"\n"+
		"branchTelephone1:"+branchTelephone1+"\n";
	}
	
	
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBranchAddress() {
		return branchAddress;
	}
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}
	public String getBranchTelephone1() {
		return branchTelephone1;
	}
	public void setBranchTelephone1(String branchTelephone1) {
		this.branchTelephone1 = branchTelephone1;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + branchId;
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
		final Branch01 other = (Branch01) obj;
		if (branchId != other.branchId)
			return false;
		return true;
	}
	
}
