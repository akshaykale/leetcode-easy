/**
https://leetcode.com/problems/construct-string-from-binary-tree/


Given the root of a binary tree, construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way, and return it.

Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship between the string and the original binary tree.

 

Example 1:


Input: root = [1,2,3,4]
Output: "1(2(4))(3)"
Explanation: Originallay it needs to be "1(2(4)())(3()())", but you need to omit all the unnecessary empty parenthesis pairs. And it will be "1(2(4))(3)"
Example 2:


Input: root = [1,2,3,null,4]
Output: "1(2()(4))(3)"
Explanation: Almost the same as the first example, except we cannot omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-1000 <= Node.val <= 1000
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

    fun tree2str(root: TreeNode?): String {
        if(root == null) return ""
        val res = traverse(root)
        
        
        return res.substring(1, res.length-1)
    }
    
    fun traverse(root: TreeNode?): String {
        
        if (root == null) return ""
        if (root.left == null && root.right == null) "(${root.`val`})" //not necessary save 2 null calls
        
        val value = root.`val`
        val l = traverse(root.left)
        val r = traverse(root.right)
        
        return if(l.isEmpty() && !(root.left == null && root.right == null)) { //not empty
            "($value()$r)"
        } else {
            "($value$l$r)"
        } 
    }
}
