package com.dsa.patterns.slidingWindow;

import java.util.HashMap;

/*
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
*   Input: String="araaci", K=2
    Output: 4
    Explanation: The longest substring with no more than '2' distinct characters is "araa".
 */
public class LongestSubstringWithKDistinctCharacters {

    public static void main(String [] args){
        String str="aabccbbx";
        System.out.println(solve(str, 3));
    }

    public static int solve(String str, int k){
        int answer = 0;
        int start =0, end=0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        while(end < str.length()){
            Character right = str.charAt(end);
            map.put(right, map.getOrDefault(right, 0)+1);
            while (map.size()>k) {
                Character left = str.charAt(start);
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
