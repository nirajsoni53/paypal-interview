package basic;

public class Fibonacci {

    public static void main(String[] args) {
        // 1 2 3 4 5 6 7  8
        // 1 1 2 3 5 8 13 21

        int n= 7;
        int f =1;
        int s =1;
        System.out.print(f + " " + s + " ");
        for (int i = 3; i<=n; i++){
            int temp = f + s;
            f = s;
            s = temp;
            System.out.print(s +" ");
        }
        //System.out.println(s);
    }
}
