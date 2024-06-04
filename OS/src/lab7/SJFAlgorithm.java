package lab7;

/* 
   name: Asil Asaad Mufti
   ID: 2106122
   section: DAR
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SJFAlgorithm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Process> processes = new LinkedList<>(); // Queue to hold processes
        int n; // Number of processes
        int totwt = 0, tottat = 0; // Total waiting time and total turnaround time
        int timer = 0; // Timer to keep track of current time

        // Input the number of processes
        System.out.println("Shortest Job First CPU Scheduling CPU Scheduling Algorithm: ");
        System.out.print("\nEnter the number of process:");
        n = scanner.nextInt();

        // Input details for each process
        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter process name, arrival time & execution time:");
            String processName = scanner.next();
            int arrivalTime = scanner.nextInt();
            int burstTime = scanner.nextInt();
            processes.add(new Process(processName, arrivalTime, burstTime)); // Add process to queue
        }

        // Sort processes based on arrival time
        processes = sortProcessesByArrivalTime(processes);

        // Sorting the processes based on burst time
        Process[] processArray = processes.toArray(new Process[0]);
        int len = processArray.length;
        timer = processes.peek().arrivalTime; // Set timer to the arrival time of the first process
        processes.clear();

        // Scheduling the processes based on burst time (Shortest Job First algorithm)
        for (int i = 0; i < n; i++) {
            for (int k = i; k < n; k++) {
                for (int j = k + 1; j < n; j++) {
                    // Swap processes based on burst time and arrival time
                    if ((processArray[k].burstTime > processArray[j].burstTime) && (processArray[j].arrivalTime <= timer)) {
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
        System.out.println("\nPname\tarrivaltime\texecutiontime\tStartime\twaitingtime\ttatime");
        for (Process process : processes) {
            System.out.println(process.processName + "\t" + process.arrivalTime + "\t\t" + process.burstTime + "\t\t" + process.start + "\t\t" + process.wt + "\t\t" + process.tat);
        }

        // Display average waiting time and average turnaround time
        System.out.println("\n\nAverage waiting time is:" + (float) totwt / n);
        System.out.println("\nAverage turnaroundtime is:" + (float) tottat / n + "\n");
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
