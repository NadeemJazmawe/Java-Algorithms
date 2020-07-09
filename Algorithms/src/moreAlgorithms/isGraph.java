package moreAlgorithms;

public class isGraph {
	public static boolean isGraph(int[] degrees){
		boolean ans = true;
		int sumDeg = 0;
		for (int i = 0; i < degrees.length; i++) {
			sumDeg = sumDeg + degrees[i];
		}
		if (sumDeg%2 == 1) 
			ans = false;
		for (int k=0; ans && k<degrees.length; k++){
			int sumLeft = 0;
			for (int i = 0; i <= k; i++) {
				sumLeft = sumLeft + degrees[i];
			}
			int sumRight = k*(k+1);
			for (int i = k+1; i<degrees.length; i++) {
				sumRight = sumRight + Math.min(k+1, degrees[i]);
			}
			if(sumLeft > sumRight) 
				ans = false;
		}
		return ans;
	}
}
