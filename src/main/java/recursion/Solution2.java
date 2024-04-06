package recursion;

import java.util.Scanner;

class Solution2
{
    static int count;
    public long countFriendsPairings(int n)
    {
        //code here

        boolean[] b = new boolean[n+1];


        solve(b,1,n,"");
        return count;
    }
    public void solve(boolean[]b ,int indx,int n,String ssf)
    {
        if(indx>n)
        {
            count++;
            System.out.println(ssf);
            return;
        }
        if(b[indx]==true)
            solve(b,indx+1,n,ssf);
        else
        {
            b[indx]=true;
            solve(b,indx+1,n,ssf+"("+indx+") ");
            for(int j=indx+1;j<=n;j++)
            {
                if(b[j]==false)
                {
                    b[j] = true;
                    solve(b, j+1, n, ssf + "(" + indx + j + ") ");
                    b[j] = false;
                }
            }
            b[indx]=false;
        }




    }


    public static void main(String[] args) {
        Solution2 s = new Solution2();
        Scanner sc = new Scanner(System.in);
        count = 0;
        int n = sc.nextInt();
        s.countFriendsPairings(n);
        System.out.println(count);
    }
}
