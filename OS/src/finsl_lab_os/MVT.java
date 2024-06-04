//doneeeeeeeeeeeeee
//doneeeeeeeeeeeeee
//doneeeeeeeeeeeeee




package finsl_lab_os;

//Lab 09 - Multi Programming with a Variable number of Tasks
import java.util.Scanner;
public class MVT {

  
    public static void main(String[] args) {
        //ms is memory available
        int ms,i, temp,n=0;
        String ch = "y";//has next input
        int[] mp=new int[10];//memory required for process 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the total memory available (in Bytes) -- ");
        ms=scanner.nextInt();
        temp=ms;
        for(i=0;ch.equalsIgnoreCase("y");i++,n++)
        {
            System.out.print("Enter memory required for process "+(i+1)+" (in Bytes)-- ");
            mp[i]=scanner.nextInt();
            if(mp[i]<=temp)
            {
                System.out.println("\nMemory is allocated for Process "+(i+1));
                temp = temp - mp[i];
            }
            else
            {
                System.out.println("\nMemory is Full");
                break;
            }
            System.out.print("\nDo you want to continue(y/n) -- ");
            ch=scanner.next();
        }
        System.out.println("\n\nTotal Memory Available -- "+ ms);
        System.out.println("\n\n\tPROCESS\t\t MEMORY ALLOCATED ");
        for(i=0;i<n;i++)
            System.out.printf("\n \t%d\t\t%d",i+1,mp[i]);
        System.out.println("\n\nTotal Memory Allocated is "+(ms-temp));
        System.out.println("\nTotal External Fragmentation is "+temp);

    }
    
}