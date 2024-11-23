package com.dsa.binarySearch;

// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

public class MinimumNumberOfDaysToMakeBouquets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] bloomDay = { 7,7,7,7,12,7,7  };
		System.out.println(minDays(bloomDay, 2, 3));
	}

	public static int minDays(int[] bloomDay, int m, int k) {
		int n = bloomDay.length;
		int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
		if (m * k > n)
			return -1;
		for (Integer day : bloomDay) {
			low = Math.min(low, day);
			high = Math.max(high, day);
		}
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (isPossible(bloomDay, m, k, mid))
				high = mid;
			else
				low = mid + 1;
		}
		return low;
	}

	public static boolean isPossible(int[] bloomDay, int m, int k, int days) {
		int flowers=0;
        for(Integer bloom:bloomDay){
            if(bloom<=days){
                flowers++;
                if(flowers==k){
                    m--;
                    flowers=0;
                }
            }else{
                flowers=0;
            }
        }
        return m<=0;
	}
}
