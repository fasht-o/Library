package ca.umanitoba.cs.fashina1.Output;

/**
 * Interface for displaying various library system components.
 * Provides a common contract for showing different types of library entities.
 */
public interface showOutput<T> {
    /**
     * Displays information about library entities.
     *
     * @param item the collection of items to display
     */
    void showOutput(T item);
}