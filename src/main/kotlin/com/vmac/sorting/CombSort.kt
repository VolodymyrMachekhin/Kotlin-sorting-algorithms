package com.vmac.sorting

object CombSort : SortingAlgorithm {

    override fun sort(array: IntArray) {
        var gap = array.size
        var swaped = false
        while (gap > 1 || swaped) {
            swaped = false
            for (i in 0 until array.size - gap) {
                if (array[i] > array[i + gap]) {
                    array.swap(i, i + gap)
                    swaped = true
                }
            }

            gap = nextGap(gap = gap)
        }
    }

    private fun nextGap(gap: Int): Int {
        val nextGap = gap / 13 * 10
        return if (nextGap < 1) 1 else nextGap
    }
}