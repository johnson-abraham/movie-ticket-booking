/**
 * 
 */
package com.full.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Johnson Abraham
 * @since 01-Apr-2017, 7:51:57 PM
 * MovieTicketBooking
 */
@Component
@Scope(scopeName=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Ticket {
	
	private Person person;
	private String seatNumber;
	
	/**
	 * 
	 */
	public Ticket() {
		// TODO Auto-generated constructor stub
	}

	public Person getPerson() {
		return person;
	}

	@Autowired
	public void setPerson(Person person) {
		this.person = person;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	@Override
	public String toString() {
		return "Ticket [person=" + person + ", seatNumber=" + seatNumber + "]";
	}

}
