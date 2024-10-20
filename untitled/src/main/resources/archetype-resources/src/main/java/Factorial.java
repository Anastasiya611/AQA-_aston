public class Factorial {
    public static void main( String[] args ) {
        int n = 25;
        int rest;
            if (n<0){
                System.out.println ("Число n отрицательное.");
            }
            if else (n==0){
                rest = 1;
            }
            else{
            for (int i =1;i<=n; i++);{
                rest *= i;
        }

        System.out.println("Факториал числа "+ n "=" + rest);
    }
}
