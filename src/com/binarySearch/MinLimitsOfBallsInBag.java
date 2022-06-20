package com.binarySearch;

// https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/

public class MinLimitsOfBallsInBag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 2, 4, 8, 2 };
		System.out.println(minimumSize(nums, 4));
	}

	public static int minimumSize(int[] nums, int maxOperations) {
		int minSize = 1, maxSize = 0;
		for (Integer num : nums)
			maxSize = Math.max(num, maxSize);
		int low = minSize, high = maxSize;
		while (low < high) {
			int mid = (low + high) / 2;
			int operations = numberOfOperationRequired(nums, mid);
			if (operations > maxOperations)
				low = mid + 1;
			else
				high = mid;
		}
		return low;
	}

	public static int numberOfOperationRequired(int[] nums, int mid) {
		int operations = 0;
		for (Integer num : nums) {
			operations += (num - 1) / mid;
		}
		return operations;
	}

}
