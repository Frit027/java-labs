package com.mirea;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        /*Task 1*/
        //System.out.println("ЗАДАНИЕ 1");

        /*String line = args[0];
        String delimiter = args[1];

        System.out.println(Arrays.toString(line.split(delimiter)));*/

        /*Task 2*/
        System.out.println("ЗАДАНИЕ 2");

        String reg = "^abcdefghijklmnopqrstuv18340$";
        String str1 = "abcdefghijklmnopqrstuv18340";
        String str2 = "abcdefghijklmnoasdfasdpqrstuv18340";

        System.out.printf("%b %b\n", isRightString(str1, reg), isRightString(str2, reg));

        /*Task 3*/
        System.out.println("ЗАДАНИЕ 3");

        String text = "77.5 USD Get more out of 45 RUB your Wolfram|Alpha " +
                "experience 0.004 EU through 43.4354 USD Web Apps 99.9 powered by 5.99 EU Wolfram|Alpha";

        Pattern pattern1 = Pattern.compile("\\d+\\.\\d{0,2}\\s(USD|RUB|EU)\\s?");
        Pattern pattern2 = Pattern.compile("(\\s|^)\\d+\\s(USD|RUB|EU)\\s?");
        Matcher matcher1 = pattern1.matcher(text);
        Matcher matcher2 = pattern2.matcher(text);

        while (matcher1.find()) {
            System.out.println(matcher1.group().trim());
        }

        while (matcher2.find()) {
            System.out.println(matcher2.group().trim());
        }

        /*Task 4*/
        System.out.println("ЗАДАНИЕ 4");

        String regExp = "\\d\\s?\\+";
        String exp = "(1 + 8) – 9 / 4";

        Pattern pat = Pattern.compile(regExp);
        Matcher match = pat.matcher(exp);

        System.out.println(match.find());

        /*Task 5*/
        System.out.println("ЗАДАНИЕ 5");

        String date = in.nextLine();
        int year = Integer.parseInt(date.substring(6));
        String r_29_28;
        String r_31 = "(0[1-9]|[12][0-9]|31)/(0[13578]|10|12)/(19[0-9][0-9]|[2-9][0-9]{3})";    //1 3 5 7 8 10 12
        String r_30 = "(0[1-9]|[12][0-9]|30)/(0[2469]|11)/(19[0-9][0-9]|[2-9][0-9]{3})";        //2 4 6 9 11

        if (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0)) {
            r_29_28 = "(0[1-9]|1[0-9]|2[0-8])/02/(19[0-9][0-9]|[2-9][0-9]{3})";
        } else {
            r_29_28 = "(0[1-9]|[12][0-9])/02/(19[0-9][0-9]|[2-9][0-9]{3})";
        }

        System.out.println(isRightString(date, r_30, r_31, r_29_28));

        /*Task 6*/
        System.out.println("ЗАДАНИЕ 6");

        String regex = "[0-9a-zA-Z\\._-]+@[a-z0-9-]+(\\.[a-z0-9-_]+)*(\\.[a-z]{2,})?";

        String email = in.nextLine();
        System.out.println(isRightString(email, regex));

        /*Task 7*/
        System.out.println("ЗАДАНИЕ 7");

        String regPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[0-9a-zA-Z]{8,}$";
        String password = in.nextLine();

        System.out.println(isRightString(password, regPassword));
    }

    private static boolean isRightString(String word, String ... regexes) {
        for(String regex : regexes) {
            if (Pattern.matches(regex, word)) {
                return true;
            }
        }
        return false;
    }
}
