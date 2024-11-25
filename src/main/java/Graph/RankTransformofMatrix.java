package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

class RankTransformofMatrix {
    static int[] parent;
    static int[] rank;
    static int[] values;
    static class pair
    {
        int r;
        int c;
        public pair(int r,int c)
        {
            this.r=r;
            this.c=c;
        }
    }
    public int find(int[] parent,int u)
    {
        if(parent[u]==-1||parent[u]==u)
            return u;
        return parent[u]=find(parent,parent[u]);
    }
    public void union(int[] parent, int[] rank,int u,int v)
    {
        int slofu = find(parent,u);
        int slofv = find(parent,v);
        if(slofu!=slofv)
        {
            if(rank[slofu]>rank[slofv])
            {
                parent[slofv]=slofu;
                rank[slofu]=rank[slofu]+rank[slofv];
            }
            else if(rank[slofu]<rank[slofv])
            {
                parent[slofu]=slofv;
                rank[slofv]=rank[slofu]+rank[slofv];
            }
            else
            {
                parent[slofu]=slofv;
                parent[slofv]=slofv;
                rank[slofv]++;
            }
        }
    }
    public int[][] matrixRankTransform(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        values = new int[n+m];
        TreeMap<Integer, List<pair>> map = new TreeMap<>();
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(!map.containsKey(matrix[i][j]))
                {
                    map.put(matrix[i][j],new ArrayList<>());
                    map.get(matrix[i][j]).add(new pair(i,j));
                }
                else
                {
                    map.get(matrix[i][j]).add(new pair(i,j));
                }
            }
        }
        for(int x:map.keySet())
        {
            System.out.print("x ="+x+" ");
            for(pair p:map.get(x))
            {
                System.out.print("("+p.r+","+p.c+")");
            }
            System.out.println();
        }
        for(int key:map.keySet())
        {
            parent = new int[n+m];
            rank   = new int[n+m];
            for(int i=0;i<n+m;i++)
            {
                parent[i]=-1;
                rank[i]=1;
            }
            for(pair p:map.get(key))
            {
                int r = p.r;
                int c = p.c;
                union(parent,rank,r,c+n);
            }
             for(int i=0;i<parent.length;i++)
             {
                 System.out.println("for key ="+key+"parent of "+i+ " = "+parent[i]);
             }
            HashMap<Integer,List<Integer>> group = new HashMap<>();
            for(int x=0;x<parent.length;x++)
            {
                if(parent[x]==-1)
                    continue;
                int slofx = find(parent,x);
                if(!group.containsKey(slofx))
                {
                    group.put(slofx,new ArrayList<>());
                    group.get(slofx).add(x);
                }
                else
                {
                    group.get(slofx).add(x);
                }
            }
            for(int x:group.keySet())
            {
                System.out.print("x ="+x+" ");
                for(int  p:group.get(x))
                {
                    System.out.print(p+" ");
                }
                System.out.println();
            }
            for(int groupkey:group.keySet())
            {
                int maxRank=0;
                for(int x:group.get(groupkey))
                {
                    maxRank=Math.max(maxRank,values[x]);
                }
                for(int x:group.get(groupkey))
                {
                    values[x]=maxRank+1;
                }
            }
            System.out.print(key+"->");
            for(int i=0;i<values.length;i++)
            {
                System.out.print("for indx ="+i+" value ="+values[i]);
            }
            System.out.println();
            for(pair p:map.get(key))
            {
                matrix[p.r][p.c]=values[p.r];
            }
            for(int i=0;i<matrix.length;i++)
            {
                for(int j=0;j<matrix[0].length;j++)
                {
                    System.out.print(matrix[i][j]+" ");
                }
                System.out.println();
            }
        }

    return matrix;
    }

    public static void main(String[] args) {
        RankTransformofMatrix obj = new RankTransformofMatrix();
        int[][] matrix = {{1,2},{3,4}};
        int[][] ans = obj.matrixRankTransform(matrix);
//        for(int i=0;i<ans.length;i++)
//        {
//            for(int j=0;j<ans[0].length;j++)
//            {
//                System.out.print(ans[i][j]+" ");
//            }
//            System.out.println();
//        }
    }
}
