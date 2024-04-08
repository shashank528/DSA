package recursion;

import java.util.Scanner;

public class Sudoku {
    public static void main(String[] args) {
        char[][] grid = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};


        solve(grid,0,0);

    }

    private static void solve(char[][] grid, int r, int c) {
        if(r==grid.length)
        {
             System.out.println("base case ");

            for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                   System.out.print(grid[i][j]+",");
                }
                 System.out.println();
            }

            return;
        }

        if(grid[r][c]=='.')
        {
            //  System.out.println("if case");
            for(int k=1;k<=9;k++)
            {
                char num=(char)(k+'0');
                //System.out.println("num "+num);
                if(isValid(grid, r, c, num))
                {
                    System.out.println("inside if");
                    grid[r][c] =num;
                    if (c + 1 < grid[0].length)
                        solve(grid, r, c + 1);
                    else {
                        System.out.println("row increased"+r);
                        solve(grid, r + 1, 0);
                    }
                    grid[r][c] = '.';
                }
            }
        }
        else
        {
            //.out.println("else case");
            if(c+1<grid[0].length)
                solve(grid,r,c+1);
            else
                solve(grid,r+1,0);
        }

    }
    public static boolean isValid(char[][] board,int row,int col,char num)
    {
        for (int c = 0; c < board[0].length; c++) {
            if (board[row][c] == num)
                return false;
        }
        // check in column
        for (int r = 0; r < board.length; r++) {
            if (board[r][col] == num)
                return false;
        }
        // check in submatrix
        // rr and cc is starting point of submatrix
        int rr = row - (row % 3);
        int cc = col - (col % 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + rr][j + cc] == num)
                    return false;
            }
        }
        return true;

    }


//    private static void solve(int[][] grid, int r, int c, int count) {
//        if(r==grid.length)
//        {
//          //  System.out.println("base case "+count);
//
//                for(int i=0;i<3;i++)
//                {
//                    for(int j=0;j<3;j++)
//                    {
//                        System.out.print(grid[i][j]+",");
//                    }
//                    System.out.println();
//                }
//
//            return;
//        }
//
//        if(grid[r][c]==0)
//        {
//          //  System.out.println("if case");
//            for(int k=1;k<=9;k++)
//            {
//                if(isValid(grid, r, c, k))
//                {
//                    grid[r][c] = k;
//                    if (c + 1 < grid[0].length)
//                        solve(grid, r, c + 1, count - 1);
//                    else
//                        solve(grid, r + 1, 0, count - 1);
//                    grid[r][c] = 0;
//                }
//            }
//        }
//        else
//        {
//            //.out.println("else case");
//            if(c+1<grid[0].length)
//                solve(grid,r,c+1,count);
//            else
//                solve(grid,r+1,0,count);
//        }
//
//    }
//    public static boolean isValid(int[][] board,int row,int col,int num)
//    {
//        for (int c = 0; c < board[0].length; c++) {
//            if (board[row][c] == num)
//                return false;
//        }
//        // check in column
//        for (int r = 0; r < board.length; r++) {
//            if (board[r][col] == num)
//                return false;
//        }
//        // check in submatrix
//        // rr and cc is starting point of submatrix
//        int rr = row - (row % 3);
//        int cc = col - (col % 3);
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (board[i + rr][j + cc] == num)
//                    return false;
//            }
//        }
//        return true;
//
//    }


}
