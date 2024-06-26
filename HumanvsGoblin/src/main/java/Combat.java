import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Combat extends JPanel{
    static JFrame window;
    Container con;
    JPanel  goblinHPPanel, PlayerHPPanel, fightPanel, invetoryPanel, inspectPanel;
    JProgressBar GoblinHealthBar, playerHealthBar;
    JLabel playerHealthLabel;
    JButton fightButton, inventoryButton, inspectButton;

    static Goblin gobby = new Goblin();
    static Player human = new Player();
    static Inventory bag = new Inventory();

    public static void combatDisplay() {
        JFrame frame = new JFrame("Combat Screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel textLabel = new JLabel("Fighting time", SwingConstants.CENTER);
        textLabel.setPreferredSize(new Dimension(300, 100));
        frame.setSize(400, 400);
        frame.getContentPane().add(textLabel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public Combat() {
        //create jframe
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        con = window.getContentPane();

        goblinHPPanel = new JPanel();
        goblinHPPanel.setBounds(50, 50, 150, 30);
        goblinHPPanel.setBackground(Color.darkGray);
        window.getContentPane().add(goblinHPPanel);
        window.add(goblinHPPanel);



        //Set HP goblin value
        GoblinHealthBar = new JProgressBar(0,gobby.getMaxHealth());
        GoblinHealthBar.setPreferredSize(new Dimension(150,30));
        GoblinHealthBar.setValue(gobby.currentHP);
        GoblinHealthBar.setBackground(Color.RED);
        GoblinHealthBar.setStringPainted(true);
        GoblinHealthBar.setString("Goblin HP: " + GoblinHealthBar.getValue());
        goblinHPPanel.add(GoblinHealthBar);

        //Create HP JPanel
        PlayerHPPanel = new JPanel();
        PlayerHPPanel.setBounds(50, 570, 150, 30);
        PlayerHPPanel.setBackground(Color.darkGray);
        window.add(PlayerHPPanel);

        //create a health progress bar that tracks player HP
        playerHealthBar = new JProgressBar(0, human.getHealth());
        playerHealthBar.setPreferredSize(new Dimension(150, 30));
        playerHealthBar.setValue(human.getHealth());
        playerHealthBar.setStringPainted(true);
        playerHealthBar.setString("Player HP: " + playerHealthBar.getValue());
        PlayerHPPanel.add(playerHealthBar);

        //Label that stores health bar
        playerHealthLabel = new JLabel();
        playerHealthLabel.setPreferredSize(new Dimension(150, 30));
        playerHealthLabel.setText("Player Health");
        playerHealthLabel.getText();
        PlayerHPPanel.add(playerHealthLabel);
        window.setVisible(true);

        //Create fight button
        fightButton = new JButton("Fight");
        fightButton.setBackground(Color.RED);
        fightButton.setForeground(Color.black);
        fightButton.setFocusPainted(false);
        //fight button function
        fightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                attack();
                window.setVisible(false);
                window.dispose();
                if ((gobby.currentHP > 0)) {
                    new Combat();
                }
            }
        });
        //add panel to frame
        fightPanel = new JPanel();
        fightPanel.setBounds(100, 450, 150, 30);
        fightPanel.setBackground(Color.darkGray);
        fightPanel.add(fightButton);
        window.add(fightPanel);

        //Create inventory button
        inventoryButton = new JButton("Inventory");
        inventoryButton.setBackground(Color.ORANGE);
        inventoryButton.setForeground(Color.black);
        inventoryButton.setFocusPainted(false);
        inventoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){  
                inventory();
            }
        });

        //create panel for inventory
        invetoryPanel = new JPanel();
        invetoryPanel.setBounds(100, 475, 150, 30);
        invetoryPanel.setBackground(Color.darkGray);
        invetoryPanel.add(inventoryButton);
        window.add(invetoryPanel);
        //create inventory button
        inspectButton = new JButton("Inspect");
        inspectButton.setBackground(Color.LIGHT_GRAY);
        inspectButton.setForeground(Color.black);
        inspectButton.setFocusPainted(false);
        inspectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inspect();
            }
        });

        //Create panel for inspect
        inspectPanel = new JPanel();
        inspectPanel.setBounds(250, 450, 150, 30);
        inspectPanel.setBackground(Color.darkGray);
        inspectPanel.add(inspectButton);
        window.add(inspectPanel);
        window.setSize(900,900);
        
        // Create the player and the goblin images
        ModelAsset Player = new ModelAsset(400,400,100,100,HumanvsGoblin.stillHumanPath);
        ModelAsset GobAsset = new ModelAsset(400, 40, 150, 200, HumanvsGoblin.stillGoblinPath);
        //ModelAsset Player = new ModelAsset(400,400,200,200,"HumanvsGoblin\\HumanvsGoblin\\src\\main\\java\\assets\\human.png");
        //ModelAsset GobAsset = new ModelAsset(400, 40, 150, 200, "HumanvsGoblin\\HumanvsGoblin\\src\\main\\java\\assets\\goblin.png");
        ArrayList<ModelAsset> arr = new ArrayList<>();
        arr.add(GobAsset);
        arr.add(Player);
        CombatImages cd = new CombatImages(arr);
        window.add(cd);
        window.setVisible(true);
        

    }

    //method to start attacking goblin
    public static void attack(){
        int playerDamage = (human.getAttack()-gobby.getDefense());
        if(!(gobby.isDead()) && !(human.isDead())){
            gobby.damageTaken(playerDamage);
            if(gobby.isDead()){
                JOptionPane.showMessageDialog(null, "Goblin has been slain", "Victory", 0);
            }
            int goblinDamage = (gobby.getAttack()-human.getDefense());
            human.damageTaken(goblinDamage);
            if(human.isDead()){
                JOptionPane.showMessageDialog(null, "You have been slain", "Death", 0);
            }
        } else{
            window.setVisible(false);
            window.dispose();
        }
        
    }
    //method to check goblin stats
    public void inspect(){
        JOptionPane.showMessageDialog(null, gobby.inspect(), "Inspect", 0);
    }

    //method to check current inventory and equip a new item
    public void inventory(){
        int attackValue=0;
        String itemName="";
        Object[]itemList = new Object[bag.backpack.size()];
        for(int i=0;i<itemList.length;i++){
            itemList[i]=bag.backpack.get(i).getName();            
        }
        //shows a window to select item in inventory
        int choice = JOptionPane.showOptionDialog(null,"Select item from inventory","Inventory",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, itemList, null);
        if(bag.backpack.get(choice).getItemId().equals(Item.ItemID.SWORD)){
            attackValue = bag.backpack.get(choice).getAttack();
            itemName = bag.backpack.get(choice).getName();
        }
        if(bag.backpack.get(choice).getItemId().equals(Item.ItemID.GOLD)){
            attackValue = bag.backpack.get(choice).getAttack();
            itemName = bag.backpack.get(choice).getName();
        }
        // show item change and any added on attack values
        JOptionPane.showMessageDialog(null, itemName+" has been selected. "+attackValue+" attack added. ", "Item Equipped", 0);
        human.setAttack(attackValue);
    }
    //Begin Combat
    public static void main(String[] args){
        new Combat();
    }
}