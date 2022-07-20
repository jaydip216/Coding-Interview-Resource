package com.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {

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
		adj.get(3).add(new Node(4, 1));
		adj.get(4).add(new Node(5, 2));

		adj.get(1).add(new Node(0, 5));
		adj.get(2).add(new Node(0, 3));
		adj.get(2).add(new Node(1, 2));
		adj.get(3).add(new Node(1, 6));
		adj.get(5).add(new Node(2, 2));
		adj.get(4).add(new Node(2, 4));
		adj.get(3).add(new Node(2, 7));
		adj.get(4).add(new Node(3, 1));
		adj.get(5).add(new Node(4, 2));

		prims(adj);
	}

	public static void prims(ArrayList<ArrayList<Node>> adj) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>(adj.size(), new Node());
		pq.add(new Node(0, 0));
		int[] key = new int[adj.size()];
		int[] parent = new int[adj.size()];
		boolean[] mst = new boolean[adj.size()];
		for (int i = 0; i < adj.size(); i++) {
			key[i] = 10000;
			parent[i] = -1;
		}
		key[0] = 0;
		parent[0] = -1;
		while (!pq.isEmpty()) {
			Node front = pq.poll();
			mst[front.v] = true;
			for (Node nbr : adj.get(front.v)) {
				if (!mst[nbr.v] && nbr.weight < key[nbr.v]) {
					key[nbr.v] = nbr.weight;
					parent[nbr.v] = front.v;
					pq.add(new Node(nbr.v, key[nbr.v]));
				}
			}
		}

		System.out.println("List of edges present in MST");
		for (int i = 1; i < adj.size(); i++) {
			System.out.println(parent[i] + "---" + i);
		}
	}

}
