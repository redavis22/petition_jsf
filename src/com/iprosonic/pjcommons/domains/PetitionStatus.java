package com.iprosonic.pjcommons.domains;

public class PetitionStatus {

	private String location;
	private Long total;
	private Long open;
	private Long close;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Long getOpen() {
		return open;
	}
	public void setOpen(Long open) {
		this.open = open;
	}
	public Long getClose() {
		return close;
	}
	public void setClose(Long close) {
		this.close = close;
	}

	
}
