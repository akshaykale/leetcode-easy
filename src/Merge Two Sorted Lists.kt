/**

Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.

 

Example 1:


Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: l1 = [], l2 = []
Output: []
Example 3:

Input: l1 = [], l2 = [0]
Output: [0]

*/

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun mergeTwoLists(p: ListNode?, q: ListNode?): ListNode? {
        var l1: ListNode? = p
        var l2: ListNode? = q
        var sortingPointer: ListNode? = ListNode()
        val start: ListNode? = sortingPointer
        
        if (l1 == null && l2 != null) { 
            sortingPointer?.next = l2  
        } else if (l2 == null && l1 != null){
            sortingPointer?.next = l1
        } else if (l1 == null && l2 == null) {
            return start?.next
        }
                
        while(l1 != null && l2 != null) {
                                    
            if (l1.`val` < l2.`val`) {
                sortingPointer?.next = l1
                l1 = l1.next
            } else {
                sortingPointer?.next = l2
                l2 = l2.next
            }
            
            sortingPointer = sortingPointer?.next 
            
            if (l1 == null) {
                sortingPointer?.next = l2
            }
            if (l2 == null) {
                sortingPointer?.next = l1
            }
                    
        }
        return start?.next
    }
}
