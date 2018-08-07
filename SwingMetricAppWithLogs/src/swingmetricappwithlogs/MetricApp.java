
package swingmetricappwithlogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.text.DefaultCaret;

public class MetricApp extends javax.swing.JFrame {

    File drive;
    long uptime;
    MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
    ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
    RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();

    ActionListener actionListener;
      
    public MetricApp() throws InterruptedException, FileNotFoundException, UnsupportedEncodingException {
        initComponents();
        showInfo();
        refreshEachSecond();
        createLogAtEndOfDay();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setText("Disk Usage:");

        jLabel2.setText("Total space:");

        jLabel3.setText("Free space:");

        jLabel4.setText("Usable space:");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel5.setText("Memory usage: ");

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel6.setText("CPU Usage: ");

        jLabel7.setText("Initial memory:");

        jLabel8.setText("Used heap memory:");

        jLabel9.setText("Max heap memory:");

        jLabel10.setText("Commited memory:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setAutoscrolls(false);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel14.setText("Uptime: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13)
                                .addComponent(jLabel12)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addContainerGap(167, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addGap(89, 89, 89)))
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel14)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showInfo() {
                  
        DefaultCaret caret = (DefaultCaret)jTextArea1.getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
        
        File[] rootDrive = File.listRoots();
            for(File drive : rootDrive) {
            jComboBox1.addItem(drive.toString());
        }
        actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
                    
                StringBuilder text = new StringBuilder();
    
                    for(Long threadID : threadMXBean.getAllThreadIds()) {
                ThreadInfo info = threadMXBean.getThreadInfo(threadID);  
                text.append("Thread name: " + info.getThreadName() + "\n");
                text.append("Thread State: " + info.getThreadState() + "\n");
                text.append(String.format("CPU time: %s ns", threadMXBean.getThreadCpuTime(threadID)) + "\n");
                text.append("\n");
        }
                
        jTextArea1.setText(text.toString());
        jLabel7.setText(String.format("Initial memory: %.2f GB", (double)memoryMXBean.getHeapMemoryUsage().getInit()/1073741824));
        jLabel8.setText(String.format("Used heap memory: %.2f GB", (double)memoryMXBean.getHeapMemoryUsage().getUsed()/1073741824));
        jLabel9.setText(String.format("Max heap memory: %.2f GB", (double)memoryMXBean.getHeapMemoryUsage().getUsed()/1073741824));
        jLabel10.setText(String.format("Committed memory: %.2f GB", (double)memoryMXBean.getHeapMemoryUsage().getCommitted()/1073741824));
        
         drive = new File(jComboBox1.getSelectedItem().toString());
       
         jLabel2.setText(String.format("Total space: %.2f GB", (double)drive.getTotalSpace()/1073741824));
         jLabel3.setText(String.format("Free space: %.2f GB", (double)drive.getFreeSpace()/1073741824));
         jLabel4.setText(String.format("Usable space: %.2f GB", (double)drive.getUsableSpace()/1073741824));
            
         uptime = runtimeMXBean.getUptime();   
         jLabel14.setText("Uptime: " + String.valueOf(uptime/1000 + "s"));
            
            }
        };
    }

    private void createLogAtEndOfDay() throws FileNotFoundException, UnsupportedEncodingException {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
         PrintWriter writer = null;
         LocalDateTime endOfDay = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);  
        
                try {
                    writer = new PrintWriter(LocalDate.now()+"-log.txt", "UTF-8");
                    writer.println("---- LOG FILE FOR END OF DAY " + endOfDay + " ----");
                    writer.println("-- MEMORY USAGE --");
                    writer.println(String.format("Initial memory: %.2f GB", (double)memoryMXBean.getHeapMemoryUsage().getInit()/1073741824));
                    writer.println(String.format("Used heap memory: %.2f GB", (double)memoryMXBean.getHeapMemoryUsage().getUsed()/1073741824));
                    writer.println(String.format("Max heap memory: %.2f GB", (double)memoryMXBean.getHeapMemoryUsage().getUsed()/1073741824));
                    writer.println( String.format("Committed memory: %.2f GB", (double)memoryMXBean.getHeapMemoryUsage().getCommitted()/1073741824));
                    writer.println("");
                    writer.println("-- DISK USAGE --");
                    File[] rootDrive = File.listRoots();
                    for(File drive : rootDrive) {
                        writer.println(drive);
                        writer.println(String.format("Total space: %.2f GB", (double)drive.getTotalSpace()/1073741824));
                        writer.println(String.format("Free space: %.2f GB", (double)drive.getFreeSpace()/1073741824));
                        writer.println(String.format("Usable space: %.2f GB" , (double)drive.getUsableSpace()/1073741824));
                        writer.println("");
                    }
                    
                    uptime = runtimeMXBean.getUptime();   
                    writer.println("Uptime: " + String.valueOf(uptime/1000 + "s"));
                    
                    writer.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MetricApp.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(MetricApp.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    writer.close();
                }
                                               
            }
                             
       };
        
        ZoneId zoneId = ZoneId.systemDefault();
        long time = LocalDateTime.of(LocalDate.now(), LocalTime.MAX).atZone(zoneId).toEpochSecond() - System.currentTimeMillis()/1000;
        long endTime = LocalDateTime.of(LocalDate.MAX, LocalTime.MAX).atZone(zoneId).toEpochSecond();
        System.out.println(time);
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable, time, endTime, TimeUnit.SECONDS);

    }
    
    public void refreshEachSecond() throws InterruptedException {
        Timer timer = new Timer(1000, actionListener);
        timer.setRepeats(true);
        timer.start();
    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MetricApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MetricApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MetricApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MetricApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MetricApp().setVisible(true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MetricApp.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MetricApp.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(MetricApp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
          
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
