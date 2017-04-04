/**
 * 
 */
package com.full.service;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContextManager;

import com.full.config.ApplicationConfiguration;

/**
 * @author Johnson Abraham
 * @since 04-Apr-2017, 8:25:25 AM
 * MovieTicketBooking
 */
@RunWith(Parameterized.class)
@ContextConfiguration(classes=ApplicationConfiguration.class)
public class InputServiceIsNameValidTrueTest {

	@Parameter(value=0)
	private String input;
	
	@Autowired
	private InputService inputService;
	
	private TestContextManager test;
	
	@Parameters
	public static Collection<String[]> data() {
		return Arrays.asList(new String[][] {
			{"Johnson Abraham"},
			{"Salman"},
			{"A"}
		});
	}
	
	@Before
	public void setup() throws Exception {
		this.test = new TestContextManager(getClass());
		this.test.prepareTestInstance(this);
	}
	
	@Test
	public void test() {
		assertTrue(inputService.isNameValid(input));
	}

}
