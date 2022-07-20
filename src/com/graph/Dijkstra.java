package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {

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

		System.out.println("shortest path from src to all nodes dijkstra : " + Arrays.toString(dijkstras(0, adj)));
	}

	public static int[] dijkstras(int src, ArrayList<ArrayList<Node>> adj) {
		int[] dist = new int[adj.size()];
		for (int i = 0; i < adj.size(); i++)
			dist[i] = 10000;
		PriorityQueue<Node> pq = new PriorityQueue<Node>(adj.size(), new Node());
		pq.add(new Node(src, 0));
		dist[src] = 0;
		while (!pq.isEmpty()) {
			Node front = pq.poll();
			for (Node nbr : adj.get(front.v)) {
				if (dist[front.v] + nbr.weight < dist[nbr.v]) {
					dist[nbr.v] = dist[front.v] + nbr.weight;
					pq.add(new Node(nbr.v, dist[nbr.v]));
				}
			}
		}
		return dist;
	}
}
