/**
 * 
 */
package com.full.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.full.db.SeatsDB;

/**
 * @author Johnson Abraham
 * @since 01-Apr-2017, 8:25:33 PM
 * MovieTicketBooking
 */
@Component
public class SeatsService {

	@Autowired
	private SeatsDB seatsDB;
	
	public boolean doesSeatExist(String seatNumber) {
		return seatsDB.doesSeatExist(seatNumber);
	}
	
	public boolean isSeatAvailable(String seatNumber) {
		return seatsDB.isSeatAvailable(seatNumber);
	}
	
	public void changeSeatStatus(String seatNumber) {
		seatsDB.changeSeatStatus(seatNumber);
	}
	
	public Map<String, Boolean> getSeats() {
		return seatsDB.getSeatNumbers();
	}
	
	public int getRowsCount() {
		return SeatsDB.ROWS;
	}
	
	public int getColumnsCount() {
		return SeatsDB.COLUMNS;
	}
	
}
