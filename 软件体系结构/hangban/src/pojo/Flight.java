package pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Flight entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Flight implements java.io.Serializable {

	// Fields

	private Long flightid;
	private String flightno;
	private String flighttype;
	private String leavetime;
	private String arrivetime;
	private String qdzhan;
	private String zhdzhan;
	public String getQdzhan() {
		return qdzhan;
	}

	public void setQdzhan(String qdzhan) {
		this.qdzhan = qdzhan;
	}

	public String getZhdzhan() {
		return zhdzhan;
	}

	public void setZhdzhan(String zhdzhan) {
		this.zhdzhan = zhdzhan;
	}

	private Long softtotal;
	private Long hardtotal;
	private Long softprice;
	private Long hardprice;
	private Set reserveflights = new HashSet(0);

	// Constructors

	/** default constructor */
	public Flight() {
	}

	/** full constructor */
	public Flight(String flightno, String flighttype, String leavetime,
			String arrivetime, Long softtotal, Long hardtotal, Long softprice,
			Long hardprice, Set reserveflights) {
		this.flightno = flightno;
		this.flighttype = flighttype;
		this.leavetime = leavetime;
		this.arrivetime = arrivetime;
		this.softtotal = softtotal;
		this.hardtotal = hardtotal;
		this.softprice = softprice;
		this.hardprice = hardprice;
		this.reserveflights = reserveflights;
	}

	// Property accessors

	public Long getFlightid() {
		return this.flightid;
	}

	public void setFlightid(Long flightid) {
		this.flightid = flightid;
	}

	public String getFlightno() {
		return this.flightno;
	}

	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}

	public String getFlighttype() {
		return this.flighttype;
	}

	public void setFlighttype(String flighttype) {
		this.flighttype = flighttype;
	}

	public String getLeavetime() {
		return this.leavetime;
	}

	public void setLeavetime(String leavetime) {
		this.leavetime = leavetime;
	}

	public String getArrivetime() {
		return this.arrivetime;
	}

	public void setArrivetime(String arrivetime) {
		this.arrivetime = arrivetime;
	}

	public Long getSofttotal() {
		return this.softtotal;
	}

	public void setSofttotal(Long softtotal) {
		this.softtotal = softtotal;
	}

	public Long getHardtotal() {
		return this.hardtotal;
	}

	public void setHardtotal(Long hardtotal) {
		this.hardtotal = hardtotal;
	}

	public Long getSoftprice() {
		return this.softprice;
	}

	public void setSoftprice(Long softprice) {
		this.softprice = softprice;
	}

	public Long getHardprice() {
		return this.hardprice;
	}

	public void setHardprice(Long hardprice) {
		this.hardprice = hardprice;
	}

	public Set getReserveflights() {
		return this.reserveflights;
	}

	public void setReserveflights(Set reserveflights) {
		this.reserveflights = reserveflights;
	}

}