/**
https://leetcode.com/problems/integer-to-english-words/


Convert a non-negative integer num to its English words representation.

 

Example 1:

Input: num = 123
Output: "One Hundred Twenty Three"
Example 2:

Input: num = 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: num = 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
Example 4:

Input: num = 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 

Constraints:

0 <= num <= 231 - 1
*/



class Solution {
    fun numberToWords(num: Int): String { //676,213,123,423
        if(num == 0) return "Zero"
        
        var n: Int = num
        val hundred = n % 1000 //423
        n = n/1000 // 676,213,123
        val thousand = n % 1000 // 123
        n = n/1000 // 676,213
        val million = n % 1000 //213
        n = n/1000
        val billion = n % 1000 //676
        
        println(hundred)
        println(thousand)
        
        println(million)
        println(billion)
        val sb = StringBuilder()
        
        if(billion > 0) {
            sb.append(getThreeDigit(billion))
            sb.append(" Billion")
        }  
        if (million > 0) {
            sb.append(" ")
            sb.append(getThreeDigit(million))
            sb.append(" Million")
        }  
        if (thousand > 0) {
            sb.append(" ")
            sb.append(getThreeDigit(thousand))
            sb.append(" Thousand")
        }  
        if (hundred > 0) {
            sb.append(" ")
            sb.append(getThreeDigit(hundred))
        }
        return sb.toString().trim().replace("  ", " ")
        
    }
    
    fun getOneDigit(num: Int): String {
        return when(num) {
            1 -> "One"
            2 -> "Two"
            3 -> "Three"
            4 -> "Four"
            5 -> "Five"
            6 -> "Six"
            7 -> "Seven"
            8 -> "Eight"
            9 -> "Nine"
            else -> ""
        }
    }
    
    fun getTwoDigit(num: Int): String {
        return when {
            num < 10 -> getOneDigit(num)
            num >= 10 && num <= 19 -> {
                when(num) {
                    10 -> "Ten"
                    11 -> "Eleven"
                    12 -> "Twelve"
                    13 -> "Thirteen"
                    14 -> "Fourteen"
                    15 -> "Fifteen"
                    16 -> "Sixteen"
                    17 -> "Seventeen"
                    18 -> "Eighteen"
                    19 -> "Nineteen"
                    else -> ""
                }
            }
            num >= 20 && num <= 29 -> "Twenty ${getOneDigit(num%10)}"
            num >= 30 && num <= 39 -> "Thirty ${getOneDigit(num%10)}"
            num >= 40 && num <= 49 -> "Forty ${getOneDigit(num%10)}"
            num >= 50 && num <= 59 -> "Fifty ${getOneDigit(num%10)}"
            num >= 60 && num <= 69 -> "Sixty ${getOneDigit(num%10)}"
            num >= 70 && num <= 79 -> "Seventy ${getOneDigit(num%10)}"
            num >= 80 && num <= 89 -> "Eighty ${getOneDigit(num%10)}"
            num >= 90 && num <= 99 -> "Ninety ${getOneDigit(num%10)}"
            else -> ""
            //num >= 20 && num <= 29 -> ""
            //num >= 20 && num <= 29 -> ""
        }  
    }
    
    fun getThreeDigit(num: Int): String {
        return when {
            (num / 100 > 0) -> {
                "${getOneDigit(num/100)} Hundred ${getTwoDigit(num%100)}"
            }
            (num / 10 > 0) -> {
                "${getTwoDigit(num%100)}"
            }
            (num > 0) -> {
                "${getOneDigit(num%10)}"
            }
            else -> ""
        }
    }
}
