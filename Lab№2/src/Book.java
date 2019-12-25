public class Book {
    private String title;
    private String author;
    private int year;
    private int numberOfPages;

    public Book(String title, String author, int year, int numberOfPages) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.numberOfPages = numberOfPages;
    }

    public Book(String title, String author) {
        this(title, author, 1845, 486);
    }

    public Book(String title) {
        this(title, "Unknown", 1244, 700);
    }

    public Book() {
        this("War and Peace", "Tolstoy", 1851, 654);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        return "Title: " + title + ". Author: " + author
                + ". Year: " + year + ". NumberOfPages: " + numberOfPages;
    }
}