class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {

        val map = hashMapOf<Int, Int>()

        for(i in nums.indices) {
            val compliment = target - nums[i]
            map[compliment]?.let {
                return intArrayOf(it, i)
            }
            map[nums[i]] = i
        }

        // for (i in nums.indices) {
        //     val a = nums[i]
        //     val b = target - a
        //     if(map[b] != null) {
        //         return intArrayOf(i, map[b]!!)
        //     } else continue
        // }
        return intArrayOf(0,0) //Nothing found
    }
}