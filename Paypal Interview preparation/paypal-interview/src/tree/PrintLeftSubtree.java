package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Tree{
    int value;
    Tree left, right;
    public Tree(int value){
        this.value = value;
        this.left = this.right = null;
    }
}

public class PrintLeftSubtree {
/*
*        10
*      8    12
*        9
*
* */
    static int maxLevel = 0;
    static void printLeftSubtreeFromRoot(Tree root, int level){
        if(root == null) return;
        if(level > maxLevel){
            System.out.print(root.value + " ");
            maxLevel = level;
        }
        printLeftSubtreeFromRoot(root.left, level+1);
        printLeftSubtreeFromRoot(root.right, level+1);
    }

    public static void main(String[] args) {
        Tree root = new Tree(10);
        root.left = new Tree(8);
        root.right = new Tree(12);
        //root.left.left = new Tree(6);
        root.left.right = new Tree(9);

        printLeftSubtreeFromRoot(root, 1);
    }
}
