

import javax.swing.*;
import java.awt.*;
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

public class VS_Ai {
    public static void main(String[] args) {
        // Automatically start the TicTacToe game in Player vs AI mode with no initial moves
        SwingUtilities.invokeLater(() -> {
            new TicTacToe(GameMode.PLAYER_VS_AI).setVisible(true);
        });
    }
}

enum GameMode {
    PLAYER_VS_PLAYER,
    PLAYER_VS_AI
}

class TicTacToe extends JFrame {
    private JButton[] buttons = new JButton[9];
    private JLabel statusLabel = new JLabel("Play Your Move", JLabel.CENTER);
    private char currentPlayer = 'X';
    private boolean gameWon = false;
    private JButton resetButton = new JButton("Reset");
    private JButton exitButton = new JButton("Back");
    private GameMode gameMode;
    private Clip clip;
    
    public TicTacToe(GameMode gameMode) {
        this.gameMode = gameMode;
        setTitle("XO not Tic tac toe");
        setSize(400, 500); // Adjusted to account for extra space for the exit button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setUndecorated(true);
        getContentPane().setBackground(new Color(0,204,204));

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3));
        boardPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        boardPanel.setBackground(new Color(0,204,204));

        Font buttonFont = new Font("SansSerif", Font.BOLD, 60);
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(buttonFont);
            buttons[i].setFocusPainted(false);
            buttons[i].setBackground(new Color(153,153,0));
            buttons[i].setForeground(Color.WHITE);
            buttons[i].addActionListener(new ButtonClickListener());
            boardPanel.add(buttons[i]);
        }

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BorderLayout());
        controlPanel.setBackground(new Color(0,204,204));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        statusLabel.setFont(new Font("Bell MT", Font.PLAIN, 20));
        statusLabel.setForeground(Color.WHITE);

        resetButton.setFont(new Font("Bell MT", Font.PLAIN, 20));
        resetButton.setFocusable(false);
        resetButton.setBackground(new Color(153,153,0));
        resetButton.setForeground(new Color (153,0,0));
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
        exitButton.setFocusable(false);
        exitButton.setBackground(new Color(153,153,0));
        exitButton.setForeground(new Color (153,0,0));
        exitButton.addActionListener(e ->  {
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
                First_Page n = new First_Page(clip);
                n.setVisible(true);
                this.dispose();
                });

        // Using FlowLayout to align the exit button to the left
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        bottomPanel.setBackground(new Color(0,204,204));
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
            JButton buttonClicked = (JButton) e.getSource();
            if (buttonClicked.getText().equals("") && !gameWon) {
                buttonClicked.setText(String.valueOf(currentPlayer));
                buttonClicked.setForeground(currentPlayer == 'X' ? Color.CYAN : Color.PINK);
                checkForWin();
                if (!gameWon) {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    statusLabel.setText("Your Next Move");
                    if (gameMode == GameMode.PLAYER_VS_AI && currentPlayer == 'O') {
                        aiMove();
                    }
                }
            }
        }
    }

    private void checkForWin() {
        String[][] board = new String[3][3];
        for (int i = 0; i < 9; i++) {
            board[i / 3][i % 3] = buttons[i].getText();
        }

        for (int i = 0; i < 3; i++) {
            if (checkLine(board[i][0], board[i][1], board[i][2])) {
                highlightWinningLine(buttons[i * 3], buttons[i * 3 + 1], buttons[i * 3 + 2]);
                return;
            }
            if (checkLine(board[0][i], board[1][i], board[2][i])) {
                highlightWinningLine(buttons[i], buttons[i + 3], buttons[i + 6]);
                return;
            }
        }

        if (checkLine(board[0][0], board[1][1], board[2][2])) {
            highlightWinningLine(buttons[0], buttons[4], buttons[8]);
        } else if (checkLine(board[0][2], board[1][1], board[2][0])) {
            highlightWinningLine(buttons[2], buttons[4], buttons[6]);
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
        if (currentPlayer == 'X') statusLabel.setText("X wins");
        else statusLabel.setText("O wins");
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

    private void aiMove() {
        if (gameWon) return;

        // AI logic to make a move
        int move = findBestMove();
        buttons[move].doClick();
    }

    private int findBestMove() {
        // Check if AI can win in the next move
        for (int i = 0; i < 9; i++) {
            if (buttons[i].getText().equals("")) {
                buttons[i].setText("O");
                if (isWinningMove()) {
                    buttons[i].setText("");
                    return i;
                }
                buttons[i].setText("");
            }
        }

        // Check if the player can win in the next move and block them
        for (int i = 0; i < 9; i++) {
            if (buttons[i].getText().equals("")) {
                buttons[i].setText("X");
                if (isWinningMove()) {
                    buttons[i].setText("");
                    return i;
                }
                buttons[i].setText("");
            }
        }

        // Otherwise, make a random move
        Random rand = new Random();
        int move;
        do {
            move = rand.nextInt(9);
        } while (!buttons[move].getText().equals(""));

        return move;
    }

    private boolean isWinningMove() {
        String[][] board = new String[3][3];
        for (int i = 0; i < 9; i++) {
            board[i / 3][i % 3] = buttons[i].getText();
        }

        // Check rows, columns, and diagonals for a winning move
        for (int i = 0; i < 3; i++) {
            if (checkLine(board[i][0], board[i][1], board[i][2])) return true;
            if (checkLine(board[0][i], board[1][i], board[2][i])) return true;
        }
        if (checkLine(board[0][0], board[1][1], board[2][2])) return true;
        if (checkLine(board[0][2], board[1][1], board[2][0])) return true;

        return false;
    }

    private boolean isBoardFull() {
        for (JButton button : buttons) {
            if (button.getText().equals("")) {
                return false;
            }
        }
        return true;
    }
}
