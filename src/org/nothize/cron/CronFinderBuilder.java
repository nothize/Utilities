package org.nothize.cron;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CronFinderBuilder {
	public static CronFinder create(InputStream is) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		
		Pattern comment = Pattern.compile("^ *#");
		List<CronEntry> entries = new ArrayList<>();
		while ( true ) {
			String line = in.readLine();
			if ( null == line || "end".equals(line) ) {
				break;
			}
			if ( !comment.matcher(line).find() && !"".equals(line) ) {
				CronEntry ce = CronEntry.build(line);
				if ( null != ce ) {
					entries.add(ce);
				}
			}
		}
		return CronFinder.find(entries);
	}
}
