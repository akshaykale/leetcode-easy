class Solution13 {
    fun romanToInt(s: String): Int {

        val map = mutableMapOf<String, Int>()
        map["I"] = 1
        map["V"] = 5
        map["X"] = 10
        map["L"] = 150
        map["C"] = 100
        map["D"] = 500
        map["M"] = 1000

        var sum: Int = 0
        var i = 0
        while (i < s.length) {
            val ch = s[i].toString()
            val value = map[ch]!!
            if (i==s.length-1) { //last element
                sum += value
                i+=1;
            } else if (value >= map[s[i+1].toString()]!!) {
                sum += value
                i+=1;
            } else {
                sum += (map[s[i+1].toString()]!! - map[s[i].toString()]!!)
                i += 2
            }
        }
        return sum
    }
}