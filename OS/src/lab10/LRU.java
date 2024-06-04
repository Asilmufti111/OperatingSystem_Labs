
/* 
   name: Asil Asaad Mufti
   ID: 2106122
   section: DAR
 */

import java.util.Scanner;

public class LRU {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[3];
        int[] b = new int[20];
        int n;
        int g = 0, p = 0, q = 0, m = 0, h, k, i, q1 = 0, j, u;
        char f = 'F';

        System.out.print("Enter the number of pages:");
        n = scanner.nextInt();
        System.out.print("Enter " + n + " Page Numbers:");
        for (i = 0; i < n; i++)
            b[i] = scanner.nextInt();

        for (i = 0; i < n; i++) {
            p = 0;
            for (k = 0; k < q1; k++) {
                if (b[i] == a[k]) {
                    p = 1;
                }
            }
            if (p == 0) {
                if (q1 < 3)
                    q = q1;
                else
                    q = LRU(i, a, b, q1);
                a[q] = b[i];
                q1++;
                if (q1 > 3)
                    q1 = 3;
            }
            System.out.println("\n" + b[i] + "\t");
            for (h = 0; h < q1; h++)
                System.out.print(a[h]);
            if (p == 0) {
                System.out.print("--> " + f);
                m++;
            }
        }
        System.out.println("\nNo of faults:" + m);
    }

    public static int LRU(int i, int[] a, int[] b, int q1) {
        int[] indexlocation = new int[3];
        int m, s, u;
        for (m = 0; m < 3; m++) {
            for (s = i - 1; s >= 0; s--) {
                if (a[m] == b[s]) {
                    indexlocation[m] = s;
                    break;
                }
            }
        }
        int index = 0;
        int LRUindex = indexlocation[0];
        for (u = 1; u < 3; u++) {
            if (indexlocation[u] < LRUindex) {
                index = u;
                LRUindex = indexlocation[u];
            }
        }
        return index;
    }
}

