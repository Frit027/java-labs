import java.util.Scanner;

public class TestBook {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String title, author;
        int pages, year;

        title = in.nextLine();
        author = in.nextLine();
        pages = in.nextInt();
        year = in.nextInt();

        Book bookFirst = new Book(title, author, year, pages);
        Book bookSecond = new Book("The Cherry Orchard","Chekhov");
        Book bookThird = new Book("The Grey Wolf");
        Book bookFourth = new Book();

        bookFourth.setTitle("So said Zarathustra");
        bookFourth.setAuthor("Nietzsche");
        bookFourth.setNumberOfPages(410);
        bookFourth.setYear(1520);

        System.out.println(bookSecond.getAuthor() + " " + bookSecond.getTitle() +
               " " + bookSecond.getYear() + " " + bookSecond.getNumberOfPages());

        System.out.println(bookFirst);
        System.out.println(bookSecond);
        System.out.println(bookThird);
        System.out.println(bookFourth);
    }
}