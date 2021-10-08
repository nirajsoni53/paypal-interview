package tree.easy;

import tree.Tree;

public class PreOrder {
    static void printInOrder(Tree root){
        if(root == null) return;
        printInOrder(root.left);
        System.out.print(root.value+" ");
        printInOrder(root.right);
    }

    static void printPreOrder(Tree root){
        if(root == null) return;
        System.out.print(root.value+" ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    static void printPostOrder(Tree root){
        if(root == null) return;
        printPreOrder(root.left);
        printPreOrder(root.right);
        System.out.print(root.value+" ");
    }

    public static void main(String[] args) {
        Tree root = new Tree(10);
        root.left = new Tree(8);
        root.right = new Tree(12);
        //root.left.left = new Tree(6);
        root.left.right = new Tree(9);
        printInOrder(root);
        System.out.println();
        printPreOrder(root);
        System.out.println();
        printPostOrder(root);
    }
}
