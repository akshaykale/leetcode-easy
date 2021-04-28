/**

https://leetcode.com/problems/maximum-depth-of-binary-tree/

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2
Example 3:

Input: root = []
Output: 0
Example 4:

Input: root = [0]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100

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
    fun maxDepth(root: TreeNode?): Int {
        
        //return bfs(root)
        return dfs(root)
    }
    
    fun bfs(root: TreeNode?): Int {
        if (root == null) return 0
        
        val queue: Queue<TreeNode> = LinkedList<TreeNode>()
        queue.add(root)
        var height = 0
        while(queue.isNotEmpty()) {
            for (i in 0..queue.size-1) {
                queue.poll()?.let { node -> 
                    node.left?.let {
                        queue.add(it)
                    }
                    node.right?.let {
                        queue.add(it)
                    }
                }
            }
            height++
        }
        return height
    }
    
    fun dfs(root: TreeNode?): Int {
        if (root == null) return 0 
        return 1 + Math.max(maxDepth(root?.left), maxDepth(root?.right))
    }
}
