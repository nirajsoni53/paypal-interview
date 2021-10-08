package basic;

public class PrimeNumber {
    public static String prime(int no){
        for (int i=2;i<no;i++){
            if (no%i==0)
                return "not prime number";

        }
        return "is prime number";
    }

    public static void main(String[] args) {
        System.out.println(prime(17));
    }
}
