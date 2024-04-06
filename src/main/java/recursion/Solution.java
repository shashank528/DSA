package recursion;

class Solution {
    public static int[] xdir = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static int[] ydir = {1, 2, 2, 1, -1, -2, -2, -1};
    public static boolean isvalid = false;
    public static boolean isEqual(int[][] matrix, int[][] grid)
    {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
                System.out.print(matrix[i][j]+",");
                if(matrix[i][j]!=grid[i][j])
                    return false;
            }
            System.out.println();
        }
        return true;
    }

    public static boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        int moves = n*n;
        System.out.println("moves "+moves);
        int count =0;
        isvalid = false;
        int[][] matrix  = new int[n][n];
        matrix[0][0]=0;

        solve(grid,0,0,n*n,1,matrix);
        return isvalid;
    }
    public static void solve(int[][] grid,int sr,int sc,int moves,int count,int[][] matrix)
    {
        if(count==moves)
        {
            System.out.println("base case");
            if(isEqual(matrix,grid))
            {
                isvalid = true;
            }
            return;
        }
        System.out.println("count "+count);
        for(int i=0;i<xdir.length;i++)
        {
            int dc = sc + xdir[i];
            int dr = sr + ydir[i];
            if(dr>0 &&dr<grid.length && dc>0 && dc<grid[0].length && matrix[dr][dc]==0)
            {
                matrix[dr][dc]=count;
                solve(grid,dr,dc,moves,count+1,matrix);
                matrix[dr][sc]=0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,11,16,5,20},{17,4,19,10,15},{12,1,8,21,6},{3,18,23,14,9},{24,13,2,7,22}};
        checkValidGrid(grid);

    }
}