/**
https://leetcode.com/problems/binary-tree-paths/

Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.

 

Example 1:


Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
Example 2:

Input: root = [1]
Output: ["1"]
 

Constraints:

The number of nodes in the tree is in the range [1, 100].
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
    fun binaryTreePaths(root: TreeNode?): List<String> {
        
        val path = mutableListOf<Int>()
        val res = mutableListOf<String>()
        
        traverse(root, path, res)
        
        return res
    }
    
    fun traverse(root: TreeNode?, path: MutableList<Int>, res: MutableList<String>) {
        
        if (root == null) return
        
        path.add(root.`val`)
        
        if (root.left == null && root.right == null) {
            res.add(path.joinToString("->"))
        }
        
        traverse(root.left, path, res)
        traverse(root.right, path, res)
        
        path.removeAt(path.size -1)
        
    }
}
