package org.example.template3.findKClosestElements

class Solution {
    fun findClosestElements(arr: IntArray, interval: Int, x: Int): List<Int> {
        var start = 0
        var end = arr.lastIndex
        var mid = 0

        loop@while (start + 1 < end) {
            mid = start + (end - start) / 2

            if (arr[mid] == x) break@loop
            if (arr[mid] < x) start = mid
            else end = mid
        }

        if (arr[start] == x) end = start
        else if (arr[end] == x) start = end
        else if (arr[mid] == x) {
            start = mid
            end = mid
        }

        val borders : IntArray = getExternalBorders(arr, start, end, interval)
        return getResultList(arr, borders.first(), borders.last(), x, interval)
    }

    private fun getExternalBorders(arr: IntArray, start: Int, end: Int, interval: Int): IntArray {
        val left = if (start - interval + 1 < 0) 0 else start - interval + 1
        val right = if (end + interval - 1 > arr.lastIndex) arr.lastIndex else end + interval - 1
        return intArrayOf(left, right)
    }

    private fun getResultList(arr: IntArray, dStart: Int, dEnd: Int, x: Int, interval: Int) : List<Int> {
        var d = (dEnd - dStart + 1 - interval)
        var ds = dStart
        var de = dEnd
        var r: Int

        while (de - ds + 1 > interval) {
            r = d % 2
            d /= 2

            if (arr[de - d] - x < x - arr[ds + d]) {
                if (d == 0) d = 1
                ds += d
            } else {
                if (d == 0) d = 1
                de -= d
            }
            d += r
        }

        return arr.slice(ds..de)
    }
}

fun main() {
    val solution = Solution()
    println(solution.findClosestElements(intArrayOf(0,0,1,2,3,3,4,7,7,8), 3, 5).joinToString(", "))
    println(solution.findClosestElements(intArrayOf(0,2,2,3,4,6,7,8,9,9), 4, 5).joinToString(", "))
    println(solution.findClosestElements(intArrayOf(1,1,1,10,10,10), 2, 9).joinToString(", "))
    println(solution.findClosestElements(intArrayOf(0,0,0,1,3,5,6,7,8,8), 2, 2).joinToString(", "))
    println(solution.findClosestElements(intArrayOf(1,3,5,5,5,6,7,7,8,8,10,11,11,16,18,18,19,21,22,22,23,23,26,26,27,28,28,30,30,31,32,33,34,35,36,37,38,39,39,41,41,42,42,44,45,45,45,48,49,50,53,53,55,56,56,56,57,59,59,60,61,62,63,64,65,66,66,66,67,67,70,71,76,76,76,77,78,78,78,78,79,81,82,82,83,84,85,86,87,87,89,90,91,91,91,92,95,96,98,98), 43, 61).joinToString(", "))
}