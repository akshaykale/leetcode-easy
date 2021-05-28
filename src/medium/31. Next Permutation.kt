/**
https://leetcode.com/problems/next-permutation/



Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:

Input: nums = [1]
Output: [1]
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100
*/


class Solution {
    fun nextPermutation(nums: IntArray): Unit {
    
        var i = nums.size-2 
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--
        }
        
        if (i >= 0) {
            var j = nums.size-1
            while(nums[j] <= nums[i]) { // find the next large number than nums[i].. since ttheright side s descending 
                j--
            }
            
            val temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
            
            // arrange in ascendng order from i+1
            nums.sort(fromIndex = i+1, toIndex = nums.size)
        } else {
            nums.sort()
        }
    
    }
}
