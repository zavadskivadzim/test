package com.zavadski.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Создайте программу, которая будет получать число и печатать его в следующем формате
// (формы цифр можно придумать свои, главное, чтобы они читались на экране):
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число:");
        String znachenie = scanner.next();
        System.out.println("Введенное число в красифом формате:");
        for (int i = 0; i < znachenie.length(); i++) {
            list.add(Character.getNumericValue((znachenie.charAt(i))));
        }
        int j = 0;

        String array[][] = new String[10][5];
        array[0] = new String[]{"***    ", "* *    ", "* *    ", "* *    ", "***    "};
        array[1] = new String[]{" **    ", "  *    ", "  *    ", "  *    ", "  *    "};
        array[2] = new String[]{"***    ", "  *    ", "***    ", "*      ", "***    "};
        array[3] = new String[]{"***    ", "  *    ", " **    ", "  *    ", "***    "};
        array[4] = new String[]{"* *    ", "* *    ", "***    ", "  *    ", "  *    "};
        array[5] = new String[]{"***    ", "*      ", "***    ", "  *    ", "***    "};
        array[6] = new String[]{"*      ", "*      ", "***    ", "* *    ", "***    "};
        array[7] = new String[]{"***    ", "  *    ", "  *    ", "  *    ", "  *    "};
        array[8] = new String[]{"***    ", "* *    ", "***    ", "* *    ", "***    "};
        array[9] = new String[]{"***    ", "* *    ", "***    ", "  *    ", "  *    "};

        for (int i=0; i < 5; i++) {
            for (list.get(j); j < list.size(); j++) {
                System.out.print(array[list.get(j)][i]);
            }
            System.out.println();
            j=0;
        }
    }
}

