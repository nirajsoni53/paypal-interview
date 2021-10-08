package tree.binaryTree;

import tree.Tree;

/*
* https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
* 235. Lowest Common Ancestor of a Binary Search Tree
* Easy
 * */
public class LowestCommonAncestor {
    public Tree lowestCommonAncestor(Tree root, Tree p, Tree q)     {
        if(p.value < root.value && q.value < root.value)
            return lowestCommonAncestor(root.left, p, q);
        else if(p.value > root.value && q.value > root.value)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
