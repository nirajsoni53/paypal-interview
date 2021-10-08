package tree.easy;

import tree.Tree;

/*
* https://leetcode.com/problems/maximum-depth-of-binary-tree/
* 104. Maximum Depth of Binary Tree
* Easy
*
* Given the root of a binary tree, return its maximum depth.
  A binary tree's maximum depth is the number of nodes along
  the longest path from the root node down to the farthest leaf node.
  *
  *      3
  *   4     5
  *       6   7
  *             8
  *  output = 4, maxPath = (3, 5, 7, 8)
* */
public class MaxDepthOrHeight {
    int maxDepth = 0;
    public int maxDepth(Tree root) {
        maxDepth(root, 1);
        return maxDepth;
    }

    private void maxDepth(Tree root, int depth){
        if(root == null) return;
        if(maxDepth < depth){
            maxDepth = depth;
        }
        maxDepth(root.left, depth + 1);
        maxDepth(root.right, depth + 1);
    }
}
