package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Djikstras {
    static class Edge
    {
        int src;
        int nbr;
        int wt;
        public Edge(int src,int nbr,int wt)
        {
            this.src=src;
            this.nbr=nbr;
            this.wt=wt;
        }
    }
    static class pair implements Comparable<pair>
    {
        int vtx;
        int wsf;
        String psf;
        public pair(int vtx,int wsf,String psf)
        {
            this.vtx=vtx;
            this.wsf=wsf;
            this.psf=psf;
        }
        public int compareTo(pair o)
        {
            return this.wsf-o.wsf;
        }
    }

    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.


        ArrayList<Edge>[] graph = createGraph(n,edges);
        List<Integer> res= new ArrayList<>();
        boolean[] vis = new boolean[n+1];
        return bfs(graph,res,0,6);


    }
    public List<Integer> bfs(ArrayList<Edge>[] graph,List<Integer> list,int src,int dest)
    {
        boolean flag=false;
        PriorityQueue<pair> pq= new PriorityQueue<>();
        pq.add(new pair(src,0,src+" "));
        boolean[] vis = new boolean[graph.length+1];
        while(pq.size()>0)
        {
            pair rem = pq.remove();
            vis[rem.vtx]=true;
            System.out.println(rem.vtx + " via " + rem.psf + " @ " + rem.wsf);
            if(rem.vtx==dest)
            {

                System.out.println(rem.psf);
                flag=true;
                list.add(0,rem.wsf);
                rem.psf=rem.psf.trim();
                for(String s:rem.psf.split(" "))
                {
                    list.add(Integer.parseInt(s));
                }
                System.out.println(list);
                return list;
            }
            for(Edge e:graph[rem.vtx])
            {
                if(!vis[e.nbr])
                {
                    pair p = new pair(e.nbr,rem.wsf+e.wt,rem.psf+e.nbr+" ");
                    pq.add(p);
                }
            }
        }
        if(!flag)
        {
            list.add(-1);
        }

        return list;
    }
    // public void dfs(ArrayList<Edge>[] graph,int src,int dest,boolean[]vis,String psf,int wsf)
    // {
    //     if(src==dest)
    //     {
    //         psf+=dest;
    //       if(wsf<minwt)
    //       {
    //           asf=psf;
    //           minwt=wsf;
    //       }
    //         return;
    //     }
    //     vis[src]=true;
    //     for(Edge e:graph[src])
    //     {
    //         if(vis[e.nbr]==false)
    //         {
    //             dfs(graph,e.nbr,dest,vis,psf+src+" ",wsf+e.wt);
    //         }
    //     }
    //     vis[src]=false;
    // }
    public ArrayList<Edge>[] createGraph(int n, int[][] edges)
    {
        ArrayList<Edge>[] graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++)
        {
            graph[i]= new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++)
        {
            graph[edges[i][0]].add(new Edge(edges[i][0],edges[i][1],edges[i][2]));
            graph[edges[i][1]].add(new Edge(edges[i][1],edges[i][0],edges[i][2]));
        }
        return graph;
    }
    public static void main(String[] args) {
        int n = 7;
        int m = 8;
        int[][] edges= new int[8][3];
        edges[0][0]=0;
        edges[0][1]=3;
        edges[0][2]=40;
        edges[1][0]=0;
        edges[1][1]=1;
        edges[1][2]=10;
        edges[2][0]=1;
        edges[2][1]=2;
        edges[2][2]=2;
        edges[3][0]=2;
        edges[3][1]=3;
        edges[3][2]=10;
        edges[4][0]=4;
        edges[4][1]=5;
        edges[4][2]=3;
        edges[5][0]=3;
        edges[5][1]=4;
        edges[5][2]=2;
        edges[6][0]=4;
        edges[6][1]=6;
        edges[6][2]=8;
        edges[7][0]= 5;
        edges[7][1]=6;
        edges[7][2]=8;
        Djikstras obj = new Djikstras();
        obj.shortestPath(n,m,edges);

    }
}
