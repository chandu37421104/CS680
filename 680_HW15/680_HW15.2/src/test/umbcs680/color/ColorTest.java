package umbcs680.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ColorTest {

    private Image testImage;
    private ColorAdjuster grayScaleAdjuster;

    @BeforeEach
    public void setup() {
        testImage = new Image(2, 2);
        testImage.setColor(0, 0, new Color(255, 0, 0)); // Red
        testImage.setColor(0, 1, new Color(0, 255, 0)); // Green
        testImage.setColor(1, 0, new Color(0, 0, 255)); // Blue
        testImage.setColor(1, 1, new Color(255, 255, 0)); // Yellow

        grayScaleAdjuster = color -> {
            int avg = (color.getRedScale() + color.getGreenScale() + color.getBlueScale()) / 3;
            return new Color(avg, avg, avg);
        };
    }

    @Test
    public void RedGrayScaleAdjusterTest() {
        assertEquals(new Color(85, 85, 85), grayScaleAdjuster.adjust(new Color(255, 0, 0)), "Red to grayscale");
        }

    @Test
    public void BlueGrayScaleAdjusterTest() {
        assertEquals(new Color(85, 85, 85), grayScaleAdjuster.adjust(new Color(0, 0, 255)), "Blue to grayscale");
    }

    @Test
    public void GreenGrayScaleAdjusterTest() {
        assertEquals(new Color(85, 85, 85), grayScaleAdjuster.adjust(new Color(0, 255, 0)), "Green to grayscale");
    }

    @Test
    public void RGBGrayScaleAdjusterTest() {
        assertEquals(new Color(170, 170, 170), grayScaleAdjuster.adjust(new Color(255, 255, 0)), "Yellow to grayscale");
    }



    @Test
    public void RedImageTransformationTest() {
        Image transformedImage = Images.transform(testImage, grayScaleAdjuster);
        assertEquals(grayScaleAdjuster.adjust(testImage.getColor(0, 0)), transformedImage.getColor(0, 0), "Red pixel transformation");
    }
    
    @Test
    public void BlueImageTransformationTest() {
        Image transformedImage = Images.transform(testImage, grayScaleAdjuster);
        assertEquals(grayScaleAdjuster.adjust(testImage.getColor(0, 1)), transformedImage.getColor(0, 1), "Green pixel transformation");
    }

    @Test
    public void GreenImageTransformationTest() {
        Image transformedImage = Images.transform(testImage, grayScaleAdjuster);
        assertEquals(grayScaleAdjuster.adjust(testImage.getColor(1, 0)), transformedImage.getColor(1, 0), "Blue pixel transformation");
    }

    @Test
    public void YellowImageTransformationTest() {
        
        Image transformedImage = Images.transform(testImage, grayScaleAdjuster);
        assertEquals(grayScaleAdjuster.adjust(testImage.getColor(1, 1)), transformedImage.getColor(1, 1), "Yellow pixel transformation");
    }
    
}
