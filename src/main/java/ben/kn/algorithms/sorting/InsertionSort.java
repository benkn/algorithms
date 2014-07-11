package ben.kn.algorithms.sorting;

import ben.kn.algorithms.data.GenericData;

/**
 * Insertion sort is a simple sorting algorithm that is relatively efficient for
 * small lists and mostly sorted lists, and often is used as part of more
 * sophisticated algorithms. It works by taking elements from the list one by
 * one and inserting them in their correct position into a new sorted list. In
 * arrays, the new list and the remaining elements can share the array's space,
 * but insertion is expensive, requiring shifting all following elements over by
 * one.
 * 
 * @author Ben (bknear@gmail.com)
 */
public class InsertionSort {
	public static GenericData[] insertionSort(GenericData[] list, boolean ascending) {
		int listSize = list.length;

		for ( int placementIndex = 0; placementIndex < listSize; placementIndex++ ) {
			int minIndex = placementIndex;
			for ( int currIndex = placementIndex + 1; currIndex < listSize; currIndex++ ) {

				if ( (ascending && list[currIndex].getIntValue() < list[minIndex].getIntValue())
						|| (!ascending && list[currIndex].getIntValue() > list[minIndex]
								.getIntValue()) ) {
					minIndex = currIndex;
				}
			}

			// the minIndex now matches the smallest int, so place it in the
			// given placement index.
			GenericData min = list[minIndex];

			// move all elements from the placement to the min by one
			for ( int move = minIndex; move > placementIndex; move-- ) {
				list[move] = list[move - 1];
			}
			list[placementIndex] = min;
		}
		return list;
	}

	public static void main(String[] args) {
		GenericData[] list = SortingUtil.generateTestDataArray(10);
		System.out.println("Unsorted: ");
		SortingUtil.printArray(list);

		GenericData[] sorted = insertionSort(list, true);
		System.out.println("\nSorted: ");
		SortingUtil.printArray(sorted);

		sorted = insertionSort(list, false);
		System.out.println("\nSorted: ");
		SortingUtil.printArray(sorted);
	}
}
