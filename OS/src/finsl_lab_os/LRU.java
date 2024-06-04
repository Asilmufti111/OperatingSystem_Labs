
import java.util.Scanner;

//Lab 10 - Memory Management: Page Replacement Algorithms - LRU

public class LRU {

    static int[] a=new int[3];//page frams 
    static int[] b=new int[20];// pages to enter to the frams from the user 
    static int n;// number of pages 
        
    static int LeastRecentlyUsed(int i)//ex: i= 4
        {
            int[] indexlocation=new int[3];//{0,0,0}
            int m,s,u;
            for(m=0;m<3;m++) // on the frames 
            {
                for(s=i-1;s>=0;s--)//s start with 3
                    if(a[m]==b[s]){ // a={6,5,1}
                        indexlocation[m]=s; //{3,1,2}
                        break;
                    }
            }
            int index=0;
            int LRUindex=indexlocation[0];//3
            for(u=1;u<3;u++)
            {
                if(indexlocation[u]<LRUindex)
                {
                    index=u;//1
                    LRUindex=indexlocation[u];//1
                }
            }
            return index;//1
        }
    public static void main(String[] args) {
        int g=0,p=0,q=0,m=0,h,k,i,q1=0,j,u;  
        String f="F";  
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of pages:");  
        n=scanner.nextInt();  
        System.out.printf("Enter %d Page Numbers:",n);  
        for(i=0;i<n;i++)   
            b[i]=scanner.nextInt();  
        for(i=0;i<n;i++)
        {
            p=0;
            for(k=0;k<q1;k++)    
            {    
                if(b[i]==a[k]) 
                    p=1;   // the page is already exist in the fram  
            }    
            if(p==0){       
                if(q1<3)//there is free space in the frames
                    q=q1;  // to enter the page to the fram normally
                else
                    q=LeastRecentlyUsed(i);//to enter the new page in the place of the least recently used page
                a[q]=b[i];//enter the page to the fram
                q1++; //counter on the a array size
                if(q1>3)//a array is full
                    q1=3;			
 
    
	} 
	System.out.printf("\n %d\t",b[i]);
        
	for(h=0;h<q1;h++) 
	System.out.printf("%d",a[h]); 
	if(p==0){ 
	   System.out.printf("--> %s",f);
		m++;} 
 
	} 
        System.out.printf("\nNo of faults:%d",m);

    }
    
}