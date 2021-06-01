/**
https://leetcode.com/problems/product-of-array-except-self/




Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
*/


class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        
        val left = IntArray(nums.size) {1}
        val right = IntArray(nums.size) {1}
        
        left[0] = 1
        right[nums.size-1] = 1
        
        for (i in 1..left.size-1) {
            left[i] = left[i-1] * nums[i-1]
        }
        
        for (j in right.size-2 downTo 0 step 1) {
            right[j] = right[j+1] * nums[j+1]
        }
        
        println(left.map{it})
        println(right.map{it})
        
        for (i in nums.indices) {
            nums[i] = left[i]*right[i]
        }
        return nums
    }
}
