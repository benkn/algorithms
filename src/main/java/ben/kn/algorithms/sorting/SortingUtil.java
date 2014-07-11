package ben.kn.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ben.kn.algorithms.data.Data;
import ben.kn.algorithms.data.GenericData;
import ben.kn.algorithms.util.RandomGenerator;

public class SortingUtil extends RandomGenerator {
	private static Random random = new Random();

	public static List<Data> generateTestData(int size) {
		List<Data> data = new ArrayList<Data>();
		for ( int i = 0; i < size; i++ ) {
			data.add(new GenericData(generateRandomBetween(0, 100)));
		}
		return data;
	}

	public static GenericData[] generateTestDataArray(int size) {
		GenericData[] data = new GenericData[size];
		for ( int i = 0; i < size; i++ ) {
			data[i] = new GenericData(generateRandomBetween(0, 100));
		}
		return data;
	}

	private static int generateRandomBetween(int min, int max) {
		int randomNumber = random.nextInt(max - min + 1);
		randomNumber += min;
		return randomNumber;
	}
}
