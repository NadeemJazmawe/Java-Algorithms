package moreAlgorithms;

public class MaxSumOfKSubarray {

	public static int maxsumofksubarray(int [] a,int k) {
		int max=0;
		int [] b=new int[a.length];
		int [] c=new int[a.length];
		b[1]=a[1];
		for (int i = 2; i < a.length; i++) {
			b[i]=a[i]+b[i-1];
		}
		for (int i = 1; i < k; i++) {
			c[i]=b[i];
			if(c[i]<max) {
				max=c[i];
			}
		}
		for (int i = k+1; i < a.length; i++) {
			c[i]=b[i]-b[i-k];
			if(c[i]>max) {
				max=c[i];
			}
			
		}
		return max;
	}
}
