import javax.swing.*;
import java.awt.*;
import javax.sound.sampled.Clip;

public class TicTacToeInstructions extends JFrame {

    private Clip clip;
    public TicTacToeInstructions() {
        setTitle("Tic-Tac-Toe Instructions");
        setSize(310, 400);
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        
        // Set up a panel with a border layout
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        // Create the instructions text
        String instructions = "Tic-Tac-Toe Instructions:\n\n" +
                "1. The game is played on a 3x3 grid.\n" +
                "2. Player 1 uses 'X' and Player 2 uses 'O'.\n" +
                "3. Players take turns to place their mark in an empty cell.\n" +
                "4. The first player to get 3 marks in a row (vertically, horizontally, or diagonally) wins.\n" +
                "5. If all cells are filled and no one wins, the game ends in a draw.\n\n" +
                "How to play:\n" +
                "1. Click on an empty cell to make your move.\n" +
                "2. The game will automatically switch turns between the two players.\n" +
                "3. The game ends when one player wins or when it's a draw.\n" +
                "\n" +
                "Developers: The Tres A's";
        
        
        
        JTextArea instructionsArea = new JTextArea(instructions);
        instructionsArea.setFont(new Font("Bell MT", Font.BOLD, 16));
        instructionsArea.setForeground(new Color (153,0,0));
        instructionsArea.setEditable(false);
        instructionsArea.setLineWrap(true);
        instructionsArea.setWrapStyleWord(true);
        instructionsArea.setBackground(new Color(0,204,204));
        instructionsArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        
        JScrollPane scrollPane = new JScrollPane(instructionsArea);
        
        
        // Add the scrollable instructions text to the panel
        panel.add(scrollPane, BorderLayout.CENTER);
        
        
        // Add a "Close" button to close the instructions window
        JButton closeButton = new JButton("Close");
        closeButton.setFocusable(false);
        closeButton.setFont(new Font("Bell MT", Font.BOLD, 14));
        closeButton.setForeground(new Color(153,0,0));
        closeButton.setBackground(new Color(153,153,0));       
        closeButton.addActionListener(e -> {
                
            OPTION_Page p = new OPTION_Page(clip);
            p.setVisible(true);
            this.dispose();
                }); // Close the program when clicked
        panel.add(closeButton, BorderLayout.SOUTH);
        
        add(panel);
    }

    public static void main(String[] args) {
        // Run the TicTacToeInstructions JFrame
        SwingUtilities.invokeLater(() -> new TicTacToeInstructions().setVisible(true));
    }
}
