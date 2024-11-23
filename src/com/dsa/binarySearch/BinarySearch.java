package com.dsa.binarySearch;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = { -9, -4, -1, 0, 3, 7, 9, 12, 45 };
		System.out.println(binarySearch(arr, 12));
	}

	public static int binarySearch(int[] arr, int target) {
		int low = 0, high = arr.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == target)
				return mid;
			else if (arr[mid] > target)
				high = mid - 1;
			else
				low = mid + 1;
		}

		return -1;
	}
}
