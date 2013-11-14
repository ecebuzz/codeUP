import java.util.Scanner;
import java.util.LinkedList;

public class Solution {
	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(System.in);
		// Read in the upper bound for prime numbers
		int upperBound = -1;

		if(in.hasNextInt()) {
			upperBound = in.nextInt();
		}
		else {
			throw new Exception("The upperBound must be an integer!");
		}

		if(upperBound <= 1) {
			throw new Exception("The upperBound must be greater than 1 and integer!");
		}
        in.close();
		int numOfPrimes = getNumberOfPrimes(upperBound);

		System.out.println(numOfPrimes);

	}

	public static int getNumberOfPrimes(int upperBound) {
		// Exception Handle
		int numOfPrimes = 0;
		if(upperBound <= 1) {
			return numOfPrimes;
		}

		LinkedList<Integer> primeList = new LinkedList<Integer>();


		// Generate primes from 2
		for(int i = 2; i <= upperBound; i++) {
			if(isPrime(i, primeList)) {
				numOfPrimes++;
			}
		}

		return numOfPrimes;

	}

	public static boolean isPrime(int num, LinkedList<Integer> primeList) {
		if(primeList.isEmpty()) {
			primeList.add(num);
			return true;
		}

		for(int i = 0; i < primeList.size(); i++) {
			int primeNum = primeList.get(i);
			if(primeNum > Math.sqrt(num)) {
				primeList.add(num);
				break;
			}


			if(num % primeNum == 0) {
				return false;
			}
		}

		return true;
	}
		
}
