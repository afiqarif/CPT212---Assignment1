package com.afiqarif;

public class IntegerSort {
    /**
     * This method is the sorting algorithm
     */
    public static void sort(int[] numArray) {

        // initializing variables and arrays
        int size = numArray.length;
        int[][] array_1 = new int[10][size];
        int[][] array_2 = new int[10][size];

        // getting the maximum number in the array
        int max = getMax(numArray);

        // odd pass flag - true if odd
        boolean isOddPass = false;
        // outer loop to determine the place digit
        for (int place = 1; max / place > 0; place *= 10) {
            
            // create an array pointer that alternate between array_1 and array_2
            int[][] currentArray = isOddPass ? array_1 : array_2;

            // initializing array that hold size of each buckets. size 10 to accomodate 0-9.
            int[] bucketSize = new int[10];

            // placing each elements into their respective buckets based on place digit
            for (int num : numArray) {
                int digit = (num / place) % 10;
                currentArray[digit][bucketSize[digit]] = num;
                bucketSize[digit]++; // increment bucket size for current number
            }

            // reconstruct numArray with partially sorted elements
            int index = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < bucketSize[i]; j++) {
                    numArray[index] = currentArray[i][j];
                    index++;
                }
            }
        }
    }

    /**
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
}
