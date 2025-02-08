package com.dsa.array;

import java.util.*;

public class LexicographicallyLargestSequence {
    public static List<Integer> findLexicographicallyLargest(int[] arr, String state, int m) {
        List<Integer> S = new ArrayList<>();
        int n = arr.length;
        
        // Max-heap to always get the largest available element.
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        
        // Initialize the heap with the available elements.
        for (int i = 0; i < n; i++) {
            if (state.charAt(i) == '1') {
                maxHeap.add(new int[]{arr[i], i}); // Add [value, index]
            }
        }
        
        // Perform m operations
        for (int operation = 0; operation < m; operation++) {
            // Find the maximum available element
            if (maxHeap.isEmpty()) break;

            int[] maxElement = maxHeap.poll();  // Get the largest available element
            int maxVal = maxElement[0];
            int maxIdx = maxElement[1];

            // Add this element to the result
            S.add(maxVal);

            // Mark newly available elements based on the updated state
            if (maxIdx + 1 < n && state.charAt(maxIdx + 1) == '0') {
                state = state.substring(0, maxIdx + 1) + '1' + state.substring(maxIdx + 2);  // Update state
                maxHeap.add(new int[]{arr[maxIdx + 1], maxIdx + 1});
            }
        }
        
        return S;
    }

    public static void main(String[] args) {
        // Example
        int[] arr = {4, 9, 1, 2, 10};
        String state = "10100";
        int m = 4;

        List<Integer> result = findLexicographicallyLargest(arr, state, m);
        System.out.println(result); // Output: [6, 7]
    }
}
