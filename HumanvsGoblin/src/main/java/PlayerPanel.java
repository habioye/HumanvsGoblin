import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class PlayerPanel extends JPanel {
    private Image image;
    ArrayList<PlayerAsset> players;

    //Constructor that accepts a file path to the image
    public PlayerPanel(ArrayList<PlayerAsset> players) {
        this.players = players;
    }
    // Method to load the image
    private void loadImage(String imagePath) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        image = imageIcon.getImage();
        
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

//        if (image != null) {
            // Draw the image at position (0, 0) and scale it to the panel size
//            System.out.println("painted the component");
            for (var player: players) {
                loadImage(player.path);
                g.drawImage(image,player.x,player.y,player.width,player.height,this);

            }
//            g.drawImage(image, x, y, width,height, this);
//            ImageIcon  imgicn = new ImageIcon("assets/goblin.png");
//            Image img2 = imgicn.getImage();
//            g.drawImage(img2,80,80,20,20,this);

//            g.drawRect(x,y,width,height);
//        }
    }
}