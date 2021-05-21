/**
https://leetcode.com/problems/maximum-depth-of-n-ary-tree/


Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

 

Example 1:



Input: root = [1,null,3,2,4,null,5,6]
Output: 3
Example 2:



Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: 5
 

Constraints:

The depth of the n-ary tree is less than or equal to 1000.
The total number of nodes is between [0, 104].
*/


/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var children: List<Node?> = listOf()
 * }
 */

class Solution {
    var maxPath = Int.MIN_VALUE

    fun maxDepth(root: Node?): Int {
        
        if(root == null) return 0
        
        //traverse(root)
        //return maxPath + 1
        
        return bfs(root)
    }
    
    fun traverse(root: Node?): Int {
        if (root == null) return 0
            
        var maxInChildren = 0
        root.children.mapNotNull {
            val pathLength = traverse(it)
            println("${root.`val`} $pathLength")
            maxInChildren = Math.max(maxInChildren, pathLength)
        }
        
        
        maxPath = Math.max(maxPath, maxInChildren)
        
        return maxInChildren + 1
    }
    
    fun bfs(root: Node?): Int {
    
        val q: Queue<Node> = LinkedList()
        
        q.add(root)
        
        var height = 0
        
        while(q.isNotEmpty()) {
            
            height ++;
            
            for(i in 0..q.size-1) {
                
                q.poll().apply {
            
                    children.mapNotNull {
                        q.add(it)
                
                    }   
                }
            } 
        }
        return height
    }
}
