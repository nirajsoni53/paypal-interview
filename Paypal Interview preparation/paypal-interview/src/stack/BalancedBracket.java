package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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
        System.out.println(isBalanced("[{()]"));
    }
}
