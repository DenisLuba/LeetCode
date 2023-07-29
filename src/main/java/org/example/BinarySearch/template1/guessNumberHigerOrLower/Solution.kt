package org.example.template1.guessNumberHigerOrLower

class Solution {
    fun guessNumber(n: Int): Int {
        var right = n
        var left = 0
        var mid = 0

        while (left <= right) {
            mid = left + (right - left) / 2

            when (guess(mid)) {
                0 -> return mid
                1 -> left = mid + 1
                -1 -> right = mid - 1
            }
        }

        return mid
    }

    private fun guess(num: Int): Int {
        val target = 12

        return if (num > target) -1
        else if (num < target) 1
        else 0
    }
}

