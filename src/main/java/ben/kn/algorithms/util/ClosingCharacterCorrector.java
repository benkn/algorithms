package ben.kn.algorithms.util;

import java.util.ArrayList;
import java.util.List;

/**
 * This service allows clients to search for and remove un-used bounding
 * characters, such as parenthesis, brackets, and curly braces.
 * 
 * @author Ben (bknear@gmail.com)
 */
public class ClosingCharacterCorrector {
	public static String removeUnclosedCharacters(String in, char openingCharacter,
			char closingCharacter) {
		List<Integer> lefts = new ArrayList<Integer>();
		List<Integer> rights = new ArrayList<Integer>();
		// go through in and find all lefts and rights
		for ( int i = 0; i < in.length(); i++ ) {
			if ( in.charAt(i) == openingCharacter )
				lefts.add(i);
			if ( in.charAt(i) == closingCharacter )
				rights.add(i);
		}
		// pr("lefts: " + lefts.toString() + "\trights: " + rights.toString());

		// identify pairs and remove from lists
		while ( findBoundMatch(lefts, rights) )
			;

		// remove all parenthesis remaining
		lefts.addAll(rights);

		bubbleSortDesc(lefts);
		// pr("Indices to remove: " + lefts.toString());

		for ( Integer removeIndex : lefts ) {
			if ( removeIndex == 0 ) {
				// pr("Trimming to " + in.substring(1));
				in = in.substring(1);
			} else {
				// pr("Trimming to " + in.substring(0, removeIndex) +
				// in.substring(removeIndex + 1));
				in = in.substring(0, removeIndex) + in.substring(removeIndex + 1);
			}
		}

		return in;
	}

	private static boolean findBoundMatch(List<Integer> left, List<Integer> right) {
		boolean boundMatchRemoved = false;
		int leftIndex = 0;
		int rightIndex = 0;

		// first, check the sizes of the lists
		if ( left == null || left.size() == 0 || right == null || right.size() == 0 ) {
			return boundMatchRemoved;
		}

		// we'll be incrementing, so don't go past the size
		while ( leftIndex < left.size() && rightIndex < right.size() ) {
			// pr("Checking " + left.get(leftIndex) + " against " +
			// right.get(rightIndex));
			// if left is greater than right, and leftIndex is 0, then this
			// right has no opening left.
			if ( left.get(leftIndex) > right.get(rightIndex) && leftIndex == 0 ) {
				// pr("Ignoring un-opened right at " + right.get(rightIndex));
				rightIndex++;
			}

			// else, if leftIndex is greater than 0, then go back one, and
			// remove it and the right, as that leftIndex is the closest to the
			// rightIndex
			else if ( left.get(leftIndex) > right.get(rightIndex) && leftIndex > 0 ) {
				// pr("Removing left at " + left.get(leftIndex - 1) +
				// " and right at "
				// + right.get(rightIndex));
				left.remove(leftIndex - 1);
				right.remove(rightIndex);
				boundMatchRemoved = true;
				break;
			}

			// else, if this left is less that the right, and there are no more
			// lefts, then these must match
			else if ( left.get(leftIndex) < right.get(rightIndex) && left.size() == leftIndex + 1 ) {
				// pr("Removing left at " + left.get(leftIndex) +
				// " and right at " + right.get(0));
				left.remove(leftIndex);
				right.remove(rightIndex);
				boundMatchRemoved = true;
				break;
			}

			// else, continue incrementing left
			else {
				leftIndex++;
			}
		}

		return boundMatchRemoved;
	}

	private static List<Integer> bubbleSortDesc(List<Integer> unL) {
		int listSize = unL.size();
		boolean swapMade = true;

		while ( swapMade ) {
			swapMade = false;
			for ( int index = 0; index < listSize - 1; index++ ) {
				// get this index value and following index value
				Integer one = unL.get(index);
				Integer two = unL.get(index + 1);

				// if we are going in ascending order, and two is less than one,
				// then swap. OR if we are going in descending order, and two is
				// greater than one, then swap
				if ( two >= one ) {
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
}
