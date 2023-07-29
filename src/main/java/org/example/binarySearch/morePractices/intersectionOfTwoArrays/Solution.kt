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
            arr1 = nums1
            arr2 = nums2
        } else {
            arr1 = nums2
            arr2 = nums1
        }

        for (i in arr1) {
            if (!resultArray.isContain(i) && arr2.isContain(i))
                resultArray += i
        }

        return resultArray
    }

    fun IntArray.isContain(num: Int): Boolean {
        for (i in this) {
            if (i == num) return true
        }
        return false
    }
}