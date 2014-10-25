package org.nothize.cron;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CronRangeFilterTest {

	@Test
	public void testIsMatchString() {
		CronRangeFilter filter = new CronRangeFilter(CronField.WEEKHOUR, 605, 723);
		assertFalse(filter.isMatch(CronEntry.build("59 4 * * 6 cmd")));
		assertTrue(filter.isMatch(CronEntry.build("0 5 * * 6 cmd")));
		assertTrue(filter.isMatch(CronEntry.build("59 23 * * 0 cmd")));
		assertFalse(filter.isMatch(CronEntry.build("0 0 * * 1 cmd")));
	}

}
