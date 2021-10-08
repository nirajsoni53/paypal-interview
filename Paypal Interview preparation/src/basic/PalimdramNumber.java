package basic;

import sun.security.util.Length;

public class PalimdramNumber {
    public static boolean palimdram(String s){
        int f=0;
        int l = s.length()-1;
        while (f<l){
            if (!(s.charAt(f)== s.charAt(l))){
                return false;
            }
            f++;
            l--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(palimdram("hollh"));
    }
}
