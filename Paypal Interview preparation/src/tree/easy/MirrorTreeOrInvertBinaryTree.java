package tree.easy;

import tree.Tree;

public class MirrorTreeOrInvertBinaryTree {
    void mirror(Tree node) {
        mirrorHelper(node);
    }

    private Tree mirrorHelper(Tree node){
        if(node == null) return null;
        Tree left = mirrorHelper(node.left);
        Tree right = mirrorHelper(node.right);
        node.left = right;
        node.right = left;
        return node;
    }
}
