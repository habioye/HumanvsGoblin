import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Combat {
    static JFrame f;
    static JLabel l;
    static JFrame window;
    Container con;
    JPanel titleNamePanel, goblinHPPanel,PlayerHPPanel, goblinPanel, fightPanel, invetoryPanel, inspectPanel;
    JProgressBar GoblinHealthBar, playerHealthBar;
    JLabel playerHealthLabel, goblinLabel, humanLabel;
    JButton fightButton, inventoryButton, inspectButton;

    static Goblin gobby = new Goblin();
    static Player human = new Player();
    static Inventory bag = new Inventory();

    public static void combatDisplay(){
        JFrame frame = new JFrame("Combat Screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel textLabel = new JLabel("Fighting time",SwingConstants.CENTER);
        textLabel.setPreferredSize(new Dimension(300, 100));
        frame.setSize(400, 400);
        frame.getContentPane().add(textLabel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    public Combat(){

        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        con = window.getContentPane();

        goblinHPPanel = new JPanel();
        goblinHPPanel.setBounds(50,50,150,30);
        goblinHPPanel.setBackground(Color.BLACK);
        window.getContentPane().add(goblinHPPanel);
        con.add(goblinHPPanel);

        GoblinHealthBar = new JProgressBar(0,20);
        GoblinHealthBar.setPreferredSize(new Dimension(150,30));
        //Set HP goblin value
        GoblinHealthBar.setValue(gobby.currentHP);
        GoblinHealthBar.setBackground(Color.RED);
        GoblinHealthBar.setStringPainted(true);
        GoblinHealthBar.setString("Goblin HP: "+GoblinHealthBar.getValue());
        goblinHPPanel.add(GoblinHealthBar);

        ImageIcon goblin = new ImageIcon("HumanvsGoblin/src/main/java/assets/pngtree-goblin-cartoon-png-image_4008070.jpeg","Goblin image");
        goblin.getImage();

        goblinLabel = new JLabel(goblin);
        window.add(goblinLabel);

        ImageIcon humanIcon = new ImageIcon("C:/Users/Tman4/OneDrive/Pictures/amy mood.png");
        humanIcon.setImage(humanIcon.getImage());
        humanLabel = new JLabel(humanIcon);
        //JOptionPane.showMessageDialog(humanLabel, "Gobby", "Gobby", Goblin.currentHP);
        window.add(humanLabel);

        PlayerHPPanel = new JPanel();
        PlayerHPPanel.setBounds(50,500,150,30);
        PlayerHPPanel.setBackground(Color.BLACK);
        window.add(PlayerHPPanel);

        playerHealthBar = new JProgressBar(0,human.getHealth());
        playerHealthBar.setPreferredSize(new Dimension(150,30));
        playerHealthBar.setValue(human.getHealth());
        playerHealthBar.setStringPainted(true);
        playerHealthBar.setString("Player HP: "+playerHealthBar.getValue());
        PlayerHPPanel.add(playerHealthBar);

        playerHealthLabel = new JLabel();
        playerHealthLabel.setPreferredSize(new Dimension(150,30));
        playerHealthLabel.setText("Player Health");
        playerHealthLabel.getText();
        PlayerHPPanel.add(playerHealthLabel);
        window.setVisible(true);

        fightButton = new JButton("Fight");
        fightButton.setBackground(Color.black);
        fightButton.setForeground(Color.WHITE);
        fightButton.setFocusPainted(false);
        fightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){  
                attack();
                window.setVisible(false);  
                window.dispose();
                if((gobby.currentHP>0)){
                new Combat();
                }
            }
        });
        fightPanel = new JPanel();
        fightPanel.setBounds(100,450,150,30);
        fightPanel.setBackground(Color.black);
        fightPanel.add(fightButton);
        window.add(fightPanel);
        
        inventoryButton = new JButton("Inventory");
        inventoryButton.setBackground(Color.black);
        inventoryButton.setForeground(Color.WHITE);
        inventoryButton.setFocusPainted(false);
        inventoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){  
                inventory();
            }
        });
        invetoryPanel = new JPanel();
        invetoryPanel.setBounds(100, 475,150,30);
        invetoryPanel.setBackground(Color.black);
        invetoryPanel.add(inventoryButton);
        window.add(invetoryPanel);


        inspectButton = new JButton("Inspect");
        inspectButton.setBackground(Color.black);
        inspectButton.setForeground(Color.WHITE);
        inspectButton.setFocusPainted(false);
        inspectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){  
                inspect();
            }
        });
        inspectPanel = new JPanel();
        inspectPanel.setBounds(200,450,150,30);
        inspectPanel.setBackground(Color.black);
        inspectPanel.add(inspectButton);
        window.add(inspectPanel);

    }
    //method to start attacking goblin
    public static void attack(){
        int playerDamage = (human.getAttack()-gobby.getDefense());
        gobby.damageTaken(playerDamage);
        if(gobby.isDead()){
            JOptionPane.showMessageDialog(null, "Goblin has been slain", "Victory", 0);
            window.setVisible(false);
            window.dispose();
        }
        int goblinDamage = (gobby.getAttack()-human.getDefense());
        human.damageTaken(goblinDamage);
        if(human.isDead()){
            JOptionPane.showMessageDialog(null, "You have been slain", "Death", 0);
            window.setVisible(false);
            window.dispose();
        }
        
        
    }
    //method to check goblin stats
    public void inspect(){
        JOptionPane.showMessageDialog(null, gobby.inspect(), "Inspect", 0);
        //gobby.inspect();
    }
    //method to check current inventory and equip a new item
    public void inventory(){
        int attackValue=0;
        String itemName="";
        Object[] options = bag.backpack.toArray();
        int choice = JOptionPane.showOptionDialog(null,"Select item from inventory","Inventory",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
        if(bag.backpack.get(choice-1).getItemId().equals(Item.ItemID.SWORD)){
            attackValue = bag.backpack.get(choice-1).getAttack();
            itemName = bag.backpack.get(choice-1).getName();
        }
        if(bag.backpack.get(choice-1).getItemId().equals(Item.ItemID.GOLD)){
            attackValue = bag.backpack.get(choice-1).getAttack();
            itemName = bag.backpack.get(choice-1).getName();
        }
        JOptionPane.showMessageDialog(null, itemName+" has been selected. "+attackValue+" attack added. ", "Item Equipped", 0);
        human.setAttck(attackValue);
    }
    public static void main(String[] args){
        new Combat();
    }

}
