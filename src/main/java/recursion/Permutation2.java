package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Permutation2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        HashSet<Character> set = new HashSet<>();
        solve(str,set,"");

    }

    private static void solve(String str, HashSet<Character> set, String s) {
        if(s.length()==str.length()-1)
        {
            System.out.println(s);
            return;
        }

        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            if(!set.contains(ch))
            {
                set.add(ch);
                solve(str,set,s+ch);
                set.remove(ch);
            }
        }
    }
}
