package org.example.template2.findMinimumInRotatedSortedArray

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

fun main() {
    val solution = Solution()
    println(solution.findMin(intArrayOf(2, 1)))
    println(solution.findMin(intArrayOf(1, 2, 3, 4, 5)))
    println(solution.findMin(intArrayOf(2, 3, 4, 5, 1)))
    println(solution.findMin(intArrayOf(3, 4, 5, 1, 2)))
    println(solution.findMin(intArrayOf(4, 5, 1, 2, 3)))
    println(solution.findMin(intArrayOf(5, 1, 2, 3, 4)))

}