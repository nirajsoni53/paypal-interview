package dp.house_robber3;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

/**
 * Time: O(2^n)
 * Space: O(1) if we ignore stack space for recursive call.
 *
 * https://leetcode.com/problems/house-robber-iii/
 * 337. House Robber III
 * Medium

 The thief has found himself a new place for his thievery again.
 There is only one entrance to this area, called root.
 Besides the root, each house has one and only one parent house.
 After a tour, the smart thief realized that all houses in this place form a binary tree.
 It will automatically contact the police if two directly-linked houses were broken into on the same night.
 Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.

                3
              /   \
             2     3
             \      \
              3      7

 Here either we take root + its child[child] or we skip root and take its
 left and right child.
 *
 * */
public class HouseRobber3BruteForce {
    public int rob(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;

        return robHelper(root);
    }

    private int robHelper(TreeNode root) {
        if(root == null) return 0;

        int leftSub = 0;
        int rightSub = 0;

        // Here we sum of child[child] for left and right.
        if(root.left != null)
            leftSub = rob(root.left.left) + rob(root.left.right);
        if(root.right != null)
            rightSub = rob(root.right.left) + rob(root.right.right);

        // This case for if we keep with root.
        int keep = root.val + leftSub + rightSub;

        // This case for if we skip root.
        int skip = rob(root.left) + rob(root.right);

        return Math.max(keep, skip);
    }

    public static void main(String[] args) {

    }
}
