/**
 * 
 */
package com.full.view;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.full.config.ApplicationConfiguration;

/**
 * @author Johnson Abraham
 * @since 02-Apr-2017, 7:07:19 PM
 * MovieTicketBooking
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ApplicationConfiguration.class)
public class IndexObjectTest {

	@Autowired
	private Index index;
	
	@Test
	public void test() {
		assertNotNull(index);
		index.printSeats();
	}

}
