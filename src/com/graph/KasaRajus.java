package com.graph;

import java.util.ArrayList;
import java.util.Stack;

public class KasaRajus {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(1);
		adj.get(1).add(4);
		adj.get(4).add(0);
		adj.get(1).add(2);
		adj.get(2).add(3);
		adj.get(3).add(2);

		kasaraju(adj);
	}

	public static void dfsTopo(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st) {
		visited[node] = true;
		for (Integer ngbr : adj.get(node)) {
			if (!visited[ngbr])
				dfsTopo(ngbr, adj, visited, st);
		}
		st.push(node);
	}

	public static void dfs(ArrayList<ArrayList<Integer>> transpose, int node, boolean[] visited) {
		visited[node] = true;
		for (Integer nbr : transpose.get(node)) {
			if (!visited[nbr])
				dfs(transpose, nbr, visited);
		}
	}

	public static void kasaraju(ArrayList<ArrayList<Integer>> adj) {
		boolean visited[] = new boolean[adj.size()];
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < adj.size(); i++) {
			if (!visited[i])
				dfsTopo(i, adj, visited, st);
		}
		ArrayList<ArrayList<Integer>> transpose = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < adj.size(); i++) {
			transpose.add(new ArrayList<Integer>());
			visited[i] = false;
		}

		for (int i = 0; i < adj.size(); i++)
			for (Integer node : adj.get(i))
				transpose.get(node).add(i);

		int count = 0;
		while (!st.isEmpty()) {
			int top = st.pop();
			if (!visited[top]) {
				count++;
				dfs(transpose, top, visited);
			}
		}
		System.out.println("Total number of strongly connected components = " + count);
	}

}
