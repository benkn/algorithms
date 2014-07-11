package ben.kn.algorithms.sorting;

import java.util.List;

import ben.kn.algorithms.data.Data;

/**
 * The algorithm starts at the beginning of the data set. It compares the first
 * two elements, and if the first is greater than the second, it swaps them. It
 * continues doing this for each pair of adjacent elements to the end of the
 * data set. It then starts again with the first two elements, repeating until
 * no swaps have occurred on the last pass. This algorithm's average and worst
 * case performance is O(n2), so it is rarely used to sort large, unordered,
 * data sets. Bubble sort can be used to sort a small number of items (where its
 * inefficiency is not a high penalty). Bubble sort may also be efficiently used
 * on a list that is already sorted except for a very small number of elements.
 * For example, if only one element is not in order, bubble sort will take only
 * 2n time. If two elements are not in order, bubble sort will take only at most
 * 3n time.
 * 
 * @author Ben (bknear@gmail.com)
 */
public class BubbleSort {

	public static List<Data> bubbleSort(List<Data> unL, boolean ascending) {
		int listSize = unL.size();
		boolean swapMade = true;

		while (swapMade) {
			swapMade = false;
			for ( int index = 0; index < listSize - 1; index++ ) {
				// get this index value and following index value
				Data one = unL.get(index);
				Data two = unL.get(index + 1);

				// if we are going in ascending order, and two is less than one,
				// then swap. OR if we are going in descending order, and two is
				// greater than one, then swap
				if ( (ascending && two.getIntValue() < one.getIntValue())
						|| (!ascending && two.getIntValue() > one.getIntValue()) ) {
					swapMade = true;
					unL.remove(index + 1);
					unL.remove(index);
					unL.add(index, two);
					unL.add(index + 1, one);
				}
			}
		}
		return unL;
	}

	public static void main(String[] args) {
		List<Data> list = SortingUtil.generateTestData(10);
		System.out.println("Unsorted: ");
		SortingUtil.printList(list);

		List<Data> sorted = bubbleSort(list, true);
		System.out.println("\nSorted: ");
		SortingUtil.printList(sorted);

		sorted = bubbleSort(list, false);
		System.out.println("\nSorted: ");
		SortingUtil.printList(sorted);
	}
}