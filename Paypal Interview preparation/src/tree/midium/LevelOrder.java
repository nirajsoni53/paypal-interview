package tree.midium;

import tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {
    static LinkedList<Tree> list = new LinkedList<>();
    public List<List<Integer>> levelOrder(Tree root) {
        if (root == null) {
            return new ArrayList<>();
        }
        list.addLast(root);
        list.addLast(null); //add null after each level
        ArrayList<Integer> inner = new ArrayList<>();
        ArrayList<List<Integer>> res = new ArrayList<>();
        while (!list.isEmpty()) {
            Tree Tree = list.removeFirst();
            if (Tree != null) {
                inner.add(Tree.value);
                if (Tree.left != null) {
                    list.addLast(Tree.left);
                }
                if (Tree.right != null) {
                    list.addLast(Tree.right);
                }
            } else {
                res.add(inner);
                if (list.isEmpty()) break;
                list.addLast(null); //add null after each level
                inner = new ArrayList<>(); //clear the list to store elements at each level
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.left.left = new Tree(3);
        root.left.right = new Tree(4);
        root.right = new Tree(5);
        new LevelOrder().levelOrder(root);
    }
}
