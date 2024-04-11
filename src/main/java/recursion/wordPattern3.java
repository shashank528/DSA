package recursion;

import java.util.HashMap;

public class wordPattern3 {
    public static void wordPatternMatch(String pattern, String str) {
        HashMap<Character,String> map = new HashMap<>();
        solve(pattern,0,str,map);

    }
    public static void solve(String pattern,int indx,String  str,HashMap<Character,String> map)
    {
        if(indx==pattern.length())
        {
            if(str.length()==0)
                System.out.println(map);
            return;
        }
        char ch = pattern.charAt(indx);
        if(map.get(ch)==null)
        {
            for(int i=1;i<str.length();i++)
            {
                //System.out.println("inside loop"+indx);
                String s1 = str.substring(0,i);
                String roq = str.substring(i);
                map.put(ch,s1);
                solve(pattern,indx+1,roq,map);
                map.remove(ch);
            }
        }
        else
        {
            String alreadmapped = map.get(ch);
            if(str.length()>=alreadmapped.length()) {
                String left = str.substring(0,alreadmapped.length());
                String right = str.substring(alreadmapped.length());
                if(left.equalsIgnoreCase(alreadmapped))
                {
                    solve(pattern,indx+1,right,map);
                }
            }

        }
    }

    public static void main(String[] args) {
        String pattern = "aba";
        String str= "redbluered";
        wordPatternMatch(pattern,str);
    }
}
