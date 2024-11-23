package com.dsa.linkedList;

import java.util.HashMap;

// https://leetcode.com/problems/lru-cache/

public class LRUCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cache cache=new Cache(2);
		cache.put(1, 2);
		cache.put(5, 6);
		cache.put(2, 3);
		System.out.println(cache.get(1));
	}

}

class Node {
	int key;
	int val;
	Node next;
	Node prev;

	Node() {
	}

	Node(int key, int val) {
		this.key = key;
		this.val = val;
	}
}

class Cache {

	HashMap<Integer, Node> map = new HashMap<>();
	int capacity;
	Node head = new Node();
	Node tail = new Node();

	public Cache(int capacity) {
		this.capacity = capacity;
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			delete(node);
			insert(node);
			return node.val;
		} else {
			return -1;
		}
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			delete(map.get(key));
		}
		if (map.size() >= capacity) {
			delete(tail.prev);
		}
		insert(new Node(key, value));
	}

	private void insert(Node node) {
		map.put(node.key, node);
		Node nextHead = head.next;
		head.next = node;
		node.prev = head;
		node.next = nextHead;
		nextHead.prev = node;
	}

	private void delete(Node node) {
		map.remove(node.key);
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}
}