import java.awt.*;
import javax.swing.*;

class ModelAsset {
    int x,y;
    int width, height;
    String path;
    boolean obstacle;
//    Image image;
    public ModelAsset(int x, int y, int width, int height, String path) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.path = path;
        this.obstacle = false;

    }
    


}