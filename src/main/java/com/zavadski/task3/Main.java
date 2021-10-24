package com.zavadski.task3;

// Создайте программу, которая будет:
//        * подсчитывать количество гласных в словах
//        * выводить слова отсортированным списком по количеству гласных (сначала те, у которых больше гласных)
//        * делать первую гласную букву в слове заглавной
// Предложение вводится пользователем вручную русскими буквами. Разделитель пробел (“ ”).

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите предложение на русском языке:");
        Scanner scanner = new Scanner(System.in);
        StringBuilder predlozhenie = new StringBuilder(scanner.nextLine());
        TextProcessing metods = new TextProcessing();
        int menuItem;
        do {
            System.out.println();
            System.out.println("Что вы хотите сделать?");
            System.out.println("1. Посчитать количество гласных букв \n" +
                    "2. Отсортировать слова по количеству гласных \n" +
                    "3. Сделать первую гласную букву в слове заглавной\n" +
                    "0. Отмена");
            System.out.println("Сделайте ваш выбор: ");

            menuItem = scanner.nextInt();
            switch (menuItem) {
                case (1):
                    System.out.print("Колиество гласных в словах: ");
                    System.out.println(metods.countVowels(predlozhenie));
                    break;
                case (2):
                    System.out.print("Отсортированные по количеству гласных слова: ");
                    metods.sortWords(predlozhenie);
                    break;
                case (3):
                    metods.changeFirstVowel(predlozhenie);
                    break;
                default:
                    System.out.println("Invalid value");
                    break;
            }
        }
        while (menuItem != 0);
    }
}

class LengthComparator implements Comparator<StringBuilder> {
    TextProcessing metods = new TextProcessing();

    @Override
    public int compare(StringBuilder s1, StringBuilder s2) {
        return metods.countVowels(s2) - metods.countVowels(s1);
    }
}

class TextProcessing {
    public int countVowels(StringBuilder string) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ('а') || string.charAt(i) == ('е') || string.charAt(i) == ('и') ||
                    string.charAt(i) == ('о') || string.charAt(i) == ('у') ||
                    string.charAt(i) == ('ю') || string.charAt(i) == ('я') ||
                    string.charAt(i) == ('ё') || string.charAt(i) == ('ы') ||
                    string.charAt(i) == ('э')) {
                count++;
            }
        }
        return count;
    }

    List<StringBuilder> list = new ArrayList<>();

    public void sortWords(StringBuilder string) {

        int startPosition = 0;
        int endPosition = 0;
        String word = null;
        for (int i = startPosition; i < string.length(); i++) {
            if ((i == string.length() - 1) && (string.charAt(i) != ' ')) {
                word = string.substring(startPosition, endPosition + 1);
                list.add(new StringBuilder(word));
            }
            if (string.charAt(i) != ' ') {
                endPosition++;
                continue;
            }
            if (string.charAt(i) == ' ') {
                word = string.substring(startPosition, endPosition);
                startPosition = i + 1;
                endPosition++;
                list.add(new StringBuilder(word));
            }
        }
        Collections.sort(list, new LengthComparator());
        System.out.println(list);
    }

    public void changeFirstVowel(StringBuilder string) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if ((string.charAt(i) == ('а') || string.charAt(i) == ('е') || string.charAt(i) == ('и') ||
                    string.charAt(i) == ('о') || string.charAt(i) == ('у') ||
                    string.charAt(i) == ('ю') || string.charAt(i) == ('я') ||
                    string.charAt(i) == ('ё') || string.charAt(i) == ('ы') ||
                    string.charAt(i) == ('э')) && (count == 0)) {
                string.setCharAt(i, Character.toUpperCase(string.charAt(i)));
                count++;
            }
            if (string.charAt(i) == (' ')) {
                count = 0;
            }
        }
        System.out.println(string);
    }
}
