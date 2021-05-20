/**
https://leetcode.com/problems/minimum-absolute-difference-in-bst/


Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

 

Example 1:


Input: root = [4,2,6,1,3]
Output: 1
Example 2:


Input: root = [1,0,48,null,null,12,49]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 104].
0 <= Node.val <= 105
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
    fun getMinimumDifference(root: TreeNode?): Int {
        
        val list = mutableListOf<Int>()
        inorder(root, list)
        
        var minAbs = Int.MAX_VALUE
        for (i in 1..list.size-1) { //sorter array, compare adjcent values
            val abs = Math.abs(list[i] - list[i-1])
            if (abs< minAbs) {
                minAbs = abs
            }
        }
        
        return minAbs
    }
    
    fun inorder(root: TreeNode?, list: MutableList<Int>) {
        
        if (root == null) return
        
        inorder(root.left, list)
        list.add(root.`val`)
        inorder(root.right, list)
    }
}
