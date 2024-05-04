package umbcs680.color;

public class Image {
    private int height;
    private int width;
    private Color[][] pixels;

    public Image(int height, int width) {
        this.height = height;
        this.width = width;
        this.pixels = new Color[height][width];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Color getColor(int x, int y) {
        return pixels[x][y];
    }

    public void setColor(int x, int y, Color color) {
        pixels[x][y] = color;
    }
}
