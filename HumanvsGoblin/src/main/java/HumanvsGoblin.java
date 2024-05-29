import java.awt.*;
import javax.swing.*;

public class HumanvsGoblin {
    public static void main(String[] args) {

        JFrame window = new JFrame("Grid");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(new Grid());
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);


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
