package com.dsa.binarySearch;

import java.util.Arrays;

//https://leetcode.com/problems/missing-number/

public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums1[] = { 1, 0, 3, 2, 5 };
		System.out.println(missingNumber(nums1));
	}

	public static int missingNumber(int[] nums) {
		Arrays.sort(nums);
		int high = nums.length, low = 0;
		if (nums[0] != 0)
			return 0;
		if (nums[high - 1] != high)
			return high;
		while (low < high - 1) {
			int mid = (low + high) / 2;
			if (nums[mid] == mid)
				low = mid;
			else
				high = mid;
		}
		return low + 1;
	}

}
