package moreAlgorithms;

public class bestInteval {

	public static int[] bestInterval(int[] a){
		int i=0, ans[] = null;
		while (i<a.length && a[i]<=0) 
		{i++;}
		if (i == a.length){// a[i]<=0, i=1,...,a.length
			int maxIndex = 0;
			for (int j=1; j<a.length; j++){
				if (a[j] > a[maxIndex]) 
					maxIndex = j;
			}
			ans = new int[1];
			ans[0] = a[maxIndex];
		} else {
			int  endMax = i+1, count = 0, countMax = 1, bestCount = 1;
			double maxSum=a[i], sum = 0;
			while(i<a.length){
				sum = sum + a[i];
				count++;
				if (sum <= 0){
					sum = 0;
					count = 0;
				} else if (sum > maxSum){
					maxSum = sum;
					countMax = count;
					bestCount = countMax;
					endMax = i+1;
				} else if(sum == maxSum){
					if (count < bestCount){
						bestCount = count;
						endMax = i+1;
					}
				}
				i++;
			}
			ans = new int[bestCount];
			int start = endMax - bestCount;
			for (int j = 0; j < bestCount; j++) {
				ans[j] = a[start+j];
			}
		}
		return ans;
	}

}
