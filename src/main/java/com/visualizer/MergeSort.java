package com.visualizer;
import java.util.*;
public class MergeSort {
    public static List<SortStep> sort(int[] arr) {
        List<SortStep> steps = new ArrayList<>();
        int[] counters = {0,0};
        mergeSortHelper(arr, 0, arr.length - 1, steps, counters);

        return steps;
    }

    public static void mergeSortHelper(int[] array, int left, int right, List<SortStep> steps, int[] counters) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Left half
            mergeSortHelper(array, left, mid, steps, counters);

            // Right half
            mergeSortHelper(array, mid + 1, right, steps, counters);

            merge(array, left, mid, right, steps, counters);
        }
    }
    private static void merge(int[] array, int left, int mid, int right, List<SortStep> steps, int[] counters) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            leftArr[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            counters[0]++; // comparisons

            steps.add(new SortStep(
                    array.clone(),
                    new int[]{left + i, mid + 1 + j},
                    new int[]{},
                    counters[0],
                    counters[1]
            ));

            if (leftArr[i] <= rightArr[j]) {
                array[k] = leftArr[i];
                i++;
            } else {
                array[k] = rightArr[j];
                j++;
            }
            counters[1]++; // counts as swap/move

            steps.add(new SortStep(
                    array.clone(),
                    new int[]{},
                    new int[]{k},
                    counters[0],
                    counters[1]
            ));

            k++;
        }

        // Copy remaining of leftArr
        while (i < n1) {
            array[k] = leftArr[i];
            counters[1]++;

            steps.add(new SortStep(
                    array.clone(),
                    new int[]{},
                    new int[]{k},
                    counters[0],
                    counters[1]
            ));

            i++;
            k++;
        }

        // Copy remains of rightArr
        while (j < n2) {
            array[k] = rightArr[j];
            counters[1]++;

            steps.add(new SortStep(
                    array.clone(),
                    new int[]{},
                    new int[]{k},
                    counters[0],
                    counters[1]
            ));

            j++;
            k++;
        }
    }
}
