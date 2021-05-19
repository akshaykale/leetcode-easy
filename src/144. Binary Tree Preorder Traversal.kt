/**
https://leetcode.com/problems/binary-tree-preorder-traversal/


Given the root of a binary tree, return the preorder traversal of its nodes' values.

 

Example 1:


Input: root = [1,null,2,3]
Output: [1,2,3]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
Example 4:


Input: root = [1,2]
Output: [1,2]
Example 5:


Input: root = [1,null,2]
Output: [1,2]
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
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
    fun preorderTraversal(root: TreeNode?): List<Int> {
        
        val list = mutableListOf<Int>()
        
        root?.preOrder(list)
        
        return list
        
    }
    
    fun TreeNode.preOrder(list: MutableList<Int>) {
        list.add(this.`val`)
        this.left?.preOrder(list)
        this.right?.preOrder(list)
    }
}
