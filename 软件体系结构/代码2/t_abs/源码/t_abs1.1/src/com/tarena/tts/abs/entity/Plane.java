package com.tarena.tts.abs.entity;

/**
 * 飞机类
 * @author liangjq
 */

public class Plane implements java.io.Serializable {

	// Fields

	private Integer planeId;
	private String planeNum;
	private String planeModel;
	private String planeManufacturer;
	private Integer maxContinueVoyage;
	private Integer fcabinSeats;
	private Integer ccabinSeats;
	private Integer ycabinSeats;
	private String seatsImgUri;
	
	
	
	@Override
	public String toString() {
		return "planeId: "+planeId+"\n"
		+"planeNum: "+planeNum+"\n"
		+"planeModel: "+planeModel+"\n"
		+"planeManufacturer: "+planeManufacturer+"\n"
		+"maxContinueVoyage: "+maxContinueVoyage+"\n"
		+"FCabinSeats: "+fcabinSeats+"\n"
		+"CCabinSeats: "+ccabinSeats+"\n"
		+"YCabinSeats: "+ycabinSeats+"\n"
		+"seatsImgUri: "+seatsImgUri+"\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((planeId == null) ? 0 : planeId.hashCode());
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
		final Plane other = (Plane) obj;
		if (planeId == null) {
			if (other.planeId != null)
				return false;
		} else if (!planeId.equals(other.planeId))
			return false;
		return true;
	}

	/**
	 * 飞机编号（业务无关唯一编号）
	 * @ Integer getPlaneId(Plane)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:29:06 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getPlaneId() {
		return this.planeId;
	}
	
	/**
	 * 飞机编号（业务无关唯一编号）
	 * @ void setPlaneId(Plane)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:29:13 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setPlaneId(Integer planeId) {
		this.planeId = planeId;
	}
	
	/**
	 * 飞机机身编号（中国民航唯一编号）
	 * @ String getPlaneNum(Plane)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:29:17 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getPlaneNum() {
		return this.planeNum;
	}
	
	/**
	 * 飞机机身编号（中国民航唯一编号）
	 * @ void setPlaneNum(Plane)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:29:27 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setPlaneNum(String planeNum) {
		this.planeNum = planeNum;
	}
	
	/**
	 * 飞机机型
	 * @ String getPlaneModel(Plane)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:30:21 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getPlaneModel() {
		return this.planeModel;
	}
	
	/**
	 * 飞机机型
	 * @ void setPlaneModel(Plane)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:30:30 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setPlaneModel(String planeModel) {
		this.planeModel = planeModel;
	}
	
	/**
	 * 飞机制造厂商
	 * @ String getPlaneManufacturer(Plane)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:30:41 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getPlaneManufacturer() {
		return this.planeManufacturer;
	}	
	
	/**
	 * 飞机制造厂商
	 * @ void setPlaneManufacturer(Plane)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:30:53 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setPlaneManufacturer(String planeManufacturer) {
		this.planeManufacturer = planeManufacturer;
	}
	
	/**
	 * 最大续航里程
	 * @ Integer getMaxContinueVoyage(Plane)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:30:58 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getMaxContinueVoyage() {
		return this.maxContinueVoyage;
	}
	
	/**
	 * 最大续航里程
	 * @ void setMaxContinueVoyage(Plane)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:31:08 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setMaxContinueVoyage(Integer maxContinueVoyage) {
		this.maxContinueVoyage = maxContinueVoyage;
	}
	
	/**
	 * 头等舱座位数
	 * @ Integer getFCabinSeats(Plane)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:31:12 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getFcabinSeats() {
		return this.fcabinSeats;
	}
	
	/**
	 * 头等舱座位数
	 * @ void setFCabinSeats(Plane)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:31:25 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setFcabinSeats(Integer fcabinSeats) {
		this.fcabinSeats = fcabinSeats;
	}
	
	/**
	 * 公务舱座位数
	 * @ Integer getCCabinSeats(Plane)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:31:30 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getCcabinSeats() {
		return this.ccabinSeats;
	}
	
	/**
	 * 公务舱座位数
	 * @ void setCCabinSeats(Plane)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:31:38 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setCcabinSeats(Integer ccabinSeats) {
		this.ccabinSeats = ccabinSeats;
	}
	
	/**
	 * 经济舱座位数
	 * @ Integer getYCabinSeats(Plane)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:31:42 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getYcabinSeats() {
		return this.ycabinSeats;
	}
	
	/**
	 * 经济舱座位数
	 * @ void setYCabinSeats(Plane)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:31:50 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setYcabinSeats(Integer ycabinSeats) {
		this.ycabinSeats = ycabinSeats;
	}
	
	/**
	 * 座位布局图片位置
	 * @ String getSeatsImgUri(Plane)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:31:55 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getSeatsImgUri() {
		return this.seatsImgUri;
	}
	
	/**
	 * 座位布局图片位置
	 * @ void setSeatsImgUri(Plane)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20124:32:05 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setSeatsImgUri(String seatsImgUri) {
		this.seatsImgUri = seatsImgUri;
	}
}