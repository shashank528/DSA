package recursion;

import java.util.Scanner;

public class FriendsPairing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] vis = new boolean[n];
        String str = "";
        for (int i = 1; i <= n; i++) {
            str += i;
        }
        System.out.println(str);
        solve(str, vis, "", 0);
    }

    private static void solve(String str, boolean[] vis, String asf, int indx) {
        if (indx == str.length()-1) {
            System.out.println(asf);
            return;
        }
        char ch = str.charAt(indx);
        if (vis[indx] == true) {
            solve(str, vis, asf, indx + 1);
        } else {
            vis[indx] = true;
            solve(str, vis, asf + "(" + ch + ")", indx + 1);
            for (int j = indx; j < str.length(); j++) {
                char ch2 = str.charAt(j);
                vis[j] = true;
                solve(str, vis, asf + "("+ch + ch2+")", indx + 1);
                vis[j] = false;
            }
            vis[indx] = false;
        }
    }
}
