/**
 * 
 */
package com.full.view;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.full.bean.Ticket;
import com.full.service.TicketService;

/**
 * @author Johnson Abraham
 * @since 03-Apr-2017, 1:40:53 PM
 * MovieTicketBooking
 */
@Component
public class BookedTickets {

	@Autowired
	private TicketService ticketService;
	
	public void displayBookedTickets() {
		
		Set<Ticket> tickets = ticketService.getTickets();
		
		for(Ticket ticket : tickets) {
			
			System.out.println("Name: "+ ticket.getPerson().getName());
			System.out.println("Email: "+ ticket.getPerson().getEmail());
			System.out.println("Seat Number: "+ ticket.getSeatNumber());
			
			System.out.println();
			
		}
	}
}
