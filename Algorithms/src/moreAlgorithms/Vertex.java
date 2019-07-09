package moreAlgorithms;

public class Vertex{
	
    int weight;// the weight of the vertex for adjacency table 
    int vertex; // the vertex number
		
    public Vertex(int v, int weight){
	this.weight = weight;
	this.vertex = v;
    }
		
    public Vertex(){
	this.weight = 0;
	this.vertex = -1;
    }
		
    public Vertex(Vertex node) {
	this(node.vertex, node.weight);
    }
		
    public String toString(){
	return "(" + vertex+ ", w: " + weight + ")";
    }
}
