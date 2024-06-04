package lab7;

/* 
   name: Asil Asaad Mufti
   ID: 2106122
   section: DAR
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FCFSAlgorithm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Process> processes = new LinkedList<>(); // Queue to hold processes
        int n;
        int totwt = 0, tottat = 0; // Total waiting time and total turnaround time

        // Input the number of processes
        System.out.println("First-Come-First-Serve CPU Scheduling Algorithm: ");
        System.out.println("\nEnter the number of processes:");
        n = scanner.nextInt();

        // Input details for each process
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter the Process Name, Arrival Time & Burst Time:");
            String processName = scanner.next();
            int arrivalTime = scanner.nextInt();
            int burstTime = scanner.nextInt();
            processes.add(new Process(processName, arrivalTime, burstTime)); // Add process to queue
        }

        // Sort processes based on arrival time
        processes = sortProcesses(processes);

        // Calculate waiting time, start time, turnaround time, and finish time for each process
        for (Process process : processes) {
            if (process.equals(processes.peek())) {
                process.start = process.arrivalTime;
            } else {
                process.start = processes.peek().finish;
            }
            process.wt = process.start - process.arrivalTime;
            process.finish = process.start + process.burstTime;
            process.tat = process.finish - process.arrivalTime;
        }

        // Display process details
        System.out.println("\n\nPName Arr-time Burst-time Wait Star-time Turn-Around-Time Finish");
        for (Process process : processes) {
            System.out.printf("\n%s\t%3d\t%3d\t%3d\t%3d\t%6d\t\t%6d", process.processName, process.arrivalTime,
                    process.burstTime, process.wt, process.start, process.tat, process.finish);
            totwt += process.wt;
            tottat += process.tat;
        }

        // Display average waiting time and average turnaround time
        System.out.println("\n\n\nAverage Waiting time:" + (float) totwt / n);
        System.out.println("\nAverage Turn Around Time:" + (float) tottat / n + "\n");
    }

    // Function to sort processes based on arrival time
    public static Queue<Process> sortProcesses(Queue<Process> processes) {
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
