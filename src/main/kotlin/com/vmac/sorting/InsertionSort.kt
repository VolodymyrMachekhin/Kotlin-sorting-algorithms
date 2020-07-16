package com.vmac.sorting

object InsertionSort : SortingAlgorithm {

    override fun sort(array: IntArray) {
        for (i in 1 until array.size) {
            val temp = array[i]
            var j = i
            while (j > 0 && array[j - 1] > temp) {
                array[j] = array[j - 1]
                j--
            }
            array[j] = temp
        }
    }
}