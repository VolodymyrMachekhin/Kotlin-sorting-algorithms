package com.vmac.sorting

object InsertionSort : SortingAlgorithm {

    override fun sort(array: IntArray) {
        for (i in 1 until array.size) {
            var insertionIndex = i
            for (j in 0 until i) {
                if (array[i] < array[j]) {
                    insertionIndex = j
                    break
                }
            }
            val temp = array[i]
            for (j in i downTo insertionIndex + 1) {
                array[j] = array[j - 1]
            }
            array[insertionIndex] = temp
        }
    }
}