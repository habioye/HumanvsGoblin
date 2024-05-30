import java.awt.*;
import java.awt.image.CropImageFilter;

import javax.swing.*;

public class Combat {
    static JFrame f;
    static JLabel l;
    JFrame window;
    Container con;
    JPanel titleNamePanel, goblinHPPanel,PlayerHPPanel, goblinPanel, fightPanel, invetoryPanel, inspectPanel;
    JProgressBar GoblinHealthBar, playerHealthBar;
    JLabel playerHealthLabel, goblinLabel, humanLabel;
    JButton fightButton, invetoryButton, inspectButton;
    int playerH,goblinHP;
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

        GoblinHealthBar = new JProgressBar(0,100);
        GoblinHealthBar.setPreferredSize(new Dimension(150,30));
        //Set HP goblin value
        GoblinHealthBar.setValue(50);
        GoblinHealthBar.setBackground(Color.RED);
        GoblinHealthBar.setStringPainted(true);
        GoblinHealthBar.setString("Goblin HP: "+GoblinHealthBar.getValue());
        goblinHPPanel.add(GoblinHealthBar);

        ImageIcon goblin = new ImageIcon("HumanvsGoblin/src/main/java/assets/pngtree-goblin-cartoon-png-image_4008070.jpeg","Goblin image");
        goblin.setImage(goblin.getImage());
        goblinLabel = new JLabel(goblin);
        //goblinPanel = new JPanel();
        window.add(goblinLabel);

        ImageIcon human = new ImageIcon("C:/Users/Tman4/OneDrive/Documents/Java Training/HumanvsGoblin/HumanvsGoblin/src/main/java/assets/human.jpeg");
        human.setImage(human.getImage());
        humanLabel = new JLabel(human);
        window.add(humanLabel);

        PlayerHPPanel = new JPanel();
        PlayerHPPanel.setBounds(50,500,150,30);
        PlayerHPPanel.setBackground(Color.BLACK);
        window.add(PlayerHPPanel);

        playerHealthBar = new JProgressBar(0,100);
        playerHealthBar.setPreferredSize(new Dimension(150,30));
        playerHealthBar.setValue(50);
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
        fightPanel = new JPanel();
        fightPanel.setBounds(100,450,150,30);
        fightPanel.setBackground(Color.black);
        fightPanel.add(fightButton);
        window.add(fightPanel);
        
        invetoryButton = new JButton("Inventory");
        invetoryButton.setBackground(Color.black);
        invetoryButton.setForeground(Color.WHITE);
        invetoryButton.setFocusPainted(false);
        invetoryPanel = new JPanel();
        invetoryPanel.setBounds(100, 475,150,30);
        invetoryPanel.setBackground(Color.black);
        invetoryPanel.add(invetoryButton);
        window.add(invetoryPanel);


        inspectButton = new JButton("Inspect");
        inspectButton.setBackground(Color.black);
        inspectButton.setForeground(Color.WHITE);
        inspectButton.setFocusPainted(false);
        inspectPanel = new JPanel();
        inspectPanel.setBounds(200,450,150,30);
        inspectPanel.setBackground(Color.black);
        inspectPanel.add(inspectButton);
        window.add(inspectPanel);

    }
    //public void Display();
    public static void main(String[] args){
        //combatDisplay();
        //CD1();
        new Combat();
    }

}
