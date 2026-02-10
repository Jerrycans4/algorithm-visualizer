package com.visualizer;

import java.util.*;

public class BubbleSort {
    public static List<SortStep> sort(int[] arr) {
        List<SortStep> steps = new ArrayList<>();
        int[] array = arr.clone();
        int i, j, temp;
        int comparison = 0, swaps = 0;
        ///////////////Actual Bubble Sort Algorithm///////////////
        // Bubble Up
        for (i = 0; i < array.length - 1; i++) {
            for (j = 0; j < array.length - i - 1; j++) {
                comparison++;

                steps.add(new SortStep(
                        array.clone(),
                        new int[]{j, j+1},
                        new int[]{},
                        comparison,
                        swaps
                ));

                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swaps++;

                    steps.add(new SortStep (
                            array.clone(),
                            new int[]{j, j+1}, // compared and
                            new int[]{j, j+1}, // swapped indices
                            comparison,
                            swaps
                    ));
                }
            }
        }

        return steps;
    }

}
