package org.nothize.cron;

public class CronEntry {
	private String min;
	private String hour;
	private String day;
	private String month;
	private String week;
	private String cmd;
	private String args;
	private String line;
	
	private CronEntry(String line) {
		this.line = line;
		String[] vals = line.split(" +");
		if ( vals.length >= 6 ) {
			min = vals[0];
			hour = vals[1];
			day = vals[2];
			month = vals[3];
			week = vals[4];
			cmd = vals[5];
			if ( vals.length > 6 ) {
				args = vals[6];
				for (int i = 7; i < vals.length; i++) {
					args = " " + vals[i];
				}
			} else {
				args = "";
			}
		}
	}
	
	public static CronEntry build(String line) {
		CronEntry ce = new CronEntry(line);
		if ( null == ce.getCmd() ) {
			ce = null;
		}
		return ce;
	}
	
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public String getArgs() {
		return args;
	}
	public void setArgs(String args) {
		this.args = args;
	}

	@Override
	public String toString() {
		return "CronEntry [min=" + min + ", hour=" + hour + ", day=" + day
				+ ", month=" + month + ", week=" + week + ", cmd=" + cmd
				+ ", args=" + args + "]";
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}
	
	public String getFullWeek() {
		return "0".equals(week) ? "7" : week;
	}

	public String getFullHour() {
		return hour.length() == 1 ? ("*".equals(hour) ? "*" : "0") + hour : hour;
	}
}
