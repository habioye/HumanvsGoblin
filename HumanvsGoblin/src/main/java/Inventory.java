import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;

import java.util.Random;

public class Inventory extends JPanel implements ActionListener{
    static final int WIDTH = 800;
	static final int HEIGHT = 800;
	static final int UNIT_SIZE = 55;
	static final int NUMBER_OF_UNITS = (WIDTH * HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
    Random random;
    Timer timer;
    boolean running = false;
    final int[] cursor = new int[2];

    ArrayList<Item> backpack = HumanvsGoblin.human.getBackpack();
    int currRow = 0;
    int currCol = 0;
    JFrame inventoryFrame;
    
    public void inventoryFrame(){
        inventoryFrame = new JFrame("Inventory");
        Inventory panel = new Inventory();
		inventoryFrame.add(panel);
		inventoryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inventoryFrame.setResizable(true);
		inventoryFrame.pack();
		inventoryFrame.setVisible(true);
		inventoryFrame.setLocationRelativeTo(null);
    }
    
    public Inventory(){
        random = new Random();
        this.setPreferredSize(new Dimension(WIDTH/2,HEIGHT/2));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
 
        HumanvsGoblin.human.setWeapon(0);
        play();
    }

    @Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
        Graphics2D graphics2d = (Graphics2D) graphics;
		drawInventory(graphics2d);
        drawStats(graphics2d);
	}
    public void play(){
        cursor[0] = WIDTH/2/2 +15;
        cursor[1] = 15;
        running = true;
        timer = new Timer(100, this);
        timer.start();
        
    }
    //create frames for the inventory and use the arrow keys to equip items
    public void drawInventory(Graphics2D graphics2d){
        graphics2d.setColor(new Color(0,0,0));
        graphics2d.fillRect(0, 0, WIDTH/2, HEIGHT/2);
        
        //inventory
        final int slotXStart = WIDTH/2/2 +25;
        final int slotYStart = 25;
        int slotX = slotXStart;
        int slotY = slotYStart;
        int slotSize = UNIT_SIZE - 20;
        graphics2d.setColor(Color.RED);
        for(int i = 0; i < backpack.size();i++){
            
            graphics2d.drawImage(backpack.get(i).image,slotX, slotY,35,35,null);

            if (HumanvsGoblin.human.getWeapon() == i){
                graphics2d.setColor(new Color(135,206,250,100));  
                graphics2d.fillRect(slotX, slotY, slotSize, slotSize);
                
            }
            slotX+= slotSize+20;

            if(i == 2 ||i == 5 ||i == 8 ||i == 11 ||i == 14 ||i == 17){
                slotX = slotXStart;
                slotY += slotSize+20; 
            }
        }
        
        //cursor
        graphics2d.setColor(Color.WHITE);
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.drawRoundRect(cursor[0], cursor[1], UNIT_SIZE, UNIT_SIZE,25,25);

        
    }
    public void drawStats(Graphics2D graphics2d){

        graphics2d.setColor(new Color(255,255,255));
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.drawRoundRect(WIDTH/2/2+5, 5, WIDTH/2/2 -10, HEIGHT/2 -10,25,25);

        graphics2d.setColor(new Color(255,255,255));
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.drawRoundRect(5, 5, WIDTH/2/2 -10, HEIGHT/2 -10,25,25);

        graphics2d.setColor((Color.white));
        graphics2d.setFont(new Font("Sans serif", Font.ROMAN_BASELINE, 20));
        graphics2d.drawString("Player Stats",10 ,graphics2d.getFont().getSize()+10);
        

        if(backpack.size()>0){
            graphics2d.drawString("Attack: "+ (backpack.get(HumanvsGoblin.human.getWeapon()).getAttack() + HumanvsGoblin.human.attack()), 10, graphics2d.getFont().getSize()*2+10);
        }else{
            graphics2d.drawString("Attack: "+ HumanvsGoblin.human.attack(), 10, graphics2d.getFont().getSize()*2+10);
        }
        
        graphics2d.drawString("Defense: "+HumanvsGoblin.human.defense(), 10, graphics2d.getFont().getSize()*3+10);
        graphics2d.drawString("Equiped: "+ backpack.get(HumanvsGoblin.human.getWeapon()).getName(), 10, graphics2d.getFont().getSize()*4+10);
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
                    //moves left
                    if (cursor[0]- UNIT_SIZE > WIDTH/2/2+5){
                        cursor[0] -=UNIT_SIZE;
                        currCol-=1;
                    }
                    
                    break;
                case KeyEvent.VK_RIGHT:
                    // Move right

                    if (cursor[0]+ UNIT_SIZE < WIDTH/2 - UNIT_SIZE - 10){
                        cursor[0] +=UNIT_SIZE;
                        currCol+=1;
                    }
                    break;
                case KeyEvent.VK_UP:
                    // Move up
                    if(cursor[1]- UNIT_SIZE > 10){
                        cursor[1] -=UNIT_SIZE;
                        currRow-=1;
                    }
                    
                    break;
                case KeyEvent.VK_DOWN:
                    // Move down
                    if (cursor[1]+ UNIT_SIZE < HEIGHT/2 - UNIT_SIZE-10){
                        cursor[1] +=UNIT_SIZE;
                        currRow+=1;
                    }
                    
                    break;
                
                case KeyEvent.VK_ENTER:
                    int index = (currRow*3)+(currCol);
                    HumanvsGoblin.human.setWeapon(index);
                    break;

            }
            System.out.println(currCol+currRow);
        }
    }
}

