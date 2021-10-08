package tree.easy;

import tree.Tree;

public class SubTreeOfSameTree {
    public boolean isSubtree(Tree root, Tree subRoot) {
        return findAndMatchTree(root, subRoot);
    }
    private boolean findAndMatchTree(Tree root, Tree subRoot){
        if(root != null && subRoot == null) return false;
        else if(root == null && subRoot != null) return false;
        else if(root == null && subRoot == null) return true;
        if(root.value == subRoot.value
                && matchTree(root, subRoot)
                || findAndMatchTree(root.left, subRoot)
                || findAndMatchTree(root.right, subRoot))
            return true;

        return false;
    }

    private boolean matchTree(Tree root, Tree subRoot){
        if(root != null && subRoot == null) return false;
        else if(root == null && subRoot != null) return false;
        else if(root == null && subRoot == null) return true;
        else if(root.value != subRoot.value) return false;
        return matchTree(root.left, subRoot.left)
        && matchTree(root.right, subRoot.right);
    }

    public static void main(String[] args) {

        /*Tree root = new Tree(3);
        root.left = new Tree(4);
        root.left.left = new Tree(1);
        root.left.right = new Tree(2);
        //root.left.right.left = new Tree(0);
        root.right = new Tree(5);

        Tree subRoot = new Tree(4);
        subRoot.left = new Tree(1);
        subRoot.right = new Tree(2);
        subRoot.right.left = new Tree(0);
*/
        Tree root = new Tree(1);
        root.left = new Tree(1);

        Tree subRoot = new Tree(1);

        boolean result = new SubTreeOfSameTree().isSubtree(root, subRoot);
        System.out.println(result);
    }
}
