
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;


public class PLAY_Page extends javax.swing.JFrame {
    
    
    
    private Clip clip;
    int turn = 2;
    int buttonused[]={0,0,0,0,0,0,0,0,0}; 
    private int[] pXwon = new int[9]; // Tracks positions occupied by player X
    private int[] pOwon = new int[9]; // Tracks positions occupied by player O
    private int xcount=0;
    private int ocount=0;  
    private static char currentPlayer = 'X';  // Current player
    private int currentRiddleIndex;  // Store the index of the current riddle
    private Timer timer;
    private int timeLeft = 31;

    private boolean[] riddlesAsked = new boolean[riddle.length];
       
    private static final String[] riddle = {
        "What has keys but can't open locks?",  
        "What has many feet but can't walk?",
        "I am tall when I am young, and I am short when I am old. What am I?",
        "What has teeth but can't bite?",
        "What has a face but no eyes, hands but no fingers, and tells time?",
        "I can be cracked, made, told, and played. What am I?",
        "What gets wetter the more it dries?",
        "What is always in front of you but can’t be seen?",
        "What can travel around the world while staying in the corner?",
        "The More You Take, The More You Leave Behind",
        "The More You Have of Me, The Less You See. What am I?",
        "What Has a Head, a Tail, But No Body?",
        "What has a neck but no head?",
        "What is full of holes but still holds a lot of weight?",
        "What is so fragile that saying its name breaks it?"
    };
     private static final String[] answers = {
        "keyboard", "footsteps", "candle", "comb", "clock", "joke", 
        "towel", "future", "stamp", "footsteps", "darkness", "coin",
        "bottle", "net", "silence"
    };
    
     private void initializeTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                    jl9.setText("" + timeLeft);
                    jl9.setFont(new Font("Bell MT", Font.BOLD, 30));       
                    jl9.setForeground(new Color (153,0,0));
     
                 System.out.println("Timer triggered: " + timeLeft); // Debug message


