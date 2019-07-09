package moreAlgorithms;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class FireTree {

	public static void fire(ArrayList<Integer>[] tree){
		int n = tree.length;
		Queue<Integer> leaves = new ArrayBlockingQueue<>(n);
		int radius = 0, diameter = 0, numCenters = 0;
		int[] degrees = new int[n];
		int[] levels = new int[n];
		// queue initialization, n - number of vertices 
		for (int i = 0; i<n; i++){
			degrees[i] = tree[i].size();
			if (degrees[i] == 1) leaves.add(i);
		}
		int leaf = 0, vertex = 0, maxLevel = 0;
		while (!leaves.isEmpty()){//O(n)
			leaf = leaves.poll();
			degrees[leaf] = 0;
			for (int j=0; j<tree[leaf].size(); j++){
				vertex = tree[leaf].get(j); //O(1)
				if(degrees[vertex] > 0) degrees[vertex]--;
				if(degrees[vertex] == 1) {
					leaves.add(vertex);
					levels[vertex] = levels[leaf] + 1;
					maxLevel = Math.max(maxLevel, levels[vertex]);
				}
			}

		}
		ArrayList<Integer> centers = new ArrayList<>(2);
		for (int i = 0; i < n; i++) {
			if (levels[i] == maxLevel) centers.add(i);
		}
		numCenters = centers.size();
		//diameter = 2*maxLevel + numCenters - 1;
		//radius = (diameter + 1)/2;
		if (numCenters == 2) {
			radius = maxLevel + 1;
			diameter = 2*radius - 1;
		}
		else {
			radius = maxLevel;
			diameter = 2*radius;
		}

		System.out.println("radius = " + radius + ", diameter = " + diameter + ", centers: " + centers); 
		// +", numCenters = "+numCenters); 
		//System.out.println("levels: " + Arrays.toString(levels));
	}
	
}
