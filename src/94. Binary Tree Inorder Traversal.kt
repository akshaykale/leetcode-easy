/**
https://leetcode.com/problems/binary-tree-inorder-traversal/

Given the root of a binary tree, return the inorder traversal of its nodes' values.

 

Example 1:


Input: root = [1,null,2,3]
Output: [1,3,2]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
Example 4:


Input: root = [1,2]
Output: [2,1]
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
    
    fun inorderTraversal(root: TreeNode?): List<Int> {
        return _iterative(root)
        //val list = mutableListOf<Int>()
        //_inTraversal(root, list)
        //return list
        
    }
    
    fun _iterative(root: TreeNode?): MutableList<Int> {
        
        if (root == null) return mutableListOf();
        
        val list = mutableListOf<Int>()
        
        val stack: Stack<TreeNode> = Stack()
                
        var cur: TreeNode? = root
        
        while (cur != null || stack.isNotEmpty()) {
            while (cur != null) {
                stack.push(cur)
                cur = cur.left
            }
            cur = stack.pop()
            list.add(cur.`val`)
            cur = cur.right
        }
        
        return list
    }
    
    fun _inTraversal(root: TreeNode?, list: MutableList<Int>){
        
        if (root == null) return

        _inTraversal(root.left, list)
        list.add(root.`val`)
        _inTraversal(root.right, list) 
    }
}
