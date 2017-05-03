/**
 * 
 */
package com.full.bean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Johnson Abraham
 * @since 01-Apr-2017, 7:51:57 PM MovieTicketBooking
 */
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		result = prime * result + ((seatNumber == null) ? 0 : seatNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (seatNumber == null) {
			if (other.seatNumber != null)
				return false;
		} else if (!seatNumber.equals(other.seatNumber))
			return false;
		return true;
	}

}
