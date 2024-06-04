
/* 
   name: Asil Asaad Mufti
   ID: 2106122
   section: DAR
 */

import java.util.Scanner;

public class FIFO {
    public static void main(String[] args) {
        int[] a = new int[5];
        int[] b = new int[20];
        int n, p = 0, q = 0, m = 0, h, k, i, q1 = 0;
        char f = 'F';
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Number of Pages:");
        n = scanner.nextInt();
        System.out.print("Enter " + n + " Page Numbers:");
        for (i = 0; i < n; i++)
            b[i] = scanner.nextInt();
        for (i = 0; i < n; i++) {
            p = 0;
            for (k = 0; k < q1; k++) {
                if (b[i] == a[k])
                    p = 1;
            }
            if (p == 0) {
                if (q >= 3) {
                    q = 0;
                }
                a[q] = b[i];
                q++;
                q1++;
                if (q1 > 3) {
                    q1 = 3;
                }
            }
            System.out.println("\n" + b[i] + "\t");
            for (h = 0; h < q1; h++)
                System.out.print(a[h]);
            if (p == 0) {
                System.out.print("--> " + f);
                m++;
            }
        }
        System.out.println("\nNo of faults: " + m);
    }
}


