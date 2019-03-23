package com.tarena.tts.abs.entity;

import java.util.Date;

/**
 * 资讯信息类 
 * @author liangjq
 */

public class Information implements java.io.Serializable {

	// Fields
	private Integer infoId;
	private String infoTitle;
	private String infoContent;
	private Date infoTime;
	private String infoTop;

	// Constructors
	/** default constructor */
	public Information() {
	}

	/** minimal constructor */
	public Information(Integer infoId, String infoTitle) {
		this.infoId = infoId;
		this.infoTitle = infoTitle;
	}

	/** full constructor */
	public Information(Integer infoId, String infoTitle, String infoContent,
			Date infoTime, String infoTop) {
		this.infoId = infoId;
		this.infoTitle = infoTitle;
		this.infoContent = infoContent;
		this.infoTime = infoTime;
		this.infoTop = infoTop;
	}
	
	@Override
	public String toString() {
		return "infoId: "+infoId+"\n"
		+ "infoTitle: " + infoTitle +"\n" 
		+ "infoContent: " + infoContent +"\n" 
		+ "infoTime: " + infoTime +"\n" 
		+ "infoTop: " + infoTop +"\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((infoId == null) ? 0 : infoId.hashCode());
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
		final Information other = (Information) obj;
		if (infoId == null) {
			if (other.infoId != null)
				return false;
		} else if (!infoId.equals(other.infoId))
			return false;
		return true;
	}
	
	// Property accessors
	/**
	 * 资讯编号
	 * @ void getInfoId(Information)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 19, 20126:32:26 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getInfoId() {
		return this.infoId;
	}
	
	/**
	 * 资讯编号
	 * @ void setInfoId(Information)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 19, 20126:32:26 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}
	
	/**
	 * 资讯标题
	 * @ String getInfoTitle(Information)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 19, 20126:33:07 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getInfoTitle() {
		return this.infoTitle;
	}
	
	/**
	 * 资讯标题
	 * @ void setInfoTitle(Information)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 19, 20126:33:38 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setInfoTitle(String infoTitle) {
		this.infoTitle = infoTitle;
	}
	
	/**
	 * 资讯内容
	 * @ String getInfoContent(Information)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 19, 20126:33:43 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getInfoContent() {
		return this.infoContent;
	}
	
	/**
	 * 资讯内容
	 * @ void setInfoContent(Information)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 19, 20126:33:51 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}
	
	/**
	 * 资讯发布日期
	 * @ Date getInfoTime(Information)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 19, 20126:33:58 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Date getInfoTime() {
		return this.infoTime;
	}
	
	/**
	 * 资讯发布日期
	 * @ void setInfoTime(Information)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 19, 20126:34:06 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setInfoTime(Date infoTime) {
		this.infoTime = infoTime;
	}
	
	/**
	 * 是否置顶
	 * @ String getInfoTop(Information)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 19, 20126:34:13 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getInfoTop() {
		return this.infoTop;
	}
	
	/**
	 * 是否置顶
	 * @ void setInfoTop(Information)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 19, 20126:34:20 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setInfoTop(String infoTop) {
		this.infoTop = infoTop;
	}

}