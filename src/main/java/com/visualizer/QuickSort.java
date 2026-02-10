package com.visualizer;
import java.util.*;
public class QuickSort {
    public static List<SortStep> sort(int[] arr) {
        List<SortStep> steps = new ArrayList<>();
        int[] array = arr.clone();
        int[] counter = {0, 0}; // {comparisons, swaps}

        quickSortHelper(array, 0, array.length - 1, steps, counter);

        return steps;
    }

    public static void quickSortHelper(int[] arr, int low, int high, List<SortStep> steps, int[] counters) {
        if (low < high) {

            int pivot = partition(arr, low, high, steps, counters);

            // Left
            quickSortHelper(arr, low, pivot - 1, steps, counters);

            // Right
            quickSortHelper(arr, pivot + 1, high, steps, counters);
        }
    }

    public static int partition(int[] array, int low, int high, List<SortStep> steps, int[] counters) {
        // Lomuto partition
        int pivot = array[high];
        int i = low - 1;

        for (int j=low; j < high; j++) {
            counters[0]++;

            steps.add(new SortStep (
                    array.clone(),
                    new int[]{j, high},
                    new int[]{},
                    counters[0],
                    counters[1]
            ));

            if (array[j] < pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                counters[1]++;

                steps.add(new SortStep (
                        array.clone(),
                        new int[]{i, j},
                        new int[]{i, j},
                        counters[0],
                        counters[1]
                ));
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        counters[1]++;

        steps.add(new SortStep (
                array.clone(),
                new int[]{i+1, high},
                new int[]{i+1, high},
                counters[0],
                counters[1]
        ));

        return i + 1;
    }
}
