import java.awt.*;
import javax.swing.*;

public class Grid extends JPanel {
    public Grid() {
        setSize(500,500);
        setVisible(true);
    }



    @Override
    public void paint(Graphics g) {
        int gridsize = 40;
        int units = 20;
     for (int x = gridsize; x <= (gridsize*units); x+=gridsize) {
         for (int y = gridsize; y <= (gridsize*units); y+=gridsize) {
             g.drawRect(x,y,gridsize,gridsize);
         }
        }
    }



}
