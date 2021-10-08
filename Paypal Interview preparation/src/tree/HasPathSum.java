package tree;

/*112. Path Sum*/
public class HasPathSum {

    public boolean hasPathSum(Tree root, int targetSum) {
        return hasPathSum(root, targetSum, 0, false);
    }

    public boolean hasPathSum(Tree root, int targetSum, int sum, boolean flag) {
        if(root == null) return false;
        sum = sum + root.value;
        if(sum == targetSum && root.left == null && root.right == null){
            return true;
        }
        flag = flag || hasPathSum(root.left, targetSum, sum, flag);
        flag = flag || hasPathSum(root.right, targetSum, sum, flag);

        return flag;
    }
}
