package Tree.DponTrees;

import java.util.ArrayList;
import java.util.Scanner;

public class TreeDIstance1_approach2 {
    static int longest[];
    static int secondlongest[];
    static int[] ans;
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
        int[][] edge=new int[n][2];
        for(int i=1;i<n;i++)
        {
            edge[i][0]=sc.nextInt();
            edge[i][1]=sc.nextInt();
        }
        longest=new int[n+1];
        secondlongest=new int[n+1];
        ans=new int[n+1];
        ArrayList<Integer>[] graph=createGraph(n,edge);
        dfs(graph,1,-1);
//        for(int i=1;i<n;i++)
//        {
//            System.out.println(i+" -> "+depth[i]);
//        }
        dfs2(graph,1,-1,-1);
        for(int i=1;i<=n;i++)
        {
            System.out.println(i+" -> "+longest[i]);
        }
        for(int i=1;i<=n;i++)
        {
            System.out.println(i+" -> "+secondlongest[i]);
        }
        for(int i=1;i<=n;i++)
        {
            System.out.println(ans[i]);
        }
    }
    //find longesta nd second longest child of each node
    public static void dfs( ArrayList<Integer>[] graph,int src,int parent)
    {

        for(int child:graph[src])
        {
            if(child==parent)
                continue;
            dfs(graph,child,src);
            if (longest[child] + 1 > longest[src]) {
                secondlongest[src] = longest[src];
                longest[src] = longest[child] + 1;
            } else if (longest[child] + 1 > secondlongest[src]) {
                secondlongest[src] = longest[child]+1;
            }
        }
    }
    public static void dfs1(ArrayList<Integer>[] graph,int node , int parent ) {
        for (int i : graph[node])
            if (i != parent) {
                dfs1(graph,i, node);
                if (longest[i] + 1 > longest[node]) {
                    secondlongest[node] = longest[node];
                    longest[node] = longest[i] + 1;
                } else if (longest[i] + 1 > secondlongest[node]) {
                    secondlongest[node] = longest[i] + 1;
                }
            }
    }
    public static void dfs2( ArrayList<Integer>[] graph,int src,int parent,int parent_contribution)
    {
        ans[src] = Math.max(parent_contribution, longest[src]);
        for (int i : graph[src])
            if (i != parent) {
                if (longest[i] + 1 == longest[src])
                    dfs2(graph,i, src, Math.max(parent_contribution, secondlongest[src] )+ 1);
                else
                    dfs2(graph,i, src, ans[src] + 1);
            }
    }

}
