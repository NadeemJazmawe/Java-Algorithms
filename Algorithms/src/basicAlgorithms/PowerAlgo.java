package basicAlgorithms;

public class PowerAlgo {
	
	/*
	 * Calculating x pow n functions .
	 * both run with O(logn) => n is the power
	 */

	public static int powerLoop(int num , int pow) {
		int result = 1;
		while (pow != 0) {
			if (pow%2 == 1) 
				result *= num;
			num *= num;
			pow /=2;
		}
		return result;
	}						
	
	public static int powerRecursion(int num , int pow) {
		if ( pow == 0)
			return 1 ;
		if (pow%2 == 0)
			return powerRecursion(num*num , pow/2);
		return num*powerRecursion(num*num, (pow - 1)/2);
	}
	
}
