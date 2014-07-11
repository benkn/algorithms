package ben.kn.algorithms.google;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Generate all the possible substrings using the characters of a given
 * string. Write code. (The order of chars do not matter, i.e., ac == ca) i/p:
 * abc o/p: { a,b,c,ab,ac,bc,abc}
 * 
 * @author Ben (bknear@gmail.com)
 */
public class SubstringGenerator {

	public List<String> generate(String str) {
		// Collection of the Strings
		List<String> allSubstrings = new ArrayList<String>();

		// go through all characters in this string
		for ( int index = 0; index < str.length(); index++ ) {
			// add all the substrings generated from the string and the index
			allSubstrings.addAll(generateRight(str, "", index));
		}

		return allSubstrings;
	}

	/**
	 * Gather all substrings with the given prefix added to the remaining
	 * letters in the base from the given fromIndex.
	 * 
	 * @param base String full value
	 * @param prefix String
	 * @param fromIndex int of the index within the base to use
	 * @return
	 */
	private List<String> generateRight(String base, String prefix, int fromIndex) {

		// get the current letter
		String curPrefix = prefix + base.charAt(fromIndex);

		List<String> substrings = new ArrayList<String>();

		// add the current complete prefix as it's own values
		substrings.add(curPrefix);

		/*
		 * Go through the remaining letters in the base, and look for substrings
		 * after the offset. As this progresses, it will skip letters after the
		 * offset has passed them. For example, using 'ben' will find 'be', then
		 * 'bn'. This is important to know because with four letter words,
		 * 'cash' will be found just before 'cah'.
		 */
		for ( int offset = fromIndex + 1; offset < base.length(); offset++ ) {
			substrings.addAll(generateRight(base, curPrefix, offset));
		}

		return substrings;
	}

	public static void main(String[] args) {
		SubstringGenerator sg = new SubstringGenerator();
		List<String> results = sg.generate("ben");

		for ( String str : results ) {
			System.out.println(str);
		}
	}
}
