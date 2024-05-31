import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class Grid extends JPanel {
    int gridsize;
    int units;
    ArrayList<PlayerAsset> players;
    String path;

//    String path;
    MoveHandler moveHandler;
    Image image;
    public Grid(int gridsize, int units, ArrayList<PlayerAsset> players, String path) {
        setSize(900,900);
        setVisible(true);
        this.gridsize = gridsize;
        this.units = units;
        moveHandler = new MoveHandler();
        this.path = path;
        loadImage(path);
        this.players = players;


        this.addKeyListener(moveHandler);

    }

    // Method to load the image
    private void loadImage(String imagePath) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        this.image = imageIcon.getImage();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension((gridsize*units)+100,(gridsize*units)+100);
    }



    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.drawImage(image,100,100,gridsize,gridsize,this);
        loadImage(path);


     for (int x = gridsize; x <= (gridsize*units); x+=gridsize) {
         for (int y = gridsize; y <= (gridsize*units); y+=gridsize) {
//             g.drawRect(x,y,gridsize,gridsize);
             g.drawImage(image,x,y,gridsize,gridsize,this);
         }
        }
    for (var player: players) {
        loadImage(player.path);
        g.drawImage(image,player.x,player.y,player.width,player.height,this);

    }
    }



}
