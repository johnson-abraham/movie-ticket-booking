/**
 * 
 */
package com.full.controller;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;

import com.full.bean.Ticket;
import com.full.config.InstanceCreator;
import com.full.service.SeatsService;
import com.full.service.TicketService;
import com.full.view.BookedTickets;
import com.full.view.Choice;
import com.full.view.Index;

/**
 * @author Johnson Abraham
 * @since 03-Apr-2017, 7:41:50 AM MovieTicketBooking
 */
public class MainController {

	public static void main(String[] args) {

		ApplicationContext context = InstanceCreator.getApplicationContext();
		Choice choice = context.getBean(Choice.class);
		MainController mainController = new MainController();
		BookedTickets bookedTickets = context.getBean(BookedTickets.class);
		context.getBean(TicketService.class).clearTickets();
		
		int inputChoice = 0;
		
		do {
			
			inputChoice = choice.getChoice();
			
			switch(inputChoice) {
			
			case 1:
				mainController.bookTicket();
				break;
			case 2:
				bookedTickets.displayBookedTickets();
				break;
			case 3:
				break;
			default:
				System.out.println("Please enter a number between 1 and 3...");
			}
			
		} while(inputChoice <= 2);

	}
	
	public void bookTicket() {
		
		ApplicationContext context = InstanceCreator.getApplicationContext();
		Scanner input = InstanceCreator.getScanner();
		Index index = context.getBean(Index.class);
		
		String toContinue = "yes";
		boolean isInputValid = true;
		
		do {

			Ticket ticket = index.showIndex();

			if (context.getBean(TicketService.class).storeTicket(ticket)) {
				context.getBean(SeatsService.class).changeSeatStatus(ticket.getSeatNumber());
				index.printSuccessMessage(ticket);
			} else {
				index.printFailureMessage();
			}
			
			System.out.println();
			
			do {
				
				isInputValid = true;
				
				System.out.print("Do you want to book another ticket? [Press 'Y' for Yes, Press 'N' for No]: ");
				toContinue = input.nextLine();
				
				if(!((toContinue.toUpperCase().equals("Y") || (toContinue.toUpperCase().equals("N"))))) {
					isInputValid = false;
				}
				
			} while(!isInputValid);
			
		} while ((toContinue.trim().toUpperCase().equals("YES")) || (toContinue.trim().toUpperCase().equals("Y")));

	}
}
