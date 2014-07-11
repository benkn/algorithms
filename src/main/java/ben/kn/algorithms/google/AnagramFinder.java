package ben.kn.algorithms.google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Problem: Given a word as a String, find any possible anagram words.
 * 
 * Solution: Put all words in corpus into a map, keyed on alphabetized
 * characters in the word.
 * 
 * @author Ben (bknear@gmail.com)
 * @since Apr 15, 2013
 */
public class AnagramFinder {

	private Map<String, Set<String>> corpus = new HashMap<String, Set<String>>();

	public AnagramFinder(Set<String> initialWordSet) {
		for ( String word : initialWordSet ) {
			addWordToCorpus(word);
		}
	}

	public AnagramFinder(String... initialWordSet) {
		for ( String word : initialWordSet ) {
			addWordToCorpus(word);
		}
	}

	/**
	 * Get all the words which are anagrams of the given word.
	 * 
	 * @param word String
	 * @return Set of String representing all words, including the given itself
	 *         if present in the corpus.
	 */
	public Set<String> getAnagramWords(String word) {
		return corpus.get(alphabetizeLetters(word));
	}

	/**
	 * @param word String word to add to corpus
	 */
	private void addWordToCorpus(String word) {
		String alphabetizedLetters = alphabetizeLetters(word);
		if ( !corpus.containsKey(alphabetizedLetters) ) {
			corpus.put(alphabetizedLetters, new HashSet<String>());
		}
		corpus.get(alphabetizedLetters).add(word);
	}

	private String alphabetizeLetters(String word) {
		char[] letters = word.toCharArray();
		Arrays.sort(letters);
		return new String(letters);
	}

	/**
	 * Print the corpus of words.
	 */
	public void printCorpus() {
		for ( String key : corpus.keySet() ) {
			System.out.println(key + ":");
			for ( String word : corpus.get(key) ) {
				System.out.println("\t" + word);
			}
		}
	}

	public static void main(String[] args) {
		AnagramFinder af = new AnagramFinder("bat", "tab", "cat", "tack");
		af.printCorpus();
	}
}
