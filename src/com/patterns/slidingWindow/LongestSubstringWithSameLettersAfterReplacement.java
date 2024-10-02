package com.patterns.slidingWindow;

/*
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, 
 * find the length of the longest substring having the same letters after replacement.
 * 
 * Input: String="aabccbb", k=2
 * Output: 5
 * Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
 */



public class LongestSubstringWithSameLettersAfterReplacement {

     public static void main(String[] args) {
        String str="abccde";
        System.out.println(solve(str,1));
    }

    public static int solve(String str, int k){
        int answer = 0;
        int start =0, end=0, maxRepeatLetterCount=0;
        int[] counter = new int[26];
        while(end < str.length()){
            Character right = str.charAt(end);
            counter[right-'a']++;
            maxRepeatLetterCount = Math.max(counter[right-'a'], maxRepeatLetterCount);
            while (end-start+1-maxRepeatLetterCount > k) {
                Character left = str.charAt(start);
                counter[left-'a']--;
                maxRepeatLetterCount = Math.max(counter[left-'a'], maxRepeatLetterCount);
                start++;
            }
            answer = Math.max(answer, end-start+1);
            end++;
        }
        return answer;
    }


}