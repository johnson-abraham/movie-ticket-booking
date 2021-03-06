/**
 * 
 */
package com.full.bean;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.full.config.ApplicationConfiguration;

/**
 * @author Johnson Abraham
 * @since 02-Apr-2017, 6:26:54 AM MovieTicketBooking
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
public class PersonObjectTest {

	@Autowired
	private Person person;

	@Test
	public void test() {
		assertNotNull(person);
	}

}
