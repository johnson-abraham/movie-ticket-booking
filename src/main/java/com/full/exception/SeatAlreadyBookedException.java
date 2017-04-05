/**
 * 
 */
package com.full.exception;

/**
 * @author Johnson Abraham
 * @since 05-Apr-2017, 1:25:04 PM
 * MovieTicketBooking
 */
public class SeatAlreadyBookedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public SeatAlreadyBookedException(String message) {
		super(message);
	}
}
