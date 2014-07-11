package ben.kn.algorithms.google;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import ben.kn.algorithms.data.Data;
import ben.kn.algorithms.util.CollectionsUtil;

/**
 * Problem: Find the most frequently occurring data in a given array.
 * 
 * Solution: Use a Map to track individual values and total instances for that
 * value.
 * 
 * @author Ben (bknear@gmail.com)
 * @since Apr 15, 2013
 */
public class ElementCounter {
	/**
	 * Find elements in the given array which occur at least n times.
	 * 
	 * @param arr Integer []
	 * @param n int
	 * @return Collection of Integers
	 */
	public static Collection<Integer> findOverNth(Integer[] arr, int n) {
		Map<Integer, Integer> totals = new HashMap<Integer, Integer>();
		Collection<Integer> valuesThatMatch = new HashSet<Integer>();

		// go through given array
		for ( Integer d : arr ) {
			// set the count based on if it is present in the map
			Integer count = totals.get(d) != null ? totals.get(d) : 0;
			totals.put(d, ++count);

			// if the count is at least n, add it to the collection
			if ( count >= n ) {
				valuesThatMatch.add(d);
			}
		}
		return valuesThatMatch;
	}

	/**
	 * Find the most frequent Data value in the given Collection
	 * 
	 * @param dataCol Collection of Data objects
	 * @return Data
	 */
	public static Data findMostFrequent(Collection<Data> dataCol) {
		Map<Data, Integer> totals = new HashMap<Data, Integer>();
		Data largestFreqData = null;
		int freq = 0;

		// go through given collection of data
		for ( Data d : dataCol ) {
			Integer count = totals.get(d) != null ? totals.get(d) : 0;
			totals.put(d, ++count);
			if ( count >= freq ) {
				largestFreqData = d;
				freq = count;
			}
		}
		return largestFreqData;
	}

	public static void main(String[] args) {
		Integer[] testData = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 1, 2, 3, 9, 9 };
		System.out.println(CollectionsUtil.collectionToString(findOverNth(testData, 3)));
	}
}
