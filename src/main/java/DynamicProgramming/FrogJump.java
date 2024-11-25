package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FrogJump {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a= new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(br.readLine());
        }
        System.out.println(solve(a,0,n-1));
    }

    private static int  solve(int[] a, int i, int n) {
        if(i==n)
            return 0;
        int left = 9999;
        int right = 9999;
        if(i+2<=n)
            right=solve(a,i+2,n)+Math.abs(a[i+2]-a[i]);
         left = solve(a,i+1,n)+Math.abs(a[i+1]-a[i]);

         return Math.min(left,right);

    }
}
