package tree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaxPathSUmAnyNode {

    int maxSum = Integer.MIN_VALUE;
    int findMaxSum(Tree root)
    {
        if(root == null) return 0;
        int l = findMaxSum(root.left);
        int r = findMaxSum(root.right);

        int temp = Math.max(Math.max(l,r) +  root.value, root.value);
        int res = Math.max(temp, l + r + root.value);
        maxSum = Math.max(res, maxSum);

        return temp;
    }

    public static void main(String[] args) {
        Tree root = new Tree(10);

        root.left = new Tree(2);
        root.left.left = new Tree(20);
        root.left.right = new Tree(1);

        root.right = new Tree(-25);
        root.right.left = new Tree(3);
        root.right.right = new Tree(4);

        Tree tree = new Tree(10);
        tree.left = new Tree(2);
        tree.right = new Tree(5);
        tree.right.right = new Tree(-2);

        //new MaxPathSUmAnyNode().findMaxSum(root);
        System.out.println(new MaxPathSUmAnyNode().findMaxSum(root));
    }
}
