import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class CPUScheduler extends Thread{
    Job[] jobBatch;
    Scheduler queue;
    JTextArea textArea;
    JTextField textField; 
    JProgressBar[] pbars;
    JLabel[] turnAroundTime;
    JLabel[] waitingTimes, priorities;
    JLabel[] remainingburstTimes;
  
    static int statusSum = 0;
    Computation[] myThreads = new Computation[MainPage.NUM_OF_PROCESSES];
    
    public CPUScheduler(Job[] jobBatch, Scheduler queue, JTextArea textArea, JTextField textField, JProgressBar[] pbars,
            JLabel[] remainingburstTimes, JLabel[] waitingTimes, JLabel[] priorities, JLabel[] turnAroundTime) {
        
        this.jobBatch = jobBatch;
        this.queue = queue;
        this.textArea = textArea;
        this.textField = textField;
        this.pbars = pbars;
        this.remainingburstTimes = remainingburstTimes;
        this.waitingTimes = waitingTimes;
        this.priorities = priorities;
        this.turnAroundTime = turnAroundTime;
    }
    
    public void run(){
        
        if(ResultPage.algo.equals("FCFS")){
            FCFS fifo= new FCFS(jobBatch, queue, textArea, textField, 
                    pbars, remainingburstTimes, waitingTimes, priorities, turnAroundTime);
            fifo.fcfs_calculate();
        }
        
        else if(ResultPage.algo.equals("Round Robin")) {
            RoundRobin rr = new RoundRobin(jobBatch, queue, textArea, textField, 
                    pbars, remainingburstTimes, waitingTimes, priorities, turnAroundTime);
            rr.calculate();  
        }
        
        else if (ResultPage.algo.equals("Priority Scheduling")) {
            PriorityScheduling ps = new PriorityScheduling(jobBatch, queue, textArea, textField, 
                    pbars, remainingburstTimes, waitingTimes, priorities, turnAroundTime);
            ps.calculate();
        }
        
        else if(ResultPage.algo.equals("Shortest Job First")){
            ShortestJobFirst sjf = new ShortestJobFirst(jobBatch, queue, textArea, textField, 
                    pbars, remainingburstTimes, waitingTimes, priorities, turnAroundTime);
            sjf.calculate();
        }
        
        else if(ResultPage.algo.equals("Multilevel Queue Scheduling")){
            MultiLevelQueue mlq = new MultiLevelQueue(jobBatch, queue, textArea, textField, 
                    pbars, remainingburstTimes, waitingTimes, priorities, turnAroundTime);
            mlq.calculate();
         
        }
        
        //calculate avg of turnAround Time and Waiting Time
       avgCalculate();    
    }
    
    public void avgCalculate(){
        long avgWaitTime = 0;
        long avgTurnaroundTime = 0;
        long totalExecutionTime = 0;
        
        for(int j = 0; j < jobBatch.length; j++) {
            avgWaitTime += jobBatch[j].waitTime;
            avgTurnaroundTime += jobBatch[j].endTime;
        }
        
        avgWaitTime /= jobBatch.length;
        avgWaitTime = TimeUnit.NANOSECONDS.toSeconds(avgWaitTime);
        ResultPage.avgWaitField.setText(String.valueOf(avgWaitTime) + "s");
        
        avgTurnaroundTime /= jobBatch.length;
        avgTurnaroundTime = TimeUnit.NANOSECONDS.toSeconds(avgTurnaroundTime);
        ResultPage.avgServeField.setText(String.valueOf(avgTurnaroundTime) + "s");
        
        totalExecutionTime = System.nanoTime() - ResultPage.STRTTIME;
        totalExecutionTime = TimeUnit.NANOSECONDS.toSeconds(totalExecutionTime);
        ResultPage.totalExecField.setText(String.valueOf(totalExecutionTime) + "s");
    }
}
