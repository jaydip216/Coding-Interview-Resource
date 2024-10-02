package com.patterns.slidingWindow;

/*
 * Given an array of positive numbers and a positive number ‘S’, 
 * find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.
 */

public class SmallestSubarraySum {

    public static void main(String[] args){
        int[] arr = new int[]{3, 4, 1, 1, 6};
        System.out.println(findMinSubArray(arr,8));
    }

    public static int findMinSubArray(int[] arr, int s){
        int answer = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            int sum = arr[i];
            if(sum >= s){
                return 1;
            }
            for(int j=i+1;j<arr.length;j++){
                sum+=arr[j];
                if(sum>=s){
                    answer = Math.min(answer, j-i+1);
                    break;
                }
            }
        }
        return answer;
    }

    public static int findMinSubArray2(int[] arr, int s){
        int answer = Integer.MAX_VALUE;
        int sum = 0;
        int windowStart =0;
        for(int windowEnd=0;windowEnd<arr.length;windowEnd++){
            sum += arr[windowEnd];
            while(sum >= s){
                answer = Math.min(answer, windowEnd-windowStart+1);
                sum -= arr[windowStart];
                windowStart++;
            }
        }
        return answer==Integer.MAX_VALUE?0:answer;
    } 
    
}
