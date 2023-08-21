package org.example.binarySearch.morePractices.twoSum2

class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val resultArray = IntArray(2) { 0 }
        var start: Int = 0
        var end: Int = numbers.lastIndex
        while(start < end) {
            if ((numbers[start] + numbers[end]) == target) {
                return resultArray.also {
                    it[0] = ++start
                    it[1] = ++end
                }
            } else if ((numbers[start] + numbers[end]) > target) end--
            else start++
        }
        return resultArray
    }
}

fun main() {
    printArray(100, 5, 25, 75)
    printArray(9, 2, 7, 11, 15)
    printArray(6, 2, 3, 4)
}

private fun printArray(target: Int, vararg args: Int) {
    val intArray: IntArray = args.toList().toIntArray()
    val array = Solution().twoSum(intArray, target)
    println(array.joinToString(", "))
}