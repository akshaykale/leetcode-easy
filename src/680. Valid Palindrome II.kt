/**
https://leetcode.com/problems/valid-palindrome-ii/




Given a string s, return true if the s can be palindrome after deleting at most one character from it.

 

Example 1:

Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:

Input: s = "abc"
Output: false
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
*/

class Solution {
    fun validPalindrome(s: String): Boolean {
        if(s.isEmpty()) return true
        if(s.length == 1) return true
        
        
        var left = 0
        var right = s.length-1
        
        while(left <= right) {
            println("${s.get(left)}   ${s.get(right)}")
            if(s.get(left) == s.get(right)){
                left++
                right--
                continue
            } 
            return isP(s.substring(0,left).plus(s.substring(left+1,s.length))) || isP(s.substring(0,right).plus(s.substring(right+1,s.length)))
        }
        return true
        
    }
    
    fun isP(s: String): Boolean {
        var left = 0
        var right = s.length-1
        
        while(left < right) {
            if(s.get(left) != s.get(right)) return false
            left++
            right--
        }
        return true
    }
}
