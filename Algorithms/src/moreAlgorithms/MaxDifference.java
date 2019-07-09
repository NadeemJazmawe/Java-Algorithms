package moreAlgorithms;

public class MaxDifference {

	
	public static int MaxDifference1(int[]a) {
		int n=a.length;
		int maxdiff=a[1]-a[0];
		int min=a[0];
		for (int i = 1;i<n;i++) {
			if(a[i]-min>maxdiff) {
				maxdiff=a[i]-min;
			}
			if(a[i]<min) {
				min=a[i];
			}
		}
		return maxdiff;
	}

	public static int[] MaxDifference2(int[]a) {
		int [] arr=new int[2];
		int n=a.length;
		int maxdiff=a[1]-a[0];
		int min=a[0];
		for (int i = 0;i<n;i++) {
			if(a[i]-min>maxdiff) {
				maxdiff=a[i]-min;
				arr[0]=a[i];
				arr[1]=min;
			}
			if(a[i]<min) {
				min=a[i];
			}
		}
		return arr;
	}

}
