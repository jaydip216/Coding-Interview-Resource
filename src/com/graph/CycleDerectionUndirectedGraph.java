package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDerectionUndirectedGraph {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(1);
		adj.get(1).add(0);
		adj.get(0).add(2);
		adj.get(2).add(0);
		adj.get(0).add(3);
		adj.get(3).add(0);
		adj.get(2).add(4);
		adj.get(4).add(2);
		adj.get(4).add(1);
		adj.get(1).add(4);

		System.out.println("cycle detected : " + isCycle(5, adj));

	}

	private static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				// boolean cycle=cycleBfs(i, adj, visited);
				boolean cycle = cycleDfs(i, -1, adj, visited);
				if (cycle)
					return true;
			}
		}
		return false;
	}

	private static boolean cycleBfs(int V, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		int[] parent = new int[adj.size()];
		Arrays.fill(parent, -1);
		q.add(V);
		visited[V] = true;
		while (!q.isEmpty()) {
			int front = q.poll();

			for (Integer node : adj.get(front)) {
				if (!visited[node]) {
					visited[node] = true;
					q.add(node);
					parent[node] = front;
				} else if (parent[front] != node) {
					return true;
				}
			}
		}
		return false;

	}

	private static boolean cycleDfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
		visited[node] = true;

		for (Integer it : adj.get(node)) {
			if (!visited[it]) {
				boolean cycle = cycleDfs(it, node, adj, visited);
				if (cycle)
					return true;
			} else if (parent != it) {
				return true;
			}
		}
		return false;
	}

}
