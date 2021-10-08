package tree.binaryTree;

import tree.Tree;

public class KthLargestElement {
    int kthSmallest = 0;
    int kth = 0;
    public int kthSmallestO1(Tree root, int k) {
        kth = k;
        kthLargestElement(root);
        return kthSmallest;
    }

    void kthLargestElement(Tree root){
        if(root == null) return;
        kthLargestElement(root.right);
        kth--;
        if (kth == 0){
            kthSmallest = root.value;
        }
        kthLargestElement(root.left);
    }

    public static void main(String[] args) {
        Tree root = new Tree(5);
        root.left = new Tree(3);
        root.left.left = new Tree(2);
        root.left.right = new Tree(4);

        root.right = new Tree(7);
        root.right.left = new Tree(6);
        System.out.println(new KthLargestElement()
                .kthSmallestO1(root, 1));
    }
}
