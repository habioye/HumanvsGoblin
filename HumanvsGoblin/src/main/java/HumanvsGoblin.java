import java.awt.*;
import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.Thread;
import java.util.*;
import java.util.Random;

//package PlayerAsset;

public class HumanvsGoblin{

    public static Player human = new Player();
    public Player goblin = new Player();

    // grid dimensions
    public static int gridWidth = 20;
    public static int gridHeight = 20;

    // human and goblin paths
    public static String humanPath = "assets/knight.png";
    public static String GoblinPath = "assets/goblin.png";

    public static JFrame inventory = new JFrame();
//         ImagePanel humanAsset = new ImagePanel(10,10,40,40,"assets/human.jpeg");
//         ImagePanel goblinAsset = new ImagePanel(100,100,40,40,"assets/goblin.jpeg");


    public static int playerpos(int p) {
        return (40 + (p * 40));
    }

    public static int[] randomPos(Set<int[]> arr) {
        int posx;
        int posy;
        int[] coor = new int[2];
        Random rand = new Random();
        while (true) {
            posx = rand.nextInt(gridWidth);
            posy = rand.nextInt(gridHeight);
            coor[0] = posx;
            coor[1] = posy;
            if (arr.contains(coor)) {
                arr.remove(coor);
                break;
            }

        }
        return coor;
    }



    public static void main(String[] args) {





        human.backpackAdd(new sword());
        human.backpackAdd(new sword());
        human.backpackAdd(new sword());
        human.backpackAdd(new Gold());
        human.backpackAdd(new sword());
        human.backpackAdd(new Gold());

//        String humanPath = "assets/human.png";


        // terrain
        String grassPath = "assets/grass.png";

        // Obstacle
        String stonePath = "assets/stone.png";
        String fireHydrantPath = "assets/firehydrant.jpeg";
        String cratePath = "assets/crate.jpeg";

        Set<int[]> free = new HashSet<int[]>();
        for (int i  = 0; i < gridHeight; i++) {
            for (int j  = 0; j < gridWidth; j++) {
                int[] curr = new int[2];
                curr[0]= i;
                curr[1] = j;
                free.add(curr);

            }
        }
//        Iterator<int[]> it = free.iterator();
        Random rand = new Random();
        int[] coor = new int[2];




        // human position
        coor = randomPos(free);
        int humanx = coor[0];
        int humany = coor[1];


        // goblin position
        coor = randomPos(free);
        int goblinx = coor[0];
        int gobliny = coor[1];


        ModelAsset humanPlayer = new ModelAsset(playerpos(humanx), playerpos(humany), 40, 40, humanPath);
        ModelAsset goblinPlayer = new ModelAsset(playerpos(goblinx), playerpos(gobliny), 40, 40, goblinPath);
        ArrayList<ModelAsset> players = new ArrayList<>();
        players.add(humanPlayer);
        players.add(goblinPlayer);



        JFrame window = new JFrame("Human vs Goblin!");
        Inventory panel = new Inventory();
        inventory.add(panel);
        inventory.setTitle("Inventory");
        inventory.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        inventory.setResizable(false);
        inventory.pack();
        inventory.setLocationRelativeTo(null);
        
        
        boolean inventoryFrame = false;

//        PlayerPanel humanAsset = new PlayerPanel(humanPath,40,40,20,20);
//        PlayerPanel goblinAsset = new PlayerPanel(goblinPath,80,80,20,20);
//        ImagePanel goblinAsset = new ImagePanel(100,100,40,40,"assets/goblin.jpeg");


        System.out.println("Stop");


        int cellSize = 40;
        int unitLength = gridWidth;

        
        Grid grid = new Grid(cellSize, unitLength, players, grassPath);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(grid);

        grid.setFocusable(true);
        grid.requestFocusInWindow();

        window.setVisible(true);
        window.setSize(900,900);

        boolean humanT = true;

        boolean ch = false;
        Thread frame = new Thread(()-> {
           try {
               while (!grid.moveHandler.getInventory()) {
                   window.repaint();
                   Thread.sleep(100);
               }
           } catch(Exception e) {
               System.out.println(e);
           }
       }

       );
       frame.start();
        int goblinWait = 200;
        int humanWait = 10;
        while (true) {
            ch = false;
            if (humanT) {
                try {

                    Thread.sleep(humanWait);
                } catch (Exception e) {
                    System.out.println(e);
                }

                if (grid.moveHandler.getLeft()) {

                    if (humanx == 0) continue;
                    System.out.println("Left IS MIGHT " + humanx + " " + goblinx);
                    humanx -= 1;
                    ch = true;
                } else if (grid.moveHandler.getRight()) {
                    if (humanx == unitLength - 1) continue;
                    System.out.println("RIGHT IS MIGHT " + humanx + " " + goblinx);
                    humanx += 1;
                    ch = true;

                } else if (grid.moveHandler.getUp()) {
                    System.out.println("right");
                    if (humany == 0) continue;
                    ch = true;
                    humany -= 1;
                } else if (grid.moveHandler.getDown()) {
                    if (humany == unitLength - 1) continue;
                    humany += 1;
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
                    if (goblinx > humanx) {
                        goblinx -= 1;
                    } else {
                        goblinx += 1;
                    }
                } else if (humany != gobliny) {

                    if (gobliny > humany) {
                        gobliny -= 1;

                    } else {
                        gobliny += 1;
                    }

                    System.out.println(goblinx + gobliny);
                }
                try {

                    Thread.sleep(goblinWait);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            if (humanx == goblinx && humany == gobliny) {
                System.out.println("They are in the same square! You can start the battle!!!!!");
                window.setVisible(false);
                Combat.gobby = new Goblin();
                Combat.human = new Player();

                Combat combat = new Combat();
                int checkInterval = 10;
                while (true) {
                    try {
                        Thread.sleep(checkInterval);
                        if (combat.gobby.isDead()) {
                            System.out.println("You have killed the goblin");
                         break;
                        }
                        if (combat.human.isDead()) {
                            System.out.println("You have been killed");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                if (combat.gobby.isDead()) {
                    goblinx = 4;
                    gobliny = 5;
                }
                if (combat.human.isDead()) {
                    System.out.println("You have been killed");
                    return;
                }
                combat.window.setVisible(false);
                window.setVisible(true);



            }
            System.out.println("moved");
            humanPlayer.x = playerpos(humanx);
            humanPlayer.y = playerpos(humany);
            goblinPlayer.x = playerpos(goblinx);
            goblinPlayer.y = playerpos(gobliny);
            grid.repaint();
                 humanT = !humanT;
             }
    }
}
