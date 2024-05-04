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

        grayScaleAdjuster = new GrayScaleAdjuster();
    }

    @Test
    public void RedGrayScaleAdjusterTest() {
        assertEquals(new Color(85, 85, 85), grayScaleAdjuster.adjust(new Color(255, 0, 0)));
        }

    @Test
    public void BlueGrayScaleAdjusterTest() {
        assertEquals(new Color(85, 85, 85), grayScaleAdjuster.adjust(new Color(0, 0, 255)));
    }

    @Test
    public void GreenGrayScaleAdjusterTest() {
        assertEquals(new Color(85, 85, 85), grayScaleAdjuster.adjust(new Color(0, 255, 0)));
        }
    @Test
    public void RGBGrayScaleAdjusterTest() {
        assertEquals(new Color(170, 170, 170), grayScaleAdjuster.adjust(new Color(255, 255, 0)));
    }



    @Test
    public void RedImageTransformationTest() {
        Image transformedImage = Images.transform(testImage, grayScaleAdjuster);
        Color expectedGrayRed = grayScaleAdjuster.adjust(testImage.getColor(0, 0));
        assertEquals(expectedGrayRed, transformedImage.getColor(0, 0));
    }

    @Test
    public void BlueImageTransformationTest() {
        Image transformedImage = Images.transform(testImage, grayScaleAdjuster);
        Color expectedGrayBlue = grayScaleAdjuster.adjust(testImage.getColor(1, 0));
        assertEquals(expectedGrayBlue, transformedImage.getColor(1, 0));
    }

    @Test
    public void GreenImageTransformationTest() {
        Image transformedImage = Images.transform(testImage, grayScaleAdjuster);
        Color expectedGrayGreen = grayScaleAdjuster.adjust(testImage.getColor(0, 1));
        assertEquals(expectedGrayGreen, transformedImage.getColor(0, 1));
    }

    @Test
    public void YellowImageTransformationTest() {
        
        Image transformedImage = Images.transform(testImage, grayScaleAdjuster);
        Color expectedGrayYellow = grayScaleAdjuster.adjust(testImage.getColor(1, 1));
        assertEquals(expectedGrayYellow, transformedImage.getColor(1, 1));
    }
}
