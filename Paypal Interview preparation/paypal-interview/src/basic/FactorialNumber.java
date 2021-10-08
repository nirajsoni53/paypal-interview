package basic;

public class FactorialNumber {
    public static int factorial(int no){
        int fact=1;
        for (int i=2; i<=no;i++){
            fact=fact*i;

        }
        return fact;
    }
    public static int fibonaci(int number){
        int sum=0;
        for(int i=1;i<=number;i++){
            sum=sum*i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(fibonaci(10));

       // System.out.println(factorial(4));
    }
}
