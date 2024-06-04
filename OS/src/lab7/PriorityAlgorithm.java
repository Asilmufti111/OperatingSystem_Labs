package lab7;

/* 
   name: Asil Asaad Mufti
   ID: 2106122
   section: DAR
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PriorityAlgorithm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Process> processes = new LinkedList<>(); // Queue to hold processes
        int n; // Number of processes
        int totwt = 0, tottat = 0; // Total waiting time and total turnaround time
        int timer = 0; // Timer to keep track of current time

        // Input the number of processes
        System.out.println("Program to simulate Priority CPU Scheduling Algorithm: ");
        System.out.println("\nEnter the number of process:");
        n = scanner.nextInt();

        // Input details for each process
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter process name, arrival time, execution time & priority:");
            String processName = scanner.next();
            int arrivalTime = scanner.nextInt();
            int burstTime = scanner.nextInt();
            int priority = scanner.nextInt();
            processes.add(new Process(processName, arrivalTime, burstTime, priority)); // Add process to queue
        }

        // Sort processes based on arrival time
        processes = sortProcessesByArrivalTime(processes);

        // Sorting the processes based on burst time
        Process[] processArray = processes.toArray(new Process[0]);
        int len = processArray.length;
        timer = processes.peek().arrivalTime; // Set timer to the arrival time of the first process
        processes.clear();

        // Scheduling the processes based on priority
        for (int i = 0; i < n; i++) {
            for (int k = i; k < n; k++) {
                for (int j = k + 1; j < n; j++) {

                    // Swap processes based on priority and arrival time
                    if ((processArray[k].priority < processArray[j].priority) && (processArray[j].arrivalTime <= timer)) {
                        Process temp = processArray[i];
                        processArray[i] = processArray[j];
                        processArray[j] = temp;
                    }
                }
            }

            // Calculate waiting time, start time, turnaround time, and finish time for each process
            if (processArray[i].equals(processArray[0])) {
                processArray[i].start = processArray[i].arrivalTime;
            } else {
                processArray[i].start = processArray[i - 1].finish;
            }
            processArray[i].wt = processArray[i].start - processArray[i].arrivalTime;
            processArray[i].finish = processArray[i].start + processArray[i].burstTime;
            processArray[i].tat = processArray[i].finish - processArray[i].arrivalTime;
            totwt += processArray[i].wt;
            tottat += processArray[i].tat;
            timer = processArray[i].finish; // Update timer to the finish time of the current process
        }

        // Add the scheduled processes back to the queue
        for (Process process : processArray) {
            processes.add(process);
        }

        // Display process details
        System.out.println("\nPname\t Arrival-Time\t Execution\t Priority\t Start-Time\tWaiting-Time\t TAT");
        for (Process process : processes) {
            System.out.printf("\n%s\t%5d\t\t%5d\t\t%5d\t\t%5d\t\t%5d\t\t%5d", process.processName,
                    process.arrivalTime, process.burstTime, process.priority, process.start, process.wt, process.tat);

        }

        // Display average waiting time and average turnaround time
        System.out.printf("\n\nAverage Waiting Time is:%f", (float) totwt / n);
        System.out.printf("\nAverage Turn Around Time is:%f\n", (float) tottat / n);
    }

    // Function to sort processes based on arrival time
    public static Queue<Process> sortProcessesByArrivalTime(Queue<Process> processes) {
        Process[] processArray = processes.toArray(new Process[0]);
        int n = processArray.length;

        // Bubble sort algorithm to sort processes based on arrival time
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (processArray[i].arrivalTime > processArray[j].arrivalTime) {
                    Process temp = processArray[i];
                    processArray[i] = processArray[j];
                    processArray[j] = temp;
                }
            }
        }

        // Convert sorted array back to a queue
        Queue<Process> sortedProcesses = new LinkedList<>();
        for (Process process : processArray) {
            sortedProcesses.add(process);
        }
        return sortedProcesses;
    }

}
