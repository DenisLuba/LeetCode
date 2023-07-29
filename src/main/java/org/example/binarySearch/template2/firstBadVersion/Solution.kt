package org.example.template2.firstBadVersion

class Solution: VersionControl() {
    override fun firstBadVersion(n: Int) : Int {
        var left = 1
        var right  = n
        var mid: Int

        while (left  < right) {
            mid = left + (right - left) / 2
            if (isBadVersion(mid)) right = mid
            else left = mid + 1
        }

        return if (isBadVersion(left)) left else -1
    }
}

abstract class VersionControl {

    private val firstBadVersion = 1702766719

    abstract fun firstBadVersion(n: Int)  : Int

    fun isBadVersion(version: Int): Boolean = version >= firstBadVersion
}

fun main() {
    val solution = Solution()
    println(solution.firstBadVersion(2126753390))
}

