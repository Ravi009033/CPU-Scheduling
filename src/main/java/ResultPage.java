import java.io.File;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class ResultPage extends javax.swing.JFrame {
    Job[] jobBatch;
    int numOfJobs;
    String sourcePath;
    static String algo;
    JProgressBar[] pbars = new JProgressBar[10];
    JLabel[] remainingBurstTimes = new JLabel[10]; 
    JLabel[] waitingTimes = new JLabel[10];
    JLabel[] priorities = new JLabel[10];
    JLabel[] arrivalTime = new JLabel[10];
    JLabel[] burstTime = new JLabel[10];
    JLabel[] turnAroundTime = new JLabel[10];
    static long STRTTIME;
    
    public ResultPage(Job[] jobBatch, int numOfJobs, String sourcePath, String algo){
        this.jobBatch = jobBatch;
        this.numOfJobs = numOfJobs;
        this.sourcePath = sourcePath;
        this.algo=algo;
        
         initComponents();
        // jLabel1.setIcon(new javax.swing.ImageIcon("src\\main\\java\\bg.jpg"));
        selectedAlgo.setText(algo);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        
        pbars[0] = jProgressBar1;
        pbars[1] = jProgressBar2;
        pbars[2] = jProgressBar3;
        pbars[3] = jProgressBar4;
        pbars[4] = jProgressBar5;
        pbars[5] = jProgressBar6;
        pbars[6] = jProgressBar7;
        pbars[7] = jProgressBar8;
        pbars[8] = jProgressBar9;
        pbars[9] = jProgressBar10;
        
        remainingBurstTimes[0] = bst1;
        remainingBurstTimes[1] = bst2;
        remainingBurstTimes[2] = bst3;
        remainingBurstTimes[3] = bst4;
        remainingBurstTimes[4] = bst5;
        remainingBurstTimes[5] = bst6;
        remainingBurstTimes[6] = bst7;
        remainingBurstTimes[7] = bst8;
        remainingBurstTimes[8] = bst9;
        remainingBurstTimes[9] = bst10;
        
        waitingTimes[0] = bst11;
        waitingTimes[1] = bst12;
        waitingTimes[2] = bst13;
        waitingTimes[3] = bst14;
        waitingTimes[4] = bst15;
        waitingTimes[5] = bst16;
        waitingTimes[6] = bst17;
        waitingTimes[7] = bst18;
        waitingTimes[8] = bst19;
        waitingTimes[9] = bst20;
        
        arrivalTime[0] = bst21;
        arrivalTime[1] = bst22;
        arrivalTime[2] = bst23;
        arrivalTime[3] = bst24;
        arrivalTime[4] = bst25;
        arrivalTime[5] = bst26;
        arrivalTime[6] = bst27;
        arrivalTime[7] = bst28;
        arrivalTime[8] = bst29;
        arrivalTime[9] = bst30;
        for(int i=0;i<numOfJobs;i++){
             arrivalTime[i].setText(Long.toString(jobBatch[i].arrivalTime)+ " ms");
        }
        
        burstTime[0] = bst31;
        burstTime[1] = bst32;
        burstTime[2] = bst33;
        burstTime[3] = bst34;
        burstTime[4] = bst35;
        burstTime[5] = bst36;
        burstTime[6] = bst37;
        burstTime[7] = bst38;
        burstTime[8] = bst39;
        burstTime[9] = bst40;
        for(int i=0;i<numOfJobs;i++){
             burstTime[i].setText(Long.toString(jobBatch[i].burstTime)+ " ms");
        }
        
        turnAroundTime[0] = bst41;
        turnAroundTime[1] = bst42;
        turnAroundTime[2] = bst43;
        turnAroundTime[3] = bst44;
        turnAroundTime[4] = bst45;
        turnAroundTime[5] = bst46;
        turnAroundTime[6] = bst47;
        turnAroundTime[7] = bst48;
        turnAroundTime[8] = bst49;
        turnAroundTime[9] = bst50;
        
        priorities[0] = pt1;
        priorities[1] = pt2;
        priorities[2] = pt3;
        priorities[3] = pt4;
        priorities[4] = pt5;
        priorities[5] = pt6;
        priorities[6] = pt7;
        priorities[7] = pt8;
        priorities[8] = pt9;
        priorities[9] = pt10;
        
        STRTTIME = System.nanoTime();   
    }
     
    public void start() {
        if(algo.equals("FCFS")) {
            Queue fifo = new Queue(new File(sourcePath));
            CPUScheduler scheduler = new CPUScheduler(jobBatch, fifo, jTextArea1, selectedJob, 
                    pbars, remainingBurstTimes, waitingTimes, priorities, turnAroundTime);
            scheduler.start();
        }
        else if(algo.equals("Priority Scheduling")) {
            Queue pp = new Queue(new File(sourcePath));
            CPUScheduler scheduler = new CPUScheduler(jobBatch, pp, jTextArea1, selectedJob, 
                    pbars, remainingBurstTimes, waitingTimes, priorities, turnAroundTime);
            scheduler.start();
        }
        else if(algo.equals("Round Robin")) {
            Queue rr = new Queue(new File(sourcePath));
            CPUScheduler scheduler = new CPUScheduler(jobBatch, rr, jTextArea1, selectedJob, 
                    pbars, remainingBurstTimes, waitingTimes, priorities, turnAroundTime);
            scheduler.start();
        }
        else if(algo.equals("Shortest Job First")) {
            Queue sjf = new Queue(new File(sourcePath));
            CPUScheduler scheduler = new CPUScheduler(jobBatch, sjf, jTextArea1, selectedJob, 
                    pbars, remainingBurstTimes, waitingTimes, priorities, turnAroundTime);
            scheduler.start();
        }
        else if(algo.equals("Multilevel Queue Scheduling")) {
            selectedAlgo.setText("Multilevel Queue");
            Queue mq = new Queue(new File(sourcePath));
            CPUScheduler scheduler = new CPUScheduler(jobBatch, mq, jTextArea1, selectedJob, 
                    pbars, remainingBurstTimes, waitingTimes, priorities, turnAroundTime);
            scheduler.start();
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        algoSelected2 = new javax.swing.JLabel();
        selectedAlgo = new javax.swing.JTextField();
        pt1 = new javax.swing.JLabel();
        jProgressBar2 = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        jProgressBar3 = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        jProgressBar4 = new javax.swing.JProgressBar();
        jLabel6 = new javax.swing.JLabel();
        jProgressBar5 = new javax.swing.JProgressBar();
        jLabel7 = new javax.swing.JLabel();
        jProgressBar6 = new javax.swing.JProgressBar();
        jLabel8 = new javax.swing.JLabel();
        jProgressBar7 = new javax.swing.JProgressBar();
        jLabel9 = new javax.swing.JLabel();
        jProgressBar8 = new javax.swing.JProgressBar();
        jLabel10 = new javax.swing.JLabel();
        jProgressBar9 = new javax.swing.JProgressBar();
        jLabel11 = new javax.swing.JLabel();
        jProgressBar10 = new javax.swing.JProgressBar();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        bst3 = new javax.swing.JLabel();
        bst1 = new javax.swing.JLabel();
        bst2 = new javax.swing.JLabel();
        bst6 = new javax.swing.JLabel();
        bst5 = new javax.swing.JLabel();
        bst4 = new javax.swing.JLabel();
        bst10 = new javax.swing.JLabel();
        bst8 = new javax.swing.JLabel();
        bst7 = new javax.swing.JLabel();
        bst9 = new javax.swing.JLabel();
        bst11 = new javax.swing.JLabel();
        bst12 = new javax.swing.JLabel();
        bst13 = new javax.swing.JLabel();
        bst14 = new javax.swing.JLabel();
        bst15 = new javax.swing.JLabel();
        bst16 = new javax.swing.JLabel();
        bst17 = new javax.swing.JLabel();
        bst18 = new javax.swing.JLabel();
        bst19 = new javax.swing.JLabel();
        bst20 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        avgServeLabel = new javax.swing.JLabel();
        selectedJob = new javax.swing.JTextField();
        avgWaitField = new javax.swing.JTextField();
        avgServeField = new javax.swing.JTextField();
        totalExecField = new javax.swing.JTextField();
        avgTurnLabel1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        pt2 = new javax.swing.JLabel();
        pt3 = new javax.swing.JLabel();
        pt4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        pt5 = new javax.swing.JLabel();
        pt6 = new javax.swing.JLabel();
        pt7 = new javax.swing.JLabel();
        pt8 = new javax.swing.JLabel();
        pt9 = new javax.swing.JLabel();
        pt10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        bst21 = new javax.swing.JLabel();
        bst22 = new javax.swing.JLabel();
        bst23 = new javax.swing.JLabel();
        bst24 = new javax.swing.JLabel();
        bst25 = new javax.swing.JLabel();
        bst26 = new javax.swing.JLabel();
        bst27 = new javax.swing.JLabel();
        bst28 = new javax.swing.JLabel();
        bst29 = new javax.swing.JLabel();
        bst30 = new javax.swing.JLabel();
        bst31 = new javax.swing.JLabel();
        bst32 = new javax.swing.JLabel();
        bst33 = new javax.swing.JLabel();
        bst34 = new javax.swing.JLabel();
        bst35 = new javax.swing.JLabel();
        bst36 = new javax.swing.JLabel();
        bst37 = new javax.swing.JLabel();
        bst38 = new javax.swing.JLabel();
        bst39 = new javax.swing.JLabel();
        bst40 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        bst41 = new javax.swing.JLabel();
        bst42 = new javax.swing.JLabel();
        bst43 = new javax.swing.JLabel();
        bst44 = new javax.swing.JLabel();
        bst45 = new javax.swing.JLabel();
        bst46 = new javax.swing.JLabel();
        bst47 = new javax.swing.JLabel();
        bst48 = new javax.swing.JLabel();
        bst49 = new javax.swing.JLabel();
        bst50 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setBackground(new java.awt.Color(102, 102, 102));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 380, 60));

        jProgressBar1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 270, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ready Queue");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 100, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Algorithm: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, 30));

        algoSelected2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        algoSelected2.setForeground(new java.awt.Color(255, 255, 255));
        algoSelected2.setText("CPU Schdeule:");
        jPanel1.add(algoSelected2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 160, 30));

        selectedAlgo.setBackground(new java.awt.Color(102, 102, 102));
        selectedAlgo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        selectedAlgo.setForeground(new java.awt.Color(255, 255, 255));
        selectedAlgo.setText("FCFS");
        jPanel1.add(selectedAlgo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 250, 30));

        pt1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pt1.setForeground(new java.awt.Color(255, 255, 255));
        pt1.setText("0");
        jPanel1.add(pt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 30, 30));
        jPanel1.add(jProgressBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 270, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("P2:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 30, 30));
        jPanel1.add(jProgressBar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 270, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("P3:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 30, 30));
        jPanel1.add(jProgressBar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 270, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("P4:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 30, 30));
        jPanel1.add(jProgressBar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, 270, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("P5:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 30, 30));
        jPanel1.add(jProgressBar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 270, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("P6:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, 30, 30));
        jPanel1.add(jProgressBar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 370, 270, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("P7:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, 30, 30));
        jPanel1.add(jProgressBar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, 270, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("P8:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 420, 30, 30));
        jPanel1.add(jProgressBar9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 470, 270, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("P9:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 470, 30, 30));
        jPanel1.add(jProgressBar10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 520, 270, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("P10:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 520, 30, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Waiting Time");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1095, 20, 100, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Priority");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 70, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Arrival Time");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, 90, 30));

        bst3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst3.setForeground(new java.awt.Color(255, 255, 255));
        bst3.setText("0");
        jPanel1.add(bst3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 170, 60, 20));

        bst1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst1.setForeground(new java.awt.Color(255, 255, 255));
        bst1.setText("0");
        jPanel1.add(bst1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 70, 60, 20));

        bst2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst2.setForeground(new java.awt.Color(255, 255, 255));
        bst2.setText("0");
        jPanel1.add(bst2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 120, 60, 20));

        bst6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst6.setForeground(new java.awt.Color(255, 255, 255));
        bst6.setText("0");
        jPanel1.add(bst6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 320, 60, 20));

        bst5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst5.setForeground(new java.awt.Color(255, 255, 255));
        bst5.setText("0");
        jPanel1.add(bst5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 270, 60, 20));

        bst4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst4.setForeground(new java.awt.Color(255, 255, 255));
        bst4.setText("0");
        jPanel1.add(bst4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 220, 60, 20));

        bst10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst10.setForeground(new java.awt.Color(255, 255, 255));
        bst10.setText("0");
        jPanel1.add(bst10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 520, 60, 20));

        bst8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst8.setForeground(new java.awt.Color(255, 255, 255));
        bst8.setText("0");
        jPanel1.add(bst8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 420, 60, 20));

        bst7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst7.setForeground(new java.awt.Color(255, 255, 255));
        bst7.setText("0");
        jPanel1.add(bst7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 370, 60, 20));

        bst9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst9.setForeground(new java.awt.Color(255, 255, 255));
        bst9.setText("0");
        jPanel1.add(bst9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 470, 60, 20));

        bst11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst11.setForeground(new java.awt.Color(255, 255, 255));
        bst11.setText("0");
        jPanel1.add(bst11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 70, 50, 20));

        bst12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst12.setForeground(new java.awt.Color(255, 255, 255));
        bst12.setText("0");
        jPanel1.add(bst12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 120, 50, 20));

        bst13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst13.setForeground(new java.awt.Color(255, 255, 255));
        bst13.setText("0");
        jPanel1.add(bst13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 170, 50, 20));

        bst14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst14.setForeground(new java.awt.Color(255, 255, 255));
        bst14.setText("0");
        jPanel1.add(bst14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 220, 50, 20));

        bst15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst15.setForeground(new java.awt.Color(255, 255, 255));
        bst15.setText("0");
        jPanel1.add(bst15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 270, 50, 20));

        bst16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst16.setForeground(new java.awt.Color(255, 255, 255));
        bst16.setText("0");
        jPanel1.add(bst16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 320, 50, 20));

        bst17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst17.setForeground(new java.awt.Color(255, 255, 255));
        bst17.setText("0");
        jPanel1.add(bst17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 370, 50, 20));

        bst18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst18.setForeground(new java.awt.Color(255, 255, 255));
        bst18.setText("0");
        jPanel1.add(bst18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 420, 50, 20));

        bst19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst19.setForeground(new java.awt.Color(255, 255, 255));
        bst19.setText("0");
        jPanel1.add(bst19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 470, 50, 20));

        bst20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst20.setForeground(new java.awt.Color(255, 255, 255));
        bst20.setText("0");
        jPanel1.add(bst20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 520, 50, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Average Waiting Time:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 220, 40));

        avgServeLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        avgServeLabel.setForeground(new java.awt.Color(255, 255, 255));
        avgServeLabel.setText("Average Turnaround Time:");
        jPanel1.add(avgServeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 250, 40));

        selectedJob.setBackground(new java.awt.Color(102, 102, 102));
        selectedJob.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        selectedJob.setForeground(new java.awt.Color(255, 255, 255));
        selectedJob.setText("P1");
        jPanel1.add(selectedJob, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 80, 30));

        avgWaitField.setBackground(new java.awt.Color(102, 102, 102));
        avgWaitField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        avgWaitField.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(avgWaitField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 100, 30));

        avgServeField.setBackground(new java.awt.Color(102, 102, 102));
        avgServeField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        avgServeField.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(avgServeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 100, 30));

        totalExecField.setBackground(new java.awt.Color(102, 102, 102));
        totalExecField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        totalExecField.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(totalExecField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 100, 30));

        avgTurnLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        avgTurnLabel1.setForeground(new java.awt.Color(255, 255, 255));
        avgTurnLabel1.setText("Total Execution Time:");
        jPanel1.add(avgTurnLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 210, 40));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("P1:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 30, 30));

        pt2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pt2.setForeground(new java.awt.Color(255, 255, 255));
        pt2.setText("0");
        jPanel1.add(pt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 30, 30));

        pt3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pt3.setForeground(new java.awt.Color(255, 255, 255));
        pt3.setText("0");
        jPanel1.add(pt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 30, 30));

        pt4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pt4.setForeground(new java.awt.Color(255, 255, 255));
        pt4.setText("0");
        jPanel1.add(pt4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 30, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Status Bar");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 100, 30));

        pt5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pt5.setForeground(new java.awt.Color(255, 255, 255));
        pt5.setText("0");
        jPanel1.add(pt5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 30, 30));

        pt6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pt6.setForeground(new java.awt.Color(255, 255, 255));
        pt6.setText("0");
        jPanel1.add(pt6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 30, 30));

        pt7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pt7.setForeground(new java.awt.Color(255, 255, 255));
        pt7.setText("0");
        jPanel1.add(pt7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 30, 30));

        pt8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pt8.setForeground(new java.awt.Color(255, 255, 255));
        pt8.setText("0");
        jPanel1.add(pt8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 30, 30));

        pt9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pt9.setForeground(new java.awt.Color(255, 255, 255));
        pt9.setText("0");
        jPanel1.add(pt9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 470, 30, 30));

        pt10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pt10.setForeground(new java.awt.Color(255, 255, 255));
        pt10.setText("0");
        jPanel1.add(pt10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 520, 30, 30));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 620));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Remaining BT");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 20, 100, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Brust Time");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, 80, 30));

        bst21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst21.setForeground(new java.awt.Color(255, 255, 255));
        bst21.setText("0");
        jPanel1.add(bst21, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 70, 60, 20));

        bst22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst22.setForeground(new java.awt.Color(255, 255, 255));
        bst22.setText("0");
        jPanel1.add(bst22, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 120, 60, 20));

        bst23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst23.setForeground(new java.awt.Color(255, 255, 255));
        bst23.setText("0");
        jPanel1.add(bst23, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 170, 60, 20));

        bst24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst24.setForeground(new java.awt.Color(255, 255, 255));
        bst24.setText("0");
        jPanel1.add(bst24, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 220, 60, 20));

        bst25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst25.setForeground(new java.awt.Color(255, 255, 255));
        bst25.setText("0");
        jPanel1.add(bst25, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 270, 60, 20));

        bst26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst26.setForeground(new java.awt.Color(255, 255, 255));
        bst26.setText("0");
        jPanel1.add(bst26, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 320, 60, 20));

        bst27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst27.setForeground(new java.awt.Color(255, 255, 255));
        bst27.setText("0");
        jPanel1.add(bst27, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 370, 60, 20));

        bst28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst28.setForeground(new java.awt.Color(255, 255, 255));
        bst28.setText("0");
        jPanel1.add(bst28, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 420, 60, 20));

        bst29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst29.setForeground(new java.awt.Color(255, 255, 255));
        bst29.setText("0");
        jPanel1.add(bst29, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 470, 60, 20));

        bst30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst30.setForeground(new java.awt.Color(255, 255, 255));
        bst30.setText("0");
        jPanel1.add(bst30, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 520, 60, 20));

        bst31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst31.setForeground(new java.awt.Color(255, 255, 255));
        bst31.setText("0");
        jPanel1.add(bst31, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 70, 60, 20));

        bst32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst32.setForeground(new java.awt.Color(255, 255, 255));
        bst32.setText("0");
        jPanel1.add(bst32, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 120, 60, 20));

        bst33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst33.setForeground(new java.awt.Color(255, 255, 255));
        bst33.setText("0");
        jPanel1.add(bst33, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 170, 60, 20));

        bst34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst34.setForeground(new java.awt.Color(255, 255, 255));
        bst34.setText("0");
        jPanel1.add(bst34, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 220, 60, 20));

        bst35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst35.setForeground(new java.awt.Color(255, 255, 255));
        bst35.setText("0");
        jPanel1.add(bst35, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 270, 60, 20));

        bst36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst36.setForeground(new java.awt.Color(255, 255, 255));
        bst36.setText("0");
        jPanel1.add(bst36, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 320, 60, 20));

        bst37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst37.setForeground(new java.awt.Color(255, 255, 255));
        bst37.setText("0");
        jPanel1.add(bst37, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 370, 60, 20));

        bst38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst38.setForeground(new java.awt.Color(255, 255, 255));
        bst38.setText("0");
        jPanel1.add(bst38, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 420, 60, 20));

        bst39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst39.setForeground(new java.awt.Color(255, 255, 255));
        bst39.setText("0");
        jPanel1.add(bst39, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 470, 60, 20));

        bst40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst40.setForeground(new java.awt.Color(255, 255, 255));
        bst40.setText("0");
        jPanel1.add(bst40, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 520, 60, 20));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("TAT");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 20, 30, 30));

        bst41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst41.setForeground(new java.awt.Color(255, 255, 255));
        bst41.setText("0");
        jPanel1.add(bst41, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 70, 50, 20));

        bst42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst42.setForeground(new java.awt.Color(255, 255, 255));
        bst42.setText("0");
        jPanel1.add(bst42, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 120, 50, 20));

        bst43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst43.setForeground(new java.awt.Color(255, 255, 255));
        bst43.setText("0");
        jPanel1.add(bst43, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 170, 50, 20));

        bst44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst44.setForeground(new java.awt.Color(255, 255, 255));
        bst44.setText("0");
        jPanel1.add(bst44, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 220, 50, 20));

        bst45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst45.setForeground(new java.awt.Color(255, 255, 255));
        bst45.setText("0");
        jPanel1.add(bst45, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 270, 50, 20));

        bst46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst46.setForeground(new java.awt.Color(255, 255, 255));
        bst46.setText("0");
        jPanel1.add(bst46, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 320, 50, 20));

        bst47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst47.setForeground(new java.awt.Color(255, 255, 255));
        bst47.setText("0");
        jPanel1.add(bst47, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 370, 50, 20));

        bst48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst48.setForeground(new java.awt.Color(255, 255, 255));
        bst48.setText("0");
        jPanel1.add(bst48, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 420, 50, 20));

        bst49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst49.setForeground(new java.awt.Color(255, 255, 255));
        bst49.setText("0");
        jPanel1.add(bst49, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 470, 50, 20));

        bst50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bst50.setForeground(new java.awt.Color(255, 255, 255));
        bst50.setText("0");
        jPanel1.add(bst50, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 520, 50, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ResultPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResultPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResultPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResultPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel algoSelected2;
    public static javax.swing.JTextField avgServeField;
    private javax.swing.JLabel avgServeLabel;
    private javax.swing.JLabel avgTurnLabel1;
    public static javax.swing.JTextField avgWaitField;
    private javax.swing.JLabel bst1;
    private javax.swing.JLabel bst10;
    private javax.swing.JLabel bst11;
    private javax.swing.JLabel bst12;
    private javax.swing.JLabel bst13;
    private javax.swing.JLabel bst14;
    private javax.swing.JLabel bst15;
    private javax.swing.JLabel bst16;
    private javax.swing.JLabel bst17;
    private javax.swing.JLabel bst18;
    private javax.swing.JLabel bst19;
    private javax.swing.JLabel bst2;
    private javax.swing.JLabel bst20;
    private javax.swing.JLabel bst21;
    private javax.swing.JLabel bst22;
    private javax.swing.JLabel bst23;
    private javax.swing.JLabel bst24;
    private javax.swing.JLabel bst25;
    private javax.swing.JLabel bst26;
    private javax.swing.JLabel bst27;
    private javax.swing.JLabel bst28;
    private javax.swing.JLabel bst29;
    private javax.swing.JLabel bst3;
    private javax.swing.JLabel bst30;
    private javax.swing.JLabel bst31;
    private javax.swing.JLabel bst32;
    private javax.swing.JLabel bst33;
    private javax.swing.JLabel bst34;
    private javax.swing.JLabel bst35;
    private javax.swing.JLabel bst36;
    private javax.swing.JLabel bst37;
    private javax.swing.JLabel bst38;
    private javax.swing.JLabel bst39;
    private javax.swing.JLabel bst4;
    private javax.swing.JLabel bst40;
    private javax.swing.JLabel bst41;
    private javax.swing.JLabel bst42;
    private javax.swing.JLabel bst43;
    private javax.swing.JLabel bst44;
    private javax.swing.JLabel bst45;
    private javax.swing.JLabel bst46;
    private javax.swing.JLabel bst47;
    private javax.swing.JLabel bst48;
    private javax.swing.JLabel bst49;
    private javax.swing.JLabel bst5;
    private javax.swing.JLabel bst50;
    private javax.swing.JLabel bst6;
    private javax.swing.JLabel bst7;
    private javax.swing.JLabel bst8;
    private javax.swing.JLabel bst9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar10;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JProgressBar jProgressBar4;
    private javax.swing.JProgressBar jProgressBar5;
    private javax.swing.JProgressBar jProgressBar6;
    private javax.swing.JProgressBar jProgressBar7;
    private javax.swing.JProgressBar jProgressBar8;
    private javax.swing.JProgressBar jProgressBar9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel pt1;
    private javax.swing.JLabel pt10;
    private javax.swing.JLabel pt2;
    private javax.swing.JLabel pt3;
    private javax.swing.JLabel pt4;
    private javax.swing.JLabel pt5;
    private javax.swing.JLabel pt6;
    private javax.swing.JLabel pt7;
    private javax.swing.JLabel pt8;
    private javax.swing.JLabel pt9;
    private javax.swing.JTextField selectedAlgo;
    private javax.swing.JTextField selectedJob;
    public static javax.swing.JTextField totalExecField;
    // End of variables declaration//GEN-END:variables
}
