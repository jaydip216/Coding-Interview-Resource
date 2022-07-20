package com.sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 8, 3, 6, 5, 2, 9, 4 };
		mergeSort(arr, 0, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int[] arr, int left, int right) {
		if (right - left == 1) {
			return;
		}
		int mid = (left + right) / 2;
		mergeSort(arr, left, mid);
		mergeSort(arr, mid, right);

		merge(arr, left, mid, right);
	}

	private static void merge(int[] arr, int left, int mid, int right) {
		int i = left, j = mid, k = 0, len1 = mid, len2 = right;
		int[] res = new int[right - left];
		while (i < len1 && j < len2) {
			if (arr[i] < arr[j]) {
				res[k++] = arr[i++];
			} else {
				res[k++] = arr[j++];
			}
		}
		while (j < len2) {
			res[k++] = arr[j++];
		}
		while (i < len1) {
			res[k++] = arr[i++];
		}

		for (int l = 0; l < res.length; l++) {
			arr[left + l] = res[l];
		}
	}

}
