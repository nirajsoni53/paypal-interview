package tree;

public class Tree {
    public int value;
    public Tree left, right;
    public Tree(int value){
        this.value = value;
        this.left = this.right = null;
    }
}
