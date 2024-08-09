import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class ShortestJobFirst {
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
    
    public ShortestJobFirst(Job[] jobBatch, Scheduler queue, JTextArea textArea, JTextField textField, JProgressBar[] pbars,
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
    
    public void calculate(){
        
             Arrays.sort(jobBatch, Comparator.comparingLong(job -> job.burstTime));
             
            for (Job job : jobBatch) {
            queue.enqueue(job);
        }
           
            while (!queue.isEmpty()) {   
            Job currentJob = queue.dequeue();
            long arrivalTime = currentJob.arrivalTime;
            int index=currentJob.id;
            index=index-1;
            JProgressBar progressBar = pbars[index]; 
            JLabel remainingburstTimeLabel = remainingburstTimes[index];
    
            try {
                Thread.sleep(arrivalTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread interrupted: " + e.getMessage());
            }
                myThreads[index] = new Computation(currentJob, queue, textArea, textField, progressBar,remainingburstTimeLabel);
                myThreads[index].t.start();
                  
            try {
                // Wait for the current job to complete
                myThreads[index].t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread interrupted while waiting for job to complete: " + e.getMessage());
            } 
                int durationWT = (int) TimeUnit.NANOSECONDS.toSeconds(currentJob.waitTime);
                waitingTimes[index].setText(String.valueOf(durationWT) + "s");
                int durationTAT = (int) TimeUnit.NANOSECONDS.toSeconds(currentJob.endTime);
                turnAroundTime[index].setText(String.valueOf(durationTAT) + "s");
            }
    }
}
