package recursion;

import java.util.Scanner;

public class PrintPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Solve(str,"");

    }

    private static void Solve(String str,String psf) {

        if(str.length()==0)
        {
            System.out.println(psf);
            return;
        }

        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            String s1= str.substring(0,i);

            String s2 = str.substring(i+1);
            String roq= s1+s2;
            Solve(roq,psf+ch);
        }
    }
}
