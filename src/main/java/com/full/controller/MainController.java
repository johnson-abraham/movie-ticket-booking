/**
 * 
 */
package com.full.controller;

import org.springframework.context.ApplicationContext;

import com.full.bean.Ticket;
import com.full.config.InstanceCreator;
import com.full.service.SeatsService;
import com.full.service.TicketService;
import com.full.view.Index;

/**
 * @author Johnson Abraham
 * @since 03-Apr-2017, 7:41:50 AM MovieTicketBooking
 */
public class MainController {

	public static void main(String[] args) {

		ApplicationContext context = InstanceCreator.getApplicationContext();
		Index index = context.getBean(Index.class);
		String toContinue = "yes";

		do {

			Ticket ticket = index.showIndex();

			if (context.getBean(TicketService.class).storeTicket(ticket)) {
				context.getBean(SeatsService.class).changeSeatStatus(ticket.getSeatNumber());
				index.printSuccessMessage(ticket);
			} else {
				index.printFailureMessage();
			}
			
			System.out.println();
			
			System.out.print("Do you want to book another ticket? [Press 'Y' or 'YES' for Yes]: ");
			toContinue = InstanceCreator.getScanner().nextLine();
			
		} while ((toContinue.trim().toUpperCase().equals("YES")) || (toContinue.trim().toUpperCase().equals("Y")));

	}
}
