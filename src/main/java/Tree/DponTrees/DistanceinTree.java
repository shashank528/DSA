package Tree.DponTrees;

import java.util.ArrayList;
import java.util.Scanner;

public class DistanceinTree {
    static int[] ans;
    static int[][] dp1;
    static int[][] dp2;
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
    public static void dfs(ArrayList<Integer>[]graph,int src,int parent,int k)
    {
        for(int child:graph[src])
        {
            if(child!=parent)
            {
                dfs(graph,child,src,k);
            }
        }
        dp1[src][0]=1;
        for(int distance=1;distance<=k;distance++)
        {
            for(int child:graph[src])
            {
                dp1[src][distance] += dp1[child][distance-1];
            }
        }
    }
    public static void dfs2(ArrayList<Integer>[]graph,int src,int parent,int k)
    {
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[][] edge=new int[n][2];
        for(int i=1;i<n;i++)
        {
            edge[i][0] = sc.nextInt();
            edge[i][1] = sc.nextInt();
        }
        ans=new int[n+1];
        ArrayList<Integer>[] graph=createGraph(n,edge);
        dp1=new int[n+1][n+1];
        dp2=new int[n+1][n+1];
        dfs(graph,0,-1,k);

    }
}
