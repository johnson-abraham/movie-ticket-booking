/**
 * 
 */
package com.full.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.full.bean.Ticket;
import com.full.db.TicketBookedDB;

/**
 * @author Johnson Abraham
 * @since 03-Apr-2017, 7:47:55 AM MovieTicketBooking
 */
public class TicketService {

	private TicketBookedDB ticketBookedDB;

	public void storeTicket(Ticket ticket) {
		ticketBookedDB.persist(ticket);
	}

	public Set<Ticket> getTickets() {
		return ticketBookedDB.getBookedTickets();
	}

	public void clearTickets() {
		ticketBookedDB.clearTickets();
	}

	@Autowired
	public void setTicketBookedDB(TicketBookedDB ticketBookedDB) {
		this.ticketBookedDB = ticketBookedDB;
	}
	
}
