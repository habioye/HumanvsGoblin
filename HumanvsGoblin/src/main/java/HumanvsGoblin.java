import java.awt.*;
import javax.swing.*;

import java.lang.Thread;
import java.util.*;
import java.util.Random;


import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;


//package PlayerAsset;

public class HumanvsGoblin {

    public static Player human = new Player();
    public Player goblin = new Player();

    // grid dimensions
    public static int gridWidth = 20;
    public static int gridHeight = 20;
    public static int cellSize = 40;

    // human and goblin paths
    public static String humanPath = "assets/runner.gif";
    public static String stillHumanPath = "assets/knight.png";
    public static String goblinPath = "assets/goblin.gif";
    public static String stillGoblinPath = "assets/goblin2.png";


    // dungeon music
    public static String dungeonPath = "assets/Dungeon-Crawler.wav";

    // terrain
    static String grassPath = "assets/grass.png";

    // Obstacle
    static String stonePath = "assets/transstone.png";
    static String treePath = "assets/treepixel.png";
    static String cratePath = "assets/crate.png";

    // inventory
    public static JFrame inventory = new JFrame();

    // calculates the conversion of board position to coordinates in JPanel
    public static int playerpos(int p) {
        return (cellSize + (p * cellSize));
    }

    // returns a random unfilled position in the array
    public static int[] randomPos(int[][] arr) {
        int posx;
        int posy;
        int[] coor = new int[2];
        Random rand = new Random();
        while (true) {
            posx = rand.nextInt(gridWidth);
            posy = rand.nextInt(gridHeight);

            if (arr[posy][posx] == 0) {
                coor[0] = posy;
                coor[1] = posx;
                break;
            }

        }
        return coor;
    }

    // Generates a group of random obstacles to be added to the ModelAsset ArrayList
    public static void addObstacles(int[][] arr, ArrayList<ModelAsset> models, String path, int amount) {
        int[] coor;
        for (int i = 0; i < amount; i++) {
            coor = randomPos(arr);
            arr[coor[0]][coor[1]] = 1;
            ModelAsset obstacle = new ModelAsset(playerpos(coor[1]), playerpos(coor[0]), cellSize, cellSize, path);
            obstacle.obstacle = true;
            models.add(obstacle);
        }
    }

    // Plays music that loops
    public static void playMusic(String filePath) {
        try {
            File musicPath = new File(filePath);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.loop(clip.LOOP_CONTINUOUSLY);
                clip.start();

            } else {
                System.out.println("Can't find file");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }


    public static void main(String[] args) {
        // start the music
        playMusic(dungeonPath);

        // adds to backpack
        human.backpackAdd(new sword());
        human.backpackAdd(new sword());
        human.backpackAdd(new sword());
        human.backpackAdd(new Gold());
        human.backpackAdd(new sword());
        human.backpackAdd(new Gold());



        int[][] free = new int[gridHeight][gridWidth];

        int[] coor;
        ArrayList<ModelAsset> models = new ArrayList<>();

        // generate obstacles

        // stone obstacles
        int stoneCount = 12;
        addObstacles(free, models, stonePath, stoneCount);

        // tree obstacles
        int treeCount = 40;
        addObstacles(free, models, treePath, treeCount);

        // crate obstacles
        int crateCount = 8;
        addObstacles(free, models, cratePath, crateCount);

//        for (int i = 0; i < gridWidth; i++) {
//            for (int j = 0; j < gridWidth; j++) {
//                System.out.print(free[i][j] + " ");
//            }
//            System.out.println();
//        }


        // human position
        coor = randomPos(free);
        int humanx = coor[0];
        int humany = coor[1];


        // goblin position
        coor = randomPos(free);
        int goblinx = coor[0];
        int gobliny = coor[1];


        ModelAsset humanPlayer = new ModelAsset(playerpos(humanx), playerpos(humany), cellSize, cellSize, humanPath);
        ModelAsset goblinPlayer = new ModelAsset(playerpos(goblinx), playerpos(gobliny), cellSize, cellSize, goblinPath);
        models.add(humanPlayer);
        models.add(goblinPlayer);


        JFrame window = new JFrame("Human vs Goblin!");
        Inventory panel = new Inventory();
        inventory.add(panel);
        inventory.setTitle("Inventory");
        inventory.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        inventory.setResizable(false);
        inventory.pack();
        inventory.setLocationRelativeTo(null);


//        boolean inventoryFrame = false;

//        PlayerPanel humanAsset = new PlayerPanel(humanPath,40,40,20,20);
//        PlayerPanel goblinAsset = new PlayerPanel(goblinPath,80,80,20,20);
//        ImagePanel goblinAsset = new ImagePanel(100,100,40,40,"assets/goblin.jpeg");


        System.out.println("Stop");


        int unitLength = gridWidth;


        Grid grid = new Grid(cellSize, unitLength, models, grassPath);
        grid.setBackground(Color.black);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(grid);

        grid.setFocusable(true);
        grid.requestFocusInWindow();

        window.setSize(900, 900);
        window.setVisible(true);

        boolean humanT = true;

        boolean ch = false;
        Thread frame = new Thread(() -> {
            try {
                while (!grid.moveHandler.getInventory()) {
                    window.repaint();
                    Thread.sleep(100);
                }
            } catch (Exception e) {
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

                    if (humanx == 0 || (free[humany][humanx - 1] == 1)) continue;
                    System.out.println("Left IS MIGHT " + humanx + " " + goblinx);
                    humanx -= 1;
                    ch = true;
                } else if (grid.moveHandler.getRight()) {
                    if (humanx == unitLength - 1 || (free[humany][humanx + 1] == 1)) continue;
                    System.out.println("RIGHT IS MIGHT " + humanx + " " + goblinx);
                    humanx += 1;
                    ch = true;

                } else if (grid.moveHandler.getUp()) {
                    System.out.println("right");
                    if (humany == 0 || (free[humany - 1][humanx] == 1)) continue;
                    ch = true;
                    humany -= 1;
                } else if (grid.moveHandler.getDown()) {
                    if (humany == unitLength - 1 || (free[humany + 1][humanx] == 1)) continue;
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
                        if (free[gobliny][goblinx] == 1) goblinx += 1;

                    } else {
                        goblinx += 1;
                        if (free[gobliny][goblinx] == 1) goblinx -= 1;

                    }
                } else if (humany != gobliny) {

                    if (gobliny > humany) {
                        gobliny -= 1;
                        if (free[gobliny][goblinx] == 1) gobliny += 1;

                    } else {
                        gobliny += 1;
                        if (free[gobliny][goblinx] == 1) gobliny -= 1;
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
                        if (combat.gobby.isDead() || combat.human.isDead())
                            break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                if (combat.gobby.isDead()) {
                    coor = randomPos(free);
                    gobliny = coor[0];
                    goblinx = coor[1];
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
