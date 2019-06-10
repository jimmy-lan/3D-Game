package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Game extends JFrame implements Runnable {
    public ArrayList<Texture> textures;
    public int mapWidth = 15;
    public int mapHeight = 15;
    private Thread thread;
    private boolean running;
    private BufferedImage image;
    public int[] pixels;
    public static int[][] map =
    {
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 1 },
        { 1, 0, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 1 },
        { 1, 0, 3, 0, 0, 0, 3, 0, 2, 0, 0, 0, 0, 0, 1 },
        { 1, 0, 3, 0, 0, 0, 3, 0, 2, 2, 2, 0, 2, 2, 1 },
        { 1, 0, 3, 0, 0, 0, 3, 0, 2, 0, 0, 0, 0, 0, 1 }, 
        { 1, 0, 3, 3, 0, 3, 3, 0, 2, 0, 0, 0, 0, 0, 1 },
        { 1, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 1 }, 
        { 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 0, 4, 4, 1 },
        { 1, 0, 0, 0, 0, 0, 1, 4, 0, 0, 0, 0, 0, 0, 1 }, 
        { 1, 0, 0, 0, 0, 0, 1, 4, 0, 0, 0, 0, 0, 0, 1 },
        { 1, 0, 0, 2, 0, 0, 1, 4, 0, 3, 3, 3, 3, 0, 1 }, 
        { 1, 0, 0, 0, 0, 0, 1, 4, 0, 3, 3, 3, 3, 0, 1 },
        { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, 
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } 
    };

    public static void main(String[] args) {
        Game game = new Game();
    }

    public Game() {
        // TODO: Add Textures
        // TODO: Add Camera Instance
        // TODO: Add Screen Instance

        // Window
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int windowW = (int)(screenSize.getWidth() / 1.5);
        int windowH = (int)(screenSize.getHeight() / 1.5);

        image = new BufferedImage(windowW, windowH, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
        setSize(windowW, windowH);
        
        // Thread
        thread = new Thread(this);
        
        // Start
        setResizable(false);
        setTitle("3D Game Engine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.black);
        setLocationRelativeTo(null); // Center
        setVisible(true);
        start();
    }

    public synchronized void start() {
        running = true;
        thread.start();
    }

    public synchronized void stop() {
        running = false;
        try
        {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void render() {
        // TODO: Add your code
    }

    @Override
    public void run() {
        // TODO: Add your code
    }
}