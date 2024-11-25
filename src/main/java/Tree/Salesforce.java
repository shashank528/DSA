package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Salesforce {
    static final int COUNT = 5;
    static TreeNode temp;
    static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val,TreeNode left,TreeNode right)
        {
            this.val=val;
            this.left=left;
            this.right=right;
        }

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        int[] arr=new int[5];
       arr[0]=2;
       arr[1]=0;
       arr[2]=4;
       arr[3]=0;
       arr[4]=0;
//       arr[5]=0;
//       arr[6]=5;
//       arr[7]=3;
//       arr[8]=4;
//       arr[9]=6;
//       arr[10]=8;
//       arr[11]=2;
//       arr[12]=3;

       TreeNode root = buildTree(arr);
       temp=null;
      //  printTree(root);
        print2D(root);
       dfs(root);
       System.out.println("---------------------------------------------------------------------------------------------------------");
        print2D(root);
       // printTree(root);
    }

    private static void dfs(TreeNode root) {
        if(root==null)
            return;
        if(root.left==null && root.right==null && root.val!=0)
        {
            temp=root;
        }
        dfs(root.left);
        dfs(root.right);
        if(root.val==0 && root.left!=null && root.right!=null)
        {
            if(temp!=null)
            {
                swapValue(root,temp);
                temp=null;
            }
        }

    }

    private static void swapValue(TreeNode root, TreeNode temp) {
        int a=root.val;
        root.val=temp.val;
        temp.val=a;
    }

    public static TreeNode buildTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (i < nums.length) {
            TreeNode curr = q.remove();
            if (i < nums.length) {
                curr.left = new TreeNode(nums[i++]);
                q.add(curr.left);
            }
            if (i < nums.length) {
                curr.right = new TreeNode(nums[i++]);
                q.add(curr.right);
            }
        }
        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }
    static void print2D(TreeNode root)
    {
        // Pass initial space count as 0
        print2DUtil(root, 0);
    }

    static void print2DUtil(TreeNode root, int space)
    {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.val + "\n");

        // Process left child
        print2DUtil(root.left, space);
    }
}
