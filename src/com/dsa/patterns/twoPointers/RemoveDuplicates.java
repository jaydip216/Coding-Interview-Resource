package com.dsa.patterns.twoPointers;


/*
 * Given an array of sorted numbers, remove all duplicates from it. 
 * You should not use any extra space; after removing the duplicates in-place return the new length of the array.
 */
public class RemoveDuplicates {
    
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,3,3,6,9,9};
        int size = solve(arr);
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static int solve(final int[] arr){
        int nextNonDuplicate = 1;
        for(int i=1;i<arr.length;i++){
            if(arr[nextNonDuplicate-1]!=arr[i]){
                arr[nextNonDuplicate]=arr[i];
                nextNonDuplicate++;
            }
        }
        return nextNonDuplicate;
    }
}
