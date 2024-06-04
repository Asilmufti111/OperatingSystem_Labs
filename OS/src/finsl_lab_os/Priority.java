//doneeeeeeeeeeeeee//doneeeeeeeeeeeeee
//doneeeeeeeeeeeeee
//doneeeeeeeeeeeeee
//doneeeeeeeeeeeeee
//doneeeeeeeeeeeeee








package finsl_lab_os;

//LAB 07 CPU Scheduling Algorithms - Priority Algorithm
import finsl_lab_os.Process;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Priority {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Process> ProcessQ = new LinkedList<>();
        System.out.println("\n\nPriority CPU Scheduling Algorithm: \n");
        System.out.println("\nEnter the number of processes:");
        int n = scanner.nextInt();
        Process[] ProcessArray=new Process[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter the Process Name, Arrival Time, Burst Time & Priority:");
            ProcessArray[i]=new Process (scanner.next(),scanner.nextInt(),scanner.nextInt());
            ProcessArray[i].set_Priority(scanner.nextInt());
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
                    if ((ProcessArray[k].Priority < ProcessArray[j].Priority) 
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
        System.out.println("\n\nPocess Name ArrivalTime BurstTime Priority StartTime FinishTime WaitingTime TurnAroundTime");
        for (int i = 0; i < n; i++) {
            x=ProcessQ.poll();
            System.out.printf("\n%s\t%6d\t%10d\t%5d\t%5d\t%6d\t%9d\t%7d",x.P_Name, x.P_ArrivalTime,
                    x.P_BurstTime,x.Priority,x.P_StartTime,x.P_FinishTime,x.P_WaitingTime,x.P_TurnAroundTime);
            Total_wt+= x.P_WaitingTime;
            Total_tat+= x.P_TurnAroundTime;
        }
        System.out.printf("\n\nAverage Waiting time:%f", (float) Total_wt / n);
        System.out.printf("\n\nAverage Turn Around Time:%f \n\n", (float) Total_tat/ n);
    }
    
}