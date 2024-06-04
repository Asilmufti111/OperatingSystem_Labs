
/* 
   name: Asil Asaad Mufti
   ID: 2106122
   section: DAR
 */

import java.util.LinkedList;
import java.util.Queue;

class roundRobinnAlg {

    static class Process {
        String name;
        int arrivalTime;
        int burstTime;
        int OrgburstTime;
        int wtime; // Waiting time
        int ctime; // Completion time

        public Process(String name, int arrivalTime, int burstTime) {
            this.name = name;
            this.arrivalTime = arrivalTime;
            this.OrgburstTime = burstTime;
            this.wtime = 0;
            this.ctime = 0;
            this.burstTime=OrgburstTime;
        }  
    }

    // Driver Code
    public static void main(String args[]) {
        Queue<Process> processes = new LinkedList<>(); // Queue to hold processes

        processes.add(new Process("p1", 0, 10));
        processes.add(new Process("p2", 1, 4));
        processes.add(new Process("p3", 2, 5));
        processes.add(new Process("p4", 3, 3));

        // quantum time of each process
        int q = 3;

        // call the function for output
        roundRobin(processes, q);
    }
    
    public static void roundRobin(Queue<Process> processes, int n) {
        // result of average times
        int res = 0;
        int resc = 0;

        // for sequence storage
        String seq = new String();

        // copy the burst array and arrival array
        // for not affecting the actual array
        Queue<Process> resProcesses = new LinkedList<>(processes);

        // critical time of system
        int t = 0;

        // while loop to simulate the round-robin scheduling
        while (!resProcesses.isEmpty()) {
            Process currentProcess = resProcesses.poll();
            if (currentProcess.arrivalTime <= t) {
                if (currentProcess.burstTime > 0) {
                    if (currentProcess.burstTime > n) {
                        t += n;
                        currentProcess.burstTime -= n;
                        seq+="->"+currentProcess.name;
                        resProcesses.add(currentProcess);
                    } else {
                        t += currentProcess.burstTime;
                        currentProcess.ctime=(t-currentProcess.arrivalTime); // Set completion time
                        currentProcess.wtime=(t - currentProcess.OrgburstTime - currentProcess.arrivalTime); // Set waiting time
                        seq+="->"+currentProcess.name;
                    }
                }
            } else {
                resProcesses.add(currentProcess);
            }
        }

        // Calculate total waiting time and completion time
        for (Process p : processes) {
            res += p.wtime;
            resc += p.ctime;
        }

        // Print results
        System.out.println("name ctime wtime");
        for (Process p : processes) {
            System.out.println("  " + p.name + "   " + p.ctime + "   " + p.wtime);
        }

        // Print average waiting time and completion time
        System.out.println("Average waiting time is " + (float) res / processes.size());
        System.out.println("Average compilation time is " + (float) resc / processes.size());
        System.out.println("Sequence is like that " + seq);
    }

}
