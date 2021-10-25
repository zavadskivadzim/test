package com.zavadski.task5;

//Есть набор предметов, задаваемый заранее, предметы могут повторяться.
// Предмет имеет 2 параметра (обязательных, остальные добавлять на усмотрение):
// объем (целое значение) и ценность (целое значение). Предметы неделимы.
// Также задаётся сейф с обязательным параметром его объёма (целое значение).
//
//  Нужно написать программу, которая наполняет сейф набором предметов таким образом,
//  чтобы ценность этого набора была максимальной.

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите вместимость вашего сейфа: ");
        int saveVolume = scanner.nextInt();

        int n = 12;
        Thing[] things = {new Thing("Золото", 5, 100),
                new Thing("Золото", 5, 100),
                new Thing("Золото", 5, 100),
                new Thing("Серебро", 3, 50),
                new Thing("Серебро", 3, 50),
                new Thing("Серебро", 3, 50),
                new Thing("Бронза", 2, 30),
                new Thing("Бронза", 2, 30),
                new Thing("Бронза", 2, 30),
                new Thing("Дерево", 1, 10),
                new Thing("Дерево", 1, 10),
                new Thing("Дерево", 1, 10)};

        Safe[][] safe = new Safe[n + 1][saveVolume + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < saveVolume + 1; j++) {
                if (i == 0 || j == 0) {
                    safe[i][j] = new Safe(new Thing[]{}, 0);
                } else if (i == 1) {
                    safe[1][j] = things[0].getVolume() <= j ? new Safe(new Thing[]{things[0]}, things[0].getValue())
                            : new Safe(new Thing[]{}, 0);
                } else {
                    if (things[i - 1].getVolume() > j)
                        safe[i][j] = safe[i - 1][j];
                    else {
                        int newValue = things[i - 1].getValue() + safe[i - 1][j - things[i - 1].getVolume()].getValue();
                        if (safe[i - 1][j].getValue() > newValue)
                            safe[i][j] = safe[i - 1][j];
                        else {
                            safe[i][j] = new Safe(Stream.concat(Arrays.stream(new Thing[]{things[i - 1]}),
                                    Arrays.stream(safe[i - 1][j - things[i - 1].getVolume()].getThings())).toArray(Thing[]::new), newValue);
                        }
                    }
                }
            }
        }
        List<Safe> kolonka = Arrays.stream(safe).map(stroka -> stroka[stroka.length - 1]).collect(Collectors.toList());
        Safe max = kolonka.stream().max(Comparator.comparing(Safe::getValue)).orElse(new Safe(null, 0));
        System.out.println("Максимальновозможная ценность вашего сейфа будет со следующим набором вещей:");
        System.out.println(max.showSafe());
    }
}
