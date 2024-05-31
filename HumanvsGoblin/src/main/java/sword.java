
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class sword extends Item{
    public sword(){
        attack = 15;
		name = "Sword";
		itemId = ItemID.SWORD;
        
        image = new ImageIcon("assets/sword.png").getImage();          
        
    }
    public ImageIcon getImage(){
        return image;
    }
}
