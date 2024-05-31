import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Gold extends Item {


	public Gold() {
		name = "Gold";
		itemId = ItemID.GOLD;
		try {
            image = ImageIO.read(new File("assets/gold.png"));
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
	}
	
	public BufferedImage getImage(){
		return image;
	}
}
