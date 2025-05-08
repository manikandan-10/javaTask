package com.ebrain.subsample;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class HashSetCore {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> cars = new HashSet<>();

        System.out.print("Enter the number of cars: ");
        int numberOfCars = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfCars; i++) {
            System.out.print("Enter car name " + (i + 1) + ": ");
            String car = scanner.nextLine();
            cars.add(car);
        }

        Iterator<String> it = cars.iterator();
        while (it.hasNext()) {
            String car = it.next();
            boolean hasVowel = containsVowel(car);
            if (hasVowel) {
                it.remove();
            }
        }

        System.out.println("Remaining cars after filter: " + cars);
        scanner.close();
    }

    public static boolean containsVowel(String s) {
        s = s.toLowerCase();
        boolean hasVowel = false;

        for (char c : s.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                hasVowel = true;
                break;
            }
        }

        return hasVowel;
    }
}
