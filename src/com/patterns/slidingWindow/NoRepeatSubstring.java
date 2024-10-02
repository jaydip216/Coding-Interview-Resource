package com.patterns.slidingWindow;

/*
 * Given a string, find the length of the longest substring which has no repeating characters.
 * Input: String="aabccbb"
 * Output: 3
 * Explanation: The longest substring without any repeating characters is "abc".
 */


public class NoRepeatSubstring {
    
    public static void main(String[] args) {
        String str="abccde";
        System.out.println(solve(str));
    }

    public static int solve(String str){
        int answer = 0;
        int start =0, end=0;
        int[] counter = new int[26];
        while(end < str.length()){
            Character right = str.charAt(end);
            counter[right-'a']++;
            while (counter[right-'a']>1) {
                Character left = str.charAt(start);
                counter[left-'a']--;
                start++;
            }
            answer = Math.max(answer, end-start+1);
            end++;
        }
        return answer;
    }
}
