/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.
*/

class Solution14 {
    fun longestCommonPrefix(strs: Array<String>): String {
        return longestCommonPrefix(strs, 0, strs.size-1)
    }
    
    fun longestCommonPrefix(strs: Array<String>, left: Int, right: Int): String {
        if (left == right) {
            return strs[left]
        }
        
        val lprefix = longestCommonPrefix(strs, left, (left+right).div(2))
        val rprefix = longestCommonPrefix(strs, (left+right).div(2)+1, right)
        return findPrefix(lprefix, rprefix)
    }
    
    fun findPrefix(lp: String, rp: String): String {
        val min = Math.min(lp.length, rp.length)
        var prefix = ""
        for (i in 0..min-1) {
            if (lp[i] == rp[i]) {
                prefix += lp[i].toString()
            } else break;
        }
        return prefix 
    }
}
