package pojo;

import java.util.Date;

/**
 * Reserveflight entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Reserveflight implements java.io.Serializable {

	// Fields

	private Long reservid;
	private Userinfo userinfo;
	private Flight flight;
	private Date reservtime;
	private Long softnumber;
	private Long hardnumber;
	private Long totalprices;

	// Constructors

	/** default constructor */
	public Reserveflight() {
	}

	/** minimal constructor */
	public Reserveflight(Userinfo userinfo, Flight flight, Date reservtime) {
		this.userinfo = userinfo;
		this.flight = flight;
		this.reservtime = reservtime;
	}

	/** full constructor */
	public Reserveflight(Userinfo userinfo, Flight flight, Date reservtime,
			Long softnumber, Long hardnumber, Long totalprices) {
		this.userinfo = userinfo;
		this.flight = flight;
		this.reservtime = reservtime;
		this.softnumber = softnumber;
		this.hardnumber = hardnumber;
		this.totalprices = totalprices;
	}

	// Property accessors

	public Long getReservid() {
		return this.reservid;
	}

	public void setReservid(Long reservid) {
		this.reservid = reservid;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public Flight getFlight() {
		return this.flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Date getReservtime() {
		return this.reservtime;
	}

	public void setReservtime(Date reservtime) {
		this.reservtime = reservtime;
	}

	public Long getSoftnumber() {
		return this.softnumber;
	}

	public void setSoftnumber(Long softnumber) {
		this.softnumber = softnumber;
	}

	public Long getHardnumber() {
		return this.hardnumber;
	}

	public void setHardnumber(Long hardnumber) {
		this.hardnumber = hardnumber;
	}

	public Long getTotalprices() {
		return this.totalprices;
	}

	public void setTotalprices(Long totalprices) {
		this.totalprices = totalprices;
	}

}