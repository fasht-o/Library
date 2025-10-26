package ca.umanitoba.cs.fashina1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestInventory {
    private Inventory[] inventories;

    public TestInventory(int numInventories) {
        inventories = new Inventory[numInventories];
        for (int i = 0; i < numInventories; i++) {
            inventories[i] = new Inventory();
        }
    }

    public void processCommands(String commandFile) {
        try {
            Scanner fileScanner = new Scanner(new File(commandFile));

            // Skip the first line (number of inventories already handled by constructor)
            if (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
            }

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] tokens = line.split(",");
                executeCommand(tokens);
            }

            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + commandFile);
        }
    }

    private void executeCommand(String[] tokens) {
        switch (tokens[0]) {
            case "OPEN":
                handleOpen(tokens);
                break;
            case "COPY":
                handleCopy(tokens);
                break;
            case "ADDALL":
                handleAddAll(tokens);
                break;
            case "REMOVEALL":
                handleRemoveAll(tokens);
                break;
            case "COMBINEWITH":
                handleCombineWith(tokens);
                break;
            case "INCOMMON":
                handleInCommon(tokens);
                break;
            case "MISSINGFROM":
                handleMissingFrom(tokens);
                break;
            case "PRINT":
                handlePrint(tokens);
                break;
            case "PRINTBYAUTHOR":
                handlePrintByAuthor(tokens);
                break;
            default:
                System.out.println("Unknown command: " + tokens[0]);
        }
    }

    private void handleOpen(String[] tokens) {
        String filename = tokens[1];
        int inventoryIndex = Integer.parseInt(tokens[2]);
        loadBooksFromFile(filename, inventoryIndex);
    }

    private void loadBooksFromFile(String filename, int inventoryIndex) {
        try {
            Scanner fileScanner = new Scanner(new File(filename));
            inventories[inventoryIndex] = new Inventory(); // Overwrite existing

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] bookData = line.split(",");
                if (bookData.length == 3) {
                    String title = bookData[0].trim();
                    String author = bookData[1].trim();
                    long isbn = Long.parseLong(bookData[2].trim());

                    Book book = new Book(title, author, isbn);
                    inventories[inventoryIndex].add(book);
                }
            }

            fileScanner.close();
            System.out.println("Loaded books from " + filename + " into inventory " + inventoryIndex);

        } catch (FileNotFoundException e) {
            System.out.println("Error: Book file not found - " + filename);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid ISBN format in file " + filename);
        }
    }

    private void handleCopy(String[] tokens) {
        int sourceIndex = Integer.parseInt(tokens[1]);
        int destIndex = Integer.parseInt(tokens[2]);
        inventories[destIndex] = inventories[sourceIndex].copy();
        System.out.println("Copied inventory " + sourceIndex + " to inventory " + destIndex);
    }

    private void handleAddAll(String[] tokens) {
        int targetIndex = Integer.parseInt(tokens[1]);
        int sourceIndex = Integer.parseInt(tokens[2]);
        inventories[targetIndex].addAll(inventories[sourceIndex]);
        System.out.println("Added all books from inventory " + sourceIndex + " to inventory " + targetIndex);
    }

    private void handleRemoveAll(String[] tokens) {
        int targetIndex = Integer.parseInt(tokens[1]);
        int sourceIndex = Integer.parseInt(tokens[2]);
        inventories[targetIndex].removeAll(inventories[sourceIndex]);
        System.out.println("Removed all books from inventory " + sourceIndex + " from inventory " + targetIndex);
    }

    private void handleCombineWith(String[] tokens) {
        int source1Index = Integer.parseInt(tokens[1]);
        int source2Index = Integer.parseInt(tokens[2]);
        int destIndex = Integer.parseInt(tokens[3]);
        inventories[destIndex] = inventories[source1Index].combineWith(inventories[source2Index]);
        System.out.println("Combined inventory " + source1Index + " and " + source2Index + " into inventory " + destIndex);
    }

    private void handleInCommon(String[] tokens) {
        int source1Index = Integer.parseInt(tokens[1]);
        int source2Index = Integer.parseInt(tokens[2]);
        int destIndex = Integer.parseInt(tokens[3]);
        inventories[destIndex] = inventories[source1Index].inCommon(inventories[source2Index]);
        System.out.println("Created intersection of inventory " + source1Index + " and " + source2Index + " in inventory " + destIndex);
    }

    private void handleMissingFrom(String[] tokens) {
        int sourceIndex = Integer.parseInt(tokens[1]);
        int excludeIndex = Integer.parseInt(tokens[2]);
        int destIndex = Integer.parseInt(tokens[3]);
        inventories[destIndex] = inventories[sourceIndex].missingFrom(inventories[excludeIndex]);
        System.out.println("Created difference (inventory " + sourceIndex + " minus " + excludeIndex + ") in inventory " + destIndex);
    }

    private void handlePrint(String[] tokens) {
        int inventoryIndex = Integer.parseInt(tokens[1]);
        System.out.println("=== Contents of Inventory " + inventoryIndex + " ===");
        inventories[inventoryIndex].printAll();
        System.out.println();
    }

    private void handlePrintByAuthor(String[] tokens) {
        // Handle author names that might contain commas by joining tokens
        StringBuilder authorName = new StringBuilder(tokens[1]);
        for (int i = 2; i < tokens.length - 1; i++) {
            authorName.append(",").append(tokens[i]);
        }
        int inventoryIndex = Integer.parseInt(tokens[tokens.length - 1]);

        System.out.println("=== Books by " + authorName.toString() + " in Inventory " + inventoryIndex + " ===");
        inventories[inventoryIndex].printByAuthor(authorName.toString());
        System.out.println();
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java TestInventory <command-file>");
            return;
        }

        String commandFile = args[0];

        try {
            // First read the number of inventories from the first line
            Scanner fileScanner = new Scanner(new File(commandFile));
            int numInventories = 0;
            if (fileScanner.hasNextLine()) {
                numInventories = Integer.parseInt(fileScanner.nextLine().trim());
            }
            fileScanner.close();

            // Create test inventory with the specified number of inventories
            TestInventory test = new TestInventory(numInventories);
            test.processCommands(commandFile);

        } catch (FileNotFoundException e) {
            System.out.println("Error: Command file not found - " + commandFile);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format in command file");
        }
    }
}
