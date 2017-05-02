/**
 * 
 */
package com.full.service;

import java.util.Map;

import com.full.db.SeatsDB;
import com.full.exception.SeatAlreadyBookedException;

/**
 * @author Johnson Abraham
 * @since 01-Apr-2017, 8:25:33 PM MovieTicketBooking
 */
public class SeatsService {

	private SeatsDB seatsDB;

	public boolean doesSeatExist(String seatNumber) {
		return seatsDB.doesSeatExist(seatNumber);
	}

	public boolean isSeatAvailable(String seatNumber) {
		return seatsDB.isSeatAvailable(seatNumber);
	}

	public boolean changeSeatStatus(String seatNumber) {
		
		boolean isSeatStatusChanged = true;
		
		try {
			seatsDB.changeSeatStatus(seatNumber);
		} catch(SeatAlreadyBookedException e) {
			isSeatStatusChanged = false;
		}
		
		return isSeatStatusChanged;
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

	public void setSeatsDB(SeatsDB seatsDB) {
		this.seatsDB = seatsDB;
	}

}
