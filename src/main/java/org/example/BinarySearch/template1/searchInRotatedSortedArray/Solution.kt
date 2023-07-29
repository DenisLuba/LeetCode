package org.example.template1.searchInRotatedSortedArray

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return -1

        var left = 0
        var right = nums.lastIndex
        var mid: Int

        while (left <= right) {
            mid = (left + right) / 2

            if (nums[mid] == target) return mid

            if ((target < nums[mid] && target >= nums[left]) ||
                (target < nums[mid] && nums[mid] < nums[right]) ||
                (target >= nums[left] && nums[mid] < nums[left])) right = mid - 1
            else left = mid + 1
        }

        return -1
    }
}
