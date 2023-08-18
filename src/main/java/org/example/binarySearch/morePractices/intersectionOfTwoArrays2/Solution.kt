package org.example.binarySearch.morePractices.intersectionOfTwoArrays2

class Solution {

    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {

        val array = Array(1001) { IntArray(2) { 0 } }

        for (value in nums1) array[value][0]++

        var count = 0

        for (value in nums2) {
            if (array[value][0] > array[value][1]) {
                array[value][1]++
                count++
            }
        }

        val result = IntArray(count)

        var j = 0

        for (i in array.indices) {
            if (array[i][1] > 0) {
                repeat(array[i][1]) {
                    result[j] = i
                    j++
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
    println(solution.intersect(intArrayOf(1, 2), intArrayOf(1, 1)).joinToString(", "))
    println(solution.intersect(intArrayOf(1, 1), intArrayOf(1, 2)).joinToString(", "))
}