                if (timeLeft <= 0) {
                    timer.stop();  // Stop the timer when time runs out
                    JOptionPane.showMessageDialog(null, "Time's up! Switching turn.");
                    switchPlayer();  // Switch the turn if time runs out
                    updateRiddle();  // Update the riddle for the new player

                }
            }
        });
    }
     
     private void timer(){
         initializeTimer();
     
     }
     private void color(){
         
        b0.setForeground(currentPlayer == 'X' ? Color.CYAN : Color.PINK);
        setBackground(new Color(153,153,0));
     }
    
    // Get the riddle for the current player
    private String getRiddle() {
        return riddle[currentRiddleIndex];
    }
    
    private void updateRiddle() {
        setRandomRiddleIndex();
        rf.setText(getRiddle());
        af.setText("");  // Clear previous answer
        //timer.start();
    }
    
     private int getCurrentRiddleIndex() {
        return (currentPlayer == 'X') ? 0 : 1; // Alternate the riddles (this is just an example)
    }
     
    private boolean isRiddleCorrect(String answer) {
    // Normalize both the input and the correct answer
    String normalizedAnswer = answer.trim().toLowerCase();  // Normalize user input
    String correctAnswer = answers[currentRiddleIndex].toLowerCase();  // Normalize correct answer

    return normalizedAnswer.equals(correctAnswer);
}


   
 
     private void resetGame() {
        currentPlayer = 'X';
        jl.setText("Current Player: " + currentPlayer);
        updateRiddle();  // Show a new riddle
        
        b0.setEnabled(true);
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        
        
        turn=2;
        for(int i=0;i<9;i++){
            buttonused[i]=0;
        }
        for(int i=0;i<9;i++){
            pXwon[i]=0;
        }
        for(int i=0;i<9;i++){
            pOwon[i]=0;
        }
       
    }
     
     
    private void switchPlayer() {
    System.out.println("Switching player...");
    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';  // Switch player
    jl.setText("Current Player: " + currentPlayer);  // Update the label
    
     timeLeft = 30;  // Reset the timer for the next player
        jLabel1.setText("Time left: " + timeLeft + "s");
        timer.start();
    
    
}
     
     
     
     // Get a random riddle index for the current player that has not been asked yet
    private void setRandomRiddleIndex() {
        Random rand = new Random();
        do {
            currentRiddleIndex = rand.nextInt(riddle.length);  // Randomize the index
        } while (riddlesAsked[currentRiddleIndex]);  // Ensure we pick an unanswered riddle
        riddlesAsked[currentRiddleIndex] = true;  // Mark this riddle as asked
        
        System.out.println("Selected Riddle: " + riddle[currentRiddleIndex]); 
    }
    
    
    private boolean pXwon() {
    // Horizontal
    if (pXwon[0] == 1 && pXwon[1] == 1 && pXwon[2] == 1) return true;
    if (pXwon[3] == 1 && pXwon[4] == 1 && pXwon[5] == 1) return true;
    if (pXwon[6] == 1 && pXwon[7] == 1 && pXwon[8] == 1) return true;
    // Vertical
    if (pXwon[0] == 1 && pXwon[3] == 1 && pXwon[6] == 1) return true;
    if (pXwon[1] == 1 && pXwon[4] == 1 && pXwon[7] == 1) return true;
    if (pXwon[2] == 1 && pXwon[5] == 1 && pXwon[8] == 1) return true;
    // Diagonal
    if (pXwon[0] == 1 && pXwon[4] == 1 && pXwon[8] == 1) return true;
    if (pXwon[2] == 1 && pXwon[4] == 1 && pXwon[6] == 1) return true;
    return false;
}
    
    private boolean pOwon() {
    // Check horizontal, vertical, and diagonal conditions for Player O
    if (pOwon[0] == 1 && pOwon[1] == 1 && pOwon[2] == 1) return true;
    if (pOwon[3] == 1 && pOwon[4] == 1 && pOwon[5] == 1) return true;
    if (pOwon[6] == 1 && pOwon[7] == 1 && pOwon[8] == 1) return true;
    if (pOwon[0] == 1 && pOwon[3] == 1 && pOwon[6] == 1) return true;
    if (pOwon[1] == 1 && pOwon[4] == 1 && pOwon[7] == 1) return true;
    if (pOwon[2] == 1 && pOwon[5] == 1 && pOwon[8] == 1) return true;
    if (pOwon[0] == 1 && pOwon[4] == 1 && pOwon[8] == 1) return true;
    if (pOwon[2] == 1 && pOwon[4] == 1 && pOwon[6] == 1) return true;
    return false;
}
    
    private boolean isDraw() {
    // If all spaces are filled and no player has won
    for (int i = 0; i < 9; i++) {
        if (pXwon[i] == 0 && pOwon[i] == 0) 
             
            return false;
    }
    
    return true; // All spaces filled and no winner
}
    
    public void gamescore(){
        
        jl4.setText(String.valueOf("Player X: " + xcount));
        jl5.setText(String.valueOf("Player O: " + ocount));
        jl4.setForeground(new Color(153,0,0));
        jl5.setForeground(new Color(153,0,0));
    }
    
    
    public PLAY_Page() {
        initComponents();
        timer();
        this.setBackground(new Color(0,204,204));
        
        this.setResizable(false);
        rl.setText("Answer the riddle to make your move: ");
       
        jl.setText("Current Player: " + currentPlayer);
        
        
        updateRiddle();
        initializeTimer();
        timer.start();
        
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 90, 100));  // Adjust coordinates if needed

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b3 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        b0 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        play_again = new javax.swing.JButton();
        back_button = new javax.swing.JButton();
        cp = new javax.swing.JPanel();
        jl = new javax.swing.JLabel();
        jl4 = new javax.swing.JLabel();
        jl5 = new javax.swing.JLabel();
        rl = new javax.swing.JLabel();
        af = new javax.swing.JTextField();
        sb = new javax.swing.JButton();
        rf = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jl9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TIC-TAC-TOE");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(0, 204, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b3.setBackground(new java.awt.Color(153, 153, 0));
        b3.setFont(new java.awt.Font("Calisto MT", 0, 50)); // NOI18N
        b3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });
        getContentPane().add(b3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 84, 77));

        b2.setBackground(new java.awt.Color(153, 153, 0));
        b2.setFont(new java.awt.Font("Calisto MT", 0, 50)); // NOI18N
        b2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });
        getContentPane().add(b2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 84, 77));

        b1.setBackground(new java.awt.Color(153, 153, 0));
        b1.setFont(new java.awt.Font("Calisto MT", 0, 50)); // NOI18N
        b1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        getContentPane().add(b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 84, 77));

        b0.setBackground(new java.awt.Color(153, 153, 0));
        b0.setFont(new java.awt.Font("Calisto MT", 0, 50)); // NOI18N
        b0.setForeground(new java.awt.Color(153, 153, 0));
        b0.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b0.setFocusable(false);
        b0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b0ActionPerformed(evt);
            }
        });
        getContentPane().add(b0, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 84, 77));

        b4.setBackground(new java.awt.Color(153, 153, 0));
        b4.setFont(new java.awt.Font("Calisto MT", 0, 50)); // NOI18N
        b4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });
        getContentPane().add(b4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 84, 77));

        b8.setBackground(new java.awt.Color(153, 153, 0));
        b8.setFont(new java.awt.Font("Calisto MT", 0, 50)); // NOI18N
        b8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b8ActionPerformed(evt);
            }
        });
        getContentPane().add(b8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 84, 77));

        b7.setBackground(new java.awt.Color(153, 153, 0));
        b7.setFont(new java.awt.Font("Calisto MT", 0, 50)); // NOI18N
        b7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b7ActionPerformed(evt);
            }
        });
        getContentPane().add(b7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 84, 77));

        b6.setBackground(new java.awt.Color(153, 153, 0));
        b6.setFont(new java.awt.Font("Calisto MT", 0, 50)); // NOI18N
        b6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6ActionPerformed(evt);
            }
        });
        getContentPane().add(b6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 84, 77));

        b5.setBackground(new java.awt.Color(153, 153, 0));
        b5.setFont(new java.awt.Font("Calisto MT", 0, 50)); // NOI18N
        b5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });
        getContentPane().add(b5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 84, 77));

        play_again.setBackground(new java.awt.Color(153, 153, 0));
        play_again.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        play_again.setForeground(new java.awt.Color(153, 0, 0));
        play_again.setText("RESET");
        play_again.setToolTipText("");
        play_again.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.lightGray, java.awt.Color.lightGray));
        play_again.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        play_again.setFocusable(false);
        play_again.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                play_againActionPerformed(evt);
            }
        });
        getContentPane().add(play_again, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, 80, 40));

        back_button.setBackground(new java.awt.Color(0, 204, 204));
        back_button.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        back_button.setForeground(new java.awt.Color(153, 0, 0));
        back_button.setText("X");
        back_button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        back_button.setBorderPainted(false);
        back_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back_button.setFocusPainted(false);
        back_button.setFocusable(false);
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(back_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 40, 40));

        cp.setBackground(new java.awt.Color(0, 204, 204));
        cp.setForeground(new java.awt.Color(102, 0, 0));

        jl.setBackground(new java.awt.Color(153, 153, 0));
        jl.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        jl.setForeground(new java.awt.Color(153, 0, 0));
        jl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl.setText("PLAY");
        cp.add(jl);

        getContentPane().add(cp, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 160, 40));

        jl4.setForeground(new java.awt.Color(102, 0, 0));
        getContentPane().add(jl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 110, 30));

        jl5.setForeground(new java.awt.Color(102, 0, 0));
        getContentPane().add(jl5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 110, 30));

        rl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rl.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(rl, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 260, 20));

        af.setBackground(new java.awt.Color(153, 153, 0));
        getContentPane().add(af, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 180, 40));

        sb.setBackground(new java.awt.Color(153, 153, 0));
        sb.setFont(new java.awt.Font("Bell MT", 1, 12)); // NOI18N
        sb.setForeground(new java.awt.Color(153, 0, 0));
        sb.setText("SUBMIT");
        sb.setFocusable(false);
        sb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sbActionPerformed(evt);
            }
        });
        getContentPane().add(sb, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, -1, 40));

        rf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rf.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(rf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 440, 40));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 120, 50));

        jl9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jl9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jl9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 200, 70));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    //the variable we named for this is "b0", but we call this line "for the button 1"
    private void b0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b0ActionPerformed
       
        b0.setFocusable(false);
        timer .start();
       

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
        if( pXwon[0] == 0 && pOwon[0] == 0) {
            color();
        if (isRiddleCorrect(af.getText().trim())) {
        if (currentPlayer == 'X' && pXwon[0] == 0 && pOwon[0] == 0) {
            b0.setText("X");
            
            pXwon[0] = 1;  // Set X in the array
            
        } else if (currentPlayer == 'O' && pOwon[0] == 0 && pXwon[0] == 0) {
            b0.setText("O");
             
            pOwon[0] = 1;  // Set O in the array
            
        }

        // Check if Player X has won
        if (pXwon()) {
            b0.setText("");
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            xcount++; gamescore();
            
            b0.setEnabled(true);
     
            JOptionPane.showMessageDialog(null, "Player X wins!");

            resetGame();
        } 
        // Check if Player O has won
        else if (pOwon()) {
             b0.setText("");
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            ocount++; gamescore();
            b0.setEnabled(true);
            
            JOptionPane.showMessageDialog(null, "Player O wins!");

            resetGame();
        } 
        // Check if the game is a draw
        else if (isDraw()) {
            JOptionPane.showMessageDialog(null, "It's a draw!");
            resetGame();
            b0.setEnabled(true);
        } 
        else {
            switchPlayer();
            updateRiddle();  // Update riddle after a valid move
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please answer the riddle before making a move.");
    }
      
    }//GEN-LAST:event_b0ActionPerformed
        else{
            timer.stop();
         JOptionPane.showMessageDialog(null, "Already used!.");
        }
    }


    
    //for the 2nd button 
    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        b1.setFocusable(false);
        timer.start();
        b1.setForeground(currentPlayer == 'X' ? Color.CYAN : Color.PINK);
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
         if( pXwon[1] == 0 && pOwon[1] == 0) {
        
        if (isRiddleCorrect(af.getText().trim())) {
        if (currentPlayer == 'X' && pXwon[1] == 0 && pOwon[1] == 0) {
            b1.setText("X");
            pXwon[1] = 1;  // Set X in the array
            
        } else if (currentPlayer == 'O' && pOwon[1] == 0 && pXwon[1] == 0) {
            b1.setText("O");
            pOwon[1] = 1;  // Set O in the array
           
        }

        // Check if Player X has won
        if (pXwon()) {
             b0.setText("");
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            xcount++; gamescore();
   
            b1.setEnabled(true);
            
            JOptionPane.showMessageDialog(null, "Player X wins!");

            resetGame();
        } 
        // Check if Player O has won
        else if (pOwon()) {
              b0.setText("");
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            ocount++; gamescore();
   
            b1.setEnabled(true);
            
            JOptionPane.showMessageDialog(null, "Player O wins!");

            resetGame();
        } 
        // Check if the game is a draw
        else if (isDraw()) {
            JOptionPane.showMessageDialog(null, "It's a draw!");
            resetGame();
            b1.setEnabled(true);
        } 
        else {
            switchPlayer();
            updateRiddle();  // Update riddle after a valid move
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please answer the riddle before making a move.");
    } 
         }else{
            timer.stop();
         JOptionPane.showMessageDialog(null, "Already used!.");
        }
    }//GEN-LAST:event_b1ActionPerformed

    
    //for the 3rd button 
    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        b2.setFocusable(false);
        timer.start();
        b2.setForeground(currentPlayer == 'X' ? Color.CYAN : Color.PINK);
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
        
        if( pXwon[2] == 0 && pOwon[2] == 0) {
        
        if (isRiddleCorrect(af.getText().trim())) {
        if (currentPlayer == 'X' && pXwon[2] == 0 && pOwon[2] == 0) {
            b2.setText("X");
            pXwon[2] = 1;  // Set X in the array
          
        } else if (currentPlayer == 'O' && pOwon[2] == 0 && pXwon[2] == 0) {
            b2.setText("O");
            pOwon[2] = 1;  // Set O in the array
            
        }

        // Check if Player X has won
        if (pXwon()) {
             b0.setText("");
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            xcount++; gamescore();
            
            b2.setEnabled(true);
    
            JOptionPane.showMessageDialog(null, "Player X wins!");

            resetGame();
        } 
        // Check if Player O has won
        else if (pOwon()) {
              b0.setText("");
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            ocount++; gamescore();
            
            b2.setEnabled(true);
   
            JOptionPane.showMessageDialog(null, "Player O wins!");

            resetGame();
        } 
        // Check if the game is a draw
        else if (isDraw()) {
            JOptionPane.showMessageDialog(null, "It's a draw!");
            resetGame();
            b2.setEnabled(true);
        } 
        else {
            switchPlayer();
            updateRiddle();  // Update riddle after a valid move
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please answer the riddle before making a move.");
    }}else{
            timer.stop();
         JOptionPane.showMessageDialog(null, "Already used!.");
        }
    }//GEN-LAST:event_b2ActionPerformed

    
    //for the 4th button 
    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        b3.setFocusable(false);
        timer.start();
        b3.setForeground(currentPlayer == 'X' ? Color.CYAN : Color.PINK);
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
        
        if( pXwon[3] == 0 && pOwon[3] == 0) {
        
        if (isRiddleCorrect(af.getText().trim())) {
        if (currentPlayer == 'X' && pXwon[3] == 0 && pOwon[3] == 0) {
            b3.setText("X");
            pXwon[3] = 1;  // Set X in the array
           
        } else if (currentPlayer == 'O' && pOwon[3] == 0 && pXwon[3] == 0) {
            b3.setText("O");
            pOwon[3] = 1;  // Set O in the array
            
        }

        // Check if Player X has won
        if (pXwon()) {
              b0.setText("");
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            xcount++; gamescore();
            
            b3.setEnabled(true);
     
            JOptionPane.showMessageDialog(null, "Player X wins!");

            resetGame();
        } 
        // Check if Player O has won
        else if (pOwon()) {
              b0.setText("");
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            ocount++; gamescore();
            
            b3.setEnabled(true);
        
            JOptionPane.showMessageDialog(null, "Player O wins!");

            resetGame();
        } 
        // Check if the game is a draw
        else if (isDraw()) {
            JOptionPane.showMessageDialog(null, "It's a draw!");
            resetGame();
            b3.setEnabled(true);
        } 
        else {
            switchPlayer();
            updateRiddle();  // Update riddle after a valid move
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please answer the riddle before making a move.");
    }}else{
            timer.stop();
         JOptionPane.showMessageDialog(null, "Already used!.");
        }
    }//GEN-LAST:event_b3ActionPerformed

    
    //for the 5th button 
    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        b4.setFocusable(false);
        timer.start();
        b4.setForeground(currentPlayer == 'X' ? Color.CYAN : Color.PINK);
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
        
        if( pXwon[4] == 0 && pOwon[4] == 0) {
        
        if (isRiddleCorrect(af.getText().trim())) {
        if (currentPlayer == 'X' && pXwon[4] == 0 && pOwon[4] == 0) {
            b4.setText("X");
            pXwon[4] = 1;  // Set X in the array
           
        } else if (currentPlayer == 'O' && pOwon[4] == 0 && pXwon[4] == 0) {
            b4.setText("O");
            pOwon[4] = 1;  // Set O in the array
          
        }

        // Check if Player X has won
        if (pXwon()) {
              b0.setText("");
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            xcount++; gamescore();
            
            b4.setEnabled(true);
            
            JOptionPane.showMessageDialog(null, "Player X wins!");

            resetGame();
        } 
        // Check if Player O has won
        else if (pOwon()) {
              b0.setText("");
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            ocount++; gamescore();
            
            b4.setEnabled(true);
     
            JOptionPane.showMessageDialog(null, "Player O wins!");

            resetGame();
        } 
        // Check if the game is a draw
        else if (isDraw()) {
            JOptionPane.showMessageDialog(null, "It's a draw!");
            resetGame();
            b4.setEnabled(true);
        } 
        else {
            switchPlayer();
            updateRiddle();  // Update riddle after a valid move
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please answer the riddle before making a move.");
    }}else{
            timer.stop();
         JOptionPane.showMessageDialog(null, "Already used!.");
        }
    }//GEN-LAST:event_b4ActionPerformed

    
    //for the 6th button 
    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b5ActionPerformed
        b5.setFocusable(false);
        timer.start();
        b5.setForeground(currentPlayer == 'X' ? Color.CYAN : Color.PINK);
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
        
        if( pXwon[5] == 0 && pOwon[5] == 0) {
        
        if (isRiddleCorrect(af.getText().trim())) {
        if (currentPlayer == 'X' && pXwon[5] == 0 && pOwon[5] == 0) {
            b5.setText("X");
            pXwon[5] = 1;  // Set X in the array
           
        } else if (currentPlayer == 'O' && pOwon[5] == 0 && pXwon[5] == 0) {
            b5.setText("O");
            pOwon[5] = 1;  // Set O in the array
           
        }

        // Check if Player X has won
        if (pXwon()) {
             b0.setText("");
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            xcount++; gamescore();
            
            b5.setEnabled(true);
    
            JOptionPane.showMessageDialog(null, "Player X wins!");

            resetGame();
        } 
        // Check if Player O has won
        else if (pOwon()) {
             b0.setText("");
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            ocount++; gamescore();
            
             b5.setEnabled(true);
            
            JOptionPane.showMessageDialog(null, "Player O wins!");

            resetGame();
        } 
        // Check if the game is a draw
        else if (isDraw()) {
            JOptionPane.showMessageDialog(null, "It's a draw!");
            resetGame();
             b5.setEnabled(true);
        } 
        else {
            switchPlayer();
            updateRiddle();  // Update riddle after a valid move
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please answer the riddle before making a move.");
    }}else{
            timer.stop();
         JOptionPane.showMessageDialog(null, "Already used!.");
        }
    }//GEN-LAST:event_b5ActionPerformed

    
    //for the 7th button 
    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b6ActionPerformed
        b6.setFocusable(false);
        timer.start();
        b6.setForeground(currentPlayer == 'X' ? Color.CYAN : Color.PINK);
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
        
        if( pXwon[6] == 0 && pOwon[6] == 0) {
        
        if (isRiddleCorrect(af.getText().trim())) {
        if (currentPlayer == 'X' && pXwon[6] == 0 && pOwon[6] == 0) {
            b6.setText("X");
            pXwon[6] = 1;  // Set X in the array
            
        } else if (currentPlayer == 'O' && pOwon[6] == 0 && pXwon[6] == 0) {
            b6.setText("O");
            pOwon[6] = 1;  // Set O in the array
           
        }

        // Check if Player X has won
        if (pXwon()) {
             b0.setText("");
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            xcount++; gamescore();
            
             b6.setEnabled(true);
    
            JOptionPane.showMessageDialog(null, "Player X wins!");

            resetGame();
        } 
        // Check if Player O has won
        else if (pOwon()) {
              b0.setText("");
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            ocount++; gamescore();
            
            b6.setEnabled(true);
   
            JOptionPane.showMessageDialog(null, "Player O wins!");

            resetGame();
        } 
        // Check if the game is a draw
        else if (isDraw()) {
            JOptionPane.showMessageDialog(null, "It's a draw!");
            resetGame();
            b6.setEnabled(true);
        } 
        else {
            switchPlayer();
            updateRiddle();  // Update riddle after a valid move
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please answer the riddle before making a move.");
    }}else{
            timer.stop();
         JOptionPane.showMessageDialog(null, "Already used!.");
        }
    }//GEN-LAST:event_b6ActionPerformed

    
    //for the 8th button 
    private void b7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b7ActionPerformed
        b7.setFocusable(false);
        timer.start();
        b7.setForeground(currentPlayer == 'X' ? Color.CYAN : Color.PINK);
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
        if( pXwon[7] == 0 && pOwon[7] == 0) {
        
        if (isRiddleCorrect(af.getText().trim())) {
        if (currentPlayer == 'X' && pXwon[7] == 0 && pOwon[7] == 0) {
            b7.setText("X");
            pXwon[7] = 1;  // Set X in the array
            
        } else if (currentPlayer == 'O' && pOwon[7] == 0 && pXwon[7] == 0) {
            b7.setText("O");
            pOwon[7] = 1;  // Set O in the array
            
        }

        // Check if Player X has won
        if (pXwon()) {
              b0.setText("");
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            xcount++; gamescore();
            
            b7.setEnabled(true);
            
        
            JOptionPane.showMessageDialog(null, "Player X wins!");

            resetGame();
        } 
        // Check if Player O has won
        else if (pOwon()) {
             b0.setText("");
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            ocount++; gamescore();
            
            b7.setEnabled(true);
   
            JOptionPane.showMessageDialog(null, "Player O wins!");

            resetGame();
        } 
        // Check if the game is a draw
        else if (isDraw()) {
            JOptionPane.showMessageDialog(null, "It's a draw!");
            resetGame();
            b7.setEnabled(true);
        } 
        else {
            switchPlayer();
            updateRiddle();  // Update riddle after a valid move
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please answer the riddle before making a move.");
    }}else{
            timer.stop();
         JOptionPane.showMessageDialog(null, "Already used!.");
        }
    }//GEN-LAST:event_b7ActionPerformed

    
    //for the 9th button 
    private void b8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b8ActionPerformed
        b8.setFocusable(false);
        timer.start();
        b8.setForeground(currentPlayer == 'X' ? Color.CYAN : Color.PINK);
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
        
        if( pXwon[8] == 0 && pOwon[8] == 0) {
        
        
        if (isRiddleCorrect(af.getText().trim())) {
        if (currentPlayer == 'X' && pXwon[8] == 0 && pOwon[8] == 0) {
            b8.setText("X");
            pXwon[7] = 1;  // Set X in the array
           
        } else if (currentPlayer == 'O' && pOwon[8] == 0 && pXwon[8] == 0) {
            b8.setText("O");
            pOwon[8] = 1;  // Set O in the array
           
        }

        // Check if Player X has won
        if (pXwon()) {
              b0.setText("");
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            xcount++; gamescore();
            
            
           
            JOptionPane.showMessageDialog(null, "Player X wins!");

            resetGame();
        } 
        // Check if Player O has won
        else if (pOwon()) {
             b0.setText("");
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            ocount++; gamescore();
           
            
           
            JOptionPane.showMessageDialog(null, "Player O wins!");

            resetGame();
        } 
        // Check if the game is a draw
        else if (isDraw()) {
            JOptionPane.showMessageDialog(null, "It's a draw!");
            resetGame();
           
        } 
        else {
            switchPlayer();
            updateRiddle();  // Update riddle after a valid move
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please answer the riddle before making a move.");
    }}else{
            timer.stop();
         JOptionPane.showMessageDialog(null, "Already used!.");
        }
    }//GEN-LAST:event_b8ActionPerformed

    
    //for PLAY AGAIN button
    private void play_againActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_play_againActionPerformed
        play_again.setFocusable(false);
         timeLeft = 31;
         timer.start();
         
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
        b0.setText("");
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        jl.setText("Current Player: " + currentPlayer);
        resetGame();
        
        b0.setEnabled(true);
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        
        
        turn=2;
        for(int i=0;i<9;i++){
            buttonused[i]=0;
        }
        for(int i=0;i<9;i++){
            pXwon[i]=0;
        }
        for(int i=0;i<9;i++){
            pOwon[i]=0;
        }
        
    }//GEN-LAST:event_play_againActionPerformed

    
    //for BACK button
    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed
        timer.stop();
        back_button.setFocusable(false);
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
        
       First_Page mainFrame = new First_Page(clip);  // Pass the same clip object
                mainFrame.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_back_buttonActionPerformed

    private void sbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sbActionPerformed
         String answer = af.getText().trim();
            if (answer.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter an answer!");
            } else {
                if (isRiddleCorrect(answer)) {
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Correct answer! Now make your move.");
                    
                } else {
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Incorrect answer! It's the other player's turn.");
                    switchPlayer();  // Switch player on incorrect answer
                    updateRiddle();  // Update riddle after an incorrect answer
    }//GEN-LAST:event_sbActionPerformed
   }
            isDraw();
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
            java.util.logging.Logger.getLogger(PLAY_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PLAY_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PLAY_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PLAY_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PLAY_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField af;
    private javax.swing.JButton b0;
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton b8;
    private javax.swing.JButton back_button;
    private javax.swing.JPanel cp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jl;
    private javax.swing.JLabel jl4;
    private javax.swing.JLabel jl5;
    private javax.swing.JLabel jl9;
    private javax.swing.JButton play_again;
    private javax.swing.JLabel rf;
    private javax.swing.JLabel rl;
    private javax.swing.JButton sb;
    // End of variables declaration//GEN-END:variables
}
