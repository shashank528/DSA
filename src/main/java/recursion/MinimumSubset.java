package recursion;

import java.util.ArrayList;
import java.util.List;

public class MinimumSubset {
    public static int maxdiff =9999;
    public static List<List<Integer>> ans;
    public static void main(String[] args) {
        int[] a= new int[]{1,2,3,5,7};
        int n = a.length;
        ans = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<=1;i++)
        {
            res.add(new ArrayList<>());
        }
        for(int i=0;i<=1;i++)
        {
            ans.add(new ArrayList<>());
        }
        solve(a,0,res);
       // System.out.println(ans);
    }

    private static void solve(int[] a, int indx, List<List<Integer>> res) {
        if(indx==a.length)
        {
            if(a.length%2==0)
            {
                if(res.get(0).size()==res.get(1).size())
                {
                    int sum1=0;
                    int sum2=0;
                    for(int x:res.get(0))
                    {
                        sum1+=x;
                    }
                    for(int x:res.get(1))
                    {
                        sum2+=x;
                    }
                    if(Math.abs(sum2-sum1)<maxdiff)
                    {
                        maxdiff=Math.abs(sum2-sum1);
                        ans.set(0,res.get(0));
                        ans.set(1,res.get(1));
                        System.out.println("ans"+ans);
                    }
                }
            }
            else
            {
               if(Math.abs(res.get(0).size()-res.get(1).size())<=1)
               {
                   System.out.println("first arraylist "+res.get(0));
                   System.out.println("second arraylist "+res.get(1));
                   int sum1=0;
                   int sum2=0;
                   for(int x:res.get(0))
                   {
                       sum1+=x;
                   }
                   for(int x:res.get(1))
                   {
                       sum2+=x;
                   }
                   if(Math.abs(sum2-sum1)<maxdiff)
                   {
                       maxdiff=Math.abs(sum2-sum1);
                       ans.set(0,res.get(0));
                       ans.set(1,res.get(1));
                       System.out.println("ans"+ans);
                   }
               }
            }
          return;
        }
        for(int i=0;i<res.size();i++)
        {
                    res.get(i).add(a[indx]);
                    solve(a,indx+1,res);
                   res.get(i).remove(res.get(i).size()-1);
        }
    }
}
