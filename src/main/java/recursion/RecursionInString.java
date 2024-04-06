package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecursionInString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        List<String> listOfSubequence = new ArrayList<>();
        getSS(str,"",listOfSubequence);
        System.out.println(listOfSubequence);
    }

    private static void getSS(String str, String asf, List<String> listOfSubequence) {
        if(str.length()==0)
        {
            listOfSubequence.add(asf);
            return;
        }
        char ch = str.charAt(0);
        String roq = str.substring(1);
        //yes call
        getSS(roq,asf+ch,listOfSubequence);
        getSS(roq,asf,listOfSubequence);

    }
}
