package BOJ.intensify1;

import java.util.*;

public class BOJ_3003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
        int k = 1;
        int q = 1;
        int r = 2;
        int b = 2;
        int n = 2;
        int p = 8;

        k = k - sc.nextInt();
        q = q - sc.nextInt();
        r = r - sc.nextInt();
        b = b - sc.nextInt();
        n = n - sc.nextInt();
        p = p - sc.nextInt();

        System.out.printf(k + " ");
        System.out.printf(q + " ");
        System.out.printf(r + " ");
        System.out.printf(b + " ");
        System.out.printf(n + " ");
        System.out.printf(p + " ");
        */

        int a[] = {1,1,2,2,2,8};
        int b;

        for(int i = 0; i<6; i++){
            b = sc.nextInt();
            a[i] = a[i] - b;
        }
        for(int i = 0; i<6; i++){
            System.out.printf(a[i] + " ");
        }
    }
}
