package org.example.binarySearch.morePractices.twoSum2

class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var start: Int
        var end: Int
        var mid: Int
        for(i in numbers.indices) {
            start = i
            end = numbers.lastIndex
            while (start <= end) {
                mid = start + (end - start) / 2

                if ((numbers[i] + numbers[mid]) == target) return intArrayOf(i + 1, mid + 1)
                else if ((numbers[i] + numbers[mid] > target)) end = mid - 1
                else start = mid + 1
            }
            if ((numbers[i] + numbers[start]) == target) return intArrayOf(i + 1, start + 1)
        }
        return intArrayOf()
    }
}