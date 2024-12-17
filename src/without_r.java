import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

public class without_r extends JFrame {
    private JButton[] buttons = new JButton[9];
    private JLabel statusLabel = new JLabel("Play Your Move", JLabel.CENTER);
    private char currentPlayer = 'X';
    private boolean gameWon = false;
    private JButton resetButton = new JButton("Reset");
    private JButton exitButton = new JButton("Back");

    private int scoreX = 0;  // Score for Player X
    private int scoreO = 0;  // Score for Player O
    private Clip clip;

    public without_r() {
        setTitle("Tic Tac Toe");
        setUndecorated(true);
        setSize(500, 500); // Adjusted to account for extra space for the exit button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        
        getContentPane().setBackground(new Color(0, 204, 204));

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3, 3, 3));
        boardPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        boardPanel.setBackground(new Color(0, 204, 204));

        Font buttonFont = new Font("SansSerif", Font.BOLD, 60);
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(buttonFont);
            buttons[i].setFocusPainted(false);
            buttons[i].setBackground(new Color(153, 153, 0));
            buttons[i].setForeground(Color.WHITE);
            buttons[i].addActionListener(new ButtonClickListener());
            boardPanel.add(buttons[i]);
        }

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BorderLayout());
        controlPanel.setBackground(new Color(0, 204, 204));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        statusLabel.setFont(new Font("Bell MT", Font.PLAIN, 20));
        statusLabel.setForeground(new Color(153, 0, 0));

        resetButton.setFont(new Font("Bell MT", Font.PLAIN, 20));
        resetButton.setBackground(new Color(153, 153, 0));
        resetButton.setForeground(new Color(153, 0, 0));
        resetButton.setFocusable(false);
        resetButton.addActionListener(e -> {
                String filepath="C:\\Users\\admin\\Documents\\jas.wav";
        try {
            AudioInputStream aui = AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile());
            
            try{
            
                Clip clip = AudioSystem.getClip();
                clip.open(aui);
                clip.start();
               
            
            }catch(Exception g){{
                
                
            }}
            
            
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(First_Page.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(First_Page.class.getName()).log(Level.SEVERE, null, ex);
        }
                resetGame();
                        });

        // Exit button setup
        exitButton.setFont(new Font("Bell MT", Font.PLAIN, 20));
        exitButton.setBackground(new Color(153, 153, 0));
        exitButton.setForeground(new Color(153, 0, 0));
        exitButton.setFocusable(false);
        exitButton.addActionListener(e -> {
            
            String filepath="C:\\Users\\admin\\Documents\\jas.wav";
        try {
            AudioInputStream aui = AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile());
            
            try{
            
                Clip clip = AudioSystem.getClip();
                clip.open(aui);
                clip.start();
               
            
            }catch(Exception d){{
                
                
            }}
            
            
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(First_Page.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(First_Page.class.getName()).log(Level.SEVERE, null, ex);
        }
                First_Page n = new First_Page(clip);
                n.setVisible(true);
                this.dispose();
                });  // Exit the application

        // Using FlowLayout to align the exit button to the left
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        bottomPanel.setBackground(new Color(0, 204, 204));
        bottomPanel.add(exitButton);
        bottomPanel.add(resetButton);

        controlPanel.add(statusLabel, BorderLayout.CENTER);
        controlPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(boardPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String filepath="C:\\Users\\admin\\Documents\\jas.wav";
        try {
            AudioInputStream aui = AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile());
            
            try{
            
                Clip clip = AudioSystem.getClip();
                clip.open(aui);
                clip.start();
               
            
            }catch(Exception c){{
                
                
            }}
            
            
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(First_Page.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(First_Page.class.getName()).log(Level.SEVERE, null, ex);
        }
            JButton buttonClicked = (JButton) e.getSource();
            if (buttonClicked.getText().equals("") && !gameWon) {
                buttonClicked.setText(String.valueOf(currentPlayer));
                buttonClicked.setForeground(currentPlayer == 'X' ? Color.CYAN : Color.PINK);
                checkForWin();
                if (!gameWon) {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    statusLabel.setText("Your Next Move");
                }
            }
        }
    }

    private void checkForWin() {
        String[][] board = new String[3][3];
        for (int i = 0; i < 9; i++) {
            board[i / 3][i % 3] = buttons[i].getText();
        }

        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (checkLine(board[i][0], board[i][1], board[i][2])) {
                highlightWinningLine(buttons[i * 3], buttons[i * 3 + 1], buttons[i * 3 + 2]);
                updateScore();
                return;
            }
            if (checkLine(board[0][i], board[1][i], board[2][i])) {
                highlightWinningLine(buttons[i], buttons[i + 3], buttons[i + 6]);
                updateScore();
                return;
            }
        }

        if (checkLine(board[0][0], board[1][1], board[2][2])) {
            highlightWinningLine(buttons[0], buttons[4], buttons[8]);
            updateScore();
        } else if (checkLine(board[0][2], board[1][1], board[2][0])) {
            highlightWinningLine(buttons[2], buttons[4], buttons[6]);
            updateScore();
        } else if (isBoardFull()) {
            gameWon = true;
            statusLabel.setText("Draw");
        }
    }

    private boolean checkLine(String s1, String s2, String s3) {
        return !s1.equals("") && s1.equals(s2) && s2.equals(s3);
    }

    private void highlightWinningLine(JButton b1, JButton b2, JButton b3) {
        b1.setBackground(new Color(50, 205, 50));
        b2.setBackground(new Color(50, 205, 50));
        b3.setBackground(new Color(50, 205, 50));
        gameWon = true;
        if (currentPlayer == 'X') {
            statusLabel.setText("X wins");
        } else {
            statusLabel.setText("O wins");
        }
    }

    private void updateScore() {
        if (currentPlayer == 'X') {
            scoreX++;
        } else {
            scoreO++;
        }
        // Update the status label to show current scores
        statusLabel.setText("X: " + scoreX + " | O: " + scoreO);
    }

    private void resetGame() {
        currentPlayer = 'X';
        gameWon = false;
        statusLabel.setText("Your Game Is now Reset");
        for (JButton button : buttons) {
            button.setText("");
            button.setBackground(new Color(153,153,0));
            button.setForeground(Color.WHITE);
        }
    }

    private boolean isBoardFull() {
        for (JButton button : buttons) {
            if (button.getText().equals("")) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Automatically start the TicTacToe game in Player vs Player mode with no initial moves
        SwingUtilities.invokeLater(() -> {
            new without_r().setVisible(true);
        });
    }
}
