package DynamicProgramming;

public class KeyBoard {
    public static int minSteps(int n) {
        return solve("","A",3);
    }
    public static int solve(String copied,String onscreen,int n)
    {
        if(onscreen.length()>=n)
            return 0;

        int ans=(int)1e9;
        if(copied.length()==0)
        {
            int copy = solve(onscreen,onscreen,n)+1;
            ans=Math.min(ans,copy);
        }
        else
        {
            int copy = solve(onscreen,onscreen,n)+1;
            int paste = solve(copied,onscreen+copied,n)+1;
            ans=Math.min(ans,Math.min(copy,paste));
        }



        return ans;
    }

    public static void main(String[] args) {
        int n=3;
        System.out.println(minSteps(3));
    }
}
