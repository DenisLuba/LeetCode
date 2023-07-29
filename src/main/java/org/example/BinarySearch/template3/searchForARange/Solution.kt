package org.example.template3.searchForARange

class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val start = search(nums, target, true)
        val end = search(nums, target, false)

        return intArrayOf(start, end)
    }

    private fun search(nums: IntArray, target: Int, isStart: Boolean): Int {
        if (nums.isEmpty()) return -1

        var start = 0
        var end = nums.lastIndex
        var mid: Int

        while (start + 1 < end) {
            mid = start + (end - start) / 2

            if (isStart
                && nums[mid] == target
                && (mid == 0 || (nums[mid] > nums[mid - 1]))) return mid

            else if (!isStart
                && nums[mid] == target
                && (mid == nums.lastIndex || nums[mid + 1] > nums[mid])) return mid

            else if (isStart && nums[mid] < target) start = mid
            else if (!isStart && nums[mid] <= target) start = mid
            else if (isStart && nums[mid] >= target) end = mid
            else if (!isStart && nums[mid] > target) end = mid
        }

        if (isStart
            && nums[start] == target
            && (start == 0 || (nums[start] > nums[start - 1]))) return start

        if (isStart
            && nums[end] == target
            && nums[end] > nums[start]) return end

        if (!isStart
            && nums[start] == target
            && nums[start] < nums[end]) return start

        if (!isStart
            && nums[end] == target
            && (end == nums.lastIndex || nums[end] < nums[end + 1])) return end

        return -1
    }
}