package recursion;



public class MaximumNumberAfterKSwaps {
    public static int max;
    public static void main(String[] args) {
        max=-1;
        String str="1234";
        int[] num = new int[str.length()];
        for(int i=0;i<str.length();i++)
        {
            num[i]=(int)(str.charAt(i)-'0');
        }
        for(int i=0;i<str.length();i++)
        {
            System.out.print(num[i]+"-");
        }
        System.out.println();
        int k=3;
        solve(num,k);
        System.out.println("max "+max);
    }

    private static void solve(int[] num, int k) {
        if(k==0)
        {

            return;

        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<num.length;i++)
        {
            sb.append(num[i]);
        }
        max=Math.max(max,Integer.parseInt(sb.toString()));



        for(int i=0;i<num.length-1;i++)
        {
            for(int j=i+1;j<num.length;j++)
            {
                if(num[i]<num[j])
                {
                    swap(num,i,j);
                    solve(num,k-1);
                    swap(num,i,j);
                }
            }
        }
    }
    public static void swap(int[]num,int i,int j)
    {
        int temp = num[i];
        num[i]=num[j];
        num[j]=temp;
        System.out.println("after swap ");
        for(int indx=0;indx<num.length;indx++)
        {
            System.out.print(num[indx]+"-");
        }
        System.out.println();

    }
}
