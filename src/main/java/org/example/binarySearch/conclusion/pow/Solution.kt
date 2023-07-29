package org.example.binarySearch.conclusion.pow

class Solution {
    fun myPow(x: Double, n: Int): Double {

        val isPositiveDegree = n > 0
        var degree: Int = if (isPositiveDegree) n
        else if (n == Integer.MIN_VALUE) Integer.MAX_VALUE - 1
        else -n
        var number: Double = x
        var result: Double = 1.0
        var remainder: Int
        var notFirst = false

        while (degree > 0) {
            remainder = degree % 2
            degree /= 2

            number = if (notFirst) number * number else {
                notFirst = true
                number
            }

            if (remainder > 0) result *= number
        }

        return if (isPositiveDegree) result else 1 / result
    }
}