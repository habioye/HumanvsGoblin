import java.awt.*;
import javax.swing.*;

public class HumanvsGoblin {
    public static void main(String[] args) {
        ImagePanel humanAsset = new ImagePanel(10,10,40,40,"assets/human.jpeg");
        ImagePanel goblinAsset = new ImagePanel(100,100,40,40,"assets/goblin.jpeg");

//        humanAsset.setPreferredSize(new Dimension(500,500));
//        goblinAsset.setPreferredSize(new Dimension(50,50));

        Grid grid =  new Grid(40,20);

        JFrame window = new JFrame("Grid");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(grid);
        window.add(humanAsset);
        window.add(goblinAsset);


        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setSize(900,900);


        boolean humanT = true;
        Player humnan = new Player();
        Player goblin = new Player();


        while (true) {
            if (humanT) {


            } else {

            }


            humanT = !humanT;
        }
    }

}
