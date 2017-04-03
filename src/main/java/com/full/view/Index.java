/**
 * 
 */
package com.full.view;

import java.util.Map;
import java.util.Scanner;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.full.bean.Person;
import com.full.bean.Ticket;
import com.full.config.InstanceCreator;
import com.full.service.SeatsService;

/**
 * @author Johnson Abraham
 * @since 02-Apr-2017, 6:45:08 PM MovieTicketBooking
 */
@Component
public class Index {

	@Autowired
	private SeatsService seatsService;

	public void printSeats() {

		int columns = seatsService.getColumnsCount();
		int count = 0;

		Map<String, Boolean> seats = seatsService.getSeats();

		for (Map.Entry<String, Boolean> entry : seats.entrySet()) {

			++count;

			if (entry.getValue()) {
				System.out.print(entry.getKey() + "  ");
			} else {

				int length = entry.getKey().length();

				for (int i = 1; i <= length; i++) {
					System.out.print("X");
				}

				System.out.print("  ");
			}

			if ((count % columns) == 0) {
				System.out.println();
			}
		}

	}

	public Ticket showIndex() {

		Scanner scanner = InstanceCreator.getScanner();

		String seatNumber = new String();
		String name = new String();
		String email = new String();

		boolean isNameValid = false;
		boolean isEmailValid = false;
		boolean isSeatValid = false;

		this.printSeats();

		System.out.println();

		do {

			isNameValid = true;

			System.out.print("Enter your name: ");
			name = scanner.nextLine();
			name = name.trim();

			if (name.length() == 0) {
				System.out.println("This field is mandatory... Please try again...");
				isNameValid = false;
			} else if (!name.matches(".*\\d+.*")) {
				System.out.println("Name cannot numbers. Please enter only alphabets...");
				isNameValid = false;

			}

		} while (!isNameValid);

		do {

			isEmailValid = true;

			System.out.print("Enter your email: ");
			email = scanner.nextLine();

			if (email.length() == 0) {
				System.out.println("This field is mandatory... Please try again...");
				isEmailValid = false;
			} else if (!EmailValidator.getInstance(false).isValid(email)) {
				System.out.println("Incorrect email format.. Please try again...");
				isEmailValid = false;
			}

		} while (!isEmailValid);

		do {

			isSeatValid = true;

			System.out.print("Please select your seat number: ");
			seatNumber = scanner.nextLine();
			seatNumber = seatNumber.toUpperCase();

			if (!seatsService.doesSeatExist(seatNumber)) {
				System.out.println("You seemed to have typed an invalid seat number. Please try again..");
				isSeatValid = false;
			} else if (!seatsService.isSeatAvailable(seatNumber)) {
				System.out.println("Sorry, the seat you've entered is not available. Please select another seat...");
				isSeatValid = false;
			}

		} while (!isSeatValid);

		Person person = InstanceCreator.getApplicationContext().getBean(Person.class);
		person.setName(name);
		person.setEmail(email);

		Ticket ticket = InstanceCreator.getApplicationContext().getBean(Ticket.class);
		ticket.setPerson(person);
		ticket.setSeatNumber(seatNumber);

		return ticket;

	}

	public void printSuccessMessage(Ticket ticket) {

		System.out.println("Congratulations!!! Your seat has been booked. Details of your ticket below..");

		System.out.println("Name: " + ticket.getPerson().getName());
		System.out.println("Email: " + ticket.getPerson().getEmail());
		System.out.println("Seat Number: " + ticket.getSeatNumber());
	}

	public void printFailureMessage() {
		System.out.println("Sorry, please try again later..");
	}

}
