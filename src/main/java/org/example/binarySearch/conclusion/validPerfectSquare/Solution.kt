package org.example.binarySearch.conclusion.validPerfectSquare

class Solution {
    fun isPerfectSquare(num: Int): Boolean {
        var start = 0
        var end = 92680
        var mid: Int
        var square: Int

        while (start + 1 < end) {
            mid = start + (end - start) / 2
            square = mid * mid

            if (square == num) return true
            if (square > num) end = mid
            if (square < num) start = mid
        }

        return if (start == num || end == num) true else false
    }
}