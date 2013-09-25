
public class BettingMoney {
	public static void main( String[] args ) {
//		//Testcase 0
//		int[] amounts = {10, 20, 30};
//		int[] centsPerDollar = {20, 30, 40};
//		int finalResult = 1;
//		//Testcase 1
//		int[] amounts = {200, 300, 100};
//		int[] centsPerDollar = {10, 10, 10};
//		int finalResult = 2;
//		//Testcase 2
//		int[] amounts = {100, 100, 100, 100};
//		int[] centsPerDollar = {5, 5, 5, 5};
//		int finalResult = 0;
//		//Testcase 3
//		int[] amounts = {5000, 5000};
//		int[] centsPerDollar = {100, 2};
//		int finalResult = 0;
		//Testcase 4
		int[] amounts = {100};
		int[] centsPerDollar = {10};
		int finalResult = 0;

		System.out.println( moneyMade( amounts, centsPerDollar, finalResult ) );
	}

	public static int moneyMade( int[] amounts, int[] centsPerDollar, int finalResult ) {
		if( amounts == null || centsPerDollar == null 
				|| ( finalResult < 0 && finalResult > amounts.length ) ) {
			//TODO Exception handle
		}

		if( amounts.length != centsPerDollar.length ) {
			//TODO Exception handle
		}

		int moneyEarned = 0;

		for( int i = 0; i < amounts.length; i++ ) {
			if( i == finalResult ) {
				moneyEarned -= centsPerDollar[i] * amounts[i];
			}
			else {
				moneyEarned += amounts[i] * 100;
			}

		}

		return moneyEarned;
	}
}
