package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grocery {

    // Public static groceryList ArrayList
    public static ArrayList<String> groceryList = new ArrayList<>();

    // Method to start the console application
    public static void startGrocery() {
        // The logic for starting the console application,
        // interacting with users through Scanner etc.
        // can be added here (if needed in tests).
    }

    // Add items to the grocery list
    public static void addItems(String input) {
        String[] items = input.split(",\\s*");
        for (String item : items) {
            if (!checkItemIsInList(item)) {
                groceryList.add(item.trim());
            }
        }
        Collections.sort(groceryList);  // Sort the list after adding
    }

    // Remove items from the grocery list
    public static void removeItems(String input) {
        String[] items = input.split(",\\s*");
        for (String item : items) {
            if (checkItemIsInList(item)) {
                groceryList.remove(item.trim());
            }
        }
        Collections.sort(groceryList);  // Sort the list after removing
    }

    // Check if a specific item is in the list
    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product.trim());
    }

    // Print the sorted list
    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("Sorted List: " + groceryList);
    }
}
