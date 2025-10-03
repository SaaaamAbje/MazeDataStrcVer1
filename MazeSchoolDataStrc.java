import java.awt.*;
import javax.swing.*;

public class Maze extends JPanel {
    // Maze layout: 0 = path, 1 = wall
    private final int[][] maze = {
        {0,1,1,1,1,1,1},
        {0,0,0,0,1,0,1},
        {1,0,1,0,1,0,1},
        {1,0,1,0,0,0,1},
        {1,0,1,1,1,0,1},
        {1,0,0,0,0,0,0},
        {1,1,1,1,1,1,0}
    };

    private final int cellSize = 60; // size of each square

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                if (maze[row][col] == 1) {
                    g.setColor(Color.BLACK); // walls
                } else {
                    g.setColor(Color.WHITE); // paths
                }
                g.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);
                g.setColor(Color.GRAY);
                g.drawRect(col * cellSize, row * cellSize, cellSize, cellSize);
            }
        }

        // Entrance (top-left)
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, cellSize, cellSize);

        // Exit (bottom-right)
        g.setColor(Color.RED);
        g.fillRect(6 * cellSize, 6 * cellSize, cellSize, cellSize);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Custom Maze Board");
        Maze panel = new Maze();
        frame.add(panel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
} 
