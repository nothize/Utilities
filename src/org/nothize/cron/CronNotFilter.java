package org.nothize.cron;

public class CronNotFilter implements ICronFilter {
	private ICronFilter filter;

	public CronNotFilter(ICronFilter filter) {
		this.filter = filter;
	}

	@Override
	public boolean isMatch(CronEntry cronEntry) {
		return !filter.isMatch(cronEntry);
	}

}
