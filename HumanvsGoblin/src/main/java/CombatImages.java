import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
public class CombatImages extends JPanel {
    int gridsize;
    int units;
    ArrayList<ModelAsset> players;
    String path;

    //    String path;
    MoveHandler moveHandler;
    java.awt.Image image;

    public CombatImages (ArrayList<ModelAsset> players) {
        setSize(900, 900);
        setVisible(true);
        setBackground(Color.DARK_GRAY);
        moveHandler = new MoveHandler();
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
        return new Dimension((gridsize * units) + 100, (gridsize * units) + 100);
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        loadImage(path);
        for (var player : players) {
            loadImage(player.path);
            g.drawImage(image, player.x, player.y, player.width, player.height, this);
        }
    }


}
