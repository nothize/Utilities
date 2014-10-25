package org.nothize.cron;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CronFilterTest {

	@Test
	public void testIsMatch() {
		assertTrue(CronFilter.isMatch("709", 605, 723));
	}

	@Test
	public void testGetField() throws Exception {
		assertEquals("705", CronFilter.getField(CronEntry.build("0 5 * * 0 cmd"), CronField.WEEKHOUR));
	}
}
