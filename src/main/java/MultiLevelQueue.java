import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiLevelQueue {
    Job[] jobBatch;
    Scheduler queue;
    JTextArea textArea;
    JTextField textField; 
    JProgressBar[] pbars;
    JLabel[] turnAroundTime;
    JLabel[] waitingTimes;
    JLabel[] priorities;
    JLabel[] remainingburstTimes;
   
    static int statusSum = 0;
    Computation[] myThreads = new Computation[MainPage.NUM_OF_PROCESSES];
    
    public MultiLevelQueue(Job[] jobBatch, Scheduler queue, JTextArea textArea, JTextField textField, JProgressBar[] pbars,
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
                int priority = (new java.util.Random().nextInt(3) + 1);
                jobBatch[i].progressBar = pbars[i];
                jobBatch[i].burstTimeLabel = remainingburstTimes[i];
                jobBatch[i].waitTimeLabel = waitingTimes[i];
                jobBatch[i].priority = priority;
                priorities[i].setText(String.valueOf(jobBatch[i].priority)); 
                mp.insert(jobBatch[i]);
                tempmp.insert(jobBatch[i]);
            }
       
           while(!tempmp.isEmpty()) {
                queue.enqueue(tempmp.extractMin());
            }
           
           while(!mp.isEmpty()) {
                long arrivalTime = mp.getMax().arrivalTime;
                try {
                    Thread.sleep(arrivalTime);
                } catch(Exception e) {}

                Job newJob = mp.extractMin();
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
