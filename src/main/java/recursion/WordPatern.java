package recursion;

import java.util.HashMap;

public class WordPatern {
    public static boolean wordPattern(String pattern, String s) {
        String[] words = pattern.split(" ");
        if(words.length!=s.length())
            return false;
        HashMap<Character,String> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            System.out.println(map);
            char ch = s.charAt(i);
            String word = words[i];
            if(map.get(ch)==null)
            {
                if(map.containsValue("word"))
                    return false;
                else
                map.put(ch,word);
            }
            else
            {
                if(map.get(ch)!=word)
                    return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        wordPattern(pattern ,s);
    }
}
