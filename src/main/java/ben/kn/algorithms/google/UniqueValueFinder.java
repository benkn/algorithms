package ben.kn.algorithms.google;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ben.kn.algorithms.util.RandomGenerator;

/**
 * Problem:
 * Given a very long list of URLs, find the first URL which is unique ( occurred
 * exactly once ).
 * 
 * @author Ben (bknear@gmail.com)
 */
public class UniqueValueFinder {
	public static String findFirstUnique(Collection<String> urls) {
		Map<String, Integer> uniques = new LinkedHashMap<String, Integer>();
		Map<String, Integer> dups = new HashMap<String, Integer>();

		for ( String url : urls ) {
			// if the url is in dups, continue
			if ( dups.containsKey(url) ) {
				continue;
			}

			// if the url is already in uniques
			if ( uniques.containsKey(url) ) {
				uniques.remove(url);
				dups.put(url, null);
			} else {
				uniques.put(url, null);
			}
		}

		// get the first key, which represents the first unique String found
		return uniques.keySet().iterator().next();
	}

	public static String inefficientFindFirstUnique(Collection<String> urls) {
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();

		for ( String url : urls ) {
			// if the url is in dups, continue
			if ( map.containsKey(url) ) {
				map.put(url, map.get(url) + 1);
			} else {
				map.put(url, 1);
			}
		}

		// now find the first a count of 1
		for ( String key : map.keySet() ) {
			if ( map.get(key) == 1 ) {
				return key;
			}
		}

		// get the first key, which represents the first unique String found
		return null;
	}

	public static void main(String[] args) {
		System.out.println("Generating data.");
		int size = 1000000;
		List<String> testData = RandomGenerator.generateUniqueStrings(size);
		testData.add("expectedValue");

		System.out.println("Testing");
		long startTime = System.currentTimeMillis();
		String found = findFirstUnique(testData);
		long endTime = System.currentTimeMillis();
		System.out.println("Complete. Found " + found + " and took " + (endTime - startTime)
				+ " ms");

		System.out.println("Testing inefficient");
		long ineffStartTime = System.currentTimeMillis();
		found = findFirstUnique(testData);
		long ineffEndTime = System.currentTimeMillis();
		System.out.println("Complete inefficiently. Found " + found + " and took "
				+ (ineffEndTime - ineffStartTime) + " ms");
	}
}