package tree;

public class HeightOFBT {

    private int checkHeight(Tree root){
        if(root == null) return 0;
        int left = checkHeight(root.left);
        int right = checkHeight(root.right);

        return Math.max(left,right) + 1;
    }
}
