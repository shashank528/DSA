package recursion;

import java.util.HashMap;

public class WordPattern2 {
    public static void main(String[] args) {
        String pattern = "aba";
        String str = "redbluered";
        HashMap<Character,String> map = new HashMap<>();
        solve(pattern,0,str,map);
    }

    private static void solve(String pattern, int i, String str, HashMap<Character, String> map) {
        if(i==pattern.length())
        {
            if(str.length()==0)
            System.out.println(map);
            return;
        }
        char ch = pattern.charAt(i);
        if(map.get(ch)!=null)
        {
            String alreadymappeed = map.get(ch);
            if(str.length()>=alreadymappeed.length())
            {
                String left = str.substring(0,alreadymappeed.length());
                String right = str.substring(alreadymappeed.length());
                if(left.equals(alreadymappeed))
                {
                    solve(pattern,i+1,right,map);
                }
            }
        }
        else
        {
            for (int j = 1; j < str.length(); j++) {
                String s1 = str.substring(0, j);
                String s2 = str.substring(j);
                map.put(ch, s1);
                solve(pattern, i + 1, s2, map);
                map.remove(ch);
            }
        }
    }
}
