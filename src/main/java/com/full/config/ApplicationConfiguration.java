/**
 * 
 */
package com.full.config;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.full.bean.Ticket;

/**
 * @author Johnson Abraham
 * @since 02-Apr-2017, 6:18:33 AM MovieTicketBooking
 */
@Configuration
@ComponentScan(basePackages = { "com.full" })
public class ApplicationConfiguration {

	@Bean
	public Map<String, Boolean> map() {
		return new LinkedHashMap<String, Boolean>();
	}

	@Bean
	public Set<Ticket> set() {
		return new HashSet<Ticket>();
	}

}
