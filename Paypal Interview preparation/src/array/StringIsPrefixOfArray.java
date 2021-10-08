package array;

public class StringIsPrefixOfArray {
    public boolean isPrefixString(String s, String[] words) {
        if(s == null || s.isEmpty()) return false;
        if(words.length == 0) return false;
        int length = s.length();
        int start = 0;
        int end = 0;

        for(String word: words){
            end = start + word.length(); // 0 + 1 = 1
            if(end > length) return false;
            String subString = s.substring(start, end);
            if(!word.equals(subString)) return false;
            start = end;
            if(end == length) return true;
        }
        if(end != length) return false;
        return true;
    }
}
