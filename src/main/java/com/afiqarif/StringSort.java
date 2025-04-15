package com.afiqarif;

public class StringSort {
    /**
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
            
            // create an array pointer that alternate between array_1 and array_2
            String[][] currentArray = (place % 2) == 0 ? array_1 : array_2;
            
            // initializing array that hold size of each buckets
            int[] bucketSize = new int[27];

            // placing word into their respective bucket based on letter
            for (String str : strArray) {
                // Convert character at current place to lowercase for case-insensitive comparison
                char currentChar = Character.toLowerCase(str.charAt(place));
                // Space (' ') goes to bucket 26
                int letterPlace = currentChar == ' ' ? 26 : currentChar - 'a';
                currentArray[letterPlace][bucketSize[letterPlace]] = str;
                bucketSize[letterPlace]++; // incrementing bucket size for current character
            }

            // reconstructing strArray with partially sorted elements
            int index = 0;
            for (int i = 0; i < 27; i++) {
                for (int j = 0; j < bucketSize[i]; j++) {
                    strArray[index] = currentArray[i][j];
                    index++;
                }
            }
        }

        // remove padding so that each word has no redundant character (in this case, ' ')
        removePadding(strArray);
    }

    /**
     * This method is to get the maximum length of element in array
     */
    private static int getMaxLength(String[] strArray) {
        int max = -1;
        for (String str : strArray) {
            int strLength = str.length();
            if (max < strLength)
                max = strLength;
        }
        return max;
    }

    /**
     * This method is to add padding to make sure all element in array has the same length
     */
    private static void addPadding(String[] strArray) {
        int maxLength = getMaxLength(strArray);
        for (int i = 0; i < strArray.length; i++) {
            String str = strArray[i];
            int strLength = str.length();
            if (strLength < maxLength) {
                int spacesToAdd = maxLength - strLength;
                // StringBuilder class to add padding.
                StringBuilder padded = new StringBuilder(str);
                for (int j = 0; j < spacesToAdd; j++)
                    padded.append(' ');
                strArray[i] = padded.toString();
            }
        }
    }    

    /**
     * This method is to remove padding
     */
    private static void removePadding(String[] strArray) {
        for (int i = 0; i < strArray.length; i++) {
            String str = strArray[i];
            int start = 0;
            int end = str.length() - 1;
    
            // Find the first non-space character
            while (start <= end && str.charAt(start) == ' ')
                start++;
    
            // Find the last non-space character
            while (end >= start && str.charAt(end) == ' ')
                end--;
    
            // Extract the substring manually
            strArray[i] = (start <= end) ? str.substring(start, end + 1) : "";
        }
    }
}
