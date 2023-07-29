package org.example.template1.sqrt

class Solution {
    fun mySqrt(x: Int): Int {

        if (x < 0) return -1

        val target = x.toLong()
        var left = 0L
        var right = target
        var mid = 0L
        while (left <= right) {
            mid = (left + right) / 2
            if ((mid * mid) == target) return mid.toInt()
            else if (mid * mid < target) left = mid + 1
            else right = mid - 1
        }

        return if (mid * mid > target) (--mid).toInt() else mid.toInt()
    }
}