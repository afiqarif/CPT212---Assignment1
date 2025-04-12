package com.afiqarif;

public class Main {
    public static void main(String[] args) {

        int[] data = {
            503, 275, 87, 426, 61, 409, 170, 677, 999, 214
        };

        String[] words = {
            "Banana", "apple", "Orange", "mango", "Grape", "Peach", "pear", "Lemon", "kiwi", "Pineapple"
        };

        // Sorting number
        System.out.println("==== Sorting Number ====");
        System.out.println("Unsorted Array: ");
        for (int num : data)
            System.out.print(num + " ");

        IntegerSort.sort(data);
        System.out.println("\n\nSorted Array in Ascending Order: ");
        for (int num : data)
            System.out.print(num + " ");
        System.out.println("\n");
        
        
        // Sorting words
        System.out.println("==== Sorting String ====");
        System.out.println("Unsorted Array: ");
        for (String str : words)
            System.out.print(str + " ");

        StringSort.sort(words);
        System.out.println("\n\nSorted Array in Ascending Order: ");
        for (String str : words)
            System.out.print(str + " ");
        System.out.print("\n\n");

    }
}