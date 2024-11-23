package com.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traversals {

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

		ArrayList<Integer> bfs = bfsOfGraph(5, adj);
		System.out.print("BFS : ");
		printAns(bfs);

		ArrayList<Integer> dfs = dfsOfGraph(5, adj);
		System.out.print("DFS : ");
		printAns(dfs);

	}

	private static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		ArrayList<Integer> ans = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[V];
		q.add(0);
		visited[0] = true;
		ans.add(0);
		while (!q.isEmpty()) {
			int front = q.poll();

			for (Integer node : adj.get(front)) {
				if (!visited[node]) {
					ans.add(node);
					visited[node] = true;
					q.add(node);
				}
			}
		}
		return ans;

	}

	public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		ArrayList<Integer> storeDfs = new ArrayList<>();
		boolean vis[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!vis[i])
				dfs(i, vis, adj, storeDfs);
		}

		return storeDfs;
	}

	public static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> storeDfs) {
		/*
		 * Recursive Approach storeDfs.add(node); vis[node] = true;
		 * 
		 * for(Integer it: adj.get(node)) { if(vis[it] == false) { dfs(it, vis, adj,
		 * storeDfs); } }
		 */
		// Using stack
		Stack<Integer> stack = new Stack<>();
		stack.push(node);
		vis[node] = true;
		while (!stack.isEmpty()) {
			int top = stack.pop();
			storeDfs.add(top);
			for (Integer n : adj.get(top)) {
				if (!vis[n]) {
					vis[n] = true;
					stack.push(n);
				}
			}
		}

	}

	static void printAns(ArrayList<Integer> ans) {
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
		System.out.println();
	}

}
