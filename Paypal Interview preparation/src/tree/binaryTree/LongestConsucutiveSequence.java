package tree.binaryTree;

import tree.Tree;

public class LongestConsucutiveSequence {
    static int maxValue = 0;
    static int findLCS(Tree root){
        findLCS(root, 0, root.value - 1);
        return maxValue;
    }

    static void findLCS(Tree root, int currentCount, int currentValue){
        if(root == null) return;
        if(root.value == currentValue + 1){
            currentCount++;
        }else{
            currentCount = 1;
        }
        if(currentCount > maxValue) maxValue = currentCount;
        findLCS(root.left, currentCount, root.value);
        findLCS(root.right, currentCount, root.value);
    }

    public static void main(String[] args) {
        Tree root = new Tree(8);

        //left side
        root.left = new Tree(9);
        root.left.left = new Tree(10);

        //left right
        root.right = new Tree(6);
        root.right.left = new Tree(3);
        root.right.right = new Tree(7);
        root.right.right.right = new Tree(8);
        root.right.right.right.right = new Tree(9);

        findLCS(root);
    }
}
