package org.example;


public class Factorial {
    public static int factorial(int n) {
        long result = 1;

        if (n < 0) {
            System.out.println("Число n отрицательное число.");
        } else if (n == 0) {
            result = 1;
        } else {
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
        }
        System.out.println("Факториал числа " + n + " равен: " + result);
        return (int) result;
    }
}
