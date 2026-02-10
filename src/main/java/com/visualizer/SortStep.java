package com.visualizer;

public class SortStep {

        private int[] array;
        private int[] comparing;
        private int[] swapping;
        private int comparisons;
        private int swaps;

        SortStep(int[] array, int[] comparing, int[] swapping, int comparisons, int swaps) {
            this.array = array;
            this.comparing = comparing;
            this.swapping = swapping;
            this.comparisons = comparisons;
            this.swaps = swaps;
        }

        public int[] getArray() {
            return array;
        }

        public int getComparisons() {
            return comparisons;
        }

        public int getSwaps() {
            return swaps;
        }

        public int[] getComparing() {
            return comparing;
        }

        public int[] getSwapping() {
            return swapping;
        }
}


