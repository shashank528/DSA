package DynamicProgramming;

public class CherryPickup {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,1,-1},{1,0,-1},{1,1,1}};
        int move1 = grid[0][0]+solve(grid,0,0);
        //System.out.println("move "+move1);
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
           {
               System.out.print(grid[i][j]+" ");
           }
            System.out.println();
        }
        int move2 = solve2(grid,grid.length-1,grid.length-1);
        int move =move1+move2;
        System.out.println("move "+move);
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int solve2(int[][] grid, int r, int c) {
        if(r==0&&c==0)
        {
            return grid[r][c];
        }
        int up=0;
        int left=0;
        if(r-1>=0 &&grid[r-1][c]!=-1)
            up = solve2(grid,r-1,c)+grid[r][c];
        if(c-1>=0)
            left = solve2(grid,r,c-1)+grid[r][c];
        grid[r][c]=0;
        return left+up;
    }

    private static int solve(int[][] grid, int r, int c) {
        if(r==grid.length-1 && c== grid[0].length-1)
        {
            return grid[r][c];
        }

        int right=0;
        int down=0;
        if(r+1<grid.length&&grid[r][c+1]!=-1)
            down = solve(grid,r+1,c)+grid[r][c];
        if(c+1<grid[0].length &&grid[r][c+1]!=-1)
            right= solve(grid,r,c+1)+grid[r][c];
        grid[r][c]=0;


        return right+down;

    }
}
