package finsl_lab_os;

//LAB 07 CPU Scheduling Algorithms - Shortest Job First Algorithm
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class SJF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Process> ProcessQ = new LinkedList<>();
        System.out.println("\n\nShortest Job First CPU Scheduling Algorithm: \n");
        System.out.println("\nEnter the number of processes:");
        int n = scanner.nextInt();
        Process[] ProcessArray=new Process[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter the Process Name, Arrival Time & Burst Time:");
            ProcessArray[i]=new Process (scanner.next(),scanner.nextInt(),scanner.nextInt());
        }
        Process temp;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (ProcessArray[i].P_ArrivalTime > ProcessArray[j].P_ArrivalTime) {
                    temp = ProcessArray[i];
                    ProcessArray[i] = ProcessArray[j];
                    ProcessArray[j] = temp;    
                }
            }
        }
        int timer=ProcessArray[0].P_ArrivalTime;
        for (int i = 0; i < n; i++) {
            for (int k = i; k < n; k++) 
                for (int j = k+1; j < n; j++) 
                { 
                    if ((ProcessArray[k].P_BurstTime > ProcessArray[j].P_BurstTime) 
                            && (ProcessArray[j].P_ArrivalTime<= timer)) 
                    {  
                        temp = ProcessArray[k]; 
                        ProcessArray[k]=ProcessArray[j];
                        ProcessArray[j]=temp;
                    } 
                }             
            if (i == 0)
                ProcessArray[i].P_StartTime=ProcessArray[i].P_ArrivalTime;
            else
            {
                if(ProcessArray[i-1].P_FinishTime>=ProcessArray[i].P_ArrivalTime)
                    ProcessArray[i].P_StartTime =ProcessArray[i-1].P_FinishTime;
                else ProcessArray[i].P_StartTime = ProcessArray[i].P_ArrivalTime;  
            }
            ProcessArray[i].P_WaitingTime=ProcessArray[i].P_StartTime-ProcessArray[i].P_ArrivalTime;
            ProcessArray[i].P_FinishTime = ProcessArray[i].P_StartTime +ProcessArray[i].P_BurstTime;
            ProcessArray[i].P_TurnAroundTime= ProcessArray[i].P_FinishTime-ProcessArray[i].P_ArrivalTime;
            timer=ProcessArray[i].P_FinishTime;
            ProcessQ.add(ProcessArray[i]);
        }
        Process x;
        int Total_tat=0;
        int Total_wt=0;
        System.out.println("\n\nPocess Name ArrivalTime BurstTime StartTime FinishTime WaitingTime TurnAroundTime");
        for (int i = 0; i < n; i++) {
            x=ProcessQ.poll();
            System.out.printf("\n%s\t%6d\t%10d\t%5d\t%6d\t%9d\t%7d",x.P_Name, x.P_ArrivalTime,
                    x.P_BurstTime,x.P_StartTime,x.P_FinishTime,x.P_WaitingTime,x.P_TurnAroundTime);
            Total_wt+= x.P_WaitingTime;
            Total_tat+= x.P_TurnAroundTime;
        }
        System.out.printf("\n\nAverage Waiting time:%f", (float) Total_wt / n);
        System.out.printf("\n\nAverage Turn Around Time:%f \n\n", (float) Total_tat/ n);
    }
    
}