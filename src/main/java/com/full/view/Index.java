/**
 * 
 */
package com.full.view;

import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.full.bean.Person;
import com.full.bean.Ticket;
import com.full.config.InstanceCreator;
import com.full.service.InputService;
import com.full.service.SeatsService;

/**
 * @author Johnson Abraham
 * @since 02-Apr-2017, 6:45:08 PM MovieTicketBooking
 */
public class Index {

	private SeatsService seatsService;
	private InputService inputService;
	
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

		this.printSeats();

		System.out.println();

		do {
			System.out.print("Enter your name: ");
			name = scanner.nextLine();
		} while (!InputService.isNameValid(name));

		do {
			System.out.print("Enter your email: ");
			email = scanner.nextLine();
		} while (!InputService.isEmailValid(email));

		do {
			System.out.print("Please select your seat number: ");
			seatNumber = scanner.nextLine();
		} while (!inputService.isSeatNumberValid(seatNumber));

		Person person = InstanceCreator.getApplicationContext().getBean(Person.class);
		person.setName(name.trim());
		person.setEmail(email.trim());

		Ticket ticket = InstanceCreator.getApplicationContext().getBean(Ticket.class);
		ticket.setPerson(person);
		ticket.setSeatNumber(seatNumber.trim().toUpperCase());

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

	@Autowired
	public void setSeatsService(SeatsService seatsService) {
		this.seatsService = seatsService;
	}

	@Autowired
	public void setInputService(InputService inputService) {
		this.inputService = inputService;
	}

}
