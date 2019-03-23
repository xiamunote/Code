package pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Userinfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Userinfo implements java.io.Serializable {

	// Fields

	private Long userid;
	private String username;
	private String realname;
	private String password;
	private String sex;
	private Long age;
	private String email;
	private String ismanager;
	private Set reserveflights = new HashSet(0);

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** full constructor */
	public Userinfo(String username, String realname, String password,
			String sex, Long age, String email, String ismanager,
			Set reserveflights) {
		this.username = username;
		this.realname = realname;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.email = email;
		this.ismanager = ismanager;
		this.reserveflights = reserveflights;
	}

	// Property accessors

	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Long getAge() {
		return this.age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIsmanager() {
		return this.ismanager;
	}

	public void setIsmanager(String ismanager) {
		this.ismanager = ismanager;
	}

	public Set getReserveflights() {
		return this.reserveflights;
	}

	public void setReserveflights(Set reserveflights) {
		this.reserveflights = reserveflights;
	}

}