package com.revature.model;

import java.sql.Timestamp;

public class BusReservation {
	
	private String registrationNumber;
	private int seatNo;
	private  String birthType;
	private String status;
	private String pnrNo;
	private String reservationDateTime;
	private String username;
	private String email;
	private String phnNo;
	private int age;
	private String sourceName;
	private String destination;
	private Timestamp dateOfTravel;
	private Timestamp boardedTime;
	private Timestamp arrivalTime;
	private int ticketCharges;
	
	public BusReservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BusReservation(String registrationNumber, int seatNo, String birthType, String status) {
		super();
		this.registrationNumber = registrationNumber;
		this.seatNo = seatNo;
		this.birthType = birthType;
		this.status = status;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public String getBirthType() {
		return birthType;
	}

	public void setBirthType(String birthType) {
		this.birthType = birthType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "BusReservation [registrationNumber=" + registrationNumber + ", seatNo=" + seatNo + ", birthType="
				+ birthType + ", status=" + status + "]";
	}

	
	

}
