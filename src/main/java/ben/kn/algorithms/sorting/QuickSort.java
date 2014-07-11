package ben.kn.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

import ben.kn.algorithms.data.Data;

/**
 * Implements the QuickSort algorithm.
 * 
 * The QuickSort algorithm involves splitting the collection by a 'pivot' entry
 * in the list, and ordering relative to that value. All values less than the
 * pivot is put into a collection, and all greater into another. Then, each of
 * those collections undergo the same sorting functionality recursively. When
 * arriving at single values, they are joined into an ordered list with the
 * pivot value between the now ordered lesser and greater values.
 * 
 * This runs as an O(log n) efficiency.
 * 
 * @author Ben (bknear@gmail.com)
 */
public class QuickSort {

	public List<Data> sort(List<Data> data) {
		// an array of zero or one elements is already sorted
		if ( data.size() <= 1 ) {
			return data;
		}

		// get pivot value
		int pivotIndex = data.size() / 2;
		Data pivot = data.get(pivotIndex);

		// create empty lists for less and greater
		List<Data> lesser = new ArrayList<Data>(), greater = new ArrayList<Data>();

		for ( int i = 0; i < data.size(); i++ ) {
			Data d = data.get(i);
			// skip the pivot value
			if ( pivotIndex == i ) {
				continue;
			}
			if ( d.getIntValue() <= pivot.getIntValue() ) {
				lesser.add(d);
			} else {
				greater.add(d);
			}
		}

		List<Data> sorted = new ArrayList<Data>();
		sorted.addAll(sort(lesser));
		sorted.add(pivot);
		sorted.addAll(sort(greater));

		return sorted;
	}

	public static void main(String[] args) {
		List<Data> list = SortingUtil.generateTestData(10);
		System.out.println("Unsorted: ");
		SortingUtil.printList(list);

		List<Data> sorted = new QuickSort().sort(list);
		System.out.println("\nSorted: ");
		SortingUtil.printList(sorted);
	}
}
