
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

public class OPTION_Page extends javax.swing.JFrame {

     private Clip clip;
     

    public OPTION_Page(Clip sharedClip) {
        initComponents();
        this.clip = sharedClip;
        
     
        
        this.setResizable(false);
        
        ////not to close the first page if the user close the play_page
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        back_button = new javax.swing.JButton();
        on = new javax.swing.JButton();
        off = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(102, 102, 0));
        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BACKGROUND SOUND");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 0), null));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        back_button.setBackground(new java.awt.Color(153, 153, 0));
        back_button.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        back_button.setForeground(new java.awt.Color(153, 0, 0));
        back_button.setText("X");
        back_button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        back_button.setBorderPainted(false);
        back_button.setContentAreaFilled(false);
        back_button.setFocusable(false);
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(back_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 50, 20));

        on.setBackground(new java.awt.Color(153, 153, 0));
        on.setFont(new java.awt.Font("Bell MT", 1, 12)); // NOI18N
        on.setForeground(new java.awt.Color(153, 0, 0));
        on.setText("ON");
        on.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        on.setFocusable(false);
        on.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onActionPerformed(evt);
            }
        });
        getContentPane().add(on, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 40, -1));

        off.setBackground(new java.awt.Color(153, 153, 0));
        off.setFont(new java.awt.Font("Bell MT", 1, 12)); // NOI18N
        off.setForeground(new java.awt.Color(153, 0, 0));
        off.setText("OFF");
        off.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        off.setFocusable(false);
        off.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                offActionPerformed(evt);
            }
        });
        getContentPane().add(off, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 40, -1));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jLabel3.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText(" OPTION");
        jPanel2.add(jLabel3);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 80));

        jButton3.setBackground(new java.awt.Color(153, 153, 0));
        jButton3.setFont(new java.awt.Font("Bell MT", 1, 10)); // NOI18N
        jButton3.setForeground(new java.awt.Color(153, 0, 0));
        jButton3.setText("ABOUT");
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 270, -1, 20));

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));
        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 300, 230));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed
        back_button.setFocusable(false); 
        OPTION_Page.this.setVisible(false);
               First_Page mainFrame = new First_Page(clip);  // Pass the same clip object
                mainFrame.setVisible(true);
                
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
                this.setVisible(false);
    }                                             

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
      //  GameServer gs = new GameServer();
      //  gs.setVisible(true);
    }                                        

    private void aiActionPerformed(java.awt.event.ActionEvent evt) {                                   
        setFocusable(false);
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
        
    }//GEN-LAST:event_back_buttonActionPerformed

    private void onActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onActionPerformed
        on.setFocusable(false);
        if (!clip.isRunning()) {
                    clip.start();  // Start the audio if it's not already playing
                }

        
    }//GEN-LAST:event_onActionPerformed

    private void offActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_offActionPerformed
        off.setFocusable(false);
        clip.stop();
        clip.setFramePosition(0);
    }//GEN-LAST:event_offActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        TicTacToeInstructions tp = new TicTacToeInstructions();
        tp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed


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
            java.util.logging.Logger.getLogger(OPTION_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OPTION_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OPTION_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OPTION_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_button;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton off;
    private javax.swing.JButton on;
    // End of variables declaration//GEN-END:variables
}
