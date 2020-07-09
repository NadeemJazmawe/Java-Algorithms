package moreAlgorithms;

public class bestShortestSubIntervalLength {

	public static int bestShortestSubInterval(int[] a){
		int i=0;
		while (i<a.length && a[i]<=0) {i++;}
		if (i == a.length){// a[i]<=0, i=1,...,a.length
			return 1;
		}
		else{
			int  endMax = i+1, count = 0, countMax = 1, bestCount = 1;
			double maxSum=a[i], sum = 0;
			while(i<a.length){
				sum = sum + a[i];
				count++;
				if (sum <= 0){
					sum = 0;
					count = 0;
				}
				else if (sum > maxSum){
					maxSum = sum;
					endMax = i+1;
					countMax = count;
					bestCount = countMax;
				}
				else if(sum == maxSum){
					if (count < bestCount){
						bestCount = count;
					}
				}
				i++;
			}
			return bestCount;
		}
	}
}
