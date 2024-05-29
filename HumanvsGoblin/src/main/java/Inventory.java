import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

import javax.swing.JPanel;

public class Inventory extends JPanel implements ActionListener{
    static final int WIDTH = 800;
	static final int HEIGHT = 800;
	static final int UNIT_SIZE = 20;
	static final int NUMBER_OF_UNITS = (WIDTH * HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
    Random random;
    Timer timer;
    boolean running = false;

    public Inventory(){
        random = new Random();
        this.setPreferredSize(new Dimension(WIDTH/2,HEIGHT/2));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        play();
    }

    @Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		drawInventory(graphics);
	}
    public void play(){
        running = true;
        int delay = 100;
        timer = new Timer(delay, this);
        timer.start();
        
    }

    public void drawInventory(Graphics graphics){
        graphics.setColor(Color.GRAY);
        graphics.fillRect(0, 0, WIDTH/2/2, HEIGHT/2);
        
        graphics.setColor((Color.white));
        graphics.setFont(new Font("Sans serif", Font.ROMAN_BASELINE, 30));
        graphics.drawString("Player Stats",0 ,graphics.getFont().getSize());
        
        
        graphics.drawString("Attack: "+ 12, 0, graphics.getFont().getSize()*2);
        graphics.drawString("Defense: "+-12, 0, graphics.getFont().getSize()*3);
        

        

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
        
    }
    
    private class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            //Handle key pressed events
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    // Move left
                    break;
                case KeyEvent.VK_RIGHT:
                    // Move right
                    break;
                case KeyEvent.VK_UP:
                    // Move up
                    break;
                case KeyEvent.VK_DOWN:
                    // Move down
                    break;
                // Add more key events as needed
            }
        }
    }
}

