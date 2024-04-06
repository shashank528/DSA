package recursion;

import java.util.Scanner;

public class Main {
    public static void printDecreasing(int n)
    {
        if(n==0)
            return;
        System.out.println(n);
        printDecreasing(n-1);
    }

    public static void printIncreasing(int n)
    {
        if(n==10)
            return;
        System.out.println(n);
        printIncreasing(n+1);

    }
    public static void printIncreasingDecreasng(int n)
    {
        if(n==0)
            return;
        System.out.println(n);
        printIncreasingDecreasng(n-1);
        System.out.println(n);

    }
    public static int factorial(int n)
    {
        if(n==0 || n==1)
            return 1;
        return n*factorial(n-1);

    }

    public static int power(int n,int x)
    {
        if(x==0)
        {
            return 1;
        }
        return n*power(n,x-1);
    }
    public static void main(String[] args) {
        System.out.println("this is my new ide");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        //printDecreasing(n);
        //printIncreasing(1);
        //printIncreasingDecreasng(n);
       //System.out.println( factorial(n));
       System.out.println(power(n,x));
    }
}
