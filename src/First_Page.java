
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class First_Page extends javax.swing.JFrame {

    private Clip clip;
    Timer timer;
    int yVelocity = 1;
    int xVelosity = 1;
    int x = 0;
    int y = 0;
    
   
   
    public First_Page(final Clip sharedClip) {
        this.clip = sharedClip;
        initComponents();
        
        
        // Create a button to control audio from another frame
      
        option_button.addActionListener(e -> {
           
           First_Page.this.setVisible(false);  // Hide the current frame
            OPTION_Page controlFrame = new OPTION_Page(clip);
            controlFrame.setVisible(true);
        });
        
        this.setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);    
        
        
    }
   // public void bird(){
   //     timer = new Timer(1000, (ActionListener) jl);
    //    timer.start();
   // }
    //public void paint(Graphics g){
   //     Graphics2D g2D = (Graphics2D) g;
   //    // g2D.drawImage(jl, x, y, null);
   // }
   // public void actionPerformed(ActionEvent e){
        
     //   x = x + xVelosity;
  //      repaint();
  //  }
    
    

    // Method to stop the audio
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b0 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ai = new javax.swing.JButton();
        tp = new javax.swing.JButton();
        option_button = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b0.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        b0.setForeground(new java.awt.Color(153, 0, 0));
        b0.setText("X");
        b0.setBorderPainted(false);
        b0.setContentAreaFilled(false);
        b0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b0.setFocusPainted(false);
        b0.setFocusable(false);
        b0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b0ActionPerformed(evt);
            }
        });
        getContentPane().add(b0, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("GAME");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 98, -1, 20));

        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TIC");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 230, 60));

        ai.setBackground(new java.awt.Color(153, 153, 0));
        ai.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        ai.setForeground(new java.awt.Color(153, 0, 0));
        ai.setText("V.S AI");
        ai.setFocusable(false);
        ai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aiActionPerformed(evt);
            }
        });
        getContentPane().add(ai, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 100, 30));

        tp.setBackground(new java.awt.Color(153, 153, 0));
        tp.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        tp.setForeground(new java.awt.Color(153, 0, 0));
        tp.setText("2 PLAYER");
        tp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tp.setFocusPainted(false);
        tp.setFocusable(false);
        tp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpActionPerformed(evt);
            }
        });
        getContentPane().add(tp, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 100, 30));

        option_button.setBackground(new java.awt.Color(153, 153, 0));
        option_button.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        option_button.setForeground(new java.awt.Color(153, 0, 0));
        option_button.setText("OPTION");
        option_button.setAutoscrolls(true);
        option_button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        option_button.setBorderPainted(false);
        option_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        option_button.setFocusable(false);
        option_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(option_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 100, 30));

        jLabel3.setFont(new java.awt.Font("Bell MT", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("TOE");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 120, 40));

        jLabel4.setFont(new java.awt.Font("Bell MT", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("TAC");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 110, 60));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Bell MT", 1, 300)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("X");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 260, 260));

        jLabel6.setFont(new java.awt.Font("Bell MT", 1, 300)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setText("O");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 240, 230));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 
    //for PLAY button :>
    private void tpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpActionPerformed
        tp.setFocusable(false);
        
        
        
         String filepath="C:\\Users\\admin\\Documents\\jas.wav";
        try {
            AudioInputStream aui = AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile());
            
            try{
            
                Clip clip = AudioSystem.getClip();
                clip.open(aui);
                clip.start();
               
            
            }catch(Exception e){{
                
                
            }}
            
            
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(First_Page.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(First_Page.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
         new twoplayer_c().setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_tpActionPerformed

    //for the OPTION button :>
    private void option_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option_buttonActionPerformed
        option_button.setFocusable(false);
        String filepath="C:\\Users\\admin\\Documents\\jas.wav";
        try {
            AudioInputStream aui = AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile());
            
            try{
            
                Clip clip = AudioSystem.getClip();
                clip.open(aui);
                clip.start();
               
            
            }catch(Exception e){{
                
                
            }}
            
            
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(First_Page.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(First_Page.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    }//GEN-LAST:event_option_buttonActionPerformed

    private void aiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aiActionPerformed
        ai.setFocusable(false);
        String filepath="C:\\Users\\admin\\Documents\\jas.wav";
        try {
            AudioInputStream aui = AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile());
            
            try{
            
                Clip clip = AudioSystem.getClip();
                clip.open(aui);
                clip.start();
               
            
            }catch(Exception e){{
                
                
            }}
            
            
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(First_Page.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(First_Page.class.getName()).log(Level.SEVERE, null, ex);
        }
        //VS_Ai m= new  VS_Ai();
      // m.setVisible(true);
       
     new TicTacToe(GameMode.PLAYER_VS_AI).setVisible(true);
        this.dispose();
      // this.dispose();
    }//GEN-LAST:event_aiActionPerformed

    private void b0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b0ActionPerformed
        b0.setFocusable(false); 
        String filepath="C:\\Users\\admin\\Documents\\jas.wav";
        try {
            AudioInputStream aui = AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile());
            
            try{
            
                Clip clip = AudioSystem.getClip();
                clip.open(aui);
                clip.start();
               
            
            }catch(Exception e){{
                
                
            }}
            
            
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(First_Page.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(First_Page.class.getName()).log(Level.SEVERE, null, ex);
        }
        int response = JOptionPane.showConfirmDialog(null, 
                "Do you want to Quit?", 
                "Exit", 
                JOptionPane.YES_NO_OPTION);
         if (response == JOptionPane.YES_OPTION) {
             System.exit(0); 
        } else if (response == JOptionPane.NO_OPTION) {
              
       First_Page mainFrame = new First_Page(clip);  // Pass the same clip object
                mainFrame.setVisible(true);
        } else {
              
       First_Page mainFrame = new First_Page(clip);  // Pass the same clip object
                mainFrame.setVisible(true);
        }
      
        
    }//GEN-LAST:event_b0ActionPerformed


    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              
                final Clip sharedClip;
        try {
            // Load audio file
            File audioFile = new File("C:\\Users\\admin\\Downloads\\jas.wav");  // Replace with your file path
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            sharedClip = AudioSystem.getClip();
            sharedClip.open(audioStream);
        } catch (Exception e) {
            e.printStackTrace();
            return;  // Exit if audio loading fails
        }

        // Create and show the MainFrame with the shared clip
       SwingUtilities.invokeLater(() -> {
            new First_Page(sharedClip).setVisible(true);

            // Only start the audio if it's not already running
            if (!sharedClip.isRunning()) {
                sharedClip.start();  // Start audio automatically when MainFrame is shown
            }
        });
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ai;
    private javax.swing.JButton b0;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton option_button;
    private javax.swing.JButton tp;
    // End of variables declaration//GEN-END:variables
}
;
