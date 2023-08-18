package org.example.binarySearch.morePractices.intersectionOfTwoArrays2

class Solution {

    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {

        val map = LinkedHashMap<Int, IntArray>(1001)

        for (i in 0..1000) map[i] = IntArray(2) { 0 }

        for (value in nums1) map[value]!![0]++

        var count = 0

        for (value in nums2) {
            if (map[value]!![0] > map[value]!![1]) {
                map[value]!![1]++
                count++
            }
        }

        val result = IntArray(count) { 0 }

        var i = 0

        for (pair in map) {
            if (pair.value[1] > 0) {
                repeat(pair.value[1]) {
                    result[i] = pair.key
                    i++
                }
            }
        }

        return result
    }
}

fun main() {
    val solution = Solution()

    println(solution.intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)).joinToString(", "))
    println(solution.intersect(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4)).joinToString(", "))
}