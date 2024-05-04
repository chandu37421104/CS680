package umbcs680.color;

public class Color {
    private int red;
    private int green;
    private int blue;

    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRedScale() {
        return red;
    }

    public int getGreenScale() {
        return green;
    }

    public int getBlueScale() {
        return blue;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Color color = (Color) obj;
        return red == color.red &&
               green == color.green &&
               blue == color.blue;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + red;
        result = 31 * result + green;
        result = 31 * result + blue;
        return result;
    }
}
