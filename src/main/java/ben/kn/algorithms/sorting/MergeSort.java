package ben.kn.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

import ben.kn.algorithms.data.Data;

/**
 * Merge sort is an O(n log n) comparison-based sorting algorithm. It works by
 * dividing the unordered list into smaller pieces until broken into pairs. It
 * then orders the smallest fragments. Then, combines those sorted fragments
 * with one another, sorting as they go. Each small sort is executed as an
 * insertion.
 * 
 * @author Ben (bknear@gmail.com)
 */
public class MergeSort {

	/**
	 * Execute the merge sort on the given List of Data objects
	 * 
	 * @param data List of Data
	 * @return List of Data sorted in ascending order
	 */
	public List<Data> sort(List<Data> data) {
		if ( data.size() <= 1 ) {
			return data;
		}

		// initialize our smaller collections
		int mid = data.size() / 2;
		List<Data> left = new ArrayList<Data>();
		List<Data> right = new ArrayList<Data>();

		// populate them with the left and right sides of the given list
		for ( int leftIndex = 0; leftIndex < mid; leftIndex++ ) {
			left.add(data.get(leftIndex));
		}
		for ( int rightIndex = mid; rightIndex < data.size(); rightIndex++ ) {
			right.add(data.get(rightIndex));
		}

		// recursively call mergeSort to get smaller pieces
		left = sort(left);
		right = sort(right);

		// Merge the left and right list, sorting them as it is merged together
		return merge(left, right);
	}

	/**
	 * Merge the two given lists, ordering the values in ascending order
	 * 
	 * @param left List of Data
	 * @param right List of Data
	 * @return List of Data
	 */
	private List<Data> merge(List<Data> left, List<Data> right) {
		List<Data> ordered = new ArrayList<Data>();
		// go through each list as long as either has values
		while (left.size() > 0 || right.size() > 0) {

			// if both left and right has a value, then check their values
			if ( left.size() > 0 && right.size() > 0 ) {
				// if left is less or equal to right, then add it and remove it
				// from left
				if ( left.get(0).getIntValue() <= right.get(0).getIntValue() ) {
					ordered.add(left.get(0));
					left.remove(0);
				}
				// else, add right and remove it from right
				else {
					ordered.add(right.get(0));
					right.remove(0);
				}
			}
			// else, if only left has a value, then add left
			else if ( left.size() > 0 ) {
				ordered.add(left.get(0));
				left.remove(0);
			}
			// else, if only right has a value, then add right
			else if ( right.size() > 0 ) {
				ordered.add(right.get(0));
				right.remove(0);
			}
		}
		return ordered;
	}

	public static void main(String[] args) {
		List<Data> list = SortingUtil.generateTestData(10);
		System.out.println("Unsorted: ");
		SortingUtil.printList(list);

		MergeSort sorter = new MergeSort();
		List<Data> sorted = sorter.sort(list);
		System.out.println("\nSorted: ");
		SortingUtil.printList(sorted);
	}
}