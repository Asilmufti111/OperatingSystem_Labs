package finsl_lab_os;
//doneeeeeeeeeeeeee
//doneeeeeeeeeeeeee
//doneeeeeeeeeeeeee





public class Process {
    String P_Name;
    int P_ArrivalTime;
    int P_BurstTime;
    int P_TurnAroundTime;
    int P_StartTime;
    int P_FinishTime;
    int P_WaitingTime;
    int Priority;
    Process(String P_Name,int P_ArrivalTime,int P_BurstTime)
    {
        this.P_Name=P_Name;
        this.P_ArrivalTime=P_ArrivalTime;
        this.P_BurstTime=P_BurstTime;
    }
    void set_Priority(int Priority)
    {
        this.Priority=Priority;
    }
    
    
    
}