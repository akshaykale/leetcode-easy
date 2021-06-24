/**
https://leetcode.com/problems/word-search/


Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 

Follow up: Could you use search pruning to make your solution faster with a larger board?
*/


class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        
        if(board.size == 0) return false
        
        val r = board.size
        val c = board[0].size
        val visited = Array(r) { IntArray(c) {0} }
        
        for (i in 0..r-1) {
            for (j in 0..c-1) {
                if(visited[i][j] == 0) {
                    if (board[i][j] == word[0] && dfs(board, visited, 0, word, i, j)) {
                        return true
                    }
                }
                
            }
        }
        return false
    }
    
    fun dfs(board: Array<CharArray>, visited: Array<IntArray>, index: Int, word:String, r: Int, c: Int): Boolean {
        
        if (index >= word.length) return true
        
        if (r > board.size-1 || r < 0 || 
                    c > board[0].size-1 || c < 0 ||
                    visited[r][c] == 1) {
            return false
        }
        
        if (board[r][c] != word[index]) return false

        
        visited[r][c] = 1
        
        val rc = intArrayOf( 0, 0, 1,-1)
        val cc = intArrayOf( 1,-1, 0, 0)
        
        for (i in 0..rc.size-1) {
            val newR = r+rc[i]
            val newC = c+cc[i]
            if (dfs(board, visited, index+1, word, newR, newC)) {
                return true
            }
        }
        visited[r][c] = 0
        
        return false
    }
    
    fun isSafe(board: Array<CharArray>, visited: Array<IntArray>, r: Int, c: Int): Boolean {
        return if (r > board.size-1 || r < 0 || 
                    c > board[0].size-1 || c < 0 ||
                    visited[r][c] == 1) {
            false
        } else true
    }
}
