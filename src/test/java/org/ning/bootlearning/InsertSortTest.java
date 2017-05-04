package org.ning.bootlearning;

import org.junit.Test;

public class InsertSortTest {


    @Test
    public void shouldPrintBubbleSortedList() {
        int[] nums = {3, 2, 4, 5, 8, 11, 6, 1};
        bubbleSort(nums);
        printSorted(nums);
    }


    private void bubbleSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++)
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
        }
    }

    private void printSorted(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
