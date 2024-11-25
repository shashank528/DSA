package Tree.DponTrees;

import java.util.ArrayList;

public class MaximumMatchingPairs {
    // Represents infinity
    static final long INF = 10000000000000L;
    // Maximum number of nodes
    static final int MX = 200005;

    // Adjacency list
    static ArrayList<Integer>[] Adj = new ArrayList[MX];
    // Dynamic programming array

    public  static int solve( ArrayList<Integer>[] graph,int src, boolean flag,boolean[] vis)
    {
        int ans =0;
        vis[src]=true;
        for(int nbr:graph[src])
        {
            if(flag==true && vis[nbr]==false)
            {
                ans=Math.max(ans,Math.max(solve(graph,nbr,false,vis)+1,solve(graph,nbr,flag,vis)));
            }
            else
            {
                if(vis[nbr]==false)
                ans=Math.max(ans,solve(graph,nbr,true,vis));
            }
        }
        vis[src]=false;
        return ans;
    }

    public static void main(String[] args)
    {
        // Number of nodes
        int n = 10;
        // Edges of the tree
        int[][] edges = { { 5, 8 },  { 4, 6 }, { 9, 1 },
                { 10, 4 }, { 1, 3 }, { 2, 3 },
                { 7, 9 },  { 6, 2 }, { 5, 10 } };

        for (int i = 0; i < MX; i++) {
            Adj[i] = new ArrayList<>();
        }

        // Build adjacency list
        for (int i = 0; i < n - 1; ++i) {
            int a = edges[i][0] - 1;
            int b = edges[i][1] - 1;
            Adj[a].add(b);
            Adj[b].add(a);
        }

        // Start DFS from root node (0)

        // Output the maximum number of pairs
        boolean[] vis=new boolean[n];
        long ans = solve(Adj,0,true,vis);
        System.out.println(
                "Maximum number of edges in a matching: "
                        + ans);
    }
}

// This code is contributed by shivamgupta310570
