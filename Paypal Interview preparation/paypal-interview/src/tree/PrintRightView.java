package tree;

public class PrintRightView {
    /*
    *     10
    *   8    11
    * 7   9     12
    *
    * */
    static int maxLevel = 0;
    static void printRightView(Tree root, int level){
        if(root == null) return;
        if(level > maxLevel){
            System.out.print(root.value+" ");
            maxLevel = level;
        }

        printRightView(root.right, level + 1);
        printRightView(root.left, level + 1);
    }

    public static void main(String[] args) {
        Tree root = new Tree(10);
        root.left = new Tree(8);
        root.right = new Tree(11);
        root.right.right = new Tree(12);
        root.left.left = new Tree(7);
        root.left.right = new Tree(9);

        printRightView(root, 1);
    }
}
