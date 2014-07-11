package ben.kn.algorithms.google;

/**
 * Problem: Give the user the nth value in the fibonacci sequence.
 * 
 * @author Ben (bknear@gmail.com)
 * @since Apr 15, 2013
 */
public class FibonacciSequence {

	public static int getNthValueInSequence(int n) {
		int a = 1, b = 0, c = 0;

		// Sequence begins 1,1,2,3,5,8,13, so n = 1 or 2 is 1
		for ( int i = 1; i < n; i++ ) {
			c = b;
			b = a;
			a = b + c;
		}

		return a;
	}

	public static void main(String[] args) {
		for ( int i = 1; i <= 10; i++ ) {
			System.out.println("Fib value for " + i + " is " + getNthValueInSequence(i));
		}
	}
}
