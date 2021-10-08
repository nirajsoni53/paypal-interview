package tree;

/*111. Minimum Depth of Binary Tree*/
public class MinHeight {

    public int minDepth(Tree root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return height(root);
    }

    private int height(Tree root){
        if(root == null) return 0;
        int lH = height(root.left);
        int rH = height(root.right);
        int min = Math.min(lH, rH);
        return min == 0 ? Math.max(lH, rH) + 1 : min + 1;
    }
}
