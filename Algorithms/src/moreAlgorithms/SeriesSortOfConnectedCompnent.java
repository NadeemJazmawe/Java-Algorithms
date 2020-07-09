package moreAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class SeriesSortOfConnectedCompnent {

	private final static int infinity = -1;
	public static int bfs(ArrayList<Integer>[] g, int[]dist, int s){
		int lenComp = 1;
		ArrayList<Integer>[]  graph;
		final int WHITE=1, GRAY=2,  BLACK=3, NIL = -1;
		//size - number of vertexes
		int size = g.length;
		// initialization
		Queue<Integer> q = new ArrayBlockingQueue<Integer>(size);
		int pred[], color[];
		pred = new int[size];
		color = new int[size];
		graph = new ArrayList[size];
		for (int i=0; i<size; i++){
			graph[i] = new ArrayList<Integer>(g[i]);
			pred[i] = NIL;
			color[i] = WHITE;
		}
		color[s] = GRAY;
		dist[s] = 0;
		pred[s] = NIL;
		q.add(s);
		// bfs
		while (!q.isEmpty()){
			int u = q.poll();
			for (int i=0; i<graph[u].size(); i++){
				int v = graph[u].get(i);
				if (color[v] == WHITE){
					color[v] = GRAY;
					dist[v] = dist[u] + 1;
					pred[v] = u;
					q.add(v);
					lenComp++;
				}
			}
			color[u] = BLACK;
		}
		return lenComp;
	}

	public static int[] connectedComponents(ArrayList<Integer>[] graph){
		int s = 0, count = 0, sumLen = 0;;
		int temp[] = new int[graph.length] ;
		int[] dist = new int[graph.length] ;
		for (int k=0; k<dist.length; k++){
			dist[k] = infinity;
		}
		boolean ans = true;
		while (sumLen < dist.length){
			int lenComp = bfs(graph, dist, s);
			sumLen = sumLen + lenComp;
			int k = 0;
			while (k<dist.length && dist[k]!=infinity) 
				k++;
			if (k < dist.length) s = k;
			temp[count++] = lenComp;
		}
		int result[] = new int[count];
		for (int j=0; j<count; j++){
			result[j] = temp[j];
		}
		Arrays.sort(result);
		return result;
	}

}
