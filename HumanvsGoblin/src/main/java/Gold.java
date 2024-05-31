import java.awt.image.BufferedImage;
import java.awt.image.ImagingOpException;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Gold extends Item {


	public Gold() {
		name = "Gold";
		itemId = ItemID.GOLD;
		try {
            ImageIcon imageIcon = new ImageIcon("assets/gold.png");
			image = imageIcon.getImage();
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
	}

	public ImageIcon getImage(){
		return image;
	}
}
