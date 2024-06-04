//doneeeeeeeeeeeeee
//doneeeeeeeeeeeeee
//doneeeeeeeeeeeeee




//Lab 09 - Multi Programming with a Fixed number of Tasks

import java.util.Scanner;

public class MFT {

 
    public static void main(String[] args) {
        // ms is memory size 
        //bs is block size 
        // nob is number of blocks 
        //ef is external fragmentaion 
        //tif is total internal fragmentaion 
        // n is number of process
        int ms, bs, nob, ef,n,i,tif=0,p=0;
        int[] mp=new int[10];//memory required for process
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the total memory available (in Bytes) -- ");
        ms=scanner.nextInt();
        System.out.print("Enter the block size (in Bytes) -- ");
        bs=scanner.nextInt();
        nob=ms/bs;// number of blocks = memory size / block size
        ef=ms - nob*bs; // external fragmentaiion = memory size - number of blocks * block size
        System.out.print("\nEnter the number of processes -- ");
        n=scanner.nextInt();
        for(i=0;i<n;i++)
        {
            System.out.print("Enter memory required for process "+(i+1)+" (in Bytes)-- ");
            mp[i]=scanner.nextInt();
        }
        System.out.println("No. of Blocks available in memory -- "+nob);
        System.out.println("\n\nPROCESS\tMEMORY REQUIRED\t ALLOCATED\tINTERNAL FRAGMENTATION");
        for(i=0;i<n && p<nob;i++)
        {
            System.out.printf("\n %d\t%d",i+1,mp[i]);
            if(mp[i] > bs)
                System.out.printf("\t\t  NO\t\t---");
            else
            {
                System.out.printf("\t\t  YES\t\t%d",bs-mp[i]);
                tif = tif + bs-mp[i];// calculate the total internal fragmentaion 
                p++;//increase the number of process that was alocated to a block 
            }
        }
        if(i<n)// if the loop end with (p==nop) that means there is no avalable block
            System.out.println("\nMemory is Full, Remaining Processes cannot be accomodated");
        System.out.println("\n\nTotal Internal Fragmentation is "+tif);
        ef=ef+tif;
        System.out.println("\nTotal External Fragmentation is "+ef);

}
}
    
