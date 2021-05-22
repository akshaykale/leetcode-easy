/**
https://leetcode.com/problems/subtree-of-another-tree/

Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

 

Example 1:


Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true
Example 2:


Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
 

Constraints:

The number of nodes in the root tree is in the range [1, 2000].
The number of nodes in the subRoot tree is in the range [1, 1000].
-104 <= root.val <= 104
-104 <= subRoot.val <= 104
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
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        root?:return false
        val q: Queue<TreeNode> = LinkedList()
        q.add(root)
        
        while (q.isNotEmpty()) {
            
            for(i in 0..q.size-1) {
                val cur = q.poll()
                if (isSame(cur, subRoot)) return true
                cur.left?.let { q.add(it) }
                cur.right?.let { q.add(it) }
            }
        }
        return false
    }
    
    fun isSame(root: TreeNode?, subRoot: TreeNode?): Boolean {
        
        if (root == null && subRoot == null) return true
        if (root == null || subRoot == null) return false
        
        return (root.`val` == subRoot.`val`) && isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right)
        
    }
}
