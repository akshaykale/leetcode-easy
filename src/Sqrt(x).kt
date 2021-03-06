/**
Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

 

Example 1:

Input: x = 4
Output: 2
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 

Constraints:

0 <= x <= 231 - 1

*/


class Solution {
    fun mySqrt(x: Int): Int {
        var start: Long = 1
        var end: Long = x.toLong()
        
        if (x==0) return 0
        if (x==1) return 1
        
        while (start <= end) {
            
            val mid: Long = (start + end)/2
            
            if (mid*mid <= x) {
                start = mid+1
            } else {
                end  = mid - 1
            }
            
        }
        return end.toInt()
    }
}
