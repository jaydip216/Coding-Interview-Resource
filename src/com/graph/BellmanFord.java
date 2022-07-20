package com.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {

	public static void main(String[] args) {
		ArrayList<GraphNode> edges = new ArrayList<>();

		edges.add(new GraphNode(0, 1, 5));
		edges.add(new GraphNode(0, 2, 3));
		edges.add(new GraphNode(1, 2, 2));
		edges.add(new GraphNode(1, 3, 6));
		edges.add(new GraphNode(2, 5, 2));
		edges.add(new GraphNode(2, 4, 4));
		edges.add(new GraphNode(2, 3, 7));
		edges.add(new GraphNode(3, 4, -1));
		edges.add(new GraphNode(4, 5, -4));
		//edges.add(new GraphNode(5, 4, 2));
		
		bellmanFord(edges,6);
		
	}
	
	public static void bellmanFord(ArrayList<GraphNode> edges,int N) {
		int [] dist=new int[N];
		for(int i=0;i<N;i++) dist[i]=10000;
		dist[0]=0;
		for(int i=1;i<N;i++) {
			for(GraphNode edge:edges) {
				int u=edge.u;
				int v=edge.v;
				int weight=edge.weight;
				if(dist[u]+weight<dist[v]) {
					dist[v]=dist[u]+weight;
				}
			}
		}
		
		for(GraphNode edge:edges) {
			int u=edge.u;
			int v=edge.v;
			int weight=edge.weight;
			if(dist[u]+weight<dist[v]) {
				System.out.println("Negative cycle detected");
				return;
			}
		}
		
		System.out.println("Shortest path from 0 to all nodes using ballmanFord algo :" + Arrays.toString(dist));
	}

}
