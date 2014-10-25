package org.nothize.cron;

public class CronEqualFilter extends AbstractCronFilter {
	private int target;

	public CronEqualFilter(CronField field, int val) {
		super(field);
		this.target = val;
	}

	@Override
	public boolean isMatch(String val) {
		return CronFilter.isMatch(val, target, target);
	}

}
