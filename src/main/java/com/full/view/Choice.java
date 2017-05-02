/**
 * 
 */
package com.full.view;

import java.util.Scanner;

import com.full.config.InstanceCreator;

/**
 * @author Johnson Abraham
 * @since 03-Apr-2017, 12:37:07 PM MovieTicketBooking
 */
public class Choice {

	public int getChoice() {

		Scanner input = InstanceCreator.getScanner();

		int choice = 0;
		boolean isInputValid = true;

		do {

			isInputValid = true;

			System.out.println("1. Book Ticket");
			System.out.println("2. View Booked Tickets");
			System.out.println("3. Exit");

			System.out.print("Enter your choice: ");

			try {
				choice = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid input.. Please try again...");
				isInputValid = false;
			}

			if (isInputValid) {
				if ((choice <= 0) || (choice > 3)) {
					System.out.println("Please enter a number between 1 and 3...");
					isInputValid = false;
				}
			}

		} while (!isInputValid);

		return choice;
	}
}
