/**
https://leetcode.com/problems/move-zeroes/


Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 

Follow up: Could you minimize the total number of operations done?
*/


class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        
        var p = 0
        var q = p
        
        while(p < nums.size) {
            
            if (nums[p] == 0) {
                //find the next non-0 number in the array using q
                while(q < nums.size && nums[q]==0){
                    q++
                }
                if (q == nums.size) return
                else {
                    //swap
                    val temp = nums[q]
                    nums[q] = nums[p]
                    nums[p] = temp
                }
            } else {
                p ++
                q = p
            }
            
        }
        
    }
}
