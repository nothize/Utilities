package org.nothize.cron;

public interface ICronFilter {

	public abstract boolean isMatch(CronEntry cronEntry);

}