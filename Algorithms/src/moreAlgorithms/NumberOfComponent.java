package moreAlgorithms;

import java.util.ArrayList;

public class NumberOfComponent {
	public static int NumberOfComponents(boolean[][] T) {
		int size = T.length;
		ArrayList<Integer> Seen = new ArrayList<Integer>();
		ArrayList<Integer> UnSeen = new ArrayList<Integer>();
		for (int i = 0; i < T.length; i++) {
			UnSeen.add(i);
		}

		int counter = 0;
		while (UnSeen.isEmpty() == false) {
			int vertex = UnSeen.get(0);
			counter++;
			for (int j = 0; j < size; j++) {
				if (T[vertex][j]==true)
				{
					Seen.add(j);
				}
			}
			UnSeen = Substract(UnSeen, Seen);
		}
		return counter;
	}
	private static ArrayList<Integer> Substract(ArrayList<Integer> UnSeen, ArrayList<Integer> Seen) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < UnSeen.size(); i++) {
			if (Seen.contains(UnSeen.get(i)) == false)
			{
				ans.add(UnSeen.get(i));
			}
		}
		return ans;
	}

}
