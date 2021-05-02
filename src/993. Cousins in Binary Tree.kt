/**

https://leetcode.com/problems/cousins-in-binary-tree/


In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:



Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Constraints:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.
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
    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        
        if(root == null) return false
        
        val q: Queue<TreeNode> = LinkedList()
        q.add(root)
        
        while(q.isNotEmpty()) {
            var t = 0
            for (i in 0..q.size-1) {
                q.poll()?.let { node ->
                    
                    /// Check if this is child nodes and not cousin
                    var foundX = false
                    var foundY = false
                    node.left?.let{
                        q.add(it)
                        when (it.`val`) {
                            x -> foundX = true
                            y -> foundY = true
                        } 
                    }
                    node.right?.let{
                        q.add(it)
                        when (it.`val`) {
                            x -> foundX = true
                            y -> foundY = true
                        } 
                    }
                    
                    if (foundX && foundY) return false
                                                            
                    if (node.`val` == x || node.`val` == y) { t++ }
                }
            }
            if (t==2) return true
        }
        return false
    }
}
