/**
https://leetcode.com/problems/invert-binary-tree/


Given the root of a binary tree, invert the tree, and return its root.

 

Example 1:


Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
Example 2:


Input: root = [2,1,3]
Output: [2,3,1]
Example 3:

Input: root = []
Output: []
 

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
    fun invertTree(root: TreeNode?): TreeNode? {
        invert(root)
        //root?.let{ iterative(it) }
        return root
    }
    
    fun invert(root: TreeNode?) {
        
        if(root == null) return
                
        invertTree(root.left)
        invertTree(root.right)
        
        val temp = root.right
        root.right = root.left
        root.left = temp
    }
    
    fun iterative(root: TreeNode) {
        
        val queue: Queue<TreeNode> = LinkedList()
        
        queue.add(root)
        
        while(queue.isNotEmpty()) {
            
            val curr = queue.poll()
            val temp: TreeNode? = curr.right
            curr.right = curr.left
            curr.left = temp
            
            curr.left?.let { queue.add(it) }
            curr.right?.let {queue.add(it) }
            
        }
        
    }
}
