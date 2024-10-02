package com.patterns.slidingWindow;

import java.util.HashMap;

/*
 * Given an array of characters where each character represents a fruit tree, 
 * you are given two baskets and your goal is to put maximum number of fruits in each basket. 
 * The only restriction is that each basket can have only one type of fruit.
 * You can start with any tree, but once you have started you can’t skip a tree. 
 * You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
 * 
 * example
 * 
 * Input: Fruit=['A', 'B', 'C', 'A', 'C']
 * Output: 3
 * Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
 */

public class FruitsIntoBaskets {

    public static void main(String[] args) {
        char[] trees = new char[]{'A', 'B', 'C', 'B', 'B', 'C'};
        System.out.println(solve(trees));
    }

    public static int solve(char[] trees){
        int answer = 0;
        int start =0, end=0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        while(end < trees.length){
            Character right = trees[end];
            map.put(right, map.getOrDefault(right, 0)+1);
            while (map.size()>2) {
                Character left = trees[start];
                map.put(left, map.get(left)-1);
                if(map.get(left) == 0){
                    map.remove(left);
                }
                start++;
            }
            answer = Math.max(answer, end-start+1);
            end++;
        }
        return answer;
    }
}
