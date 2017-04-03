/**
 * 
 */
package com.full.db;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.full.config.ApplicationConfiguration;

/**
 * @author Johnson Abraham
 * @since 02-Apr-2017, 2:17:38 PM MovieTicketBooking
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
public class SeatsDBDoesSeatExistTest {

	@Autowired
	private SeatsDB seatsDB;

	@Test
	public void testDoesSeatExistTrue() {

		assertTrue(seatsDB.doesSeatExist("A1"));
		assertTrue(seatsDB.doesSeatExist("G12"));
		assertTrue(seatsDB.doesSeatExist("D11"));

	}

	@Test
	public void testDoesSeatExistFalse() {

		assertFalse(seatsDB.doesSeatExist("A0"));
		assertFalse(seatsDB.doesSeatExist("G13"));
		assertFalse(seatsDB.doesSeatExist("H29"));

	}

}
