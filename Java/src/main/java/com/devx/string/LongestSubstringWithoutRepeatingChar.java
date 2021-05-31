package com.devx.string;

import java.util.Arrays;

/**
 * @author I348618
 * @since 5/31/2021
 */
public class LongestSubstringWithoutRepeatingChar {

    public int lengthOfLongestSubstring(String s) {
        // To handle null and empty strings
        if(s==null || s.length()==0)
            return 0;

        int[] lastIndex = new int[256];
        Arrays.fill(lastIndex, -1);
        int count=0, start=0;
        for(int i=0; i<s.length(); i++) {

            if(lastIndex[s.charAt(i)] != -1) {
                start = Math.max(start, lastIndex[s.charAt(i)] + 1);
            }
            count = Math.max(count, i - start + 1);
            lastIndex[s.charAt(i)] = i;
        }
        return count;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingChar l = new LongestSubstringWithoutRepeatingChar();

        System.out.println(l.lengthOfLongestSubstring("abcabcbb") == 3);
        System.out.println(l.lengthOfLongestSubstring("bbbb") == 1);
        System.out.println(l.lengthOfLongestSubstring("pwwkew") == 3);
        System.out.println(l.lengthOfLongestSubstring("abcdabcd") == 4);
        System.out.println(l.lengthOfLongestSubstring("pwwakew") == 4);
        System.out.println(l.lengthOfLongestSubstring("") == 0);
    }
}
