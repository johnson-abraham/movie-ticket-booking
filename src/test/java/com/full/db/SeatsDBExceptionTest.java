/**
 * 
 */
package com.full.db;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.full.config.ApplicationConfiguration;
import com.full.exception.SeatAlreadyBookedException;

/**
 * @author Johnson Abraham
 * @since 06-Apr-2017, 7:14:59 AM
 * MovieTicketBooking
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ApplicationConfiguration.class)
public class SeatsDBExceptionTest {

	@Autowired
	private SeatsDB seatsDB;
	
	@Before
	public void config() {
		seatsDB.changeSeatStatus("B2");
	}
	
	@Test(expected=SeatAlreadyBookedException.class)
	public void testException() {
		seatsDB.changeSeatStatus("B2");
	}
	
	@Test
	public void testExceptionWithoutExpecting() {
		seatsDB.changeSeatStatus("B2");
	}

}
