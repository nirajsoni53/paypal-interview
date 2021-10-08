package tree;

public class SortedArrayToBST {

    public Tree sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;

        return sortedArrayToBSTHelper(nums, 0 , nums.length - 1);
    }

    private Tree sortedArrayToBSTHelper(int[] nums, int start, int end){
        if(start > end) return null;
        int mid = (start + end) / 2;
        Tree node = new Tree(nums[mid]);
        node.left =  sortedArrayToBSTHelper(nums, start, mid - 1);
        node.right =  sortedArrayToBSTHelper(nums, mid + 1, end);

        return node;
    }
}
