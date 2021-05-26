/**
https://leetcode.com/problems/leftmost-column-with-at-least-a-one/



(This problem is an interactive problem.)

A row-sorted binary matrix means that all elements are 0 or 1 and each row of the matrix is sorted in non-decreasing order.

Given a row-sorted binary matrix binaryMatrix, return the index (0-indexed) of the leftmost column with a 1 in it. If such an index does not exist, return -1.

You can't access the Binary Matrix directly. You may only access the matrix using a BinaryMatrix interface:

BinaryMatrix.get(row, col) returns the element of the matrix at index (row, col) (0-indexed).
BinaryMatrix.dimensions() returns the dimensions of the matrix as a list of 2 elements [rows, cols], which means the matrix is rows x cols.
Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.

For custom testing purposes, the input will be the entire binary matrix mat. You will not have access to the binary matrix directly.

 

Example 1:



Input: mat = [[0,0],[1,1]]
Output: 0
Example 2:



Input: mat = [[0,0],[0,1]]
Output: 1
Example 3:



Input: mat = [[0,0],[0,0]]
Output: -1
Example 4:



Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
Output: 1
 

Constraints:

rows == mat.length
cols == mat[i].length
1 <= rows, cols <= 100
mat[i][j] is either 0 or 1.
mat[i] is sorted in non-decreasing order.
*/



/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * class BinaryMatrix {
 *     fun get(row:Int, col:Int):Int {}
 *     fun dimensions():List<Int> {}
 * }
 */

class Solution {
    fun leftMostColumnWithOne(binaryMatrix:BinaryMatrix):Int {
        
        val r = binaryMatrix.dimensions().get(0)
        val c = binaryMatrix.dimensions().get(1)
                
        var row = 0
        var col = c-1
        while (row < r && col >= 0) {
            if (binaryMatrix.get(row,col) == 1) {
                col --
            } else {
                row ++
            }
        }
        return if(col == c-1) -1 else col+1
        
        //return binarySearch(binaryMatrix)
    }
    
    fun binarySearch(binaryMatrix:BinaryMatrix): Int {
        
        val r = binaryMatrix.dimensions().get(0)
        val c = binaryMatrix.dimensions().get(1)
        
        var l = 0
        var h = c

        var res = -1
        while (l < h-1) {
            var mid = (l+h)/2
            var presentInCol = false
            mid = (l+h)/2
            for (j in 0..r-1) {
                if (binaryMatrix.get(j, mid) == 1) {
                    presentInCol = true
                }
            }
            if(presentInCol) {
                h = mid
                res = mid
            } else {
                l = mid
                println(l)
                println(h)
            }
        }
        
        for (j in 0..r-1) {
            if (binaryMatrix.get(j, 0) == 1) {
                 return 0
            }
        }
        
        if (res > 0) return res
        
        for (j in 0..r-1) {
            if (binaryMatrix.get(j, c-1) == 1) {
                 return c-1
            }
        }
        return res  
    }
}
