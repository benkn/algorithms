package ben.kn.algorithms.sorting;

import java.util.List;

import ben.kn.algorithms.data.Data;

/**
 * Selection sort is an in-place comparison sort. It has O(n2) complexity,
 * making it inefficient on large lists, and generally performs worse than the
 * similar insertion sort. Selection sort is noted for its simplicity, and also
 * has performance advantages over more complicated algorithms in certain
 * situations.
 * 
 * The algorithm finds the minimum value, swaps it with the value in the first
 * position, and repeats these steps for the remainder of the list. It does no
 * more than n swaps, and thus is useful where swapping is very expensive.
 * 
 * @author Ben (bknear@gmail.com)
 */
public class SelectionSort {
	public static List<Data> selectionSort(List<Data> list, boolean ascending) {
		int listSize = list.size();

		for ( int placementIndex = 0; placementIndex < listSize; placementIndex++ ) {
			int minIndex = placementIndex;
			for ( int currIndex = placementIndex + 1; currIndex < listSize; currIndex++ ) {

				if ( (ascending && list.get(currIndex).getIntValue() < list.get(minIndex)
						.getIntValue())
						|| (!ascending && list.get(currIndex).getIntValue() > list.get(minIndex)
								.getIntValue()) ) {
					minIndex = currIndex;
				}
			}

			// the minIndex now matches the smallest int, so place it in the
			// given placement index.
			Data min = list.get(minIndex);
			list.remove(minIndex);
			list.add(placementIndex, min);
		}
		return list;
	}

	public static void main(String[] args) {
		List<Data> list = SortingUtil.generateTestData(10);
		System.out.println("Unsorted: ");
		SortingUtil.printList(list);

		List<Data> sorted = selectionSort(list, true);
		System.out.println("\nSorted: ");
		SortingUtil.printList(sorted);

		sorted = selectionSort(list, false);
		System.out.println("\nSorted: ");
		SortingUtil.printList(sorted);
	}
}
