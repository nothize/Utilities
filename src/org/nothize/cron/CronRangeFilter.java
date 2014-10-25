package org.nothize.cron;

public class CronRangeFilter extends AbstractCronFilter {
	private int from;
	private int to;

	public CronRangeFilter(CronField field, int from, int to) {
		super(field);
		this.from = from;
		this.to = to;
	}

	@Override
	public boolean isMatch(String val) {
		return CronFilter.isMatch(val, from, to);
	}
}
