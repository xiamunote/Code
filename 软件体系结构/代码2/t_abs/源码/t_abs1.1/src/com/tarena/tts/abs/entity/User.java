package com.tarena.tts.abs.entity;

import java.util.Date;

/**
 * 用户信息类
 * @author liangjq
 */
public class User implements java.io.Serializable {

	// Fields
	private Integer userId;
	private String userLoginName;
	private String userPassword;
	private String userName;
	private String userState;
	private String userPassengerType;
	private String userTelephone;
	private String userCertifType;
	private String userCertifNum;
	private String userEmail;
	private Date userCreationDate;
	private Date userLastLoginTime;
	private Integer userTotalLoginTimes = 0;
	private Integer userTotalLoginSeconds = 0;
	private String refPsgsId;
	private Integer refMembId;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		final User other = (User) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "userId: "+userId + "\n" 
		+"userLoginName: "+ userLoginName + "\n"
		+"userPassword: "+ userPassword + "\n"
		+"userName: "+ userName + "\n" 
		+"userState: "+ userState + "\n" 
		+"userPassengerType: "+ userPassengerType + "\n" 
		+"userTelephone: "+ userTelephone + "\n" 
		+"userCertifType: "+ userCertifType + "\n"
		+"userCertifNum: "+ userCertifNum + "\n"
		+"userEmail: "+ userEmail + "\n"
		+"userCreationDate: "+ userCreationDate + "\n"
		+"userLastLoginTime: "+ userLastLoginTime + "\n"
		+"userTotalLoginTimes: "+ userTotalLoginTimes + "\n"
		+"userTotalLoginSeconds: "+ userTotalLoginSeconds + "\n"
		+"refPsgsId: "+ refPsgsId + "\n"
		+"refMembId: "+ refMembId + "\n"
		;
	}
	
	/**
	 * 用户编号
	 * @ Integer getUserId(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 201211:43:12 AM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getUserId() {
		return this.userId;
	}
	
	/**
	 * 用户编号
	 * @ void setUserId(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:06:51 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * 用户登录名
	 * @ String getUserLoginName(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:07:21 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getUserLoginName() {
		return this.userLoginName;
	}
	
	/**
	 * 用户登录名
	 * @ void setUserLoginName(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:07:32 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}
	
	/**
	 * 用户密码(MD5码)
	 * @ String getUserPassword(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:07:40 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getUserPassword() {
		return this.userPassword;
	}
	
	/**
	 * 用户密码(MD5码)
	 * @ void setUserPassword(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:08:03 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	/**
	 * 用户真实姓名
	 * @ String getUserName(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:08:15 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getUserName() {
		return this.userName;
	}
	
	/**
	 * 用户真实姓名
	 * @ void setUserName(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:08:20 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * 用户状态
	 * @ String getUserState(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:08:26 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getUserState() {
		return this.userState;
	}
	
	/**
	 * 用户状态
	 * @ void setUserState(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:08:39 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setUserState(String userState) {
		this.userState = userState;
	}
	
	/**
	 * 用户乘客类型
	 * @ String getUserPassengerType(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:08:59 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getUserPassengerType() {
		return this.userPassengerType;
	}
	
	/**
	 * 用户乘客类型
	 * @ void setUserPassengerType(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:09:06 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setUserPassengerType(String userPassengerType) {
		this.userPassengerType = userPassengerType;
	}
	
	/**
	 * 用户电话
	 * @ String getUserTelephone(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:09:20 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getUserTelephone() {
		return this.userTelephone;
	}
	
	/**
	 * 用户电话
	 * @ void setUserTelephone(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:09:27 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}
	
	/**
	 * 用户证件类型
	 * @ String getUserCertifType(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:09:39 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getUserCertifType() {
		return this.userCertifType;
	}
	
	/**
	 * 用户证件类型
	 * @ void setUserCertifType(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:09:46 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setUserCertifType(String userCertifType) {
		this.userCertifType = userCertifType;
	}
	
	/**
	 * 用户证件号码
	 * @ String getUserCertifNum(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:09:53 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getUserCertifNum() {
		return this.userCertifNum;
	}
	
	/**
	 * 用户证件号码
	 * @ void setUserCertifNum(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:10:02 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setUserCertifNum(String userCertifNum) {
		this.userCertifNum = userCertifNum;
	}
	
	/**
	 * 用户邮箱
	 * @ String getUserEmail(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:10:10 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getUserEmail() {
		return this.userEmail;
	}
	
	/**
	 * 用户邮箱
	 * @ void setUserEmail(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:10:20 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	/**
	 * 用户创建时间
	 * @ Date getUserCreationDate(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:10:31 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Date getUserCreationDate() {
		return this.userCreationDate;
	}
	
	/**
	 * 用户创建时间
	 * @ void setUserCreationDate(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:10:35 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setUserCreationDate(Date userCreationDate) {
		this.userCreationDate = userCreationDate;
	}
	
	/**
	 * 用户最后一次登录时间
	 * @ Date getUserLastLoginTime(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:11:07 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Date getUserLastLoginTime() {
		return this.userLastLoginTime;
	}
	
	/**
	 * 用户最后一次登录时间
	 * @ void setUserLastLoginTime(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:11:12 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setUserLastLoginTime(Date userLastLoginTime) {
		this.userLastLoginTime = userLastLoginTime;
	}
	
	/**
	 * 用户总共登录次数
	 * @ Integer getUserTotalLoginTimes(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:11:23 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getUserTotalLoginTimes() {
		return this.userTotalLoginTimes;
	}
	
	/**
	 * 用户总共登录次数
	 * @ void setUserTotalLoginTimes(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:11:29 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setUserTotalLoginTimes(Integer userTotalLoginTimes) {
		this.userTotalLoginTimes = userTotalLoginTimes;
	}
	
	/**
	 * 用户总共登录时长(单位:秒)
	 * @ Integer getUserTotalLoginSeconds(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:11:43 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getUserTotalLoginSeconds() {
		return this.userTotalLoginSeconds;
	}
	
	/**
	 * 用户总共登录时长(单位:秒)
	 * @ void setUserTotalLoginSeconds(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:12:01 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setUserTotalLoginSeconds(Integer userTotalLoginSeconds) {
		this.userTotalLoginSeconds = userTotalLoginSeconds;
	}
	
	/**
	 * 用户关联乘客编号集合:'1002,1015,1027'
	 * @ String getRefPsgsId(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:12:51 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public String getRefPsgsId() {
		return this.refPsgsId;
	}
	
	/**
	 * 用户关联乘客编号集合:'1002,1015,1027'
	 * @ void setRefPsgsId(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:13:52 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setRefPsgsId(String refPsgsId) {
		this.refPsgsId = refPsgsId;
	}
	
	/**
	 * 用户关联会员编号
	 * @ Integer getRefMembId(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:14:01 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public Integer getRefMembId() {
		return this.refMembId;
	}
	
	/**
	 * 用户关联会员编号
	 * @ void setRefMembId(User)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date Apr 12, 20123:14:10 PM
	 * @ description 
	 * @ reviewed_by
	 */
	public void setRefMembId(Integer refMembId) {
		this.refMembId = refMembId;
	}	
}