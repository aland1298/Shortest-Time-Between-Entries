import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

/**
* Contains method for parsing the input file and find the shortest time between entrys.
*
* @author Alan Dobrzelecki
*
*/
public class ShortestTimeBetweenEntryCalc {	
	private ShortestTimeBetweenEntryCalc() {};
	
	/**
	 * Solves it.
	 * @param arr
	 * @return String - the shortest time between an entry
	 */
	public static String solve(String[] arr) {	
		String[] times;
		Map<Long, Long> map = new TreeMap<>();
		for(String e: arr) {
			e = e.replace(":", "");
			times = e.split("-");
			
			map.put(getMilliseconds(getMilitaryTime(times[0])), getMilliseconds(getMilitaryTime(times[1])));
		}
		
		Long shortestTime = getShortestTime(map);
		
		// Convert to standard time (00:00hhmm)
		return convertToHHMM(shortestTime);
	}
	
	/**
	 * Converts long too standard 12 hour formatted string.
	 * @param t - the long value to convert
	 * @return String - the formatted string of the time from time t
	 */
	private static String convertToHHMM(Long t) {
		long min = TimeUnit.MILLISECONDS.toMinutes(t);
		long hours = TimeUnit.MILLISECONDS.toHours(t);		
		
		return ((hours != 0)? (hours + "hours "):"") + ((min != 0)? (min + "min"):"");
	}
	
	/**
	 * Gets the shortest time between mapped entries
	 * @param map - the map
	 * @return s - the shortest time between entries
	 */
	private static Long getShortestTime(Map<Long, Long> map) {
		long s = Long.MAX_VALUE;
		
		Entry<Long, Long> temp = null;
		for(Map.Entry<Long, Long> e: map.entrySet()) {
			if(temp != null) {
				s = (e.getKey() - temp.getValue() < s)? e.getKey() - temp.getValue(): s;
			}
			
			temp = e;
		}
		return s;
	}
	
	/**
	 * Converts the given string in Military time too miliseconds. 
	 * @param t - the military time
	 * @return long - the total time in milliseconds since 0000
	 */
	private static long getMilliseconds(String t) {
		long hours = 0;
		long min;
		
		// If hours are present
		if(t.length() >= 3)
			hours = Long.parseLong((t.substring(0, t.length() - 2))) * 3600000L; // 3,600,000 milli in an hour
		min = Long.parseLong((t.substring((t.length() >= 2)? t.length() - 2:0, t.length()))) * 60000L; // 60,000 milli in a min
		
		return hours + min;
	}
	
	/**
	 * Converts time from standard time (12h format) to military time (24h format).
	 * @param s - the time to convert
	 * @return time - the military converted time
	 */
	private static String getMilitaryTime(String s) {
		short time = (short) Integer.parseInt(s.substring(0, s.length() - 2));
		String pam = s.substring(s.length() - 2, s.length());
		
		/*
		 * Adds 1200 to:
		 * - Every PM value that does not reside in hour 12
		 * 
		 * Subtracts 1200 to:
		 * - AM value that resides in hour 12
		 */
		if((pam.equalsIgnoreCase("PM") && !s.substring(0, 2).equals("12"))) {
			time += 1200;
		}
		else if((pam.equalsIgnoreCase("AM") && s.substring(0, 2).equals("12"))) {
			time -= 1200;
		}
		return String.valueOf(time);
	}
	
}
