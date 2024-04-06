package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class RecursionInArray {
    public static void displayArr(int[]a ,int indx)
    {
        if(indx==a.length)
            return;
        System.out.println(a[indx]);
        displayArr(a,indx+1);
    }
    public static void calculate()
    {
        String asf ="+1+1-1+1";
        int sum =0;
        for(int i=0;i<asf.length()-1;i=i+2)
        {
            char ch1 = asf.charAt(i);
            char ch2 = asf.charAt(i+1);
            if(ch1=='+')
            {
                int a = Integer.parseInt(String.valueOf(ch2));
                sum+=a;
            }
            if(ch1=='-')
            {
                int a = Integer.parseInt(String.valueOf(ch2));
                sum-=a;
            }
        }
        System.out.println(sum);
    }
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         //int n = sc.nextInt();
         //int m =  sc.nextInt();
         ///String str = sc.nextLine();
        calculate();

        int a = 1;
        char b = Integer.toString(a).charAt(0);
        System.out.println(b);
//        int[] a= new int[n];
//        for(int i=0;i<n;i++)
//        {
//            a[i]=sc.nextInt();
//        }
//        //displayArr(a,0);
//        //System.out.println(maxOfArray(a,0,-1));
//        System.out.println(firstIndex(a,0,5,9999));
         //String s = sc.nextLine();
    //    getSubsequence(s,0,"");
 //        getStairPath(n);
     //3   System.out.println(getMazePath(0,0,n,m));
     //   System.out.println(getMazePathWithJump(0,0,n,m));
   //     permutationOfString(str,"");


    }

    private static void permutationOfString(String str,String asf) {
        if(str.length()==0)
        {
            System.out.println(asf);
            return;
        }

        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            String s1= str.substring(0,i);
            String s2 = str.substring(i+1);
            String roq =s1+s2;
           // System.out.println("roq "+roq);
            permutationOfString(roq,asf+ch);
        }

    }

    private static ArrayList<String> getMazePathWithJump(int r, int c, int n, int m) {
        if(r==m-1 && c ==n-1)
        {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        ArrayList<String> path = new ArrayList<>();
        for(int i=1;i+r<m;i++)
        {
            ArrayList<String> path1 = getMazePathWithJump(r+i,c,n,m);
            for(String s:path1)
            {
                path.add(s+"v"+i);
            }

        }
        for(int i=1;i+c<n;i++)
        {
            ArrayList<String> path2 = getMazePathWithJump(r,c+i,n,m);
            for(String s:path2)
            {
                path.add(s+"h"+i);
            }

        }
        return path;
    }

    private static ArrayList<String> getMazePath(int r, int c, int n, int m) {
        if(r==m-1 && c ==n-1)
        {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        ArrayList<String> path1 = new ArrayList<>();
        ArrayList<String> path2 = new ArrayList<>();
        ArrayList<String> path = new ArrayList<>();
        if(c+1<n)
        {
            path1 = getMazePath(r,c+1,n,m);
            for(String s:path1)
            {
                path.add(s+"h");
            }

        }
        if(r+1<m)
        {
            path2 = getMazePath(r+1,c,n,m);
            for(String s:path2)
            {
                path.add(s+"v");
            }

        }
        return path;
    }

    private static void getStairPath(int n) {
        HashSet<String> s = new HashSet<>();
      //  solve(n,s,"");

        System.out.println(getStairPath2(n));
    }



    private static ArrayList<String> getStairPath2(int n) {
        if(n==0)
        {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        ArrayList<String> path1=new ArrayList<>();
        ArrayList<String> path2=new ArrayList<>();
        ArrayList<String> path3=new ArrayList<>();
        if(n-1>=0)
            path1 = getStairPath2(n-1);
        if(n-2>=0)
            path2 = getStairPath2(n-2);
        if(n-3>=0)
            path3 = getStairPath2(n-3);

        ArrayList<String> path = new ArrayList<>();


        for(String s:path1)
        {
            path.add(s+1);
        }
        for(String s:path2)
        {
            path.add(s+2);
        }
        for(String s:path3)
        {
            path.add(s+3);
        }
        return path;
    }

    private static void solve(int n, HashSet<String> s, String s1) {
        if(n==0)
        {
            s.add(s1);
            return;
        }
        for(int i=1;i<=3 && n-i>=0 ;i++)
        {
            solve(n-i,s,s1+i);
        }
    }

    private static void getSubsequence(String s,int indx,String res) {

        if(indx==s.length()) {
            System.out.println(res);
            return;
        }

        char ch= s.charAt(indx);
        //yes call
      //  System.out.println(res);
        if(indx+1<=s.length())
        getSubsequence(s,indx+1,res+ch);
        //no call
        if(indx+1<=s.length())
        getSubsequence(s,indx+1,res);
    }

    private static int firstIndex(int[] a, int indx, int i1,int min) {
        if(indx==a.length)
            return min;
        if(a[indx]==i1)
            min=Math.min(min,indx);
        return firstIndex(a,indx+1,i1,min);

    }

    private static int maxOfArray(int[] a, int indx,int max) {
        if(indx==a.length)
            return max;

        max=Math.max(a[indx],max);
       return maxOfArray(a,indx+1,max);

    }
}
