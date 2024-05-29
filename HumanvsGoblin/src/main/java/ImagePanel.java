import java.awt.*;
import javax.swing.*;

public class ImagePanel extends JPanel {
    int x,y;
    int width, height;
//    String path;
    private Image image;
    ImagePanel(int posx, int posy,int width, int height, String path) {
        x = posx;
        y = posy;
//        this.path = path;
        LoadImage(path);
        this.width = width;
        this.height = height;
        setSize(width,height);


    }
    public void LoadImage(String path) {
        image = new ImageIcon(path).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            System.out.println("Painting at "+x+y);
        g.drawImage(image,x,y,width, height,this);
        } else {
            System.out.println("THe image is null!!!1");
        }

    }
}