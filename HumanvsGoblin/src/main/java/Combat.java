import java.awt.*;
import javax.swing.*;

public class Combat {
    static JFrame f;
    static JLabel l;
    JFrame window;
    Container con;
    JPanel titleNamePanel, goblinHPPanel,PlayerHPPanel, goblinPanel;
    JProgressBar GoblinHealthBar, playerHealthBar;
    JLabel playerHealthLabel, goblinLabel;
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
        GoblinHealthBar.setValue(50);
        GoblinHealthBar.setBackground(Color.RED);
        GoblinHealthBar.setStringPainted(true);
        GoblinHealthBar.setString("Goblin HP: "+GoblinHealthBar.getValue());
        goblinHPPanel.add(GoblinHealthBar);

        ImageIcon goblin = new ImageIcon("HumanvsGoblin/src/main/java/assets/pngtree-goblin-cartoon-png-image_4008070.jpeg","Goblin image");
        goblinLabel = new JLabel(goblin);
        //goblinPanel = new JPanel();
        goblin.setImage(goblin.getImage());
        window.add(goblinLabel);
        //window.pack();

        PlayerHPPanel = new JPanel();
        PlayerHPPanel.setBounds(50,500,150,30);
        PlayerHPPanel.setBackground(Color.BLACK);
        con.add(PlayerHPPanel);

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

    }
    //public void Display();
    public static void main(String[] args){
        //combatDisplay();
        //CD1();
        new Combat();
    }

}
