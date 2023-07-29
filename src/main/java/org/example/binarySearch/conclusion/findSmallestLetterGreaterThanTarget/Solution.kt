package org.example.binarySearch.conclusion.findSmallestLetterGreaterThanTarget

class Solution {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        if (letters.isEmpty()) return ' '
        var start = 0
        var end = letters.lastIndex
        var mid: Int

        while (start + 1 < end) {
            mid = start + (end - start) / 2

            if (letters[mid] > target
                && (letters[mid - 1] == target
                        || letters[mid - 1] < target)) return letters[mid]
            if (mid != letters.lastIndex
                && (letters[mid] == target
                        || letters[mid] < target)
                && letters[mid + 1] > target) return letters[mid + 1]

            if (letters[mid] == target || letters[mid] < target ) start = mid
            else end = mid
        }

        if ((letters[start] == target || letters[start] < target)
            && letters[end] > target) return letters[end]
        if (end != letters.lastIndex
            && letters[end] == target
            && letters[end + 1] > target) return letters[end + 1]
        return letters.first()
    }
}