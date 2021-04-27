/**

https://leetcode.com/problems/symmetric-tree/

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 

Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
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
    fun isSymmetric(root: TreeNode?): Boolean {
        return _isSym(root?.left, root?.right)
    }
    
    fun _isSym(root1: TreeNode?, root2: TreeNode?): Boolean {
        
        if (root1 != null && root2 != null && root1.`val` == root2.`val`) { // valid same node
            
            return _isSym(root1.right, root2.left) && _isSym(root1.left, root2.right)
            
        } else if (root1 == null && root2 == null) { // considered as same 
            return true
        } 
        
        else return false // not same
        
        return true
    }
}
