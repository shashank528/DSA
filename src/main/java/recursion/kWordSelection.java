package recursion;

import java.util.HashMap;

public class kWordSelection {

    public static void main(String[] args) {
        String str="abcdabcdeg";
        HashMap<Character,Boolean> map = new HashMap<>();
        solve(str,map,0,"");
    }

    private static void solve(String str, HashMap<Character, Boolean> map, int indx, String asf) {

        if(asf.length()==3)
        {
            System.out.println(asf);
            return;
        }
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            if(map.get(ch)==null)
            {
                map.put(ch,true);
                solve(str,map,i+1,asf+ch);
                map.remove(ch);
            }
        }
    }
}
