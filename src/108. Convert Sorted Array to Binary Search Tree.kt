
/**

https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

 

Example 1:


Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:


Input: nums = [1,3]
Output: [3,1]
Explanation: [1,3] and [3,1] are both a height-balanced BSTs.
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in a strictly increasing order.
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
    
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return createTree(nums, 0, nums.size-1)
    }
    
    fun createTree (nums: IntArray, l: Int, r: Int): TreeNode? {
        
        if(l>r) return null
        
        val mid: Int = (l+r)/2
        val node: TreeNode = TreeNode(nums[mid])
        node.left = createTree(nums, l, mid-1)
        node.right = createTree(nums, mid+1, r)
        return node
        
    }
    
    
}
