package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CreateGraph {
    //we can represent graph as List of list or Array of List
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        int[][] edges= new int[E][2];
        for(int i=0;i<E;i++)
        {
            edges[i][0] =Integer.parseInt(br.readLine());
            edges[i][1] = Integer.parseInt(br.readLine());
        }

        ArrayList<Integer>[] graph = createGraph(V,E,edges);
        List<Integer> bfs = bfs(graph);
        System.out.println(bfs);
    }

    private static List<Integer> bfs(ArrayList<Integer>[] graph)
    {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> res= new ArrayList<>();
        boolean[] vis = new boolean[graph.length+1];
        q.add(0);
        vis[0]=true;
        while(q.size()>0)
        {
            int rem = q.remove();
            res.add(rem);
            for(int x:graph[rem])
            {
                if(vis[x]==false)
                {
                    vis[x]=true;
                    q.add(x);
                }
            }
        }
        return res;

    }

    private static ArrayList<Integer>[] createGraph(int v, int e, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[v];
        for(int i=0;i<v;i++)
        {
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++)
        {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        return graph;
    }
    private static void dfs(ArrayList<Integer>[] graph,int indx,boolean[] vis)
    {

    }
}
