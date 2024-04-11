package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {

        int mincount = solve(s);
        System.out.println(mincount);
        List<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        helper(s,set,mincount);
        if(set.size()>0)
        {
            for(String str:set)
            {
                res.add(str);
            }
        }else
        {
            String str ="";
            for(int i=0;i<s.length();i++)
            {

                char ch = s.charAt(i);
                if(ch=='('||ch==')')
                {
                    continue;
                }
                else
                {
                    str+=ch;
                }
            }
            res.add(str);
        }
        return res;

    }
    public static void helper(String s, HashSet<String> set, int mincount)
    {
        if(mincount==0|| s.length()==0)
        {
            System.out.println("base case "+s);
            if(isValid(s))
            {

                set.add(s);
            }
            return;
        }
        for(int i=0;i<s.length();i++)
        {
            String s1 = s.substring(0,i);
            String s2 = s.substring(i+1);
            String roq = s1+s2;
            helper(roq,set,mincount-1);

        }
    }
    public static int solve(String s)
    {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch=='(')
            {
                st.push(ch);
            }
            else if(ch==')')
            {
                if(st.size()==0 || st.peek()==')')
                {
                    st.push(ch);
                }
                else  if(st.peek()=='(')
                {
                    st.pop();
                }
                else if(st.size()==0 || st.peek()==')')
                {
                    st.push(ch);
                }
            }
            else
                continue;
        }
        return st.size();
    }
    private static boolean isValid(String str) {
        Stack<Character> st = new Stack<>();

        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            if(ch=='(')
                st.push(ch);
            else if(ch==')')
            {
                if(st.size()==0)
                    return false;
                else if(st.peek()=='(')
                    st.pop();
            }
            else
                continue;
        }
        if(st.size()>0)
            return false;

        return true;
    }

}

