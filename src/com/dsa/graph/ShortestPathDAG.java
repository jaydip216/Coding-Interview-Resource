package com.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class Node implements Comparator<Node> {
	int v, weight;

	Node() {
	}

	Node(int v, int weight) {
		this.v = v;
		this.weight = weight;
	}

	@Override
	public int compare(Node o1, Node o2) {
		if (o1.weight < o2.weight)
			return -1;
		else if (o1.weight > o2.weight)
			return 1;
		return 0;
	}
}

public class ShortestPathDAG {

	public static void main(String[] args) {
		ArrayList<ArrayList<Node>> adj = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(new Node(1, 5));
		adj.get(0).add(new Node(2, 3));
		adj.get(1).add(new Node(2, 2));
		adj.get(1).add(new Node(3, 6));
		adj.get(2).add(new Node(5, 2));
		adj.get(2).add(new Node(4, 4));
		adj.get(2).add(new Node(3, 7));
		adj.get(3).add(new Node(4, -1));
		adj.get(4).add(new Node(5, -2));

		System.out.println("shortest path from src to all nodes in DAG : " + Arrays.toString(shortestPath(0, adj)));

	}

	public static int[] shortestPath(int src, ArrayList<ArrayList<Node>> adj) {
		int[] dist = new int[adj.size()];
		boolean visited[] = new boolean[adj.size()];
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < adj.size(); i++) {
			if (!visited[i])
				dfs(i, adj, visited, st);
		}

		for (int i = 0; i < adj.size(); i++)
			dist[i] = 10000;

		dist[src] = 0;
		while (!st.isEmpty()) {
			int top = st.pop();
			if (dist[top] != 10000) {
				for (Node node : adj.get(top)) {
					if (dist[top] + node.weight < dist[node.v]) {
						dist[node.v] = dist[top] + node.weight;
					}
				}
			}
		}
		return dist;
	}

	public static void dfs(int node, ArrayList<ArrayList<Node>> adj, boolean[] visited, Stack<Integer> st) {
		visited[node] = true;
		for (Node ngbr : adj.get(node)) {
			if (!visited[ngbr.v])
				dfs(ngbr.v, adj, visited, st);
		}
		st.push(node);
	}

}
