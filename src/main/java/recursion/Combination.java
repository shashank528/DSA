package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Combination {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int  boxes = Integer.parseInt(br.readLine());
        int[] box = new int[boxes];
        CombinationHelper(box,0,0);
    }

    private static void CombinationHelper(int[] box, int indx,int count) {

        if(count==2)
        {
            for(int k=0;k<box.length;k++)
            {
                System.out.print(box[k]+"-");
            }
            System.out.println();
            return;
        }
        for(int i=indx;i<box.length;i++)
        {
            if(box[i]==0)
            {
                box[i]=1;
                CombinationHelper(box,i+1,count+1);
                box[i]=0;

            }
        }
    }
}
