package com.vmac.sorting

/**
 * Max heap implementation.
 * To create min heap just replace the comparing logic from largest to smallest
 */
object BinaryHeapSort : SortingAlgorithm {

    override fun sort(array: IntArray) {
        // Building a max heap.
        // Starting from the middle of the array and traversing all leaves.
        for (i in array.size / 2 - 1 downTo 0) {
            heapify(array, i, array.size)
        }

        // The largest element is root with index 0 we need to put it in the end.
        // After largest element is last element in the heap we must heapify our tree again with reduced heap size.
        // After each iteration root element of the tree is the max for it's current heap.
        for (heapSize in array.size - 1 downTo 0) {
            array.swap(0, heapSize)
            heapify(array, 0, heapSize)
        }
    }

    private fun heapify(array: IntArray, i: Int, max: Int) {
        var currentNode = i
        // Traversing all children leaves so the largest element is root in the end
        while (true) {
            val left = 2 * currentNode + 1
            val right = 2 * currentNode + 2
            var largest = currentNode

            if (left < max && array[largest] < array[left]) {
                largest = left
            }
            if (right < max && array[largest] < array[right]) {
                largest = right
            }

            if (largest == currentNode) return
            array.swap(largest, currentNode)
            currentNode = largest
        }
    }

}