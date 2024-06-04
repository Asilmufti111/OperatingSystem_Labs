/* 
   name: Asil Asaad Mufti
   ID: 2106122
   section: DAR
 */

import java.util.Scanner;

public class mft {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ms, bs, nob, ef, n, tif = 0;
        int[] mp = new int[10];
        int i, p = 0;
        System.out.print("Enter the total memory available (in Bytes) -- ");
        ms = scanner.nextInt();
        System.out.print("Enter the block size (in Bytes) -- ");
        bs = scanner.nextInt();
        nob = ms / bs;           // Calculating the number of blocks available
        ef = ms - nob * bs;     // Calculating the external fragmentation
        System.out.print("Enter the number of processes -- ");
        n = scanner.nextInt();
        for (i = 0; i < n; i++) {
            System.out.print("Enter memory required for process " + (i + 1) + " (in Bytes)-- ");
            mp[i] = scanner.nextInt();
        }
        System.out.println("\nNo. of Blocks available in memory -- " + nob);
        System.out.println("\nPROCESS\t\tMEMORY REQUIRED\t\t ALLOCATED\tINTERNAL FRAGMENTATION");
        // Loop to allocate memory for processes and calculate fragmentation
        for (i = 0; i < n && p < nob; i++) {
            System.out.print("\n" + (i + 1) + "\t\t" + mp[i]);
            if (mp[i] > bs) {
                System.out.print("\t\t\t NO\t\t---");
            } else {
                System.out.print("\t\t\t YES\t\t" + (bs - mp[i]));
                tif = tif + bs - mp[i];
                p++;
            }
        }
        if (i < n) {
            System.out.println("\n\nMemory is Full, Remaining Processes cannot be accommodated");
        }
        System.out.println("Total Internal Fragmentation is " + tif);
        ef = ef + tif;     // Adding total internal fragmentation to external fragmentation
        System.out.println("Total External Fragmentation is " + ef + "\n");
    }
}
