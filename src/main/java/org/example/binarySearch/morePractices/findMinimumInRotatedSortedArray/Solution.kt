package org.example.binarySearch.morePractices.findMinimumInRotatedSortedArray

class Solution {
    fun findMin(nums: IntArray): Int {
        if (nums.isEmpty()) return -1
        if (nums[0] < nums.last()) return nums[0]

        var left = 0
        var right = nums.lastIndex
        var mid: Int

        while (left < right) {
            mid = left + (right - left) / 2

            if ((mid == nums.lastIndex) ||
                (mid > 0
                        && nums[mid] < nums[mid - 1]
                        && nums[mid] < nums[mid + 1])
            ) return nums[mid]
            else if (nums[mid] > nums.last()) left = mid + 1
            else right = mid
        }

        return nums[left]
    }
}