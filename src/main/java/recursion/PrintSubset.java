package recursion;

public class PrintSubset {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4};
        solve(a,0,"");
    }

    private static void solve(int[] a,int indx,String asf) {

        if(indx==a.length)
        {
            System.out.println(asf);
            return;
        }
        solve(a,indx+1,asf+a[indx]);
        solve(a,indx+1,asf);

    }
}
