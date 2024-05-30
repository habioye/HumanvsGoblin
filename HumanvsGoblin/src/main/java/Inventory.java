import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

import javax.swing.JPanel;

public class Inventory extends JPanel implements ActionListener{
    static final int WIDTH = 800;
	static final int HEIGHT = 800;
	static final int UNIT_SIZE = 55;
	static final int NUMBER_OF_UNITS = (WIDTH * HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
    Random random;
    Timer timer;
    boolean running = false;
    final int[] cursor = new int[2];

    public Inventory(){
        random = new Random();
        this.setPreferredSize(new Dimension(WIDTH/2,HEIGHT/2));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        System.out.println(this.getWidth());
        play();
    }

    @Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
        Graphics2D graphics2d = (Graphics2D) graphics;
		drawInventory(graphics2d);
	}
    public void play(){
        cursor[0] = WIDTH/2/2 +15;
        cursor[1] = 15;
        running = true;
        int delay = 100;
        timer = new Timer(delay, this);
        timer.start();
        
    }
    //create frames for the inventory and use the arrow keys to equip items
    public void drawInventory(Graphics2D graphics2d){
        graphics2d.setColor(new Color(0,0,0));
        graphics2d.fillRect(0, 0, WIDTH/2, HEIGHT/2);
        
        //inventory
        graphics2d.setColor(new Color(255,255,255));
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.drawRoundRect(WIDTH/2/2+5, 5, WIDTH/2/2 -10, HEIGHT/2 -10,25,25);
        

        //cursor
        graphics2d.drawRoundRect(cursor[0], cursor[1], UNIT_SIZE, UNIT_SIZE,25,25);

        //stats
        graphics2d.setColor(new Color(255,255,255));
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.drawRoundRect(5, 5, WIDTH/2/2 -10, HEIGHT/2 -10,25,25);

        graphics2d.setColor((Color.white));
        graphics2d.setFont(new Font("Sans serif", Font.ROMAN_BASELINE, 20));
        graphics2d.drawString("Player Stats",10 ,graphics2d.getFont().getSize()+10);
        
        
        
        graphics2d.drawString("Attack: "+ 12, 10, graphics2d.getFont().getSize()*2+10);
        graphics2d.drawString("Defense: "+-12, 10, graphics2d.getFont().getSize()*3+10);
        

        // graphics2d.setColor((Color.white));
        // graphics2d.setFont(new Font("Sans serif", Font.ROMAN_BASELINE, 20));
        // graphics2d.drawString("Inventory",WIDTH/2/2+5+8 ,graphics2d.getFont().getSize()+5);

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        repaint();
        
        
    }
    
    private class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            //Handle key pressed events
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    System.out.println(cursor[0]);
                    if (cursor[0]- UNIT_SIZE > WIDTH/2/2+5){
                        cursor[0] -=UNIT_SIZE;
                    }
                    
                    break;
                case KeyEvent.VK_RIGHT:
                    // Move right

                    System.out.println(cursor[0]);
                    if (cursor[0]+ UNIT_SIZE < WIDTH/2 - UNIT_SIZE - 10){
                        cursor[0] +=UNIT_SIZE;
                    }
                    break;
                case KeyEvent.VK_UP:
                    // Move up
                    if(cursor[1]- UNIT_SIZE > 10){
                        cursor[1] -=UNIT_SIZE;
                    }
                    
                    break;
                case KeyEvent.VK_DOWN:
                    // Move down
                    if (cursor[1]+ UNIT_SIZE < HEIGHT/2 - UNIT_SIZE-10){
                        cursor[1] +=UNIT_SIZE;
                    }
                    
                    break;
                // Add more key events as needed
            }
        }
    }
}

