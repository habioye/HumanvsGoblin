
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class sword extends Item{
    public sword(){
        attack = 15;
		name = "Sword";
		itemId = ItemID.SWORD;
        try {
            image = ImageIO.read(new File("assets/sword.png"));
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    public BufferedImage getImage(){
        return image;
    }
}