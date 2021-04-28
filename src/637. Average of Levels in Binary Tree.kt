/**

https://leetcode.com/problems/average-of-levels-in-binary-tree/

Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
 

Example 1:


Input: root = [3,9,20,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].
Example 2:


Input: root = [3,9,20,15,7]
Output: [3.00000,14.50000,11.00000]
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
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
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        if(root == null) return doubleArrayOf()
        
        val q: Queue<TreeNode> = LinkedList()
        q.add(root)
        
        val res = mutableListOf<Double>()
        while (q.isNotEmpty()) {
            var sum: Double = 0.0
            val size = q.size
            for(i in 0..size-1) {
                q.poll()?.let { node ->
                    sum += node.`val`
                    node.left?.let {q.add(it)}
                    node.right?.let {q.add(it)}
                }
            }
            res.add(sum.div(size))
        }
        return res.toDoubleArray()
        
    }
}
