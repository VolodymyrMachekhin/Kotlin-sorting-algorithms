package com.vmac.sorting

object RadixSort : SortingAlgorithm {

    override fun sort(array: IntArray) {
        val digit = 10
        val maxValue = array.max() ?: return
        var exp = 1
        while (maxValue / exp > 0) {
            countSortByDigit(
                array = array,
                digit = digit,
                exp = exp
            )
            exp *= digit
        }
    }

    private fun countSortByDigit(array: IntArray, digit: Int, exp: Int) {
        val countArray = IntArray(size = digit)
        val output = IntArray(size = array.size)
        array.forEach { item ->
            countArray[(item / exp) % digit]++
        }

        for (i in 1 until digit) {
            countArray[i] += countArray[i - 1]
        }

        for (i in (array.size - 1) downTo 0) {
            output[countArray[(array[i] / exp) % digit] - 1] = array[i]
            countArray[(array[i] / exp) % digit]--
        }

        output.forEachIndexed { index, value ->
            array[index] = value
        }
    }
}