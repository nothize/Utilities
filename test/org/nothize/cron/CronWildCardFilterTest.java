package org.nothize.cron;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CronWildCardFilterTest {

	@Test
	public void testIsMatchString() {
		CronWildCardFilter bjFilter = new CronWildCardFilter(CronField.CMD, "cmd2");
		assertFalse(bjFilter.isMatch("cmd1"));
		assertTrue(bjFilter.isMatch("cmd2"));
	}

}
