package org.example.template2.findPeakElement

class Solution {
    fun findPeakElement(nums: IntArray): Int {
        if (nums.isEmpty()) return -1

        var left = 0
        var right = nums.lastIndex
        var mid = 0

        while (left < right) {
            mid = left + (right - left) / 2

            if ((mid == 0 && nums[0] > nums[1]) ||
                (mid == nums.lastIndex) ||
                (mid > 0
                        && nums[mid] > nums[mid - 1]
                        && nums[mid] > nums[mid + 1])
            ) return mid
            else if (nums[mid] < nums[mid + 1]) left = mid + 1
            else right = mid
        }
        return left
    }
}

fun main() {
    val solution = Solution()
    println(solution.findPeakElement(intArrayOf(1, 2)))
}