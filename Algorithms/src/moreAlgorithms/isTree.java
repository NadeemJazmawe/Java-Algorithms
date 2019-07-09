package moreAlgorithms;

import java.util.ArrayList;

public class isTree {

	public static int NumOfEdges(ArrayList<Integer>[] graph) {
		int sum=0;
		for (int i = 0; i < graph.length; i++) {
			sum+=graph[i].size();
		}
		return sum/2;
	}
	public static boolean isTree(ArrayList<Integer>[] graph){
		BFS tree= new BFS(graph);
		int numofEdges=NumOfEdges(graph);
		if(numofEdges!=graph.length-1) {
			return false;
		}
		if(!tree.isConnected()) {
			return false;
		}
		return true;
	}
	
}
