package tree.binaryTree;

import tree.Tree;

import java.util.TreeSet;

public class KathSmallestElement {

    public int kthSmallestON(Tree root, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        kthSmallest(root, set, k);
        /*int result = 0;
        for(int val : set){
            if(k == 0){
                result = val;
            }
            k--;
        }
        return result;*/
        return set.last();
    }
    int kthSmallest = 0;
    int kth = 0;
    public int kthSmallestO1(Tree root, int k) {
        kth = k;
        kthSmallestElement(root);
        return kthSmallest;
    }

    void kthSmallestElement(Tree root){
        if(root == null) return;
        kthSmallestElement(root.left);
        kth--;
        if (kth == 0){
            kthSmallest = root.value;
        }
        kthSmallestElement(root.right);
    }

    private void kthSmallest(Tree root, TreeSet<Integer> set, int k) {
        if(root == null) return;
        if(set.size() == k) {
            if(set.last() > root.value)
            {
                set.remove(set.last());
                set.add(root.value);
            }
        }
        else set.add(root.value);
        kthSmallest(root.left, set, k);
        kthSmallest(root.right, set, k);
    }

    public static void main(String[] args) {
        Tree root = new Tree(5);
        root.left = new Tree(3);
        root.left.left = new Tree(2);
        root.left.right = new Tree(4);

        root.right = new Tree(7);
        root.right.left = new Tree(6);
        System.out.println(new KathSmallestElement()
                .kthSmallestO1(root, 3));
    }
}
