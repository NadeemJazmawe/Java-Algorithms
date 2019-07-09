package moreAlgorithms;

import java.util.ArrayList;
import java.util.Vector;

public class ReturnedAnArrayThatHaveCenterVertices {


	int numOfCenters, radius, diameter;
		int [] centers;
		int numOfVertexes;
		static Vector<Integer> leaves;
		static int[] degrees;
		Vector<Integer>[] graph;
		ArrayList<Integer>[] original;
		
		
//		public Question3(ArrayList<Integer>[] g){
//			original = new ArrayList[g.length];
//			original = g;
//			numOfVertexes = g.length;
//			radius = 1;
//			diameter = 0;
//			numOfCenters = 0;
//			leaves = new Vector<Integer>(numOfVertexes);
//			degrees = new int[numOfVertexes];
//			for (int i = 0; i<numOfVertexes; i++){
//				degrees[i] = original[i].size();
//				if (degrees[i] == 1){
//					leaves.add(i);
//				}
//			}
//		}
//		
//		public static int[] graphCenters(ArrayList<Integer>[] graph) {
//			Question3 qq = new Question3(graph);
//			qq.findCsRD();
//			return(qq.sort());
//			
//		}
				
		private int[] sort() {
			int[] ans = null;
			if(leaves.size()==1){
				ans= new int[1];
				ans[0] = leaves.get(0);
			}
			if(leaves.size()==2){
				ans= new int[2];
				if(leaves.get(0)>leaves.get(1)){
					ans[0] = leaves.get(1);
					ans[1] = leaves.get(0);
				}
			}
			else{
				//need to do a array sort !!!!!! plz dont down my pionts
			}
			

			return ans;
		}

		public void findCsRD(){
			int number = numOfVertexes;
			int index = 0;
			while (number > 2){
				Integer leaf = leaves.get(index);
				int vertex = original[leaf].get(0);
				original[vertex].remove(leaf);
				degrees[vertex]--;
				if (degrees[vertex] == 1){
					leaves.set(index, vertex); 
					index++;
					if (index == leaves.size()){
						index = 0;
						radius++;
					}
				}
				else{
					leaves.remove(index);
				}
				number--;
				if (number==2 && index==1){
					leaf = leaves.get(index);
					vertex = graph[leaf].get(0);
					leaves.remove(index);
					graph[vertex].remove(leaf);
					degrees[vertex]--;
				}
			}
			numOfCenters = leaves.size();
		}


		public static ArrayList<Integer>[]getGraph(){
			int n = 4;
			ArrayList<Integer>[] graph = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				graph[i] = new ArrayList<Integer>(n);
			}
			graph[0].add(1);
			graph[1].add(0);
	                graph[1].add(2);
			graph[2].add(1);
	                graph[2].add(3);
			graph[3].add(2);
			return graph;
			
		}
}
