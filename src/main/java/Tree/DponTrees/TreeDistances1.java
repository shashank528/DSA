package Tree.DponTrees;

import java.util.ArrayList;
import java.util.Scanner;

//import static Graph.CreateGraph.createGraph;

public class TreeDistances1 {
    static int[] ans;
    static int[] depth;
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
        ans=new int[n+1];
        depth=new int[n+1];
        ArrayList<Integer>[] graph=createGraph(n,edge);
        dfs(graph,1,-1);
//        for(int i=1;i<n;i++)
//        {
//            System.out.println(i+" -> "+depth[i]);
//        }
        dfs2(graph,1,-1,-1);
        for(int i=1;i<=n;i++)
        {
            System.out.println(i+" -> "+ans[i]);
        }
    }
//second recursion yo calculate distance of other nodes
    private static void dfs2(ArrayList<Integer>[] graph, int root, int parent, int partial_ans) {
        int maxlength=-1;
        int secondmaxlength=-1;
        for(int child:graph[root])
        {
            if(child==parent)
                continue;
            if(depth[child]>maxlength)
            {
                secondmaxlength = maxlength;
                maxlength=depth[child];
            }
            else if(depth[child]>secondmaxlength)
            {
                secondmaxlength = depth[child];
            }
        }
        for(int child:graph[root])
        {
            if(child==parent)
                continue;
            if(depth[child]==maxlength)
            {
                int par_ans = 1+Math.max(partial_ans,1+secondmaxlength);
                dfs2(graph,child,root,par_ans);
            }
            else
            {
                int par_ans = 1+Math.max(partial_ans,1+maxlength);
                dfs2(graph,child,root,par_ans);
            }
        }

        ans[root]=Math.max(partial_ans,1+maxlength);
    }

    private static int dfs(ArrayList<Integer>[] graph, int src, int parent) {


        int ht=0;
        for(int nbr:graph[src])
        {
            if(nbr==parent)
                continue;
            ht=Math.max(ht,1+dfs(graph,nbr,src));
        }
        return depth[src]=ht;
    }
}
