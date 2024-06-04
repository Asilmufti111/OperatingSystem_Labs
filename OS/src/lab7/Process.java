package lab7;

/* 
   name: Asil Asaad Mufti
   ID: 2106122
   section: DAR
 */

// Process class represents a process in the CPU scheduling simulation
class Process {

    // Attributes of the process
    String processName; // Name of the process
    int arrivalTime;    // Time at which the process arrives
    int burstTime;      // Time required by the process for execution
    int start;          // Start time of the process
    int finish;         // Finish time of the process
    int tat;            // Turnaround time of the process
    int wt;             // Waiting time of the process
    int priority;       // Priority of the process (used in priority scheduling)

    // Constructor for a process without priority
    public Process(String processName, int arrivalTime, int burstTime) {
        this.processName = processName;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }

    // Constructor for a process with priority
    public Process(String processName, int arrivalTime, int burstTime, int priority) {
        this.processName = processName;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
    }
}
