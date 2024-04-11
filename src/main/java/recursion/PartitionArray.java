package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PartitionArray {
    public static void main(String[] args) {
        int[] a = new int[]{4,3,2,3,5,2,1};
        List<List<Integer>> res= new ArrayList<>();
        for(int i=0;i<4;i++)
        {
            res.add(new ArrayList<>());
        }
        solve(a,0,res);
    }

    private static void solve(int[] a, int indx, List<List<Integer>> res) {
        if(indx==a.length)
        {
            Set<Integer> set= new HashSet<>();
            for(List<Integer> lis:res)
            {
                int sum=0;
                for(int x:lis)
                {
                 sum+=x;
                }
                set.add(sum);
            }
            if(set.size()==1)
            {
                System.out.println(res);

            }
            return;
        }
        for(int i=0;i<res.size();i++)
        {
            if(res.get(i).size()==0)
            {
                res.get(i).add(a[indx]);
                solve(a,indx+1,res);
                res.get(i).remove(res.get(i).size()-1);
                break;
            }
            else
            {
                res.get(i).add(a[indx]);
                solve(a,indx+1,res);
                res.get(i).remove(res.get(i).size()-1);
            }

        }
    }

}
