package ca.umanitoba.cs.fashina1;

public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private long ISBN;
    public Book(String title, String author, long ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }
    @Override
    public int compareTo(Book otherBook) {
        int comparison;
        if(this.ISBN < otherBook.ISBN){
            comparison = -1;
        }
        else if(this.ISBN == otherBook.ISBN){
            comparison = 0;
        }
        else{
            comparison = 1;
        }
        return comparison;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public long getISBN() {
        return ISBN;
    }
}