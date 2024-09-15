import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        printThreeWords();                    //Задача1
//        checkSumSign();                       //Задача2
//        printColor();                         //Задача3
//        compareNumbers();                     //Задача4
//        sumNumbers();                         //Задача5
//        positiveNumber();                     //Задача6
//        negativeNumber();                     //Задача7
//        doubleString();                       //Задача8
//        highGradeYear();                      //Задача9
//        replacementArray();                   //Задача10
//        newArray();                           //Задача11
//        multArray();                          //Задача12
//        squareTableArray();                   //Задача13
        initialValueArray();                    //Задача14
    }

    //    ____________________________Задача_1____________________________________________________________________
       public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    //    ____________________________Задача_2____________________________________________________________________
        public static void checkSumSign(){
        int a = 5;
        int b = -7;

        if ((a+b)>=0)
            System.out.println("Сумма положительная");
        else
            System.out.println("Сумма отрицательная");
    }
    //    ____________________________Задача_3____________________________________________________________________
    public static void printColor() {
        int value = 101;

        if (value <= 0)
            System.out.println("Красный");
        else if (value > 100)
            System.out.println("Желтый");
        else
            System.out.println("Зеленый");

    }
    //    ____________________________Задача_4____________________________________________________________________
    public static void compareNumbers() {
        int a = 5;
        int b = 3;

        if (a>=b)
            System.out.println("a>=b");
        if (a<b)
            System.out.println("a<b");

    }
    //    ____________________________Задача_5____________________________________________________________________
    public static void sumNumbers() {
        int a = 5;
        int b = 5;
        boolean sum = true;
        if ( a+b > 9 & a+b<21)
            System.out.println (sum);

       else {
            sum = false;
            System.out.println (sum);
       }
}
    //    ____________________________Задача_6____________________________________________________________________
    public static void positiveNumber() {
        int a = -1;
        if (a>=0)
            System.out.println ("Число положительное");
        else
            System.out.println ("Число отрицательное");
    }
    //    ____________________________Задача_7____________________________________________________________________
    public static void negativeNumber(){
        int a = 0;
        boolean resl = true;
        if (a<0)
            System.out.println (resl);
        else {
            resl = false;
            System.out.println (resl);
        }
    }
    //    ____________________________Задача_8____________________________________________________________________
    public static void doubleString(){
        int a = 1;
        String tekst = "Повторяю текст";
        for (int i=0; i<a; i++)
        {System.out.println (tekst);}
        }
    //    ____________________________Задача_9____________________________________________________________________
    public static void highGradeYear(){
        int a = 800;
        boolean year = false;
        if (a%4==0){
            if (a%100==0 & a%400!=0)
            System.out.println(year);
            else if (a%400==0){
            year = true;
            System.out.println(year);
            }
            else {
            year = true;
            System.out.println(year);
            }
        }
        else
            System.out.println(year);
    }
    //    ____________________________Задача_10____________________________________________________________________
    public static void replacementArray(){
        int [] arr = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        for (int i=0; i<arr.length; i++){
        if (arr[i]==1)
        arr[i] = 0;
        else
        arr[i] = 1;}
        System.out.println(Arrays.toString(arr));
    }
    //    ____________________________Задача_11____________________________________________________________________
    public static void newArray(){
        int [] arr = new int[100];
        for (int i=0; i<arr.length; i++){
            arr[i] = i+1;
        }
        System.out.println(Arrays.toString(arr));
    }
    //    ____________________________Задача_12____________________________________________________________________
    public static void multArray(){
        int [] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i=0; i<arr.length; i++){
            if (arr[i]<6)
            arr[i] = arr[i]*2;
        }
        System.out.println(Arrays.toString(arr));
    }
    //    ____________________________Задача_13____________________________________________________________________
    public static void squareTableArray(){
        int [] [] table = new int [30] [30];
        for (int t=0; t< table.length; ++t) {
            for (int i = 0; i < table.length; ++i) {
                if (t==i)
                    table[t][i] = 1;
                else
                    table[t][i] = 0;
                System.out.print(table[t][i] + " ");
            }
            System.out.println();
        }
    }
    //    ____________________________Задача_14____________________________________________________________________
    public static void initialValueArray(){
       int len = 10;
       int initialValue = 333;
        int [] arr = new int[len];
        for (int i=0; i<arr.length; i++){
            arr[i] = initialValue;
        }
        System.out.println(Arrays.toString(arr));
    }
}

