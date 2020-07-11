package com.vmac.sorting

/**
 * Same as [InsertionSort] with the only difference that binary search is used to find the position in the sorted array
 */
object BinaryInsertion : SortingAlgorithm {

    override fun sort(array: IntArray) {
        for (i in 1 until array.size) {
            val insertionIndex = binarySearch(
                array = array,
                left = 0,
                right = i,
                element = array[i]
            )

            val temp = array[i]
            for (j in i downTo insertionIndex + 1) {
                array[j] = array[j - 1]
            }
            array[insertionIndex] = temp
        }
    }

    private fun binarySearch(array: IntArray, left: Int, right: Int, element: Int): Int {
        var position = right
        if (right > left) {
            val middle = (left + right - 1) / 2
            position = if (element < array[middle]) {
                if (middle == 0 || element >= array[middle - 1]) {
                    middle
                } else {
                    binarySearch(
                        array = array,
                        left = left,
                        right = middle,
                        element = element
                    )
                }
            } else {
                if (element <= array[middle + 1]) {
                    middle + 1
                } else {
                    binarySearch(
                        array = array,
                        left = middle + 1,
                        right = right,
                        element = element
                    )
                }
            }

        }

        return position
    }
}