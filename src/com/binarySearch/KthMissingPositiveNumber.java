package com.binarySearch;

// https://leetcode.com/problems/kth-missing-positive-number/

public class KthMissingPositiveNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 3, 4, 9 };
		System.out.println(findKthPositive(arr, 3));
	}
	
	public static int findKthPositive(int[] arr, int k) {
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]-mid-1 < k)
                low=mid+1;
            else
                high=mid-1;
        }
        return low+k;
    }
}
