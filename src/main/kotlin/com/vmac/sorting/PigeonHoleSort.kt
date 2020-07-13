package com.vmac.sorting

object PigeonHoleSort : SortingAlgorithm {

    override fun sort(array: IntArray) {
        val min = array.min() ?: return
        val max = array.max() ?: return
        val counts = IntArray(max - min + 1)
        array.forEach { item ->
            counts[item - min]++
        }

        var i = 0
        counts.forEachIndexed { index, value ->
            (0 until value).forEach {
                array[i] = index
                i++
            }
        }
    }
}