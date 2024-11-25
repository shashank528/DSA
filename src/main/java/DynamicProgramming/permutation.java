package DynamicProgramming;

public class permutation {
    static int count;
    public static void main(String[] args) {
        int s=3;
        int n=4;
        count=0;
        solve(n,s);
        System.out.println(count);
    }
    public static void solve(int n,int s)
    {
        if(n==0)
        {
           // System.out.println("base");
            count++;
            return;
        }
        for(int i=0;i<s;i++)
        {
            solve(n-1,s);
        }
    }
}
