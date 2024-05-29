import java.awt.*;
import javax.swing.*;

public class Combat {
    static JFrame f;
    static JLabel l;
    JFrame window;
    Container con;
    JPanel titleNamePanel, goblinHPPanel,PlayerHPPanel;
    JProgressBar GoblinHealthBar;
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
        goblinHPPanel.setBackground(Color.GREEN);
        window.getContentPane().add(goblinHPPanel);
        con.add(goblinHPPanel);

        ImageIcon goblin = new ImageIcon("C:\\Users\\Tman4\\OneDrive\\Pictures\\gobby.jpg");
        window.add(new JLabel(goblin));
        window.pack();

        PlayerHPPanel = new JPanel();
        PlayerHPPanel.setBounds(50,500,150,30);
        PlayerHPPanel.setBackground(Color.BLUE);
        con.add(PlayerHPPanel);

        GoblinHealthBar = new JProgressBar(0,100);
        GoblinHealthBar.setPreferredSize(new Dimension(150,30));
        GoblinHealthBar.setValue(50);
        goblinHPPanel.add(GoblinHealthBar);

        window.setVisible(true);
    }
    //public void Display();
    public static void main(String[] args){
        //combatDisplay();
        //CD1();
        //new Combat();
        JFrame frame = new JFrame("My first JFrame");
        frame.setSize(600, 600);  
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\Tman4\\OneDrive\\Pictures\\Goblin.webp").getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH)));
        frame.add(label);
        frame.pack();
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }

}
