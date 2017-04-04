/**
 * 
 */
package com.full.service;

import org.springframework.stereotype.Component;

/**
 * @author Johnson Abraham
 * @since 04-Apr-2017, 8:23:15 AM MovieTicketBooking
 */
@Component
public class InputService {

	public boolean isNameValid(String name) {

		boolean isNameValid = true;
		name = name.trim();

		if (name.length() == 0) {
			System.out.println("Name field should not be empty...");
			isNameValid = false;
		} else if (name.matches(".*\\d+.*")) {
			System.out.println("Name field should not contain any numbers.. Please try again... ");
			isNameValid = false;
		}

		return isNameValid;
	}
	
}
