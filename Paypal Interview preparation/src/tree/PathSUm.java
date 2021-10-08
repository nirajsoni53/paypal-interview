package tree;

public class PathSUm {

    static long allSum = 0;
    public static long treePathsSum(Tree root)
    {
        treePathsSum(root, 0);
        return allSum;
    }

    private static void treePathsSum(Tree root, long sum){
        if(root == null) return;
        sum = (sum * 10) + root.value;
        if(root.left == null && root.right ==null) allSum += sum;
        treePathsSum(root.left, sum);
        treePathsSum(root.right, sum);
    }

    public static void main(String[] args) {
        Tree root = new Tree(1);

        //Left Part
        /*root.left = new Tree(3);
        root.left.left =  new Tree(2);
        root.left.right =  new Tree(5);
        root.left.right.left =  new Tree(7);
        root.left.right.right =  new Tree(4);
*/
        //Right Part
/*

        root.right = new Tree(5);
        root.right.right = new Tree(4);
*/

        root.left = new Tree(2);
        root.left.left = new Tree(3);
        root.left.left.left = new Tree(4);
        root.right = new Tree(1);
        System.out.println(treePathsSum(root));

    }
}
