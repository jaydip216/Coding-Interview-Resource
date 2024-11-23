package com.dsa.binarySearch;

// https://leetcode.com/problems/single-element-in-a-sorted-array/

public class SingleElementInSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
		System.out.println(singleNonDuplicate(nums));
	}

	public static int singleNonDuplicate(int[] nums) {
		int low = 0, high = nums.length - 1;

		while (low < high) {
			int mid = (high - low) / 2 + low; // avoid max integer size exception

			if (nums[mid] == nums[mid + 1])
				mid = mid - 1;

			if ((mid - low + 1) % 2 == 0)
				low = mid + 1;
			else
				high = mid;
		}
		return nums[low];
	}

}
