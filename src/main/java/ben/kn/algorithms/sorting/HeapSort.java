package ben.kn.algorithms.sorting;

import ben.kn.algorithms.data.GenericData;

/**
 * Heapsort is a much more efficient version of selection sort. It also works by
 * determining the largest (or smallest) element of the list, placing that at
 * the end (or beginning) of the list, then continuing with the rest of the
 * list, but accomplishes this task efficiently by using a data structure called
 * a heap, a special type of binary tree. Once the data list has been made into
 * a heap, the root node is guaranteed to be the largest (or smallest) element.
 * When it is removed and placed at the end of the list, the heap is rearranged
 * so the largest element remaining moves to the root. Using the heap, finding
 * the next largest element takes O(log n) time, instead of O(n) for a linear
 * scan as in simple selection sort. This allows Heapsort to run in O(n log n)
 * time, and this is also the worst case complexity.
 * 
 * @author Ben (bknear@gmail.com)
 */
public class HeapSort {

	private static int heapSize = 0;

	/**
	 * Heapsort the given array
	 * 
	 * @param array GenericData array
	 * @return GenericData array
	 */
	public static GenericData[] heapSort(GenericData[] array) {
		// Put all elements into a max heap
		buildMaxHeap(array);
		// Go down to 2 because once the length is 2, we know the first element
		// is larger than the second, and we can put both into our sorted
		// collection.
		for ( int i = array.length - 1; i >= 1; i-- ) {
			// swap the first element (largest) with the last ([one of the]
			// smallest)
			exchange(array, 0, i);
			// Reduce heapSize to ignore the last elements (which are sorted)
			heapSize--;
			// Reorder the heap to maintain max heap
			maxHeapify(array, 0);
		}
		return array;
	}

	private static void buildMaxHeap(GenericData[] array) {
		heapSize = array.length;
		// first i is floor(n/2), and it moves closer to the top of the tree
		for ( int i = (int) Math.floor(array.length / 2); i >= 0; i-- ) {
			maxHeapify(array, i);
		}
	}

	private static void maxHeapify(GenericData[] array, int i) {
		// set the values of the leafs for i
		int l = LEFT(i);
		int r = RIGHT(i);
		int largest = -1;

		if ( l <= heapSize - 1 && array[l].getIntValue() > array[i].getIntValue() )
			largest = l;
		else
			largest = i;

		if ( r <= heapSize - 1 && array[r].getIntValue() > array[largest].getIntValue() )
			largest = r;

		if ( largest != i ) {
			exchange(array, i, largest);

			// Recursively do it over again.
			maxHeapify(array, largest);
		}
	}

	private static void exchange(GenericData[] array, int i, int j) {
		GenericData inter = array[i];
		array[i] = array[j];
		array[j] = inter;
	}

	private static int LEFT(int i) {
		return 2 * i;
	}

	private static int RIGHT(int i) {
		return 2 * i + 1;
	}

	@SuppressWarnings("unused")
    private static int PARENT(int i) {
		return (int) Math.floor(i / 2);
	}

	public static void main(String[] args) {
		GenericData[] list = SortingUtil.generateTestDataArray(10);
		System.out.println("Unsorted: ");
		SortingUtil.printArray(list);

		GenericData[] sorted = heapSort(list);
		System.out.println("\nSorted: ");
		SortingUtil.printArray(sorted);

		sorted = heapSort(list);
		System.out.println("\nSorted: ");
		SortingUtil.printArray(sorted);
	}
}