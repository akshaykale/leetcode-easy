/**
https://leetcode.com/problems/subarray-sum-equals-k/



Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
*/

class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        
        val n = nums.size
        
        val map = hashMapOf<Int, Int>() //num -> count
        map[0] = 1
        var sum = 0
        var count = 0
        for (i in 0..n-1) {
            sum += nums[i]
            val d = sum-k
            if(map.containsKey(d)) {
                count += map[d]?:0  
            } 
            map[sum] = (map[sum]?:0) + 1 
        } 
        return count
    }
    
//     fun subarraySum(nums: IntArray, k: Int): Int {
//         val n = nums.size
//         if (nums.isEmpty()) return 0
        
//         var left = 0
//         var right = 0
        
//         val map = hashMapOf<Char, Int>()
        
//         val arr = IntArray(n+1) //prefiix sum
//         arr[0] = 0
//         for (i in 1..n) { arr[i] = arr[i-1] + nums[i-1] } // O(n)
        
//         println(arr.map{it})
        
//         var count = 0
        
//         while (right < n) {
            
//             val sum = arr[right+1]//3
//             val d = sum - k
//             println("$right   $sum   $d ")
//             for(j in 0..right) {
                
//                 if(arr[j] == d) {
//                     count++
//                 }
                
//             }
            
//             right++
//         }
//         return count
//     }
}
