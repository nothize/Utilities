package org.nothize.cron;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CronEntryTest {

	@Test
	public void testGetFullWeek() {
		assertEquals("6", CronEntry.build("0 5 * * 6 cmd").getFullWeek());
		assertEquals("7", CronEntry.build("0 5 * * 0 cmd").getFullWeek());
		assertEquals("23", CronEntry.build("0 23 * * 0 cmd").getFullHour());
		assertEquals("00", CronEntry.build("0 0 * * 0 cmd").getFullHour());
	}

}
