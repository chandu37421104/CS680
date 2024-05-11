package umbcs680.color;

public class GrayScaleAdjuster implements ColorAdjuster {
    @Override
    public Color adjust(Color color) {
        int avg = (color.getRedScale() + color.getGreenScale() + color.getBlueScale()) / 3;
        return new Color(avg, avg, avg);
    }
}
