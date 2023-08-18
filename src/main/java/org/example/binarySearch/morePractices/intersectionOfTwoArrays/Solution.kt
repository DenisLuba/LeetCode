package org.example.binarySearch.morePractices.intersectionOfTwoArrays

class Solution {

    fun intersection_1(nums1: IntArray, nums2: IntArray): IntArray {
        val set1: MutableSet<Int> = nums1.toMutableSet()
        val set2: MutableSet<Int> = nums2.toMutableSet()

        set1.retainAll(set2)

        return set1.toIntArray()
    }

    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {

        var resultArray = intArrayOf()

        val arr1: IntArray
        val arr2: IntArray

        if (nums1.size < nums2.size) {
            arr1 = nums1.sortedArray()
            arr2 = nums2.sortedArray()
        } else {
            arr1 = nums2.sortedArray()
            arr2 = nums1.sortedArray()
        }

        for (value in arr1) {
            if (!resultArray.isContaining(value) && arr2.isContaining(value))
                resultArray += value
        }

        return resultArray
    }

    fun IntArray.isContaining(num: Int): Boolean {

        if (this.isEmpty()) return false

        var start = 0
        var end = this.lastIndex
        var mid: Int

        while(start <= end) {
            mid = start + (end - start) / 2
            if (this[mid] == num) return true
            else if (this[mid] > num) end = mid - 1
            else start = mid + 1
        }

        return false
    }
}