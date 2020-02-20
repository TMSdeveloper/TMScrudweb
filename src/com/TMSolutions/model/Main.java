package com.TMSolutions.model;

import java.sql.Date;

public class Main {
	private int ID;
	private Date in_date;
	private int ID_mineral;
	private int ID_status;
	private double or_weight;
	private double or_purity;
	private Date up_date;

	public Main(int iD, Date in_date, int iD_mineral, int iD_status, double or_weight, double or_purity, Date up_date) {
		super();
		this.ID = iD;
		this.in_date = in_date;
		this.ID_mineral = iD_mineral;
		this.ID_status = iD_status;
		this.or_weight = or_weight;
		this.or_purity = or_purity;
		this.up_date = up_date;
	}
	
	public Main() {
		
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Date getIn_date() {
		return in_date;
	}

	public void setIn_date(Date in_date) {
		this.in_date = in_date;
	}

	public int getID_mineral() {
		return ID_mineral;
	}

	public void setID_mineral(int iD_mineral) {
		ID_mineral = iD_mineral;
	}

	public int getID_status() {
		return ID_status;
	}

	public void setID_status(int iD_status) {
		ID_status = iD_status;
	}

	public double getOr_weight() {
		return or_weight;
	}

	public void setOr_weight(double or_weight) {
		this.or_weight = or_weight;
	}

	public double getOr_purity() {
		return or_purity;
	}

	public void setOr_purity(double or_purity) {
		this.or_purity = or_purity;
	}

	public Date getUp_date() {
		return up_date;
	}

	public void setUp_date(Date up_date) {
		this.up_date = up_date;
	}

	@Override
	public String toString() {
		return "Main [ID=" + ID + ", in_date=" + in_date + ", ID_mineral=" + ID_mineral + ", ID_status=" + ID_status
				+ ", or_weight=" + or_weight + ", or_purity=" + or_purity + ", up_date=" + up_date + "]";
	}

	
	
}