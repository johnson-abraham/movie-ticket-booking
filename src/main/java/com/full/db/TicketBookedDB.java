/**
 * 
 */
package com.full.db;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.full.bean.Ticket;

/**
 * @author Johnson Abraham
 * @since 02-Apr-2017, 1:31:48 PM MovieTicketBooking
 */
@Component
public class TicketBookedDB {

	@Autowired
	private Set<Ticket> bookedTickets;

	/**
	 * 
	 */
	public TicketBookedDB(Set<Ticket> bookedTickets) {
		this.bookedTickets = bookedTickets;
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

}
