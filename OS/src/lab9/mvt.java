/* 
   name: Asil Asaad Mufti
   ID: 2106122
   section: DAR
 */

import java.util.Scanner;

public class mvt {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ms, mp[] = new int[10], i, temp, n = 0;
        char ch = 'y';
        System.out.print("Enter the total memory available (in Bytes)-- ");
        ms = scanner.nextInt();
        temp = ms;
        // Loop to allocate memory for processes
        for (i = 0; ch == 'y'; i++, n++) {
            System.out.print("Enter memory required for process " + (i + 1) + " (in Bytes) -- ");
            mp[i] = scanner.nextInt();
            if (mp[i] <= temp) {
                // Allocating memory for the process if memory is available
                System.out.println("Memory is allocated for Process " + (i + 1));
                temp = temp - mp[i];
            } else {
                System.out.println("\nMemory is Full");
                break;
            }
            System.out.print("Do you want to continue(y/n) -- ");
            ch = scanner.next().charAt(0);
        }
        System.out.println("Total Memory Available -- " + ms);
        System.out.println("PROCESS\t\tMEMORY ALLOCATED ");
        // Loop to display memory allocated for each process
        for (i = 0; i < n; i++) {
            System.out.println("\n" + (i + 1) + "\t\t" + mp[i]);
        }
        System.out.println("\nTotal Memory Allocated is " + (ms - temp));
        System.out.println("Total External Fragmentation is " + temp);
    }
}
