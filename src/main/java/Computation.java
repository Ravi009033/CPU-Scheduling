import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class Computation implements Runnable {
    Scheduler queue;
    Thread t;
    Job job;
    JTextField textField;
    JTextArea readyQueue;
    JProgressBar pbar;
    JLabel burstTime;
    
    static final long TIME_QUANTUM = 140;
    
    Computation(Job job, Scheduler queue, JTextArea readyQueue, JTextField textField,
            JProgressBar pbar,JLabel burstTime){
        
        this.queue=queue;
        t = new Thread(this);
        this.job=job;
        this.readyQueue=readyQueue;
        this.textField=textField;
        this.pbar=pbar;
        this.burstTime=burstTime; 
    }
    
    public void assignJob(Job job){
        this.job=job;
    }
    
    public void run(){
        queue.allocateCPU(job);
        boolean status=true;
        
         if(ResultPage.algo.equals("Round Robin")) {
            int min = job.pBarValue;
            int max = (int) job.burstTime;
            pbar.setMinimum(0);
            pbar.setMaximum(max);

            int remainingBurstTime = (int) job.lastRemainingBurst; 
            int exceedTime = 0;
            
            String remProcesses = queue.getRemainingProcesses();
            readyQueue.setText(remProcesses);
            
            for(int i = min; i < max; i++) {
                pbar.setValue(i);
                try {
                    Thread.sleep(20);
                    if(exceedTime == TIME_QUANTUM  && remainingBurstTime > 0) { 
                        job.lastRemainingBurst = remainingBurstTime;
                        job.pBarValue = i;
                        queue.enqueue(job);
                        break;
                    }
                    synchronized(this) {
                        textField.setText("");
                        textField.setText(job.processID);
                    }
                } catch(InterruptedException ex) {}
                
                remainingBurstTime--;
                burstTime.setText(String.valueOf(remainingBurstTime) + "ms");
                exceedTime++;
            }
            readyQueue.setText(queue.getRemainingProcesses());
        }
         
        //for remaining algorithms 
        else{
            int min = 0;
            int max = (int) job.burstTime;
            pbar.setMinimum(min);
            pbar.setMaximum(max);
            pbar.setValue(0);
            
            String remProcesses = queue.getRemainingProcesses();
            readyQueue.setText(remProcesses);
            
            int remainingBurstTime = (int) job.burstTime; 
            for(int i = 0; i < max; i++) {
                pbar.setValue(i);
                try {
                    Thread.sleep(20);
                    synchronized(this) {
                        textField.setText("");
                        textField.setText(job.processID);
                    }
                }catch(InterruptedException ex) {}
                
                remainingBurstTime--;
                burstTime.setText(String.valueOf(remainingBurstTime) + " ms");    
            }
                
             if(status) {
                CPUScheduler.statusSum++;
                System.out.println(CPUScheduler.statusSum);
            }
             
        }
        job.endTime = System.nanoTime() - job.startTime;
        
    }  
}
