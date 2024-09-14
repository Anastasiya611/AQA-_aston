public class Main {
    public static void main(String[] args) {
//        printThreeWords();
//        checkSumSign();
//        printColor();
//        compareNumbers();
//        sumNumbers();
//        positiveNumber();
//        negativeNumber();
        doubleString();
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
    }
