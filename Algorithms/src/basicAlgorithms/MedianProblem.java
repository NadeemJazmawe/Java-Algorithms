package basicAlgorithms;

import java.util.Arrays;

public class MedianProblem {
	
	/*
	 * This function accept two sorted arrays (every array have n integers),
	 * it calculate a new array , that have the n biggest number from the two arrays.
	 */
	public static int[] median1(int [] a , int [] b) {
		int n = a.length + b.length;
		int [] helper = new int[n];
		int x = 0; //x=> index at a
		int y = 0; //y=> index at b 
		int i = 0; //i=> index at helper
		while(x < a.length && y < b.length) {
			if (a[x] < b[y]) {
				helper[i] = a[x];
				x++;
			}
			else {
				helper[i] = b[y];
				y++;
			}
			i++;
		}
		while(x < a.length) {
			helper[i] = a[x];
			x++;
			i++;
		}
		while(y < b.length) {
			helper[i] = b[y];
			y++;
			i++;
		}
		
		int [] ans = new int [n/2];
		for(int j = 0 ; j < ans.length ; j++) {
			ans[j] = helper[n-j-1];
		}
		
		return ans;
	}
	
	/*
	 * This function accept two sorted arrays (every array have n integers),
	 * it calculate a new array , that have the n biggest number from the two arrays.
	 * it simlar to median1 function but it dont build help array
	 */
	public static int[] median2(int [] a , int [] b) {
		int [] ans = new int[a.length];
		for(int i = 0 ; i < a.length ; i++) 
			ans[i] = Math.max(a[i], b[b.length-1-i]);
		
		return ans;
	}
	
}
