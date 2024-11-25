package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Permutation  {
public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int boxes = Integer.parseInt(br.readLine());
        int items = Integer.parseInt(br.readLine());
        int[] a = new int [boxes];
        solve(a,1,items);
        }


        //box are at level and items are options
        private static void solve(int[] a, int i,int items) {
                if(i==items+1)
                {
                        for(int k=0;k<a.length;k++)
                        {
                                System.out.print(a[k]+"-");
                        }
                        System.out.println();
                        return;
                }

                for(int j=0;j<a.length;j++)
                {
                        if(a[j]==0)
                        {
                                a[j]=i;
                                solve(a,i+1,items);
                                a[j]=0;
                        }
                }
        }



}
