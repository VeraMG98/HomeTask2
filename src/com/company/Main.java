package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] data = {
                {"БИШКЕК", "8:170.0;10:500.0;30:800.0;50:3495.0->1.0:-1.0"},
                {"ОШ", "8.0:350.0;10.0:900.0;30.0:2460.0;50.0:4926.0->1.0:-1.0"},
                {"АЛМАТЫ", "0.3:650.0;0.5:750.0->1.0:430.0"},
                {"ШЫМКЕНТ", "0.3:700.0;0.5:750.0->1.0:430.0"},
                {"МОСКВА", "0.5:1130.14->1.0:160.0"},
                {"САНКТ-ПЕТЕРБУРГ", "0.5:856.98->1.0:231.53"},
                {"ЛОНДОН", "0.5:2900.0->1.0:500.0"},
                {"МАДРИД", "0.5:3000.0->1.0:700.0"},
        };
        System.out.print("Введите вес товара в килограммах: ");
        double weight = scanner.nextInt();
        System.out.println("Введите код города из нижеперечисленных: ");
        int id = 0;
        while (id < data.length) {
            System.out.println(id + ". " + data[id][0]);
            id++;
        }
        id = scanner.nextInt();
        String[] arr = data[id][1].split("->1.0:");
        double eachNextKgPrice = Double.parseDouble(arr[1]);
        arr = arr[0].split(";");
        id = 0;
        while (id < data.length) {
            String[] temp = arr[id].split(":");
            double intervalWeight = Double.parseDouble(temp[0]);
            double intervalPrice = Double.parseDouble(temp[1]);
            if (weight <= intervalWeight) {
                System.out.println("Цена: " + intervalPrice);
                break;
            } else if (id == arr.length - 1 && eachNextKgPrice == -1.0) {
                System.out.println("Невозможно расчтать цену");
                break;
            } else if (id == arr.length - 1) {
                System.out.println("Цена: " + intervalPrice +
                        (weight - intervalWeight) * eachNextKgPrice);
                id++;
            } else id++;
        }
    }
}
