package com.dsa.array;

import java.util.*;

public class MinWatchScore {
    public static int findMinWatchScore(int[] watchHistory, int series1, int series2) {
        int n = watchHistory.length;
        int minScore = Integer.MAX_VALUE;
        int left = 0;

        // Track the counts of series1 and series2
        Map<Integer, Integer> seriesCount = new HashMap<>();
        seriesCount.put(series1, 0);
        seriesCount.put(series2, 0);

        // Track distinct series in the current window
        Set<Integer> distinctSeries = new HashSet<>();

        for (int right = 0; right < n; right++) {
            int current = watchHistory[right];
            distinctSeries.add(current);

            // Update the series count
            if (current == series1) {
                seriesCount.put(series1, seriesCount.get(series1) + 1);
            }
            if (current == series2) {
                seriesCount.put(series2, seriesCount.get(series2) + 1);
            }

            // Shrink the window when the condition is met
            while (seriesCount.get(series1) > 0 && seriesCount.get(series2) > 0) {
                // Calculate the score (size of distinct series)
                minScore = Math.min(minScore, distinctSeries.size());

                // Shrink the window from the left
                int leftSeries = watchHistory[left];
                if (leftSeries == series1) {
                    seriesCount.put(series1, seriesCount.get(series1) - 1);
                }
                if (leftSeries == series2) {
                    seriesCount.put(series2, seriesCount.get(series2) - 1);
                }

                // Remove from distinct set if count drops to 0
                if (!seriesCount.containsKey(leftSeries) || seriesCount.get(leftSeries) == 0) {
                    distinctSeries.remove(leftSeries);
                }

                left++;
            }
        }

        return minScore == Integer.MAX_VALUE ? -1 : minScore;
    }

    public static void main(String[] args) {
        int[] watchHistory = {1, 2, 3, 5, 1};
        int series1 = 5;
        int series2 = 5;

        int result = findMinWatchScore(watchHistory, series1, series2);
        System.out.println("Minimum Watch Score: " + result); // Expected output: 2
    }
}
