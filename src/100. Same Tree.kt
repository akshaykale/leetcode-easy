/**

https://leetcode.com/problems/same-tree/

Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

 

Example 1:


Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:


Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:


Input: p = [1,2,1], q = [1,1,2]
Output: false
 

Constraints:

The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104
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
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        //return rec(p,q)
        return iterative(p,q)
    }
    
    fun rec(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true //both are same
        if (p == null || q == null) return false // one of them is null
        if (p?.`val` != q?.`val`) return false // value is not same
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }
    
    fun iterative(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true //both are same
        if (p == null || q == null) return false // one of them is null
        
        val stackP: Stack<TreeNode> = Stack()
        val stackQ: Stack<TreeNode> = Stack()
        
        var currP = p
        var currQ = q
        
        while ((currP != null && currQ != null) || (stackP.isNotEmpty() && stackQ.isNotEmpty())) {
            
            while(currP!=null && currQ!=null) {
                
                if (currP?.`val` != currQ?.`val`) return false
                
                stackP.push(currP)
                stackQ.push(currQ)
                currP = currP.left
                currQ = currQ.left
                
                if (currP!=null && currQ!=null) {
                    if (currP.`val` != currQ.`val`) return false
                } else if (currP == null && currQ == null) {
                    continue
                } else return false //one of them is null
            }
            
            currP = stackP.pop()
            currQ = stackQ.pop()
            
            if (currP?.`val` != currQ?.`val`) return false
            
            currP = currP.right
            currQ = currQ.right
            
            if (currP!=null && currQ!=null) {
                if (currP.`val` != currQ.`val`) return false
            } else if (currP == null && currQ == null) {
                continue
            } else return false //one of them is null
        }
        
        
        return true
    }
}
