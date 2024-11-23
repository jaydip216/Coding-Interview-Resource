package com.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionDirectedGraph {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(1);
		adj.get(1).add(2);
		adj.get(1).add(5);
		adj.get(2).add(3);
		adj.get(3).add(4);
		adj.get(4).add(0);
		adj.get(4).add(1);

		System.out.println("cycle detected : " + isCycle(6, adj));
		System.out.println("cycle detected using khans algo : " + cycleBfs(adj));

	}

	private static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean[] visited = new boolean[V];
		boolean[] dfsVisited = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				boolean cycle = cycleDfs(i, adj, visited, dfsVisited);
				if (cycle)
					return true;
			}
		}
		return false;
	}

	private static boolean cycleBfs(ArrayList<ArrayList<Integer>> adj) {
		int[] inorder = new int[adj.size()];
		for (int i = 0; i < adj.size(); i++) {
			for (Integer node : adj.get(i)) {
				inorder[node]++;
			}
		}
		System.out.println(Arrays.toString(inorder));
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == 0)
				q.add(i);
		}
		int count = 0;
		while (!q.isEmpty()) {
			int front = q.poll();
			count += 1;
			for (Integer node : adj.get(front)) {
				inorder[node]--;
				if (inorder[node] == 0) {
					q.add(node);
				}
			}
		}
		if (count == adj.size())
			return false;
		return true;
	}

	private static boolean cycleDfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] dfsVisited) {
		dfsVisited[i] = true;
		visited[i] = true;
		for (Integer node : adj.get(i)) {
			if (!visited[node]) {
				boolean cycle = cycleDfs(node, adj, visited, dfsVisited);
				if (cycle)
					return true;
			} else if (dfsVisited[node])
				return true;
		}
		dfsVisited[i] = false;
		return false;
	}

}
