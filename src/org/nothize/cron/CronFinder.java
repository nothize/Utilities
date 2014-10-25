package org.nothize.cron;

import java.util.ArrayList;
import java.util.List;

public class CronFinder {
	private List<CronEntry> entries;

	public CronFinder(List<CronEntry> entries) {
		this.entries = entries;
	}

	public static CronFinder find(List<CronEntry> entries) {
		return new CronFinder(entries);
	}

	public CronFinder filter(ICronFilter filter) {
		List<CronEntry> rez = new ArrayList<CronEntry>();
		for (CronEntry cronEntry : entries) {
			if ( filter.isMatch(cronEntry) ) {
				rez.add(cronEntry);
			}
		}
		entries = rez;
		return this;
	}
	
	public List<CronEntry> getResult() {
		return entries;
	}
}
