package basicAlgorithms;

import java.util.Arrays;


public class SeceretariatProblem {
	/*
	 * This problem can be stated in the following form: 
	 * Imagine an administrator who wants to hire the best secretary out of n rankable applicants for a position. 
	 * The applicants are interviewed one by one in random order. 
	 * A decision about each particular applicant is to be made immediately after the interview. 
	 * Once rejected, an applicant cannot be recalled. 
	 * During the interview, the administrator can rank the applicant among all applicants interviewed so far, 
	 * but is unaware of the quality of yet unseen applicants. 
	 * The question is about the optimal strategy (stopping rule) to maximize the probability of selecting the best applicant.
	 * 
	 * So , we enter the order time in a array, and it well return a new array, with the same number of orders,
	 * that have the arrangment of num of order to do first
	 */
	
	
	public static int [] SeceretariatProblems(int [] arr) {
		int [] ans = new int[arr.length];
		int [] helper = new int[arr.length];
		for(int i = 0 ; i < arr.length ; i++)
			helper[i] = arr[i];
		Arrays.sort(helper);
		
		int[][] insert = new int[2][arr.length];
		for(int i = 0 ; i < arr.length ; i++)
			insert[0][i] = arr[i];
		
		for(int i=0 ; i<helper.length ; i++) 
			for(int j=0 ; j<helper.length ; j++) {
				if(helper[i] == insert[0][j] && insert[1][j] == 0) {
					ans[i] = j+1;
					insert[1][j] = 1;
					break;
				}
			}
		return ans;
	}


		public static void main(String[] args) {
			int [] a = {8 ,13, 6 ,30 ,1 ,9,11};
			int [] b = SeceretariatProblems(a);
			System.out.println(Arrays.toString(b));
	
		}
} 


