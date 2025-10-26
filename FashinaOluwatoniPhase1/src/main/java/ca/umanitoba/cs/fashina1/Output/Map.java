package ca.umanitoba.cs.fashina1.Output;

import ca.umanitoba.cs.fashina1.Model.classes.Library;

/**
 * Represents a visual map of a library's department layout.
 * This class generates ASCII art representations of library spaces
 * */
public class Map {
    private final Library library;

    /**
     * Creates a new map for the specified library.
     * @param library the library whose map will be displayed, must not be null
     */
    public Map(Library library){
        this.library = library;
    }

    /**
     * Displays an ASCII art representation of the library's department layout.
     */
    public void showMap(){
        // Display library header with personalized name
        System.out.println("\n=== " + library.getName() + " - Department Layout ===");

        System.out.println("\nDepartment Grid Layout:");
        // ASCII art representation of department layout
        // Using box characters to create a visual grid structure
        System.out.println("+----------+           +----------+");
        System.out.println("| Science  |   Art    |Recreation|");
        System.out.println("|    (S)       (A)       (R)    |");
        System.out.println("+----------+   ----    +----------+");
        System.out.println("|Journalism| Business |Hospitality|");
        System.out.println("|    (J)       (B)       (H)    |");
        System.out.println("+----------+          +----------+");
    }
}