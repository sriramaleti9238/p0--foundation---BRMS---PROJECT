package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mysql.cj.jdbc.CallableStatement;
import com.revature.config.DataBaseConnection;
import com.revature.constants.Constantt;
import com.revature.dao.Reservation;
import com.revature.menu.ReservationMenu;

public class ReservationImpl implements Reservation{
	
	private static Logger log = Logger.getLogger(ReservationImpl.class);
	Connection con = DataBaseConnection.getConnection();
	
	CallableStatement cs = null;

	
	public void reserveTicket() throws SQLException {	
		Scanner sc =new Scanner(System.in);
		cs = (CallableStatement) con.prepareCall(Constantt.callableStatement1);
		
		log.info(Constantt.src);
		String src = sc.nextLine();
		log.info(Constantt.dest);
		String dest = sc.nextLine();
		
		cs.setString(1,src);
		cs.setString(2,dest);
		cs.execute();
		
		 ResultSet resultSet = cs.executeQuery();
		 
		    while(resultSet.next())
		    {
		    	log.info(resultSet.getString(1)+Constantt.spaceLine+resultSet.getString(2)+Constantt.spaceLine+resultSet.getString(3)+Constantt.spaceLine+resultSet.getString(4)+Constantt.spaceLine+resultSet.getTime(5)+Constantt.spaceLine+resultSet.getTime(6)+Constantt.spaceLine+resultSet.getString(7)+Constantt.spaceLine+resultSet.getString(8)+Constantt.spaceLine+resultSet.getString(9));
		    }
		    
		    log.info(Constantt.choosingRegNo);
		    String regisNo =sc.nextLine(); 
		    
		    CallableStatement cs1 = (CallableStatement) con.prepareCall(Constantt.callableStatement2);
		    
		    cs1.setString(1,regisNo);
		    cs1.execute();
		    
		    ResultSet resultSet1 = cs1.executeQuery();
		    
		    while(resultSet1.next())
		    {
		
		    	log.info(resultSet1.getString(1)+Constantt.spaceLine+resultSet1.getString(2)+Constantt.spaceLine+resultSet1.getString(3));
		    }
		    log.info(Constantt.chooseSeatNo);
		    
		    int selectingSeat = sc.nextInt();
		    
			    CallableStatement cs2 = (CallableStatement) con.prepareCall(Constantt.callableStatement3);
		    String regisNo1 = regisNo;  
		    cs2.setInt(1,selectingSeat);	    
		    cs2.setString(2,regisNo1);	    
		    cs2.execute();
		    
		    
		    
		    CallableStatement cs3 = (CallableStatement) con.prepareCall(Constantt.callableStatement4);
		    
		    cs3.setInt(1,selectingSeat);
		    cs3.setString(2,regisNo1);
		    cs3.execute();
		    ResultSet resultSet2 = cs3.executeQuery();
		    log.info(Constantt.ticketStatus);
		    log.info(Constantt.ticketDetails);
		    while(resultSet2.next())
		    {
		    	log.info(resultSet2.getString(1)+Constantt.spaceLine+resultSet2.getInt(2)+Constantt.spaceLine+resultSet2.getString(3)+Constantt.spaceLine+resultSet2.getString(4)+Constantt.spaceLine+resultSet2.getString(5)+Constantt.spaceLine+resultSet2.getTimestamp(6));
		    }

		
		CallableStatement cs5 = (CallableStatement) con.prepareCall(Constantt.callableStatement5);
		cs5.execute();
		
		
		log.info(Constantt.enterGenerate);
		
		int x = sc.nextInt();
	
		CallableStatement cs4 = (CallableStatement) con.prepareCall(Constantt.callableStatement6);
		
		cs4.setInt(1,selectingSeat);
	    cs4.setString(2,regisNo1);
	    cs4.execute();
	    ResultSet resultSet3 = cs4.executeQuery();
	    while(resultSet3.next())
	    {
	 
	    	log.info("  BusRegNo :"+resultSet3.getString(1)+
	    			" || seatNo : "+resultSet3.getString(2)+
	    			" || birth-type : "+resultSet3.getString(3)+
	    			" || status : "+resultSet3.getString(4)+
	    			" || PNR : "+resultSet3.getString(5)+
	    			" || reservation-date-time : "+resultSet3.getString(6)+
	    			" || username :"+resultSet3.getString(7)+
	    			" || email : "+resultSet3.getString(8)+
	    			" || phone-no :"+resultSet3.getString(9)+
	    			" || age : "+resultSet3.getInt(10)+
	    			" || source : "+resultSet3.getString(11)+
	    			" || destination : "+resultSet3.getString(12)+
	    			" || date-of-travel :"+resultSet3.getString(13)+
	    			" || boarding-time : "+resultSet3.getTimestamp(14)+
	    			" || arrival-time : "+resultSet3.getTimestamp(15)+
	    			" || ticket-charges : "+resultSet3.getString(16));
	    }
		
	    log.info(Constantt.safeJourney);
		
		
		
	}

	public void viewTicket() throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		cs = (CallableStatement) con.prepareCall(Constantt.callableStatement7);
		log.info(Constantt.enterPNR);
		String pnrNo = sc.nextLine();
		cs.setString(1,pnrNo);
	    cs.execute();
	    ResultSet resultSetSearch = cs.executeQuery();
	    log.info(Constantt.ticketDetailsView);
	    while(resultSetSearch.next())
	    {
	    	log.info("  BusRegNo :"+resultSetSearch.getString(1)+
	    			" || seatNo : "+resultSetSearch.getString(2)+
	    			" || birth-type : "+resultSetSearch.getString(3)+
	    			" || status : "+resultSetSearch.getString(4)+
	    			" || PNR : "+resultSetSearch.getString(5)+
	    			" || reservation-date-time : "+resultSetSearch.getString(6)+
	    			" || username :"+resultSetSearch.getString(7)+
	    			" || email : "+resultSetSearch.getString(8)+
	    			" || phone-no :"+resultSetSearch.getString(9)+
	    			" || age : "+resultSetSearch.getInt(10)+
	    			" || source : "+resultSetSearch.getString(11)+
	    			" || destination : "+resultSetSearch.getString(12)+
	    			" || date-of-travel :"+resultSetSearch.getString(13)+
	    			" || boarding-time : "+resultSetSearch.getTimestamp(14)+
	    			" || arrival-time : "+resultSetSearch.getTimestamp(15)+
	    			" || ticket-charges : "+resultSetSearch.getString(16));
	    }
	    log.info(Constantt.endTab);
	    		
	    
	}
}
