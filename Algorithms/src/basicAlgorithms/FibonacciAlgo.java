package basicAlgorithms;

public class FibonacciAlgo {

	/*
	 * Calculating fibonacci numbers with loop and recursive methods.
	 * both run with O(logn) => n is the fibonacci num
	 */
	
	public static int fibLoop(int n) { //O(log(n))
		if (n==1 || n==2)
			return 1;
		n = n-2;
		int mat[][] = {{1,1},{1,0}};
		int result[][] = {{1,1},{1,0}};
		while (n != 0) {
			if ( (n % 2) != 0 )
				result = matrixSq2Multi(result, mat);
			mat = matrixSq2Multi(mat, mat);
			n = n/2;
		}
		return result[0][0];
	}

	private static int[][] matrixSq2Multi(int[][] m1, int m2[][]){//O(1)
		int[][]ans = new int [2][2];
		ans[0][0] = m1[0][0]*m2[0][0] + m1[0][1]*m2[1][0];
		ans[0][1] = m1[0][0]*m2[0][1] + m1[0][1]*m2[1][1];
		ans[1][0] = m1[1][0]*m2[0][0] + m1[1][1]*m2[1][0];
		ans[1][1] = m1[1][0]*m2[0][1] + m1[1][1]*m2[1][1];
		return ans;
	}

	public static int fibRecursion(int n) {//O(log(n))
		int [][] mat={{1,1}, {1,0}};
		int [][] ans = fibRecursion(mat, n-1);
		return ans[0][0];
	}	

	private static  int[][] fibRecursion(int mat[][], int n){
		int [][] A={{1,0}, {0,1}};
		if ( n == 0) 
			return A;
		else if (n%2 == 0)
			return fibRecursion(matrixSq2Multi(mat,mat),n/2);
		else
			return matrixSq2Multi(mat,fibRecursion(matrixSq2Multi(mat,mat),(n - 1)/2));
	}		

}
