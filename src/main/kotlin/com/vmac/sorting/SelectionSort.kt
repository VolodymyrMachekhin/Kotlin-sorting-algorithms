package com.vmac.sorting

object SelectionSort : SortingAlgorithm {

    override fun sort(array: IntArray) {
        for (i in array.indices) {
            array.swap(
                i = i,
                j = array.indexOfMin(low = i)
            )
        }
    }

    private fun IntArray.indexOfMin(low: Int, high: Int = this.size - 1): Int {
        var indexOfMin = low
        for (i in low + 1..high) {
            if (this[i] < this[indexOfMin]) {
                indexOfMin = i
            }
        }

        return indexOfMin
    }
}