/**
 * 
 */
package com.full.db;

import java.util.Set;

import com.full.bean.Ticket;

/**
 * @author Johnson Abraham
 * @since 02-Apr-2017, 1:31:48 PM MovieTicketBooking
 */
public class TicketBookedDB {

	private Set<Ticket> bookedTickets;

	public TicketBookedDB(Set<Ticket> bookedTickets) {
		this.bookedTickets = bookedTickets;
	}
	
	public TicketBookedDB() {
		// TODO Auto-generated constructor stub
	}

	public boolean persist(Ticket ticket) {
		return bookedTickets.add(ticket);
	}

	public Set<Ticket> getBookedTickets() {
		return bookedTickets;
	}

	public void clearTickets() {
		bookedTickets.clear();
	}

	public void setBookedTickets(Set<Ticket> bookedTickets) {
		this.bookedTickets = bookedTickets;
	}

}
