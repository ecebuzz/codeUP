
public class RecurrenceRelation {
	public static void main(String[] args) {
//		//Testcase 0
//		int[] coefficients = {2, 1};
//		int[] initial = {9, 7};
//		int N = 6;
//		//Testcase 1
//		int[] coefficients = {1, 1};
//		int[] initial = {0, 1};
//		int N = 9;
//		//Testcase 2
//		int[] coefficients = {2};
//		int[] initial = {1};
//		int N = 20;
//		//Testcase 3
//		int[] coefficients = {2};
//		int[] initial = {1};
//		int N = 64;
//		//Testcase 4
//		int[] coefficients = {25, 143};
//		int[] initial = {0, 0};
//		int N = 100000;
//		//Testcase 5
//		int[] coefficients = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
//		int[] initial = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//		int N = 654;
		//Testcase 6
		int[] coefficients = {901, 492, 100};
		int[] initial = {-6, -15, -39};
		int N = 0;
		System.out.println(moduloTen(coefficients, initial, N));
	}

	public static int moduloTen(int[] coefficients,
			int[] initial, int N) {
		//TODO Excpetion Handle
		if(N <= initial.length - 1) {
			return modulo(initial[N]);
		}

		int[] arr = new int[N + 1];
		int k = coefficients.length;
		//Initialize the initials
		for(int i = 0; i < initial.length; i++) {
			arr[i] = initial[i];
		}

		for(int i = initial.length; i <= N; i++) {
			int tmp = 0;
			for(int j = 0; j < k; j++) {
				tmp += modulo(arr[i - j - 1] * coefficients[k - j - 1]);
			}
			arr[i] = modulo(tmp);
		}

		return modulo(arr[N]);
	}

	public static int modulo(int num) {
		if(num >= 0) {
			return num % 10;
		}
		else {
			return (10 - ((-num) % 10)) % 10;
		}
	}
}
