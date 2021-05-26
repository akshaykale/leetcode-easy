/**
https://leetcode.com/problems/longest-substring-without-repeating-characters/


Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/


class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        
        if (s.length == 0) return 0
                
        var left = 0
        var right = 0
        
        var ans = 0
        
        while (right < s.length) {
            
            val sub = s.substring(left, right+1)   
             
            if (hasDuplicate(sub)) {
                left ++
            } else {
                ans = Math.max(ans, sub.length)
                right ++
            }
            
            
        }
        return ans
    }
    
    fun hasDuplicate(s: String): Boolean {
        
        val set = hashSetOf<Char>()
        
        for (ch in s) {
            if (set.contains(ch)) {
                return true
            } else set.add(ch)
        }
        return false
        
    }
}
