package com.revature.dao;

import java.sql.SQLException;

public interface Reservation {
	public void reserveTicket() throws SQLException;
	public void viewTicket() throws SQLException;

}
