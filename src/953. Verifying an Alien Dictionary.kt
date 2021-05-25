/**
https://leetcode.com/problems/verifying-an-alien-dictionary/

In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.

 

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
All characters in words[i] and order are English lowercase letters.
*/



class Solution {
    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        
        val orders = order.toCharArray()
        
        for (i in 0..words.size-2) {
            
            val w1 = words[i].toCharArray()
            val w2 = words[i+1].toCharArray()
            
            for ((i, chw1) in w1.withIndex()) {
                
                if(i >= w2.size) return false

                val chw2 = w2[i]
                
                //if same letter go to next letter
                if(orders.indexOf(chw1) == orders.indexOf(chw2)) { 
                    continue
                } 
                // if first not same letter is less then order is correct
                else if (orders.indexOf(chw1) < orders.indexOf(chw2)) { 
                    break
                } 
                // if first not same letter is greater then order return false
                else {
                    return false
                }
                
            }
            
        }
        return true
    }
}
