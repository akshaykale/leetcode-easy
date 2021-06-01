/*

https://leetcode.com/problems/valid-palindrome/

Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
*/


class Solution {
    fun isPalindrome(s: String): Boolean {
        
        var l = 0
        var r = s.length-1
        
        while (l<r) {
            
            val ls = s.get(l)
            if (!ls.isValid()) {
                l++
                continue
            }
            val rs = s.get(r)
            if (!rs.isValid()) {
                r--
                continue
            }
            l++
            r--
            if (ls.toString().toLowerCase() == rs.toString().toLowerCase()) continue
            return false
            
        }
        return true
    }
    
    fun Char.isValid(): Boolean {
        //println("$this")
        return if((this >= 'a' && this <= 'z') || (this >= 'A' && this <= 'Z') || (this >= '0' && this <= '9'))  true
        else  false
    }
}
