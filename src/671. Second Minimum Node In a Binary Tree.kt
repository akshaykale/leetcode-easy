/**
https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/



Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

 

 

Example 1:


Input: root = [2,2,5,null,null,5,7]
Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
Example 2:


Input: root = [2,2,2]
Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.
 

Constraints:

The number of nodes in the tree is in the range [1, 25].
1 <= Node.val <= 231 - 1
root.val == min(root.left.val, root.right.val) for each internal node of the tree.
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
    
    var min = Long.MAX_VALUE
    var min1 = 0
    var flag = false
    
    fun findSecondMinimumValue(root: TreeNode?): Int {
        if (root == null) return 0
        
        //return bfs(root)
        
        min1 = root.`val`
        dfs(root)
        return if (min < Long.MAX_VALUE) min.toInt() else -1
    }
    
    fun dfs(root: TreeNode?) {
        if (root == null) return
        
        if(root.`val` > min1 && root.`val` < min) {
            min = (root.`val`).toLong()  
        } 
        
        dfs(root.left)
        dfs(root.right)
    }
    
    fun bfs(root: TreeNode): Int {
        val q : Queue<TreeNode> = LinkedList()
        q.add(root)
        var min = Long.MAX_VALUE
        while(q.isNotEmpty()) {
            for(i in 0..q.size-1) {
                val cur = q.poll()
                if (cur.`val` <= min.toLong() && cur.`val` > root.`val`) {
                    min = (cur.`val`).toLong()
                }
                cur.left?.let {q.add(it)}
                cur.right?.let {q.add(it)}
            }
        }
        return if(min < Long.MAX_VALUE) min.toInt() else -1
    }
}
