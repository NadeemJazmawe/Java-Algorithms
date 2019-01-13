package basicAlgorithms;

import java.util.Arrays;

public class LISandLDS {

	/*
	 * The longest increasing subsequence problem, is to find a subsequence of 
	 * a given sequence in which the subsequence's elements are in sorted order, 
	 * lowest to highest, and in which the subsequence is as long as possible. 
	 * This subsequence is not necessarily contiguous, or unique.
	 * LTS3 is the best algorithm.
	 */

	/*
	 * basic algorithm , it return answer(it can be not True answer)
	 */

	public static int[] LIS1(int [] arr){
		int n = arr.length ;
		int [] temp = new int [n];
		int k = 0 ;
		temp[0] = arr[0];
		for ( int  i = 0 ; i < n-1 ; i++) 
			if(arr[i] > temp[k]) 
				temp[++k] = arr[i];

		int [] ans = new int [k+1];
		for( int  i = 0 ; i <= k ; i++)
			ans[i] = temp[i];

		return ans;
	}


	/*
	 * in this function , i sorted the Arrays first , after that run the LCS on it.
	 */
	public static int[] LIS2(int [] arr) {
		int [] helper = new int [arr.length];
		for(int i = 0 ; i< arr.length ; i++) 
			helper[i] = arr[i];
		Arrays.sort(helper);

		int [] temp = new int [arr.length];
		int start = 0 , index = 0 , i =0 , j=0;
		int m = arr.length , n = m;
		while(i < m && index < n) {
			index = findIndex(arr , helper[i] , start);
			if(index != -1) {
				temp[j] = helper[i];
				j++;
				start = index +1;
			}
			i++;
		}
		int [] ans = new int [j];
		for(i = 0 ; i < j ; i++)
			ans[i] = temp[i];
		return ans;
	}
	/*
	 * help function for LIS2 function.
	 * it accept Arrays and num to search , and it start the search from index that we enter to it(start). 
	 */
	private static int findIndex(int [] arr , int find ,int start) {
		for(int i = start ; i < arr.length ; i++)
			if(arr[i] == find)
				return i;
		return -1;
	}


	/*
	 * here is the best algo to sort get the answer.
	 * i use two help arrays:-
	 * length array , that show to me the max length to subst array for each idex
	 * sub array , that show me the path for the answe
	 */
	public static int[] LIS3(int [] arr) {
		int [] length = new int [arr.length];
		int [] sub = new int [arr.length];
		for(int i =0 ; i < length.length ; i++)
			length[i] = 1;

		for(int i = 0 ; i < arr.length  ; i++)
			for(int j = 0; j < i ; j++) {
				if(arr[j] < arr[i] && (length[i] < length[j] + 1)) {
					length[i] = length[j] + 1 ;
					sub[i] =j;
				}
			}

		int maxlen = 0 , index = 0;
		for(int  i = 0 ; i < length.length ; i++)
			if(maxlen < length[i]) {
				maxlen = length[i];
				index = i;
			}

		int [] ans = new int[maxlen];
		for(int i = ans.length-1 ; i > 0 ; i--) {
			ans[i] = arr[index];
			index = sub[index];
		}

		return ans;
	}


	/*
	 * This function give me the Longest Descending Subseq.
	 */
	public static int [] LDS(int [] arr) {
		int [] ans = new int [arr.length];
		for(int i = 0 ; i < ans.length ; i++)
			ans[i] = -arr[i];
		ans = LIS3(ans);
		for(int i = 0 ; i < ans.length ; i++)
			ans[i] = -ans[i];
		return ans;
	}


}
