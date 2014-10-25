package org.nothize.cron;

public abstract class AbstractCronFilter implements ICronFilter {
	private CronField field;

	public AbstractCronFilter() {
		super();
	}

	public AbstractCronFilter(CronField field) {
		this.field = field;
	}

	@Override
	public boolean isMatch(CronEntry cronEntry) {
		String val = CronFilter.getField(cronEntry, field);
		return isMatch(val);
	}

	public abstract boolean isMatch(String val);
}