package mirea;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        /*Задания 1, 4*/

        try(FileWriter file = new FileWriter("TextFiles/FileWriter1.txt", true)) {
            String str = in.nextLine();

            file.write(str);
            file.append('\n');
        }
        catch (IOException ex) {
            ex.getMessage();
        }

        /*Задание 2*/

        try(FileReader file = new FileReader("TextFiles/FileWriter1.txt")) {
            int c;

            while((c = file.read()) != -1)
                System.out.print((char) c);
        }
        catch (IOException ex) {
            ex.getMessage();
        }

        /*Задание 3*/

        try(FileWriter file = new FileWriter("TextFiles/FileWriter2.txt", false)) {
            String str = in.nextLine();

            file.write(str);
        }
        catch (IOException ex) {
            ex.getMessage();
        }
    }
}
