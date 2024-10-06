package com.patterns.twoPointers;

import java.util.Arrays;

/*
 * Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.
 * Example 1:
 * Input: [-2, -1, 0, 2, 3]
 * Output: [0, 1, 4, 4, 9]
 */

public class SquaringSortedArray {
    
    public static void main(String[] args) {
        int[] arr = new int[]{-2, -1, 0, 2, 3};
        System.out.println(Arrays.toString(solve(arr)));
    }

    private static int[] solve(int[] arr){
        int[] answer = new int[arr.length];
        int n=arr.length-1;
        int left=0,right=arr.length-1;
        while (left<=right) {
            int leftSquare = arr[left]*arr[left];
            int rightSquare = arr[right]*arr[right];
            if(leftSquare>rightSquare){
                answer[n--]=leftSquare;
                left++;
            }else{
                answer[n--]=rightSquare;
                right--;
            }
        }
        return answer;
    }
}
