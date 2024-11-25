package recursion;

import java.util.Arrays;
import java.util.HashSet;

public class WordBreak {
    public static void main(String[] args) {
    //   String s = "applepenapple";

//       HashSet<String> wordDict = new HashSet<>();
//       wordDict.add("apple");
//       wordDict.add("pen");
//        WordBreakHelp(s,wordDict,"");
        String s="1.0.1.1";
        String[] str=s.split("\\.");
        System.out.println(Arrays.toString(str));

    }

    private static void WordBreakHelp(String s, HashSet<String> wordDict,String ans) {

        if(s.length()==0)
        {
            System.out.println(ans);
            return;
        }
        for(int i=0;i<s.length();i++)
        {
            String left = s.substring(0,i+1);
            if(wordDict.contains(left))
            {
                String right = s.substring(i + 1);
                WordBreakHelp(right,wordDict,ans+left+" ");
            }
        }
    }
}
