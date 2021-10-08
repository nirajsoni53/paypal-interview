package trie;

import linkedList.LinkedList;

import java.util.Queue;

class TrieNode{
    TrieNode[] nodes = new TrieNode[26];
    boolean isWord;

    public TrieNode next(char c){
        return nodes[c - 'a'];
    }
}

public class    TrieConstruction {
    TrieNode root;
    public TrieConstruction(){
        this.root = new TrieNode();
    }

    public void insert(String s){
        //s= s.toUpperCase();
        TrieNode currentNode = root;
        for (int i= 0; i< s.length(); i++){
            if(currentNode.next(s.charAt(i)) == null){
                currentNode.nodes[s.charAt(i) - 'a'] = new TrieNode();
            }
            currentNode = currentNode.next(s.charAt(i));
        }
        currentNode.isWord = true;
    }

    public boolean isWordPresent(String s){
        TrieNode currentNode = traverseAndFindLastCharacter(s);
        if (currentNode == null) return false;
        return currentNode.isWord;
    }

    public void delete(String s){
        TrieNode currentNode = root;

        for (int i = 0; i < s.length(); i++){
            if(currentNode.next(s.charAt(i)) == null){
                throw new RuntimeException("");
            }
            currentNode = currentNode.next(s.charAt(i));
        }
        currentNode.isWord = false;
    }

    public boolean startWith(String s){
        return traverseAndFindLastCharacter(s) != null;
    }

    private TrieNode traverseAndFindLastCharacter(String s) {
        TrieNode currentNode = root;
        for (int i = 0; i < s.length(); i++) {
            if (currentNode.next(s.charAt(i)) == null) {
                return null;
            }
            currentNode = currentNode.next(s.charAt(i));
        }
        return currentNode;
    }

    public static void main(String[] args) {
        TrieConstruction trieConstruction = new TrieConstruction();
        trieConstruction.insert("apple");
        trieConstruction.insert("apollo");

        System.out.println(trieConstruction.isWordPresent("apple"));
        System.out.println(trieConstruction.startWith("adp"));

        trieConstruction.delete("apple");
        System.out.println(trieConstruction.isWordPresent("apple"));
        System.out.println(trieConstruction.startWith("ap"));
    }

}
