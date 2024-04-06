package recursion;

import java.util.Scanner;

public class KnightsTour {


    public static int[] xdir = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static int[] ydir = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        boolean[][] matrix = new boolean[n][n];

        printAllMoves(grid,matrix,0,0,n*n,1);
    }

    private static void printAllMoves(int[][] grid, boolean[][] matrix, int sr, int sc, int n, int count) {
        if(count==n-1)
        {
            System.out.println("base case");
            grid[sr][sc]=count;
            for(int i=0;i<grid.length;i++)
            {
                for(int j=0;j<grid.length;j++)
                {
                    System.out.print(grid[i][j]+",");
                }
                System.out.println();
            }

            return;
        }

        for(int i=0;i<xdir.length;i++)
        {
            int dr=sr+xdir[i];
            int dc=sc+ydir[i];
       //     System.out.println("dr ="+dr+" dc "+dc+" count "+count+" index "+i);
            if(dr>=0 &&dr<grid.length && dc >=0 && dc<grid.length && grid[dr][dc]==0)
            {
                grid[dr][dc] = count;
                printAllMoves(grid,matrix,dr,dc,n,count+1);
                grid[dr][dc] = 0;
            }
        }

    }


}
