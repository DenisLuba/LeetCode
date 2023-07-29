package org.example.binarySearch.morePractices.findMinimumInRotatedSortedArray2

class Solution {
    fun findMin(nums: IntArray): Int {
        if (nums.isEmpty()) return -1
        if (nums.first() < nums.last()) return nums.first()

        var start = 0
        var end = nums.lastIndex
        var mid: Int

        while (start < end) {
            mid = start + (end - start) / 2

            if (mid > 0 && nums[mid] < nums[mid - 1])
                return nums[mid]
            else if (nums[mid] == nums[start] && nums[mid] == nums[end])
                return findMin(nums.slice(start..mid).toIntArray())
                    .coerceAtMost(
                        findMin(nums.slice((mid + 1)..end).toIntArray())
                    )
            else if (nums[mid] > nums[end]) start = mid + 1
            else end = mid
        }

        return nums[start]
    }
}