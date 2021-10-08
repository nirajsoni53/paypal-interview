package dp.house_robber3;


/*
* Time : O(n)
* Space : O(1)
*
* https://leetcode.com/problems/house-robber-iii/
* 337. House Robber III
* Medium
*
*
* Algorithm Explain:
*
*          2
*       /     \ [5,8]
*      7       5
*    /   \      \  [0,8]
*   2     6      8
* [0,0]  / \    [0,0]
*       5  11
*    [0,0] [0,0]
*
*
* Here we use array for with root and without root
* array idx 0 for with root and 1 for without root
*
*  So here as an example if do calculation for sub tree.
*
*        6
*      /   \
*     5     11
*    / \    / \
*
*
* Here 1 choice is choose 6 + subTree(5) + subTree(11) and exclude 5 & 11
* Or choose 5 + 11 and exclude 6, subTree(5) + subTree(11)
*
* Step 1:
* So let's take first 5 and find its maximum value without and with root.
* So for 5 its sub return left = [0,0] and right = [0,0] because they are null.
* either we can take Max(left[0], left[1]) + Max(right[0], right[1])
* or we can take root.val which is 5 + left[0] + right[0]
*
* So, result will be [0, 5]
*
* Step 2:
* So let's take first 11 and find its maximum value without and with root.
* So for 11 its sub return left = [0,0] and right = [0,0] because they are null.
* either we can take Max(left[0], left[1]) + Max(right[0], right[1])
* or we can take root.val which is 11 + left[0] + right[0]
*
* So, result will be [0, 5]
*
*
* Step 3:
* So let's take now 6 and find its maximum value without and with root.
* So for 11 its sub return left = [0,5] and right = [0,11] from step 1 and step 2.
* either we can take Max(left[0], left[1]) + Max(right[0], right[1]) = 5+ 11 = 16
* or we can take root.val which is 6 + left[0] + right[0] = 6
*
* So, result will be [11,6]
* */
public class HouseRobber3Optimized {

    public int rob(TreeNode root) {
        if(root == null) return 0;
        int[] result = robHelper(root);
        return Math.max(result[0], result[1]);
    }

    private int[] robHelper(TreeNode root){
        if(root == null) return new int[2];

        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);

        int[] result = new int[2];
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = root.val + left[0] + right[0];

        return result;
    }

    public static void main(String[] args) {
    }
}
