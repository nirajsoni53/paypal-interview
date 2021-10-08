package dp;

public class LongestCommonSubSequence {

    public int longestCommonSubSequence(String str1, String str2){
        if(str1.length() == 0 || str2.length() == 0)
            return 0;
        int L[][] = new int[str1.length()+1][str2.length()+1];
        for (int i = 0; i <= str1.length(); i++){
            for (int j = 0; j <= str2.length(); j++){
                if(i == 0 || j == 0){
                    L[i][j] = 0;
                }else if(str1.charAt(i-1) == str2.charAt(j-1) && i!=j){
                    L[i][j] = 1 + L[i-1][j-1];
                    System.out.print(str1.charAt(i));
                } else{
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
                }
            }
        }
        return L[str1.length()][str2.length()];
    }


    public int LongestRepeatingSubsequence(String str)
    {
        if(str.length() == 0 || str.length() == 0)
            return 0;
        int L[][] = new int[str.length()+1][str.length()+1];
        for (int i = 0; i <= str.length(); i++){
            for (int j = 0; j <= str.length(); j++){
                if(i == 0 || j == 0){
                    L[i][j] = 0;
                }else if(str.charAt(i-1) == str.charAt(j-1) && i!=j){
                    L[i][j] = 1 + L[i-1][j-1];
                } else{
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
                }
            }
        }
        return L[str.length()][str.length()];
    }

    public int kThPelindrom(String str, String str1){
        int L[][] = new int[str.length()+1][str1.length()+1];
        for (int i = 0; i <= str.length(); i++){
            for (int j = 0; j <= str1.length(); j++){
                if(i == 0 || j == 0){
                    L[i][j] = 0;
                }else if(str.charAt(i-1) == str1.charAt(j-1)){
                    L[i][j] = L[i-1][j-1];
                } else{
                    L[i][j] = 1+ Math.min(L[i-1][j], L[i][j-1]);
                }
            }
        }
        return L[str.length()][str1.length()] / 2;
    }
    public static void main(String[] args) {
        LongestCommonSubSequence lcs = new LongestCommonSubSequence();
        String s1 = "AGGTAB";
        String s2 = "AGGTAB";

        System.out.println(lcs.longestCommonSubSequence(s1, s2));
        System.out.println(lcs.kThPelindrom("abcdeca", "acedcba"));
    }
}
