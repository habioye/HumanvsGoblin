import java.awt.*;
import javax.swing.*;

public class Grid extends JPanel {
    int gridsize;
    int units;
    public Grid(int gridsize, int units) {
        setSize(500,500);
        setVisible(true);
        this.gridsize = gridsize;
        this.units = units;

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(gridsize*units+100,gridsize*units+100);
    }


    @Override
    public void paint(Graphics g) {
     for (int x = gridsize; x <= (gridsize*units); x+=gridsize) {
         for (int y = gridsize; y <= (gridsize*units); y+=gridsize) {
             g.drawRect(x,y,gridsize,gridsize);
         }
        }
    }



}
