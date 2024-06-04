
//Lab 10 - Memory Management: Page Replacement Algorithms - FIFO
import java.util.Scanner;

public class FIFO {

    public static void main(String[] args) {
        //the pages in the memory right now
        int[] a=new int[5];
        //b array ia the pages that we will takes from the user
        int[] b=new int[20];
        
        //q1 store the size of a array 
        int n,p=0,q=0,m=0,h,k,i,q1=0;  
        String f="F";  
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Number of Pages:");
        n=scanner.nextInt();
        System.out.printf("Enter %d Page Numbers:", n);  
        for(i=0;i<n;i++)
            b[i]=scanner.nextInt();
        for(i=0;i<n;i++)//mowing on the number of the pages to execute all pages 
        {
            p=0;// as flag to know if the page is already in a array or we should add it 
            for(k=0;k<q1;k++)//move along the size of a array 
            {
		if (b[i]==a[k])
			p=1;  //means thet the page is already in a array 
            } 
            if (p==0)
            {
                //why 3? becouse this is the page frames number that given in the Q
                if (q>=3)  //if the a array is full then start replacing the first element with the new one 
                    q=0;
		a[q] = b[i];  
		q++;//keep track on the first in element to out it 
                q1++; // keep track on the size of the array		
		if(q1>3)  // if it is latger than 3--> then set it to 3
                    q1=3;   
            }
            System.out.printf("\n %d\t", b[i]);  
            for(h=0;h<q1;h++)
                System.out.printf("%d",a[h]); // the content in a arrsy   
            if(p==0)// that mean it wasn't on the a array and we put it so incrment the faults number
            {   
                System.out.printf("--> %s ",f);
                m++;//count the number of faults
            }
        } 
        System.out.printf("\n No of faults: %d",m);  
    }
    
}