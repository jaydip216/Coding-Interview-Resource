package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPath {

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

		shortestPath(0, 4, adj);

	}

	public static void shortestPath(int src, int dest, ArrayList<ArrayList<Integer>> adj) {
		List<Integer> result = new ArrayList<>();

		int[] parent = new int[adj.size()];
		Arrays.fill(parent, -1);
		boolean[] visited = new boolean[adj.size()];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(src);
		while (!q.isEmpty()) {
			int front = q.poll();
			for (Integer node : adj.get(front)) {
				if (!visited[node]) {
					parent[node] = front;
					visited[node] = true;
					q.add(node);
				}
			}
		}
		while (src != dest) {
			result.add(dest);
			dest = parent[dest];
		}
		result.add(src);
		Collections.reverse(result);
		System.out.println(result);
	}

}
