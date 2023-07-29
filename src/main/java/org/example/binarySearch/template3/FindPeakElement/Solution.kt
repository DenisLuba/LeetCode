package org.example.template3.FindPeakElement

class Solution {
    fun findPeakElement(nums: IntArray): Int {
        if (nums.isEmpty()) return -1

        var start = 0
        var end = nums.lastIndex
        var mid: Int

        while (start + 1 < end) {
            mid = start + (end - start) / 2

            if ((mid == nums.lastIndex) ||
                (mid > 0 &&
                        nums[mid] > nums[mid + 1] &&
                        nums[mid] > nums[mid - 1])
            ) return mid

            else if (nums[mid + 1] > nums[mid]) start = mid
            else end = mid
        }

        return if (nums[start] > nums[end]) start else end
    }
}