package com.vmac.sorting

import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.system.measureTimeMillis

fun main() {
    val array = IntArray(size = 100000) { Random.nextInt(range = 0..100000) }
    listOf(
        BubbleSort,
        SelectionSort,
        InsertionSort,
        BinaryInsertion,
        MergeSort,
        QuickSort,
        RadixSort,
        BinaryHeapSort,
        ShellSort
    ).forEach {
        val copy = array.copyOf()
        val time = measureTimeMillis {
            it.sort(copy)
        }
        println("Time in mills for ${it.javaClass.simpleName}: $time")
    }
}

