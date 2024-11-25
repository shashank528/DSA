package Tree.DponTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TreeDistances2 {
    static int[] ans;
    static int[] noofnodes;
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
    public static void dfs(ArrayList<Integer>[]graph,int root,int parent)
    {
        int sum=0;
        int subtreesize=1;
        for(int child:graph[root])
        {
            if(child==parent)
                continue;
            dfs(graph,child,root);
            subtreesize+=noofnodes[child];
            sum+=noofnodes[child]+ans[child];
        }
        noofnodes[root]=subtreesize;
        ans[root]=sum;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[][] edge=new int[n][2];
        for(int i=1;i<n;i++)
        {
            edge[i][0]=sc.nextInt();
            edge[i][1]=sc.nextInt();
        }
        ans=new int[n+1];
        noofnodes=new int[n+1];
      //  Arrays.fill(noofnodes,1);
        ArrayList<Integer>[] graph=createGraph(n,edge);
        dfs(graph,1,-1);
//        for(int i=1;i<n;i++)
//        {
//            System.out.println(i+" -> "+depth[i]);
//        }
         dfs2(graph,1,-1);
        for(int i=1;i<=n;i++)
        {
            System.out.println(i+" -> "+ans[i]+" no of nodes "+noofnodes[i]);
        }
    }
    public static void dfs2(ArrayList<Integer>[] graph,int root,int parent)
    {
        for(int child:graph[root])
        {
            if(child==parent)
                continue;
            ans[child]=ans[child]+ans[root]-ans[child]-noofnodes[child]+noofnodes[root]-noofnodes[child];
            noofnodes[child]= noofnodes[child]+noofnodes[root]-noofnodes[child];
            dfs2(graph,child,root);
        }
    }
}
