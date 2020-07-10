package com.vmac.sorting

object BubbleSort : SortingAlgorithm {

    override fun sort(array: IntArray) {
        var sorted = false
        while (!sorted) {
            sorted = true
            for (i in 0..array.size - 2) {
                if (array[i] > array[i + 1]) {
                    array.swap(i, i + 1)
                    sorted = false
                }
            }
        }
    }
}