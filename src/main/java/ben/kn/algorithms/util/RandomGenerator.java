package ben.kn.algorithms.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
	private static Random random = new Random();

	public static List<String> generateUniqueStrings(int size) {
		List<String> data = new ArrayList<String>();
		for ( int i = 0; i < size; i++ ) {
			data.add("" + generateRandomBetween(0, size + 1));
		}
		return data;
	}

	public static List<String> generateLessUniqueStrings(int size, int upperLimit) {
		List<String> data = new ArrayList<String>();
		for ( int i = 0; i < size; i++ ) {
			data.add("" + generateRandomBetween(0, upperLimit));
		}
		return data;
	}

	private static int generateRandomBetween(int min, int max) {
		int randomNumber = random.nextInt(max - min + 1);
		randomNumber += min;
		return randomNumber;
	}

	@SuppressWarnings("rawtypes")
	public static void printList(List objects) {
		for ( int i = 0; i < objects.size(); i++ ) {
			if ( i > 0 ) {
				System.out.print(", ");
			}
			System.out.print(objects.get(i).toString());
		}
	}

	public static void printArray(Object[] objects) {
		for ( int i = 0; i < objects.length; i++ ) {
			if ( i > 0 ) {
				System.out.print(", ");
			}
			System.out.print(objects[i].toString());
		}
	}
}
