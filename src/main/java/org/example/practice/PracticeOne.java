package org.example.practice;

import java.util.Scanner;

public class PracticeOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("full atau x, pilih = ");
        String bentukSquare = scanner.next();

        System.out.print("masukkan n = ");
        int n = scanner.nextInt();

        System.out.println();
        switch (bentukSquare) {
            case "full" -> fullSquare(n);
            case "x" -> xSquare(n);
            default -> System.out.println("tidak valid");
        }

        scanner.close();
    }

    public static void fullSquare(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void xSquare(int n) {
        int x = n - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i == n - 1 - j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
