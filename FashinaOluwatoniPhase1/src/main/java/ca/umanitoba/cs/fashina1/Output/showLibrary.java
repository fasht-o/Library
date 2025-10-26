package ca.umanitoba.cs.fashina1.Output;

import ca.umanitoba.cs.fashina1.Model.classes.Library;

/**
 * Displays library information including users, media, and rooms count.
 */
public record showLibrary() implements showOutput<Library> {
    /**
     * Displays detailed information about a single library.
     *
     * @param library the library to display
     */
    @Override
    public void showOutput(Library library) {
        System.out.println("The library name is " + library.getName());
        System.out.println("The library type is " + library.getLibraryType());
        System.out.println("The maximum capacity is " + library.getCapacity());
        System.out.println("The number of User in the library is " + library.getUsers().size());
        System.out.println("The number of Media in the library is " + library.getMedias().size());
        System.out.println("The number of Rooms in the library is " + library.getRooms().size());
    }
}