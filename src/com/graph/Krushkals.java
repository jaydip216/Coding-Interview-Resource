package com.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class GraphNode {

	int u, v, weight;

	GraphNode() {
	}

	public GraphNode(int u, int v, int weight) {
		this.u = u;
		this.v = v;
		this.weight = weight;
	}

}

class SortComparator implements Comparator<GraphNode> {

	@Override
	public int compare(GraphNode o1, GraphNode o2) {
		if (o1.weight < o2.weight)
			return -1;
		else if (o1.weight > o2.weight)
			return 1;
		return 0;
	}

}

public class Krushkals {

	public static void main(String[] args) {
		ArrayList<GraphNode> edges = new ArrayList<>();

		edges.add(new GraphNode(0, 1, 5));
		edges.add(new GraphNode(0, 2, 3));
		edges.add(new GraphNode(1, 2, 2));
		edges.add(new GraphNode(1, 3, 6));
		edges.add(new GraphNode(2, 5, 2));
		edges.add(new GraphNode(2, 4, 4));
		edges.add(new GraphNode(2, 3, 7));
		edges.add(new GraphNode(3, 4, 1));
		edges.add(new GraphNode(4, 5, 2));

		krushkals(edges, 6);
	}

	public static int findParent(int[] parent, int u) {
		if (u == parent[u])
			return u;

		return parent[u] = findParent(parent, parent[u]);
	}

	public static void union(int u, int v, int[] rank, int[] parent) {
		u = findParent(parent, u);
		v = findParent(parent, v);
		if (rank[u] < rank[v])
			parent[v] = u;
		else if (rank[u] > rank[v])
			parent[u] = v;
		else {
			parent[u] = v;
			rank[v]++;
		}
	}

	public static void krushkals(ArrayList<GraphNode> edges, int V) {
		Collections.sort(edges, new SortComparator());
		int[] parent = new int[V];
		int[] rank = new int[V];
		ArrayList<GraphNode> mst = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			rank[i] = 0;
			parent[i] = i;
		}

		for (GraphNode edge : edges) {
			int u = findParent(parent, edge.u);
			int v = findParent(parent, edge.v);

			if (u == v)
				continue;
			else {
				mst.add(edge);
				union(edge.u, edge.v, rank, parent);
			}
		}

		System.out.println("List of edges present in MST");
		for (GraphNode edge : mst) {
			System.out.println(edge.u + "---" + edge.v);
		}
	}

}
