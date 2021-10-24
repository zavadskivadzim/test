package com.zavadski.task2;

//Создайте программу, которая будет вычислять и выводить на экран простые множители, из которых состоит целое число,
// введенное пользователем. Если введенное число не целое, то нужно сообщать пользователю об ошибке.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        try {
            int vvedennoeZnachenie = scanner.nextInt();
            System.out.print("Для числа " + vvedennoeZnachenie + " простыми множителями являются: ");
            for (int i = 2; i < vvedennoeZnachenie; ) {
                if (vvedennoeZnachenie % i == 0) {
                    System.out.print(i + " ");
                    vvedennoeZnachenie /= i;
                } else {
                    i++;
                }
            }
            System.out.print(vvedennoeZnachenie + " ");
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели некорректные данные.");
        }
    }
}
