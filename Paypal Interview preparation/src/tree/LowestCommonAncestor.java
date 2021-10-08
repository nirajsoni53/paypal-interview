package tree;

/*
* https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
* 236. Lowest Common Ancestor of a Binary Tree
* Medium
*
*         3
*    5    |    1
*  6   2  |  0   8
*    7   4|
*
* e.g. p = 7, q = 0
*
* -> Here 7 is present in 2 so, for root = 2 left will return 7 and right will return
*    null(because 4 is not matching with p or q).
* -> Same work for others.
* -> Conditions:
* - if(left != null && right != null) return root;
* - else if(left != null) return left;
* - else(right != null) return right;
* -> For root 2 left(7) will return 7 and right(4) will return null
* -> For root 5 left(6) will return null and right(2) will return 7
* -> For root 1 left(0) will return 0 and right(8) will return null
* -> For root 3 left(5) will return 7 and right(1) will return 0
* So 3 will be a Ancestor.
* */
public class LowestCommonAncestor {
    public Tree lowestCommonAncestor(Tree root, Tree p, Tree q) {
        if(root == null) return null;
        if(p.value == root.value || q.value == root.value) return root;

        Tree left =  lowestCommonAncestor(root.left, p, q);
        Tree right =  lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) return root;
        else if(left != null) return left;
        else return right;
    }

    public static void main(String[] args) {
        Tree root = new Tree(3);
        root.left = new Tree(5);
        root.left.left = new Tree(6);
        root.left.right = new Tree(2);
        root.left.right.left = new Tree(7);
        root.left.right.right = new Tree(4);

        root.right = new Tree(1);
        root.right.left = new Tree(0);
        root.right.right = new Tree(8);

        Tree result = new LowestCommonAncestor()
                .lowestCommonAncestor(root,
                        new Tree(7), new Tree(0));

        System.out.println(result);
    }
}
