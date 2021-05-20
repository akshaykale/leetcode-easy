/**
https://leetcode.com/problems/closest-binary-search-tree-value/

Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target.

 

Example 1:


Input: root = [4,2,5,1,3], target = 3.714286
Output: 4
Example 2:

Input: root = [1], target = 4.428571
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 109
-109 <= target <= 109
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
    
    var closestDiff: Double = Double.MAX_VALUE
    var closestNode: TreeNode? = null 
    
    fun closestValue(root: TreeNode?, target: Double): Int {
        
        traverse(root, target)
        
        return closestNode?.`val` ?: 0 
        
    }
    
    fun traverse(root: TreeNode?, target: Double) {
        
        if (root == null) return
        
        val diff = Math.abs(root.`val` - target)
        
        if (diff < closestDiff) {
            closestDiff = diff
            closestNode = root
        }
        
        if (target < root.`val`) traverse(root.left, target)
        else traverse(root.right, target)
        
    }
}
