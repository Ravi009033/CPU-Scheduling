import java.awt.Color;
import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class RoundRobin {
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
    
    public RoundRobin(Job[] jobBatch, Scheduler queue, JTextArea textArea, JTextField textField, JProgressBar[] pbars,
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
        for(int i = 0; i < jobBatch.length; i++) {
                jobBatch[i].progressBar = pbars[i];
                jobBatch[i].burstTimeLabel = remainingburstTimes[i];
                jobBatch[i].waitTimeLabel = waitingTimes[i];
            }
            Arrays.sort(jobBatch, Comparator.comparingLong(job -> job.arrivalTime));
             
            for (Job job : jobBatch) {
            queue.enqueue(job);
        }
            
            while(!queue.isEmpty()) {
                long arrivalTime = queue.peek().job.arrivalTime;
                try {
                    Thread.sleep(arrivalTime);
                } catch(Exception e) {}
                
                Job newJob = queue.dequeue();
                int durationInS = (int) TimeUnit.NANOSECONDS.toSeconds(newJob.waitTime);
                newJob.waitTimeLabel.setText(String.valueOf(durationInS) + "s");
                myThreads[0] = new Computation(newJob, queue, textArea, textField, 
                        newJob.progressBar, newJob.burstTimeLabel);
                myThreads[0].t.start();
                try {
                    myThreads[0].t.join();
                } catch(Exception ex) {}
            }
            
            for(int j = 1; j < myThreads.length; j++){
                myThreads[j] = new Computation(null, null, null, null, null, null);     
                
                int durationWT = (int) TimeUnit.NANOSECONDS.toSeconds(jobBatch[j].waitTime);
                waitingTimes[j].setText(String.valueOf(durationWT) + "s");
                int durationTAT = (int) TimeUnit.NANOSECONDS.toSeconds(jobBatch[j].endTime);
                turnAroundTime[j].setText(String.valueOf(durationTAT) + "s");   
            }
            System.out.println("GOT OUT");
            try {
                for(int j = 0; j < myThreads.length; j++)
                    myThreads[j].t.join();
            } catch(InterruptedException ex) {}
            
             textField.setText("Idle");
             textField.setForeground(Color.red);
    }
    
}
