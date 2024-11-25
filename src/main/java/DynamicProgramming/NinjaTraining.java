package DynamicProgramming;

public class NinjaTraining {

    public static void main(String[] args) {
        int[][] points = new int[][]{{10,50,1},{5,100,11},{5,1000,0}};
       ninjaTraining(3,points);
    }

    public static void ninjaTraining(int n, int points[][]) {

        // Write your code here..
        int[][] dp = new int[points.length][3];
         solve(points,0,0,0,-1,dp);
         for(int i=0;i<dp.length;i++)
         {
             for(int j=0;j<3;j++)
             {
                 System.out.print(dp[i][j]+" ");
             }
             System.out.println();
         }

    }
    public static int solve(int[][] points,int r,int c,int sum,int lc,int[][]dp)
    {
        if(r==points.length)
        {
            return sum;
        }
        if(dp[r][c]!=0)
            return dp[r][c];
        int yescall=-9999;
        int nocall =-9999;
        if(lc!=c)
         yescall= solve(points,r+1,0,sum+points[r][c],c,dp);
        if(c+1<points[0].length)
         nocall =solve(points,r,c+1,sum,lc,dp);
        else
            nocall =solve(points,r+1,0,sum,lc,dp);


        return dp[r][c]=Math.max(yescall,nocall);
    }
}