import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        printThreeWords(); //Задача1
//        checkSumSign(); //Задача2
//        printColor(); //Задача3
//        compareNumbers(); //Задача4
//        sumNumbers(); //Задача5
//        positiveNumber(); //Задача6
//        negativeNumber(); //Задача7
//        doubleString(); //Задача8
//        highGradeYear(); //Задача9
        replacementArray(); //Задача10

    }

//    **********************************************TASK_1**************************************************************
       public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    //    **********************************************TASK_2**********************************************************
        public static void checkSumSign(){
        int a = 5;
        int b = -7;

        if ((a+b)>=0)
            System.out.println("Сумма положительная");
        else
            System.out.println("Сумма отрицательная");
    }
    //    **********************************************TASK_3**********************************************************
    public static void printColor() {
        int value = 101;

        if (value <= 0)
            System.out.println("Красный");
        else if (value > 100)
            System.out.println("Желтый");
        else
            System.out.println("Зеленый");

    }
    //    **********************************************TASK_4**********************************************************
    public static void compareNumbers() {
        int a = 5;
        int b = 3;

        if (a>=b)
            System.out.println("a>=b");
        if (a<b)
            System.out.println("a<b");

    }
    //    **********************************************TASK_5**********************************************************
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
    //    **********************************************TASK_6**********************************************************
    public static void positiveNumber() {
        int a = -1;
        if (a>=0)
            System.out.println ("Число положительное");
        else
            System.out.println ("Число отрицательное");
    }
//        **********************************************TASK_7**********************************************************
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
    //        **********************************************TASK_8**********************************************************
    public static void doubleString(){
        int a = 1;
        String tekst = "Повторяю текст";
        for (int i=0; i<a; i++)
        {System.out.println (tekst);}
        }
    //    **********************************************TASK_9**********************************************************
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
    //        **********************************************TASK_10**********************************************************
    public static void replacementArray(){
        int [] arr = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
          System.out.println(Arrays.toString(arr));
        for (int i=0; i<arr.length; i++){
        if (arr[i]==1)
        arr[i] = 0;
        else
        arr[i] = 1;}
        System.out.println(Arrays.toString(arr));
    }
    }
