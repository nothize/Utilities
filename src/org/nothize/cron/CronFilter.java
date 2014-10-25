package org.nothize.cron;

import java.util.regex.Pattern;

public class CronFilter {
	public static boolean isMatch(String val, int from, int to) {
		String[] vals = val.split(",");
		if ( vals.length > 0 ) {
			for (String s : vals) {
				if ( "*".equals(s) ) {
					return true;
				}
				// for WEEKHOUR, *0-5 -> 0-5
				if ( s.startsWith("*") ) {
					s = s.substring(1);
					from = from - (from / 100 * 100);
					to = to - (to / 100 * 100);
				}
				if ( s.indexOf("-") > -1 ) {
					String head = "";
					String tail = "";
					// detect 1-512
					if ( s.charAt(1) == '-' ) {
						tail = s.substring(3);
						s = s.substring(0, 3);
					// detect *0-5
					} else if ( s.indexOf('-') > 1 ) {
						head = s.substring(0, 1);
						s = s.substring(1);
					}
//					System.out.println(head + " " + s + " " + tail);
					String[] ranges = s.split("-");
					return isOverlap(Integer.parseInt(head + ranges[0] + tail), Integer.parseInt(head + ranges[1] + tail), from, to);
				}
				if ( "**".equals(s) ) {
					return true;
				}
				int n = Integer.parseInt(s);
				if ( n >= from && n <= to ) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * a--------b
	 *    from-----to
	 * 
	 * @param a
	 * @param b
	 * @param from
	 * @param to
	 * @return
	 */
	public static boolean isOverlap(int a, int b, int from, int to) {
		return (from >= a && from <= b) || (to >= a && to <= b);
	}

	public static String getField(CronEntry cronEntry, CronField field) {
		String val = "";
		switch ( field ) {
		case HOUR:
			val = cronEntry.getHour();
			break;
		case WEEK:
			val = cronEntry.getWeek();
			break;
		case WEEKHOUR:
			val = cronEntry.getFullWeek() + cronEntry.getFullHour();
			break;
		case CMD:
			val = cronEntry.getCmd() + cronEntry.getArgs();
			break;
		}
		return val;
	}

	public static boolean isMatchWild(String val, String cmd) {
		return Pattern.compile(cmd).matcher(val).find();
	}
}
