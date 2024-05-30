import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Grid extends JPanel {
    int gridsize;
    int units;
    MoveHandler moveHandler;
    public Grid(int gridsize, int units) {
        setSize(900,900);
        setVisible(true);
        this.gridsize = gridsize;
        this.units = units;
        moveHandler = new MoveHandler();

        this.addKeyListener(moveHandler);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension((gridsize*units)+100,(gridsize*units)+100);
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
