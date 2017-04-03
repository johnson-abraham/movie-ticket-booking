/**
 * 
 */
package com.full.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.full.bean.Ticket;
import com.full.db.TicketBookedDB;

/**
 * @author Johnson Abraham
 * @since 03-Apr-2017, 7:47:55 AM
 * MovieTicketBooking
 */
@Component
public class TicketService {

	@Autowired
	private TicketBookedDB ticketBookedDB;
	
	public boolean storeTicket(Ticket ticket) {
		return ticketBookedDB.persist(ticket);
	}
}
