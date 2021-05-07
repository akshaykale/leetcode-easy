/*

https://leetcode.com/problems/pascals-triangle/

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:

1 <= numRows <= 30
*/


class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        
        val res: MutableList<List<Int>> = mutableListOf()
        var temp = mutableListOf<Int>()

        res.add(listOf<Int>(1))
        if(numRows == 1) return res
        
        res.add(listOf<Int>(1,1))
        temp.clear()
        temp.add(1)
        temp.add(1)
        if(numRows == 2) return res
                
        for (i in 3..numRows) {
            val list = MutableList<Int>(i) {0} // with size i and initial value as 0
            list[0] = 1 //add at 0th index
            list[i-1] = 1 //add at last 
            for(j in 1..i-2) { // for i == 3 j = 1 only
                val resAtJ = temp.get(j-1) + temp.get(j)
                list[j] = resAtJ
            }
            
            res.add(list)
            temp = list // tepm.clear(); temp.addAll(list)
        }
        return res
    }
}
