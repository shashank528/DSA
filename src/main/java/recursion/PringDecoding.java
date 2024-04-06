package recursion;

public class PringDecoding {
    static int count=0;
    public static void solve(String s,String ssf)
    {
        if(s.length()==0)
        {
            count++;
            //System.out.println(ssf);
            return;
        }
        char ch = s.charAt(0);
        if(ch=='0')
        {
            return;
        }
        else if(s.length()>=2) {
            for (int i = 1; i <= 2; i++) {

                String s1 = s.substring(0, i);
                String roq = s.substring(i );
                int value = Integer.parseInt(s1);
                //System.out.println("value "+value);
                if(value<=26)
                solve(roq, ssf + s1 + ",");


            }
        }
        else if(s.length()==1)
        {
            String s1 = s.substring(0, 1);
            String roq = s.substring(1);
            int value = Integer.parseInt(s1);
         //   System.out.println("value "+value);
            if(value<=26)
            solve(roq, ssf + s1 + ",");
        }
    }

    public static void main(String[] args) {
        solve("111111111111111111111111111111111111111111111","");
        System.out.println(count);
    }
}
