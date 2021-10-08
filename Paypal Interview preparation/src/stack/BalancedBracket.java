package stack;

import java.util.*;

public class BalancedBracket {
    private static Map<Character,Character> getSymbolCache(){
        Map<Character,Character> symbols = new HashMap<>();
        symbols.put(']', '[');
        symbols.put(')', '(');
        symbols.put('}', '{');
        return symbols;
    }

    public static String isBalanced(String s) {
        if(s == null) return "NO";
        if(s.length() % 2 == 1) return "NO";

        Map<Character,Character> symbols = getSymbolCache();
        Stack<Character> stack = new Stack<>();
        for(char symbol: s.toCharArray()){
            if(!symbols.containsKey(symbol)){
                stack.push(symbol);
            }else{
                if(stack.isEmpty()) return "NO";
                char removed = stack.pop();
                if(symbols.get(symbol) == removed) continue;
                return "NO";
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        //System.out.println(isBalanced("[{()]"));

        List<String> s1 = new ArrayList<>();
        s1.add("moneypot");
        s1.add("mobile");
        Collections.sort(s1);
        System.out.println(s1);
        System.out.println("mouse".substring(0,3));

    }


    public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
        // Write your code here
        Collections.sort(repository);
        int index = 2;
        List<List<String>> result =  new ArrayList<>();
        for(int i=1; i<customerQuery.length(); i++){ //mouse
            List<String> resultString =  new ArrayList<>();
            String subString = customerQuery.substring(0, index);//mous
            for(String s : repository){
                if(subString.length() <= s.length() && subString.equals(s.substring(0,index))){
                    resultString.add(s);
                }
                if(resultString.size() == 3) break;
            }
            result.add(resultString);
            index++;
        }
        return result;
    }
}