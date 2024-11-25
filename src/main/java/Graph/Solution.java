package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

class Solution {
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
        int steps;
        int wt;
        String psf;
        public pair(int vtx,int steps,int wt,String psf)
        {
            this.vtx=vtx;
            this.steps=steps;
            this.wt=wt;
            this.psf="";
        }
        public int compareTo(pair o)
        {
            return this.wt-o.wt;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] res=new int[n+1];
        Arrays.fill(res,Integer.MAX_VALUE);
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<flights.length;i++)
        {
            int u = flights[i][0];
            int nbr = flights[i][1];
            int wt = flights[i][2];
            graph[u].add(new Edge(u,nbr,wt));
        }
        for(int i=0;i<graph.length;i++)
        {
            System.out.print(i+" -> ");
            for(Edge e:graph[i])
            {
                System.out.print(e.src+","+e.nbr+","+e.wt+" - ");
            }
            System.out.println();
        }
        PriorityQueue<pair> pq=new PriorityQueue<>();
        String path=""+src+"@";
        System.out.println(path);
        pq.add(new pair(src,0,0,path));
        res[src]=0;
        while(pq.size()>0)
        {
           // System.out.println("inside while loop");
            print_queue(pq);
            pair rem = pq.remove();
            System.out.println(rem.vtx+" "+rem.wt);

           // System.out.println("psf ="+rem.psf);
            if(rem.steps<=k)
            {
                for(Edge e:graph[rem.vtx])
                {
                      System.out.println("src ="+e.src+" nbr ="+e.nbr+" wt ="+rem.wt+" stops = "+rem.steps);
                    if(res[e.nbr]>e.wt+rem.wt)
                    {
                      //  System.out.println("src ="+e.src+" nbr ="+e.nbr+" wt ="+rem.wt+" stops = "+rem.steps);
                        res[e.nbr]=e.wt+rem.wt;
                        pq.add(new pair(e.nbr,rem.steps+1,e.wt+rem.wt,rem.psf+e.nbr+"@"));
                    }

                }
            }

        }
        if(res[dst]!=Integer.MAX_VALUE)
            return res[dst];


        return -1;
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        int[][] flights = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        int src=0;
        int dest=2;
        s.findCheapestPrice(5,flights,0,2,2);
    }
    public void print_queue(PriorityQueue<pair> pq){
        PriorityQueue<pair>copy = new PriorityQueue<pair>();
        copy.addAll(pq) ;
        Iterator<pair> through = pq.iterator() ;
        while(through.hasNext() ) {
            pair p=  through.next();
            System.out.print("vtx "+p.vtx + " wsf = "+p.wt+ " steps ="+p.steps) ;
        }
        System.out.println() ;



    }
}
