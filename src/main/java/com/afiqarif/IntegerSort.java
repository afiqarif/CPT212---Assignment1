package com.afiqarif;

public class IntegerSort {
    /*
     * This method is the sorting algorithm
     */
    public static void sort(int[] numArray) {

        // initializing variables and arrays
        int size = numArray.length;
        int[][] array_1 = new int[10][size];
        int[][] array_2 = new int[10][size];

        // getting the maximum number in the array
        int max = getMax(numArray);

        // outer loop to determine the place digit
        for (int place = 1; max / place > 0; place *= 10) {
            
            // initializing array that hold size of each buckets. size 10 to accomodate 0-9.
            int[] bucketSize = new int[10];

            // placing each elements into their respective buckets based on place digit
            for (int num : numArray) {
                int digit = (num / place) % 10;
                array_1[digit][bucketSize[digit]] = num;
                bucketSize[digit]++; // increment bucket size for current number
            }

            // reconstruct numArray with partially sorted elements
            int index = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < bucketSize[i]; j++) {
                    numArray[index] = array_1[i][j];
                    index++;
                }
            }

            // Swapping array reference for each pass
            swap(array_1, array_2);
        }
    }

    /*
     * This method is to get the maximum element in the array
     */
    private static int getMax(int[] numArray) {
        int max = -1;
        for (int num : numArray) {
            if (max < num)
                max = num;
        }
        return max;
    }

    /*
     * This method is to swap the array reference
     */
    private static void swap(int[][] array_1, int[][] array_2) {
        int[][] temp = array_1;
        array_1 = array_2;
        array_2 = temp;
    }
}
