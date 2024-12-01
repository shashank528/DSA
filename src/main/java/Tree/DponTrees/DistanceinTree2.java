package Tree.DponTrees;

import java.util.ArrayList;
import java.util.Scanner;

public class DistanceinTree2 {
    static int ans;
    static int[][] dp1;
    static int[][] dp2;
    private static ArrayList<Integer>[] createGraph(int n, int[][] edge) {
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++)
        {
            graph[i] = new ArrayList<>();
        }
        for(int i=1;i<=n;i++)
        {
            graph[edge[i-1][0]].add(edge[i-1][1]);
            graph[edge[i-1][1]].add(edge[i-1][0]);
        }
        return graph;
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
        ans=0;
        ArrayList<Integer>[] graph=createGraph(n,edge);
        dp1=new int[n+1][n+1];
        dp2=new int[n+1][n+1];
        dfs(graph,1,-1,k);
        System.out.println(ans);

    }
    public static void dfs(ArrayList<Integer>[] graph,int src,int parent,int k)
    {
        dp1[src][0]=1;
        for(int nbr:graph[src])
        {
            if(nbr==parent)
                continue;
            dfs(graph,nbr,src,k);
            for(int x=1;x<=k;x++)
            {
                dp1[src][x]+=dp1[nbr][x-1];
            }
        }
        ans+=dp1[src][k];
        int total=0;
        for(int nbr:graph[src])
        {
            if(nbr==parent)
                continue;
            for(int x=1;x<=k-1;x++)
            {
                total+=dp1[nbr][x-1]*(dp1[src][k-x]-dp1[nbr][k-x-1]);
            }
        }
        ans+=(total/2);
    }

}
