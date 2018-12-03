package basicAlgorithms;

public class MinMax {

	/*
	 * This function accepts Array of integers , 
	 * and return the maximum integer in this Array
	 */
	public static int findMax(int [] arr) {
		if(arr.length == 0)
			return Integer.MAX_VALUE;
		int ans = arr[0];
		for(int i=1 ; i<arr.length ; i++) 
			if(ans < arr[i])
				ans = arr[i];
		return ans;
	}

	/*
	 * This function accepts Array of integers , 
	 * and return the maximum and minimum integer in this Array
	 * in a new Array with Two indexs
	 */
	public static int [] findMinMax1(int [] arr) {
		if(arr.length == 0) {
			int [] ans = {Integer.MAX_VALUE , Integer.MIN_VALUE};
			return ans;
		}
		int max = arr[0];
		for(int i=1 ; i<arr.length ; i++) 
			if(max < arr[i])
				max = arr[i];

		int min = arr[0];
		for(int i=1 ; i<arr.length ; i++) 
			if(min > arr[i])
				min = arr[i];

		int [] ans = {min , max};
		return ans;
	}

	/*
	 * This function similar with findMinMx1 function,
	 * but it run on arr one time 
	 */
	public static int [] findMinMax2(int [] arr) {
		if(arr.length == 0) {
			int [] ans = {Integer.MAX_VALUE , Integer.MIN_VALUE};
			return ans;
		}
		int max = arr[0] ,  min = arr[0];
		for(int i=1 ; i<arr.length ; i++) {
			if(max < arr[i])
				max = arr[i];
			else if(min > arr[i])
				min = arr[i];
		}

		int [] ans = {min , max};
		return ans;
	}

	/*
	 * This function also similar to findMinMx1 and findMinMx2 functions,
	 * but with minimum comparisons , to effiency the Algorithem
	 */
	public static int [] findMinMax3(int [] arr) {
		if(arr.length == 0) {
			int [] ans = {Integer.MAX_VALUE , Integer.MIN_VALUE};
			return ans;
		}
		int max = arr[1] ,  min = arr[0];
		if(arr[0] > arr[1]) {
			max = arr[0];
			min = arr[1];
		}
		for(int i=2 ; i < arr.length-1 ; i+=2) {
			if(arr[i] <= arr[i+1]) {
				if(arr[i] < min )
					min = arr[i];
				if(arr[i+1] > max)
					max = arr[i+1];
			}
			else {
				if(arr[i+1] < min )
					min = arr[i+1];
				if(arr[i] > max)
					max = arr[i];
			}	
		}
		if (arr.length%2 == 1) {
			if(arr[arr.length-1] > max)
				max = arr[arr.length-1];
			else if(arr[arr.length-1] < min)
				min = arr[arr.length-1];
		}
		int [] ans = {min , max};
		return ans;

	}

}
