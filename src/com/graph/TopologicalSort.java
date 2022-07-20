package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(1);
		adj.get(1).add(2);
		adj.get(1).add(5);
		adj.get(2).add(3);
		adj.get(3).add(4);
		adj.get(4).add(5);

		System.out.println("Topological order using dfs: " + Arrays.toString(topoDfs(7, adj)));
		System.out.println("Topological order using bfs(kahn's algo): " + Arrays.toString(topoBfs(adj)));

	}

	private static int[] topoBfs(ArrayList<ArrayList<Integer>> adj) {
		int[] inorder = new int[adj.size()];
		for (int i = 0; i < adj.size(); i++) {
			for (Integer node : adj.get(i)) {
				inorder[node]++;
			}
		}
		// System.out.println(Arrays.toString(inorder));
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == 0)
				q.add(i);
		}
		int[] result = new int[adj.size()];
		int i = 0;
		while (!q.isEmpty()) {
			int front = q.poll();
			result[i++] = front;
			for (Integer node : adj.get(front)) {
				inorder[node]--;
				if (inorder[node] == 0) {
					q.add(node);
				}
			}
		}

		return result;
	}

	public static int[] topoDfs(int V, ArrayList<ArrayList<Integer>> adj) {
		int[] result = new int[V];
		boolean visited[] = new boolean[V];
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < V; i++) {
			if (!visited[i])
				dfs(i, adj, visited, st);
		}
		int i = 0;
		while (!st.isEmpty()) {
			result[i++] = st.pop();
		}
		return result;
	}

	public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st) {
		visited[node] = true;
		for (Integer ngbr : adj.get(node)) {
			if (!visited[ngbr])
				dfs(ngbr, adj, visited, st);
		}
		st.push(node);
	}

}
