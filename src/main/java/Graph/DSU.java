package Graph;


import java.util.ArrayList;
import java.util.List;

public class DSU {
    static int[] rdir ={0,-1,0,1};
    static int[] cdir ={-1,0,1,0};
    public static int find(int[]setLeader,int v)
    {
        if(setLeader[v]==v)
            return v;
        int temp=find(setLeader,setLeader[v]);
        return setLeader[v]=temp;
    }
    public static void union(int[]setLeader,int u,int v,int[]rank)
    {
        if(rank[u]>rank[v])
        {
            setLeader[v]=u;
            rank[v]=rank[v]+rank[u];
        }
        else if(rank[u]<rank[v])
        {
            setLeader[u]=v;
            rank[u]=rank[u]+rank[v];
        }
        else
        {
            setLeader[u]=v;
            rank[u]++;
        }
    }
    public static int[] numOfIslandsII(int n, int m, int[][] q) {
        // Write your code here.
        int[][] grid=new int[n][m];
        int[] setLeader = new int[n*m];
        int[] rank = new int[n*m];
        for(int i=0;i<n*m;i++)
        {
            setLeader[i]=-1;
            rank[i]=1;
        }
        int count =0;
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<q.length;i++)
        {
            int row = q[i][0];
            int col = q[i][1];
            int boxno = row*m+col;
            grid[row][col]=1;
            if(setLeader[boxno]!=-1)
                continue;
            setLeader[boxno]=boxno;
            rank[boxno]=1;
            count++;
            System.out.println("loop1"+" boxno "+boxno);
            for(int r=0;r<rdir.length;r++)
            {
                //System.out.println("loop2"+" boxno "+boxno);
                int rr = row+rdir[i];
                int cc = col+cdir[i];
                System.out.println("rr ="+rr+" cc= "+cc);
                if(rr>=0 && rr<n &&cc>=0 &&cc<m && grid[rr][cc]==1)
                {
                    int bno = rr*m+cc;
                    System.out.println("loop3"+" new box  "+bno);
                    int slofval1 = find(setLeader,boxno);
                    int slofval2 = find(setLeader,bno);
                    System.out.println("boxno "+boxno+" setleader "+slofval1);
                    System.out.println("boxno "+bno+" setleader "+slofval2);
                    if(slofval1==slofval2)
                        continue;
                    else if(slofval1!=slofval2)
                    {
                        count--;
                        union(setLeader,slofval1,slofval2,rank);
                    }

                }

            }
            ans.add(count);
        }
        int[]res=new int[ans.size()];
        for(int i=0;i<ans.size();i++)
        {
            res[i]=ans.get(i);
        }
        return res;

    }

    public static void main(String[] args) {
        int[][] q= new int[4][2];
        q[0][0]=0;
        q[0][1]=0;
        q[1][0]=0;
        q[1][1]=1;
        q[2][0]=1;
        q[2][1]=2;
        q[3][0]=2;
        q[3][1]=1;
        numOfIslandsII(3,3,q);
    }
}
