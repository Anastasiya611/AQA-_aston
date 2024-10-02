import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//
//        printThreeWords();
//        checkSumSign();
//        printColor();
//        compareNumbers();
//        sumNumbers();
//        positiveNumber();
//        negativeNumber();
//        doubleString();
//        highGradeYear();
//        replacementArray();
//        newArray();
//        multArray();
//        squareTableArray();
//        initialValueArray();
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 5;
        int b = -7;

        if ((a + b) >= 0)
            System.out.println("Сумма положительная");
        else
            System.out.println("Сумма отрицательная");
    }

    public static void printColor() {
        int value = 101;

        if (value <= 0)
            System.out.println("Красный");
        else if (value >= 100)
            System.out.println("Желтый");
        else
            System.out.println("Зеленый");

    }

    public static void compareNumbers() {
        int a = 5;
        int b = 3;

        if (a >= b)
            System.out.println("a>=b");
        if (a < b)
            System.out.println("a<b");

    }

    public static boolean sumNumbers() {
        int a = 1;
        int b = 5;
        boolean sum = true;
        if (a + b > 9 & a + b < 21)
            System.out.println(sum);
        else {
            sum = false;
            System.out.println(sum);
        }
        return sum;
    }

    public static void positiveNumber() {
        int a = -1;
        if (a >= 0)
            System.out.println("Число положительное");
        else
            System.out.println("Число отрицательное");
    }

    public static boolean negativeNumber() {
        int a = -5;
        boolean resl = true;
        if (a < 0)
            System.out.println(resl);
        else {
            resl = false;
            System.out.println(resl);
        }
        return resl;
    }

    public static void doubleString() {
        int a = 1;
        String tekst = "Повторяю текст";
        for (int i = 0; i < a; i++) {
            System.out.println(tekst);
        }
    }

    public static void highGradeYear() {
        int a = 800;
        boolean year = false;
        if (a % 4 == 0) {
            if (a % 100 == 0 & a % 400 != 0)
                System.out.println(year);
            else if (a % 400 == 0) {
                year = true;
                System.out.println(year);
            } else {
                year = true;
                System.out.println(year);
            }
        } else
            System.out.println(year);
    }

    public static void replacementArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                arr[i] = 0;
            else
                arr[i] = 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void newArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void multArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6)
                arr[i] = arr[i] * 2;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void squareTableArray() {
        int[][] table = new int[30][30];
        for (int t = 0; t < table.length; ++t) {
            for (int i = 0; i < table.length; ++i) {
                if (t == i)
                    table[t][i] = 1;
                else
                    table[t][i] = 0;
                System.out.print(table[t][i] + " ");
            }
            System.out.println();
        }
    }

    public static void initialValueArray() {
        int len = 10;
        int initialValue = 333;
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        System.out.println(Arrays.toString(arr));
    }
}

