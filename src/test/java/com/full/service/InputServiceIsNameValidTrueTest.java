/**
 * 
 */
package com.full.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * @author Johnson Abraham
 * @since 04-Apr-2017, 8:25:25 AM
 * MovieTicketBooking
 */
@RunWith(Parameterized.class)
public class InputServiceIsNameValidTrueTest {
	
	private String name;
	
	public InputServiceIsNameValidTrueTest(String name) {
		this.name = name;
	}

	@Parameters
	public static String[] data() {
		return new String[] {"Johnson Abraham", "Salman", "A", "Peter Müller", "François Hollande", "Patrick O'Brian", "Silvana Koch-Mehrin"};
	}
	
	@Test
	public void test() {
		assertTrue(InputService.isNameValid(name));
	}

}
