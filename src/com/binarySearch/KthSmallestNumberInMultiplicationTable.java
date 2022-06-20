package com.binarySearch;

// https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/

public class KthSmallestNumberInMultiplicationTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findKthNumber(3, 4, 10));
	}

	public static int findKthNumber(int m, int n, int k) {
		int low = 1, high = m * n;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (isPossible(m, n, k, mid))
				high = mid;
			else
				low = mid + 1;
		}
		return low;
	}

	public static boolean isPossible(int m, int n, int k, int mid) {
		int count = 0;
		for (int i = 1; i <= m; i++)
			count += Math.min(mid / i, n);
		return count >= k;
	}

}
