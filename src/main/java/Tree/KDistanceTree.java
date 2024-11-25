package Tree;

import java.util.ArrayList;
import java.util.Scanner;

public class KDistanceTree {
    static int[][]dp1;
    static int[][]dp2;
    private static ArrayList<Integer>[] createGraph(int n, int[][] edge) {
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++)
        {
            graph[i] = new ArrayList<>();
        }
        for(int i=1;i<n;i++)
        {
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        return graph;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k= sc.nextInt();
        int[][] edge=new int[n][2];
        for(int i=1;i<n;i++)
        {
            edge[i][0]=sc.nextInt();
            edge[i][1]=sc.nextInt();
        }

        dp1=new int[n+1][k+1];
        dp2=new int[n+1][k+1];
        ArrayList<Integer>[] graph= createGraph(n,edge);
        dfs1(graph,1,-1,k);
        for(int i=0;i<dp1.length;i++)
        {
            for(int j=0;j<=k;j++)
            {
                System.out.print(dp1[i][j]+" ");
            }
            System.out.println();
        }
        dfs2(graph,1,-1,k);
        System.out.println("---------------dp2-----------");
        for(int i=0;i<dp1.length;i++)
        {
            for(int j=0;j<=k;j++)
            {
                System.out.print(dp2[i][j]+" ");
            }
            System.out.println();
        }
        int ans=0;
        for(int i=0;i<dp2.length;i++)
        {
            ans+=dp2[i][k];
        }
        System.out.println(ans);
    }
    public static void dfs1(ArrayList<Integer>[] graph,int src,int parent,int k)
    {
        for(int child:graph[src])
        {
            if(child!=parent)
            {
                dfs1(graph,child,src,k);
            }
        }
        dp1[src][0]=1;
        for(int i=1;i<=k;i++)
        {
            for(int child:graph[src])
            {
                dp1[src][i]+= dp1[child][i-1];
            }
        }
      //  dp1[src][0]=0;
    }
    public static void dfs2(ArrayList<Integer>[] graph,int src,int parent,int k)
    {
        for(int i=0;i<=k;i++)
        {
            dp2[src][i]=dp1[src][i];
        }
            if(parent!=-1)
            {
                dp2[src][1]+=dp2[parent][0];
                for(int i=2;i<=k;i++)
                {
                    dp2[src][i]+=dp2[parent][i-1];
                    dp2[src][i]-=dp1[src][i-2];
                }
            }
//        if(parent!=-1)
//        {
//            dp2[src][k]+=dp2[parent][k-1]-dp2[src][k-2];
//        }
        for(int child:graph[src])
        {
            if(child!=parent)
            {
                dfs2(graph,child,src,k);
            }
        }

    }
}
