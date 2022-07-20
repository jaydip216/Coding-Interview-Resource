package com.sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 8, 3, 6, 5, 2, 9, 4 };
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] arr,int low,int high) {
		if(low>=high) {
			return;
		}
		
		int start=low,end=high,mid=(low+high)/2;
		int pivot=arr[mid];
		
		while(start<=end) {
			while(arr[start]<pivot) {
				start++;
			}
			while(arr[end]>pivot) {
				end--;
			}
			if(start<=end) {
				int temp=arr[end];
				arr[end]=arr[start];
				arr[start]=temp;
				start++;
				end--;
			}
		}
		
		quickSort(arr, low, end);
		quickSort(arr, start, high);
	}
}
