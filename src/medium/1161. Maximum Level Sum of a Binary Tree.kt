/**
https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/






Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

 

Example 1:


Input: root = [1,7,0,7,-8,null,null]
Output: 2
Explanation: 
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.
Example 2:

Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-105 <= Node.val <= 105
*/



/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun maxLevelSum(root: TreeNode?): Int {
        if (root == null) return -1
        
        val q: Queue<TreeNode> = LinkedList()
        q.add(root)
        
        var resSum = Int.MIN_VALUE
        var level = 0
        var resLevel = 0
        
        while(q.isNotEmpty()) {
            var sum = 0
            level ++
            for (i in 0..q.size-1) {
                val t = q.poll()
                sum += t.`val`
                
                t.left?.let {q.add(it)}
                t.right?.let {q.add(it)}
            }

            if (sum>resSum) {
                resLevel = level
            }
            resSum = Math.max(resSum, sum) 

        }
        return resLevel
    }
}
