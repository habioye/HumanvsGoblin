public class Image entends JPanel {
    int x,y;
    String path;
    private Image image;
    Image(String path, int posx, int posy) {
        x = posx;
        y = posy;
        this.path = path;

    }
    public Image LoadImage(String path) {
        image = new ImageIcon(path).getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,x,y,getWidth(),getHeight(),this);

    }
}