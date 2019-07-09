package moreAlgorithms;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class NumOfShortestPath {

	public static int[] numOfShortestPaths(ArrayList<Integer> graph[], int source) {
		final int WHITE=1, GRAY=2,  BLACK=3, NIL = -1;
		int size = graph.length;
		Queue<Integer> q = new ArrayBlockingQueue<Integer>(size);
		int dist[] = new int[size];
		int pred[] = new int[size];
		int color[] = new int[size];
		int paths[] = new int[size];
		/// initialization
		for (int i = 0; i < size; i++) {
			dist[i] = NIL;
			pred[i] = NIL;
			color[i] = WHITE;
			paths[i] = 0;
		}
		dist[source] = 0;
		color[source] = GRAY;
		paths[source] = 1;
		q.add(source);

		///// calculations
		while(!q.isEmpty()){
			int u = q.poll();//Retrieves and removes the head of this queue, or returns null if this queue is empty
			for(int v : graph[u]){
				if (color[v] == WHITE){
					dist[v] = dist[u]+1;
					pred[v] = u;
					color[v] = GRAY;
					q.add(v);
				} else {
					if (dist[v]==dist[u] - 1){
						paths[u] = paths[u] + paths[v];
					}
				}
			}
			color[u] = BLACK;
		}	
		return paths;
	}
}
