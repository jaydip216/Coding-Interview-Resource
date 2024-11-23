package com.dsa.binarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/intersection-of-two-arrays/

public class InterSectionOfTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums1[] = { 4, 9, 5 };
		int nums2[] = { 9, 4, 9, 8, 4 };

		System.out.println(Arrays.toString(intersection(nums1, nums2)));

	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<Integer>();
		Arrays.sort(nums2);
		for (Integer num : nums1) {
			if (binarySearch(nums2, num))
				set.add(num);
		}
		int result[] = new int[set.size()];
		int i = 0;
		for (Integer num : set) {
			result[i++] = num;
		}
		return result;
	}

	public static boolean binarySearch(int[] arr, int target) {
		int low = 0, high = arr.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == target)
				return true;
			else if (arr[mid] > target)
				high = mid - 1;
			else
				low = mid + 1;
		}

		return false;
	}

}
