package umbcs680.color;

public class Images {
    public static Image transform(Image image, ColorAdjuster adjuster) {
        Image adjusted = new Image(image.getHeight(), image.getWidth());
        for (int x = 0; x < image.getHeight(); x++) {
            for (int y = 0; y < image.getWidth(); y++) {
                adjusted.setColor(x, y, adjuster.adjust(image.getColor(x, y)));
            }
        }
        return adjusted;
    }
}

