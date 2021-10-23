package com.zavadski.task1;

// Напишите программу, которая возвращает сумму цифр, присутствующих в данной строке.
// Если цифр нет, то возвращаемая сумма должна быть равна 0.

public class Main {
    public static void main(String[] args) {
        String string = "мне через 3 месяца и 27 дней будет 30 лет.";
        int sum = 0;
        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i))) {
                sum += Character.getNumericValue(string.charAt(i));
                System.out.println(sum);
            }
        }
    }
}
