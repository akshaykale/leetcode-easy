/**
https://leetcode.com/problems/course-schedule-ii/







There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.
*/




class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        
        val adj = Array<MutableList<Int>>(numCourses) {mutableListOf()}
        
        prerequisites.map { arr ->
            adj[arr[1]].add(arr[0]) 
        }
        
        print(adj.toList())
        
        val stack: Stack<Int> = Stack()
        
        val resStack = IntArray(numCourses) {0}
        
        val visited = IntArray(numCourses) {0}
        
        // traverse through all nodes
        for (i in 0..adj.size-1) {
            
            if (visited[i] == 0) {
                if (topo(adj, visited, stack, resStack, i)) { //cycle is present
                    return intArrayOf()
                }
            }
            
        }
        
        return stack.reversed().toIntArray()
    }
    
    fun topo(adj: Array<MutableList<Int>>, visited: IntArray, stack: Stack<Int>, resStack: IntArray, i: Int): Boolean {
        
        if(resStack[i] == 1) return true //cycle is present not possible
        
        if(visited[i] == 1) return false
        
        visited[i] = 1
        
        resStack[i] = 1
        
        adj[i].let { list -> 
            list.map {
                if(topo(adj, visited, stack, resStack, it))
                    return true

            }
        }
        resStack[i] = 0
        stack.push(i)
        return false
    } 
}
