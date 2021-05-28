/**
https://leetcode.com/problems/3sum/


Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []
 

Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105
*/



class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        
        val res = hashSetOf<List<Int>>()
                
        for ((index, num) in nums.withIndex()) {
            
            val target = -1 * num
            
            val map = hashMapOf<Int, Int>()
            for (i in index+1..nums.size-1) { //start form index to reduce dupliccate
                val compliment = target - nums[i]

                if (map[compliment] != null) {
                    val triplet = intArrayOf(num, compliment, nums[i] )
                    triplet.sort()
                    res.add(triplet.toList())
                } else {
                    map[nums[i]] = i
                }        
            }
        }
        return res.toList()
    }
}
