package com.vmac.sorting

object QuickSort : SortingAlgorithm {

    override fun sort(array: IntArray) = quickSort(array)

    fun quickSort(array: IntArray, low: Int = 0, high: Int = array.size - 1) {
        if (low < high) {
            val pivotIndex =
                partition(array, low, high)
            quickSort(
                array = array,
                low = low,
                high = pivotIndex - 1
            )
            quickSort(
                array = array,
                low = pivotIndex + 1,
                high = high
            )
        }
    }

    private fun partition(array: IntArray, low: Int, high: Int): Int {
        val pivot = array[high]
        var smallerItemPosition = low - 1

        for (j in low until high) {
            if (array[j] < pivot) {
                smallerItemPosition++
                array.swap(j, smallerItemPosition)
            }
        }

        array.swap(smallerItemPosition + 1, high)

        return smallerItemPosition + 1
    }
}