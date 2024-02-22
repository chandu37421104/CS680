package umbcs680.arraytoarray;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private String[] carToStringArray(Car car) {
        return new String[]{car.getMake(), car.getModel(), String.valueOf(car.getYear())};
    }

    @Test
    void arrayToArrayComparisionWithMakeModelYear() {
        
        String[] expected = {"Toyota", "RAV4", "2018"};

        
        Car actual = Car.createCar("Toyota", "RAV4", 2018, 25000.0f, 50000);

        
        assertArrayEquals(expected, carToStringArray(actual));
    }
}
