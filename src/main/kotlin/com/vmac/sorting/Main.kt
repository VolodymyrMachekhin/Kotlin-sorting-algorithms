package com.vmac.sorting

import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.system.measureTimeMillis

fun main() {
    val array = IntArray(size = 100000) { Random.nextInt(range = 0..100000) }
    listOf(
        BinaryHeapSort,
        BubbleSort,
        InsertionSort,
        MergeSort,
        QuickSort,
        RadixSort,
        SelectionSort
    ).forEach {
        val time = measureTimeMillis {
            it.sort(array.copyOf())
        }
        println("Time in mills for ${it.javaClass.simpleName}: $time")
    }
}

