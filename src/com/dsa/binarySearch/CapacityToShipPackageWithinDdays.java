package com.dsa.binarySearch;

// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

public class CapacityToShipPackageWithinDdays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(shipWithinDays(weights, 5));
	}

	public static int shipWithinDays(int[] weights, int days) {
		int sumWeight = 0, maxWeight = weights[0];
		for (Integer weight : weights) {
			sumWeight += weight;
			maxWeight = Math.max(weight, maxWeight);
		}
		int low = maxWeight, high = sumWeight;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (isValid(weights, mid, days))
				high = mid - 1;
			else
				low = mid + 1;
		}
		return low;
	}

	public static boolean isValid(int[] weights, int capacity, int days) {
		int dayNeed = 0;
		int dayWeightSum = 0;
		for (Integer weight : weights) {
			dayWeightSum += weight;
			if (dayWeightSum > capacity) {
				dayNeed++;
				dayWeightSum = weight;
			}
		}
		if (dayWeightSum > 0)
			dayNeed++;
		if (dayNeed > days)
			return false;
		else
			return true;
	}

}
