package com.revature.menu;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.revature.constants.Constantt;
import com.revature.dao.impl.ReservationImpl;

public class ReservationMenu {
	private static Logger log = Logger.getLogger(ReservationMenu.class);
	public static void main(String[] args) throws SQLException {
		
		Scanner sc=new Scanner(System.in);
		ReservationImpl reservation =new ReservationImpl();
		do
		{
			log.info(Constantt.newLine);
			log.info(Constantt.enterDetails);
			log.info(Constantt.reserv);
			log.info(Constantt.viewTicket);
			log.info(Constantt.exit);
			log.info(Constantt.enterChoice);
			
			int choice=sc.nextInt();
			
			switch(choice)
			{
				case 1:reservation.reserveTicket();break;
				case 2:reservation.viewTicket();break;
				case 3:log.info(Constantt.bye);return;
				default: log.info(Constantt.enterBetween);break;
			}
		}
		while(true);
	}
}
