package recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintSubset {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans= new ArrayList<>();
        solve(a,0,ans,res);
        System.out.println(res);
    }

    private static void solve(int[] a,int indx,List<Integer> ans,List<List<Integer>>res) {

        if(indx==a.length)
        {
            System.out.println(ans);
            res.add(ans);
            return;
        }

        solve(a,indx+1,ans,res);
        ans.add(a[indx]);
        solve(a,indx+1,ans,res);
        ans.remove(ans.size()-1);

    }
}
