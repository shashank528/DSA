package DynamicProgramming;

import java.util.HashMap;

public class LIS {
    static class Pair
    {
        int indx1;
        int indx2;
        public Pair(int indx1,int indx2)
        {
            this.indx1=indx1;
            this.indx2=indx2;
        }
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pair that = (Pair) o;
            return indx1 == that.indx1 && indx2 == that.indx2;
        }
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + indx1+indx2;
            return result;
        }

    }
    static HashMap<Pair,String> map;
    public static void main(String[] args) {
        String str1 ="abcdb";
        String str2 = "bcacdhb";
        map = new HashMap<>();
        System.out.println(solve(str1,str2,str1.length()-1,str2.length()-1,map));
    }
    public static String solve(String s1,String s2,int indx1,int indx2,HashMap<Pair,String>map)
    {
        if(indx1<0 || indx2<0)
        {
            return "";
        }
        Pair pair = new Pair(indx1,indx2);
    //    System.out.println(map.entrySet());
//        if(map.containsKey(pair))
//        {
//
//            return map.get(pair);
//        }
        char ch1=s1.charAt(indx1);
        char ch2=s2.charAt(indx2);
        String str1="";
        String str2="";
        if(ch1==ch2)
        {
            Pair p= new Pair(indx1,indx2);
            map.put(p,solve(s1,s2,indx1-1,indx2-1,map)+ch1);
          return  solve(s1,s2,indx1-1,indx2-1,map)+ch1;
        }
        else
        {
            str1=solve(s1,s2,indx1-1,indx2,map);
            str2=solve(s1,s2,indx1,indx2-1,map);
        }
        if(str1.length()>str2.length()) {
            Pair p= new Pair(indx1,indx2);
            map.put(p,str1);
            return str1;
        }
        else {
            Pair p= new Pair(indx1,indx2);
            map.put(p,str1);
            return str2;
        }
    }
}
