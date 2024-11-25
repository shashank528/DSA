package recursion;


 public class PartitionEqualSubset {
     static int[][] dp;
    public static boolean canPartition(int[] nums) {
        int k =0;
        for(int i=0;i<nums.length;i++)
        {
            k+=nums[i];
        }
//        if(k%2!=0)
//            return false;
        int target=k;
        dp = new int[nums.length][target+1];
        for(int i=0;i<nums.length;i++)
        {
            dp[i][0]=1;
        }

        boolean flag  = solve(nums,target,dp,nums.length-1);
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return flag;

    }
    public static boolean solve(int[]nums,int target,int[][] dp,int indx)
    {
        if(indx==0)
        {
            if(target==nums[indx]||target==0)
            {
                dp[indx][target]=1;
                return true;
            }
            else
            {
                dp[indx][target]=-1;
                return false;

            }
        }
        if(dp[indx][target]!=0)
        {
            if(dp[indx][target]==1)
                return true;
            else
                return false;
        }
        boolean yes = false;
        if(target-nums[indx]>=0)
            yes = solve(nums,target-nums[indx],dp,indx-1);

        boolean no = solve(nums,target,dp,indx-1);

        boolean flag = yes || no;
        if(flag==true)
            dp[indx][target]=1;
        else
            dp[indx][target]=-1;
        return  yes||no;
    }

     public static void main(String[] args) {
         int[] n= new int[]{3,1,5,2,8};
         canPartition(n);
     }
}
