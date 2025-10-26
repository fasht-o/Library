package ca.umanitoba.cs.fashina1.Model.classes;

import com.google.common.base.Preconditions;

import java.util.HashSet;
import java.util.Set;
/**
 * Represents a library system that manages multiple individual libraries..
 */
public class LibrarySystem {
    private final String name;
    private final int capacity;
    private final Set<Library> libraries;
    /**
     * Validates the library system's state to ensure all fields meet business requirements.
     * Performs checks on system data
     */
    private void checkLibrarySystem() {
        Preconditions.checkNotNull(name,"name should not be null");
        Preconditions.checkState(name.length() > 0, "LibrarySystem name should have at least a character");
        Preconditions.checkState(capacity >= 1, "There must be at least a Library in the LibrarySystem");
        Preconditions.checkNotNull(libraries, "Libraries should never be null");
        for(Library l : libraries){
            Preconditions.checkNotNull(l, "Library should never be null");

        }
    }
    /**
     * Creates a new library system with the specified name and capacity.
     * Initializes an empty set of libraries that can be populated later.
     *
     * @param name the name of the library systemy
     * @param capacity the maximum number of libraries the system can contain
     */
    public LibrarySystem(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.libraries = new HashSet<>();

    }
    /**
     * Adds a library to the library system if capacity allows.
     * @param library the library to add to the system, must not be null
     */
    public void addLibrary(Library library) {
        checkLibrarySystem();
        libraries.add(library);
        checkLibrarySystem();

    }
    /**
     * Searches for a library in the system by name.
     * @param name the name of the library to search for, must not be null
     * @return true if a library with the specified name is found, false otherwise
     */
    public boolean findLibrary(String name){
        boolean found = false;
        checkLibrarySystem();
        for(Library l: libraries){
            if(name.equals(l.getName())){
                found = true;
            }
        }
        checkLibrarySystem();
        return found;
    }
   /**Getters*/
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public Set<Library> getLibraries() {
        return libraries;
    }
}
