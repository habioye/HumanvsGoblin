import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.Thread;
import java.util.*;

//package PlayerAsset;

public class HumanvsGoblin {

    public static int playerpos(int p) {
        return (40+(p*40));
    }


    public static void main(String[] args) {
//        String humanPath = "assets/human.png";
        String humanPath = "assets/knight.png";
        String goblinPath = "assets/goblin.gif";

        // terrain
        String grassPath = "assets/grass.png";

        // Obstacle
        String stonePath = "assets/stone.png";
        String fireHydrantPath = "assets/firehydrant.jpeg";
        String cratePath = "assets/crate.jpeg";


        int humanx = 0;
        int humany = 0;

        int goblinx = 14;
        int gobliny = 17;


        PlayerAsset humanPlayer = new PlayerAsset(playerpos(humanx),playerpos(humany),40,40,humanPath);
        PlayerAsset goblinPlayer = new PlayerAsset(playerpos(goblinx),playerpos(gobliny), 40,40,goblinPath);
        ArrayList<PlayerAsset> players = new ArrayList<>();
        players.add(humanPlayer);
        players.add(goblinPlayer);

//        PlayerPanel playerPanel = new PlayerPanel(players);



        JFrame window = new JFrame("Human vs Goblin!");


//        PlayerPanel humanAsset = new PlayerPanel(humanPath,40,40,20,20);
//        PlayerPanel goblinAsset = new PlayerPanel(goblinPath,80,80,20,20);
//        ImagePanel goblinAsset = new ImagePanel(100,100,40,40,"assets/goblin.jpeg");
        System.out.println("Stop");

//        humanAsset.setPreferredSize(new Dimension(500,500));
//        goblinAsset.setPreferredSize(new Dimension(50,50));

        int cellSize = 40;
        int unitLength = 20;

        Grid grid =  new Grid(cellSize,unitLength,players, grassPath);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(grid);
//        window.add(playerPanel);
//        window.add(goblinAsset);

        grid.setFocusable(true);
        grid.requestFocusInWindow();

//        grid.addKeyListener(new KeyListener() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                switch (e.getKeyCode()) {
//                    case KeyEvent.VK_UP:
//                        System.out.println("Up arrow key pressed");
//                        break;
//                    case KeyEvent.VK_DOWN:
//                        System.out.println("Down arrow key pressed");
//                        break;
//                    case KeyEvent.VK_LEFT:
//                        System.out.println("Left arrow key pressed");
//                        break;
//                    case KeyEvent.VK_RIGHT:
//                        System.out.println("Right arrow key pressed");
//                        break;
//                }
//            }
//        });

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setSize(900,900);

        boolean humanT = true;
        Player humnan = new Player();
        Player goblin = new Player();

        boolean ch = false;
//        Thread frame = new Thread(()-> {
//            try {
//                while (true) {
//                    window.repaint();
//                    Thread.sleep(100);
//                }
//            } catch(Exception e) {
//                System.out.println(e);
//            }
//        }
//
//        );
//        frame.start();
                    int goblinWait = 200;
                    int humanWait = 200;
        while (true) {
            ch = false;
            if (humanT) {
                try {

                    Thread.sleep(humanWait);
                } catch (Exception e) {
                    System.out.println(e);
                }
//                System.out.println(grid.moveHandler.getRight() == true);
//                System.out.println();

                if (grid.moveHandler.getLeft()) {

                    if (humanx == 0) continue;
                    System.out.println("Left IS MIGHT "+humanx+" "+goblinx);
                    humanx-=1;
                    ch = true;
                } else if (grid.moveHandler.getRight()) {
                    if (humanx == unitLength-1) continue;
                    System.out.println("RIGHT IS MIGHT "+humanx+" "+goblinx);
                    humanx+=1;
                    ch = true;

                } else if (grid.moveHandler.getUp()) {
                    System.out.println("right");
                    if (humany == 0)continue;
                    ch = true;
                    humany-=1;
                } else if (grid.moveHandler.getDown()) {
                    if (humany == unitLength - 1) continue;
                    humany+=1;
                    ch = true;
                }
                if (ch == false) {
                    continue;
                }


            } else {
                System.out.println("goblin");
                try {

                    Thread.sleep(goblinWait);
                } catch (Exception e) {
                    System.out.println(e);
                }
                if (humanx != goblinx) {
                    if (goblinx>humanx) {
                        goblinx-=1;
                    } else{
                        goblinx+=1;
                    }
                } else if (humany != gobliny) {

                    if ( gobliny > humany) {
                        gobliny-=1;

                    } else {
                        gobliny+=1;
                    }

                    System.out.println(goblinx+gobliny);


                }
                try {

                    Thread.sleep(goblinWait);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            if (humanx == goblinx && humany == gobliny) {
                System.out.println("They are in the same square! You can start the battle!!!!!");

            }
            System.out.println("moved");
//            PlayerAsset human = players.get(0);
            humanPlayer.x = playerpos(humanx);
            humanPlayer.y = playerpos(humany);
            goblinPlayer.x = playerpos(goblinx);
            goblinPlayer.y = playerpos(gobliny);
//            playerPanel.repaint();
//            grid.repaint();

//            window.repaint();
//            window.add(grid);
//            window.add(playerPanel);
            grid.repaint();

            humanT = !humanT;
        }
    }

}
