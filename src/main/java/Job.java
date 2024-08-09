import javax.swing.*;

public class Job {
    String processID;
    long burstTime;
    long arrivalTime;
    long startTime;
    long endTime;
    long waitTime;
    int lastRemainingBurst;
    JProgressBar progressBar;
    JLabel waitTimeLabel;
    JLabel burstTimeLabel;
    int pBarValue=0;
    int priority;
    int id;
    
    
    public Job(String processID, long arrivalTime, long burstTime,long startTime, int id){
        this.processID=processID;
        this.arrivalTime=arrivalTime;
        this.burstTime=burstTime;
        this.startTime=startTime;
        this.id=id;
        lastRemainingBurst=(int) burstTime;
    }
    
    
}
