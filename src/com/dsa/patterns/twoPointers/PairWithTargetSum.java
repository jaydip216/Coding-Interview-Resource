package com.dsa.patterns.twoPointers;


/*
 * Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
 * 
 */
public class PairWithTargetSum {
    
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,6};
        int[] answer = solve(arr, 6);
        System.out.println(answer[0]+","+answer[1]);
    }

    public static int[] solve(int[] arr, int sum) {
        int[] answer = new int[2];
        int left=0, right=arr.length-1;
        while (left<right) {
            int currentSum = arr[left] + arr[right];

            if(currentSum == sum){
                answer[0]=left;
                answer[1]=right;
                break;
            }

            if(currentSum>sum)
                right--;
            else
                left++;
        }
        return answer;
    }
}
