package moreAlgorithms;

public class bestCycleReturnedTheSubarray {
	
	public static int[] best(int[] a){
		int i=0;
		while (i<a.length && a[i]<=0) 
			i++;
		if (i == a.length){
			int index = 0;
			for (int j=0; j<a.length; j++){
				if (a[j] > a[index]) 
					index = j;
			}
			int[]ans = {index, index+1, 1, a[index]};
			return ans;
		} else {
			int sum=0, maxSum=a[i], beginMax = i, endMax = i+1, count = 0, countMax = 1;
			while(i<a.length){
				sum = sum + a[i];
				count++;
				if (sum < 0){
					sum = 0;
					count = 0;
				} else if (sum > maxSum){
					maxSum = sum;
					endMax = i+1;
					countMax = count;
				}
				i++;
			}
			beginMax = endMax - countMax;
			int[]ans = {beginMax, endMax, countMax, maxSum};
			return ans;
		}
	}

	public static int[] bestCycle(int[] a){
		int[] ans1 = best(a);
		int sum1 = ans1[3];
		if (sum1<0)
			return ans1;
		int t[] = new int[a.length];
		int sumA = 0;
		for (int i = 0; i < t.length; i++) {
			sumA = sumA + a[i];
			t[i] = -a[i];
		}
		int[] ans2 = best(t);
		int sum2 = sumA + ans2[3];
		if (sum1 >= sum2){
			return ans1;
		} else{
			int ans[] = {ans2[1], ans2[0], a.length-ans2[2], sum2};
			printBestCycle(a, ans);
			return ans;
		}
	}


	public static void printBestCycle(int[]a ,int[] res){
		int beginMax=res[0], endMax = res[1], countmax = res[2], sumMax = res[3];
		System.out.print("sub array cycle best: ");
		for (int i = 0; i < countmax; i++) {
			System.out.print(a[(beginMax+i)%a.length] + ", ");
		}
		System.out.println();
	}




}
