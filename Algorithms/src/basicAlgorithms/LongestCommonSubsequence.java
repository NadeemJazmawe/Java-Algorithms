package basicAlgorithms;

public class LongestCommonSubsequence {
	/*
	 * In this algorithm all the function acccepts to strings , 
	 * and it calculate and return the longest string in both .
	 * LCS3 is the best algo.
	 */

	public static String LCS1(String a , String b) {//O(a.length * a.length * b.length)
		String ans = "";
		for(int i = 0 ; i < a.length() ; i++) {
			for(int j = i+1 ; j <= a.length() ; j++) {
				String helper = a.substring(i , j);
				if(b.contains(helper) && helper.length() > ans.length())
					ans = helper;
			}
		}
		return ans;
	}

	public static String LCS2(String a , String b) {//O(a.length * b.length)
		String ans = "";
		int start = 0 , index = 0 , i = 0;
		int m = a.length() , n = b.length();
		while(i < m && index < n) {
			index = b.indexOf(a.charAt(i) , start);
			if(index != -1) {
				ans = ans + a.charAt(i);
				start = index + 1;
			}
			i++;
		}
		return ans;
	}

	public static String LCS3(String a , String b) {//O(a.length + b.length) = O(min(a.length , b.length))
		int [] help = new int [26];
		int m = a.length(), n = b.length();
		for (int i = 0 ; i < a.length() ; i++) { //O(min(m,n))
			int place = a.charAt(i)-'a';
			help[place]++;
		}
		String ans = "";
		int start = 0, index = 0, i = 0 ;
		while (i<n && index<m) {//O(m+n)
			int place = b.charAt(i) - 'a';
			if (help[place] > 0) {
				index = a.indexOf(b.charAt(i), start);
				if (index != -1) {
					ans = ans + b.charAt(i);
					start = index+1;
					help[place]--;
				}
				else 
					help[place] = 0;
			}
			i++;
		}
		return ans;
	}

}
