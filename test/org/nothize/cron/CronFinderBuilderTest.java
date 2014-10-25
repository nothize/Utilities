package org.nothize.cron;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;

public class CronFinderBuilderTest {
//	@Test
	public void testInputStream() throws IOException {
		testStream(System.in);
	}

	@Test
	public void testFile() throws Exception {
		testStream(new FileInputStream("run/crontab"));
	}

	private void testStream(InputStream is) throws IOException, FileNotFoundException {
	}
}
