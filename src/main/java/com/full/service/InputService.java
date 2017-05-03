/**
 * 
 */
package com.full.service;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Johnson Abraham
 * @since 04-Apr-2017, 8:23:15 AM MovieTicketBooking
 */

public class InputService {

	private SeatsService seatsService;
	
	public static boolean isNameValid(String name) {

		boolean isNameValid = true;
		name = name.trim();

		if (name.length() == 0) {
			System.out.println("Name field should not be empty...");
			isNameValid = false;
		} else if (name.matches(".*\\d+.*")) {
			System.out.println("Name field should not contain any numbers.. Please try again... ");
			isNameValid = false;
		} else if(!name.matches("^[\\p{L} .'-]+$")) {
			System.out.println("Name contains invalid characters.. Please try again...");
			isNameValid = false;
		}

		return isNameValid;
		
	}
	
	public static boolean isEmailValid(String email) {
		
		boolean isEmailValid = true;
		email = email.trim();
		
		if(email.length() == 0) {
			System.out.println("Email field should not be empty...");
			isEmailValid = false;
		} else if(!EmailValidator.getInstance(false).isValid(email)) {
			System.out.println("Invalid Email format... Please try again...");
			isEmailValid = false;
		}
		
		return isEmailValid;
	}
	
	public boolean isSeatNumberValid(String seatNumber) {
		
		boolean isSeatValid = true;
		seatNumber = seatNumber.trim().toUpperCase();
		
		if (!seatsService.doesSeatExist(seatNumber)) {
			System.out.println("You seemed to have typed an invalid seat number. Please try again..");
			isSeatValid = false;
		} else if (!seatsService.isSeatAvailable(seatNumber)) {
			System.out.println("Sorry, the seat you've entered is not available. Please select another seat...");
			isSeatValid = false;
		}
		
		return isSeatValid;
	}

	@Autowired
	public void setSeatsService(SeatsService seatsService) {
		this.seatsService = seatsService;
	}
	
}
