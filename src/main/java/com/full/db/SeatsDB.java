/**
 * 
 */
package com.full.db;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Johnson Abraham
 * @since 01-Apr-2017, 7:53:33 PM MovieTicketBooking
 */
@Component
public class SeatsDB {

	@Autowired
	private Map<String, Boolean> seatNumbers;

	public static final int ROWS = 7;
	public static final int COLUMNS = 12;

	public SeatsDB(Map<String, Boolean> seatNumbers) {
		this.seatNumbers = seatNumbers;
		populateSeats();
	}

	private void populateSeats() {

		char ch = 'A';

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {

				Integer temp = j + 1;
				seatNumbers.put(new Character(ch).toString() + temp.toString(), true);

			}

			ch += 1;
		}
	}

	public void changeSeatStatus(String seatNumber) {
		seatNumbers.put(seatNumber, false);
	}

	public boolean doesSeatExist(String seatNumber) {
		return seatNumbers.containsKey(seatNumber);
	}

	public boolean isSeatAvailable(String seatNumber) {
		return seatNumbers.get(seatNumber);
	}

	public Map<String, Boolean> getSeatNumbers() {
		return new LinkedHashMap<String, Boolean>(seatNumbers);
	}

}
