package Graph;

import java.util.Arrays;

public class RankTransform {
    static class pair implements Comparable<pair>
    {
        int r;
        int c;
        int val;
        public pair(int r,int c,int val)
        {
            this.r=r;
            this.c=c;
            this.val=val;
        }
        public int compareTo(pair o)
        {
            return this.val-o.val;
        }
    }
    public static void main(String[] args) {
        int[][] mat= {{3,2,1},{6,4,9},{5,0,8}};
        int rank=1;
        int[]row=new int[3];
        int[]col=new int[3];
        Arrays.fill(row,-1);
        Arrays.fill(col,-1);
        int[][] ans=new int[3][3];
        pair[] pairs=new pair[9];
        int indx=0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                pairs[indx++]=new pair(i,j,mat[i][j]);
            }
        }
        Arrays.sort(pairs);


        for(pair p:pairs)
        {
            int r=p.r;
            int c=p.c;
            if(row[r]==-1 && col[c]==-1)
            {
                ans[r][c]=rank;
                row[r]=rank;
                col[c]=rank;
            }
            else
            {
                ans[r][c]=Math.max(row[r],col[c])+1;
                rank=ans[r][c];
                row[r]=rank;
                col[c]=rank;
            }
        }
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}
