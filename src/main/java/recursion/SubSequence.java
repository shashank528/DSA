package recursion;

public class SubSequence {
    public static void main(String[] args) {
        String s = "abc";
        getSubsequece(s,"",0);
    }

    private static void getSubsequece(String s, String asf,int indx) {
        System.out.println("asf "+asf);
        if(indx==s.length())
        {
            System.out.println(asf);
            return ;
        }
        char ch = s.charAt(indx);
        getSubsequece(s,asf+ch,indx+1);
        getSubsequece(s,asf,indx+1);


    }
}
