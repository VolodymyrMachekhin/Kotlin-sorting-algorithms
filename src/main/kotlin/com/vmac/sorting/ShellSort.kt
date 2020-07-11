package com.vmac.sorting

object ShellSort : SortingAlgorithm {

    override fun sort(array: IntArray) {
        var gap = array.size / 2
        while (gap > 0) {

            for (i in gap until array.size) {

                val temp = array[i]
                var j = i
                while (j >= gap && array[j - gap] > temp) {
                    array[j] = array[j - gap]
                    j -= gap
                }
                array[j] = temp
            }

            gap /= 2
        }
    }
}