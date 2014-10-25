package org.nothize.cron;

public class CronWildCardFilter extends AbstractCronFilter {
	private String cmd;

	public CronWildCardFilter(CronField field, String cmd) {
		super(field);
		this.cmd = cmd;
	}

	@Override
	public boolean isMatch(String val) {
		return CronFilter.isMatchWild(val, cmd);
	}
}
