package moreAlgorithms;

public class bestAndBestCycle {

	public static int[] best(int[] a){
		int i=0;
		//check if all numbers in a[] are negative
		while (i<a.length && a[i]<=0) {i++;}
		//extreme case: all numbers in a[] are negative 		
		if (i == a.length){
			int index = 0;
			for (int j=0; j<a.length; j++){
				if (a[j] > a[index]) index = j;
			}
			int[]ans = {index, index, 1, a[index]};
			return ans;
		}
		//normal case: not all elements are negative
		else{
			int sum=0, maxSum=a[i], beginMax = i, endMax = i, count = 0, countMax = 1;
			while(i<a.length){
				sum = sum + a[i];
				count++;
				if (sum < 0){
					sum = 0;
					count = 0;
				}
				else if (sum > maxSum){
					maxSum = sum;
					endMax = i;
					countMax = count;
				}
				i++;
			}
			beginMax = endMax + 1 - countMax;
			int[]ans = {beginMax, endMax, countMax, maxSum};
			return ans;
		}
	}
	public static int[] bestCycle(int[] a){
		int[] ans1 = best(a);
		int sum1 = ans1[3]; //max-sum of a sub-interval in the source array
		if (sum1<0){
			return ans1;
		}

		int t[] = new int[a.length]; //an opposite array for the source array
		int sumA = 0; //sum of all elements in the source array
		for (int i = 0; i < t.length; i++) {
			sumA = sumA + a[i];
			t[i] = -a[i];
		}
		int[] ans2 = best(t);
		//System.out.println("-A: " + Arrays.toString(ans2));
		int sum2 = sumA + ans2[3]; //max-sum of a sub-interval in the cycle array

		if (sum1 >= sum2){

			return ans1;
		}
		else{
			int ans[] = {(ans2[1]+1)%a.length, (ans2[0]-1)%a.length, a.length-ans2[2], sum2};
			return ans;
		}
	}

}
