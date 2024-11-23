package com.dsa.patterns.slidingWindow;

/*
 * Given an array containing 0s and 1s, 
 * if you are allowed to replace no more than ‘k’ 0s with 1s, 
 * find the length of the longest contiguous subarray having all 1s.
 * 
 * Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
 * Output: 6
 * Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
 */

public class LongestSubArrayWithOnesAfterReplacement {
    
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        System.out.println(solve(arr, 3));
    }

    public static int solve(int[] arr, int k){
        int answer = 0;
        int start=0,end=0,maxZeros=0;
        while (end<arr.length) {
            if (arr[end]==0) {
                maxZeros++;
            }
            while (maxZeros>k) {
                if(arr[start]==0)
                    maxZeros--;
                start++;
            }
            answer = Math.max(answer, end-start+1);
            end++;
        }
        return answer;
    }
    
}
