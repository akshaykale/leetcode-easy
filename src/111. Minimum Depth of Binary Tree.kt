/**

https://leetcode.com/problems/minimum-depth-of-binary-tree/

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 2
Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5
 

Constraints:

The number of nodes in the tree is in the range [0, 105].
-1000 <= Node.val <= 1000

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
    fun minDepth(root: TreeNode?): Int {
        return bfs(root)
    }
    
    fun bfs(root:TreeNode?): Int {
        if (root == null) return 0
        
        val q: Queue<TreeNode> = LinkedList()
        q.add(root)
        
        var height = 0
        
        while(q.isNotEmpty()) {
            
            for (i in 0..q.size-1) {
                q.poll()?.let { node -> 
                    
                    if(node.left == null && node.right == null) return height+1 //if it is a leaf node then this is the shortest path
                    
                    node.left?.let {q.add(it)}
                    node.right?.let {q.add(it)}
                    
                }
            }
            height++
        }
        return height
    }
}
