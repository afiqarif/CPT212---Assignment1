package com.afiqarif;

public class StringSort {
    /*
     * This method is the sorting algorithm
     */
    public static void sort(String[] strArray) {

        // initalizing variables and arrays
        int size = strArray.length;
        String[][] array_1 = new String[27][size];
        String[][] array_2 = new String[27][size];
        
        // get the maximum length of element in array
        int maxLength = getMaxLength(strArray);

        // add padding to make sure every element has the same length
        addPadding(strArray);

        // outer loop to determine the place digit
        for (int place = maxLength - 1; place >= 0; place--) {

            // initializing array that hold size of each buckets
            int[] bucketSize = new int[27];

            // placing word into their respective bucket based on letter
            for (String str : strArray) {
                // Convert character at current place to lowercase for case-insensitive comparison
                char currentChar = Character.toLowerCase(str.charAt(place));
                // Space (' ') goes to bucket 26
                int letterPlace = (currentChar == ' ') ? 26 : currentChar - 'a';
                array_1[letterPlace][bucketSize[letterPlace]] = str;
                bucketSize[letterPlace]++; // incrementing bucket size for current character
            }
            

            // reconstructing strArray with partially sorted elements
            int index = 0;
            for (int i = 0; i < 27; i++) {
                for (int j = 0; j < bucketSize[i]; j++) {
                    strArray[index] = array_1[i][j];
                    index++;
                }
            }

            // swapping array reference for each pass
            swap(array_1, array_2);
        }

        // remove padding so that each word has no redundant character (in this case, ' ')
        removePadding(strArray);
    }

    /*
     * This method is to get the maximum length of element in array
     */
    private static int getMaxLength(String[] strArray) {
        int max = -1;
        for (String str : strArray)
            max = max < str.length() ? str.length() : max;
        return max;
    }

    /*
     * This method is to add padding to make sure all element in array has the same length
     */
    private static void addPadding(String[] strArray) {
        int maxLength = getMaxLength(strArray);
        for (int i = 0; i < strArray.length; i++) {
            String str = strArray[i];
            int strLength = str.length();
            if (strLength < maxLength) {
                // putting ' ' based on how many characters are needed to reach maxLength
                strArray[i] = str + " ".repeat(maxLength - strLength);
            }
        }
    }

    /*
     * This method is to remove padding
     */
    private static void removePadding(String[] strArray) {
        for (int i = 0; i < strArray.length; i++) {
            strArray[i] = strArray[i].trim();
        }
    }

    /*
     * This method is to swap array reference
     */
    private static void swap(String[][] array_1, String[][] array_2) {
        String[][] temp = array_1;
        array_1 = array_2;
        array_2 = temp;
    }
}
