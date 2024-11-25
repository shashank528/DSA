package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class HamiltonianPath {
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges)
    {
        // code here
        ArrayList<Integer>[] graph = createGraph(Edges,N,M);
        Set<Integer> vis= new HashSet<>();
        boolean res= false;
        for(int i=1;i<=N;i++)
        {
            res = solve(graph,N,M,vis,"",-1,i,i);
            if(res)return res;
        }
        return res;
    }
    public ArrayList<Integer>[] createGraph(ArrayList<ArrayList<Integer>> Edges, int N, int M)
    {
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i=0;i<=N;i++)
        {
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++)
        {
            graph[Edges.get(i).get(0)].add(Edges.get(i).get(1));
            graph[Edges.get(i).get(1)].add(Edges.get(i).get(0));
        }
        return graph;
    }
    public boolean solve(ArrayList<Integer>[] graph ,int N,int M,Set<Integer> vis,String psf,int parent,int src,int osrc)
    {
        if(vis.size()==N-1)
        {
            vis.add(src);
            psf+=src;
            System.out.println("base case" + "psf "+psf);
            return true;
        }


        vis.add(src);
       // System.out.println(vis);
        for(int x:graph[src])
        {
            if(!vis.contains(x) )
            {
                boolean ans = solve(graph,N,M,vis,psf+src+",",src,x,osrc);
                if(ans)
                    return ans;
            }
        }
        vis.remove(src);
        return false;
    }
//4 4
//1 2 2 3 3 4 2 4
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> Edges= new ArrayList<>(5);

        for(int i=0;i<4;i++)
            Edges.add(new ArrayList<>());

            Edges.get(0).add(1);
            Edges.get(0).add(2);
            Edges.get(1).add(2);
            Edges.get(1).add(3);
            Edges.get(2).add(3);
            Edges.get(2).add(4);
            Edges.get(3).add(2);
            Edges.get(3).add(4);
            HamiltonianPath h = new HamiltonianPath();
            h.check(4,4,Edges);



    }
}
