/**
https://leetcode.com/problems/diameter-of-binary-tree/



Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

 

Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
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
    
    var diameter = Int.MIN_VALUE
    
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        longestPath(root)
        return diameter
    }
    
    fun longestPath(root: TreeNode?): Int { //O(n)
        if (root == null) return 0
        
        val l = longestPath(root.left)
        var r = longestPath(root.right)
        
        diameter = Math.max( diameter, l + r )
        
        return 1 + Math.max(l, r)
    }
}
