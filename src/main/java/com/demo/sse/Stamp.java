package com.demo.sse;

import java.util.Date;

public class Stamp {
	
	String date;
	long epoch;
	
	public Stamp() {
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long getEpoch() {
		return epoch;
	}
	public void setEpoch(long epoch) {
		this.epoch = epoch;
	}
	
	public static Stamp now() {
		Date d = new Date();
		Stamp s = new Stamp();
		s.setDate(d.toString());
		s.setEpoch(d.getTime());
		return s;
	}

}
