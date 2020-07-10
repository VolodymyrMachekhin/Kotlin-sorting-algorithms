package com.vmac.sorting

object MergeSort: SortingAlgorithm {

    override fun sort(array: IntArray) = mergeSort(array)

    private fun mergeSort(array: IntArray, low: Int = 0, high: Int = array.size - 1) {
        if (low < high) {
            val middle = (high + low) / 2
            mergeSort(array = array, low = low, high = middle)
            mergeSort(array = array, low = middle + 1, high = high)
            array.merge(low = low, high = high, middle = middle)
        }
    }

    private fun IntArray.merge(low: Int, high: Int, middle: Int) {
        val leftA = IntArray(middle - low + 1)
        val rightA = IntArray(high - middle)
        for (i in low..middle) {
            leftA[i - low] = this[i]
        }
        for (i in middle + 1..high) {
            rightA[i - middle - 1] = this[i]

        }

        var i = 0
        var j = 0
        var arrayIndex = low

        while (i < leftA.size && j < rightA.size) {
            if (leftA[i] < rightA[j]) {
                this[arrayIndex] = leftA[i]
                i++
            } else {
                this[arrayIndex] = rightA[j]
                j++
            }
            arrayIndex++
        }

        while (i < leftA.size) {
            this[arrayIndex] = leftA[i]
            i++
            arrayIndex++
        }

        while (j < rightA.size) {
            this[arrayIndex] = rightA[j]
            j++
            arrayIndex++
        }
    }
}