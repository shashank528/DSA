package Tree;

import java.util.ArrayList;
import java.util.List;

public class NAryTree {
    static class TreeNode<T>
    {
        T val;
        List<TreeNode<T>> childeren;
        public TreeNode(T val)
        {
            this.val=val;
            this.childeren=new ArrayList<>();
        }

    }
    public static void main(String[] args) {
        int [] arr= new int[10];
        TreeNode<Integer> root= createGnericTree(arr);
    }

    private static TreeNode<Integer> createGnericTree(int[] arr) {
        TreeNode<Integer> root=null;
        return root;
    }
}
