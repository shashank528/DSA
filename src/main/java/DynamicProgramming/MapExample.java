package DynamicProgramming;

import java.util.HashMap;

public class MapExample {
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
        map = new HashMap<>();
        for(int i=0;i<=5;i++)
        {
            Pair p = new Pair(i,i*10);
            String str = "x"+i ;
            map.put(p,str);
        }
        Pair p2= new Pair(0,0);
        System.out.println(map.containsKey(p2));
        for(Pair p:map.keySet())
        {
            System.out.println(map.get(p));
        }

    }
}
