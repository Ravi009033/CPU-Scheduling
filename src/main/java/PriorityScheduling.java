import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class PriorityScheduling {
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
    
    public PriorityScheduling(Job[] jobBatch, Scheduler queue, JTextArea textArea, JTextField textField, JProgressBar[] pbars,
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
        PriorityQueue mp = new PriorityQueue();
        PriorityQueue tempmp = new PriorityQueue();
            
            for(int i = 0; i < jobBatch.length; i++) {
                int priority = (new java.util.Random().nextInt(10) + 1);
                JProgressBar pbar = pbars[i];
                JLabel burstTime = remainingburstTimes[i];
                jobBatch[i].progressBar = pbar;
                jobBatch[i].burstTimeLabel = burstTime;
                jobBatch[i].priority = priority;
                jobBatch[i].waitTimeLabel = waitingTimes[i];
                priorities[i].setText(String.valueOf(jobBatch[i].priority));
                mp.insert(jobBatch[i]);
                tempmp.insert(jobBatch[i]);
            }
                 
            while(!tempmp.isEmpty()) {
                queue.enqueue(tempmp.extractMax());
            }
            
            while(!mp.isEmpty()) {
                long arrivalTime = mp.getMax().arrivalTime;
                try {
                    Thread.sleep(arrivalTime);
                } catch(Exception e) {}

                Job newJob = mp.extractMax();
                queue.dequeue();
                newJob.waitTime = System.nanoTime() - newJob.startTime;
                int durationInS = (int) TimeUnit.NANOSECONDS.toSeconds(newJob.waitTime);
                newJob.waitTimeLabel.setText(String.valueOf(durationInS) + "s");
                Computation cpu = new Computation(newJob, queue, textArea, 
                        textField, newJob.progressBar, newJob.burstTimeLabel);
                cpu.t.start();
                
                try {
                    cpu.t.join();
                } catch(InterruptedException ex) {}
                
                int index=newJob.id-1;
                int durationTAT = (int) TimeUnit.NANOSECONDS.toSeconds(newJob.endTime);
                turnAroundTime[index].setText(String.valueOf(durationTAT) + "s");
           }
    }
}
