import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class Grid extends JPanel {
    int gridsize;
    int units;
    ArrayList<ModelAsset> players;
    String path;

    //    String path;
    MoveHandler moveHandler;
    Image image;

    // Constructor
    public Grid(int gridsize, int units, ArrayList<ModelAsset> players, String path) {
        setSize(900, 900);
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

    // Changes the dimensions for the panel
    @Override
    public Dimension getPreferredSize() {
        return new Dimension((gridsize * units) + 100, (gridsize * units) + 100);
    }


//    Draws the assets for the main grid such as: Grass, obstacles, player, goblin, etc.
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        loadImage(path);


        for (int x = gridsize; x <= (gridsize * units); x += gridsize) {
            for (int y = gridsize; y <= (gridsize * units); y += gridsize) {
                g.drawImage(image, x, y, gridsize, gridsize, this);
            }
        }
        for (var player : players) {
            loadImage(player.path);
            g.setColor(Color.BLUE);
            g.drawImage(image, player.x, player.y, player.width, player.height, this);
            if (player.obstacle) continue;
            g.drawRect(player.x - 40, player.y, gridsize, gridsize); // left
            g.drawRect(player.x + 40, player.y, gridsize, gridsize); // right
            g.drawRect(player.x, player.y - 40, gridsize, gridsize); // top
            g.drawRect(player.x, player.y + 40, gridsize, gridsize); // bottom

        }
    }


}
