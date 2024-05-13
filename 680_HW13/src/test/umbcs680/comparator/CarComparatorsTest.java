
package umbcs680.comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarComparatorsTest {
    private List<Car> cars;

    @BeforeEach
    public void setup() {
        cars = new ArrayList<>();
        cars.add(Car.createCar("Toyota", "Camry", 2018, 22000, 35000));
        cars.add(Car.createCar("Honda", "Civic", 2019, 21000, 32000));
        cars.add(Car.createCar("Ford", "Focus", 2017, 19000, 45000));
        cars.add(Car.createCar("Tesla", "Model 3", 2020, 25000, 10000));
        cars.add(Car.createCar("Nissan", "Altima", 2018, 23000, 37000));
    }

    @Test
    public void priceComparatorAscendingTest() {
        cars.sort(Car.priceComparator());
        assertEquals("Ford", cars.get(0).getMake(), "Expected the cheapest car to be 'Ford'");
        assertEquals("Tesla", cars.get(cars.size() - 1).getMake(), "Expected the most expensive car to be 'Tesla'");
    }

    @Test
    public void priceComparatorDescendingTest() {
        cars.sort(Car.priceComparator().reversed());
        assertEquals("Tesla", cars.get(0).getMake(), "Expected the most expensive car to be 'Tesla'");
        assertEquals("Ford", cars.get(cars.size() - 1).getMake(), "Expected the cheapest car to be 'Ford'");
    }

    @Test
    public void yearComparatorDescendingTest() {
        cars.sort(Car.yearComparator());
        assertEquals("Tesla", cars.get(0).getMake(), "Expected the newest car to be 'Tesla'");
        assertEquals("Ford", cars.get(cars.size() - 1).getMake(), "Expected the oldest car to be 'Ford'");
    }

    @Test
    public void yearComparatorAscendingTest() {
        cars.sort(Car.yearComparator().reversed());
        assertEquals("Ford", cars.get(0).getMake(), "Expected the oldest car to be 'Ford'");
        assertEquals("Tesla", cars.get(cars.size() - 1).getMake(), "Expected the newest car to be 'Tesla'");
    }

    @Test
    public void mileageComparatorAscendingTest() {
        cars.sort(Car.mileageComparator());
        assertEquals("Tesla", cars.get(0).getMake(), "Expected the car with the least mileage to be 'Tesla'");
        assertEquals("Ford", cars.get(cars.size() - 1).getMake(), "Expected the car with the most mileage to be 'Ford'");
    }

    @Test
    public void mileageComparatorDescendingTest() {
        cars.sort(Car.mileageComparator().reversed());
        assertEquals("Ford", cars.get(0).getMake(), "Expected the car with the most mileage to be 'Ford'");
        assertEquals("Tesla", cars.get(cars.size() - 1).getMake(), "Expected the car with the least mileage to be 'Tesla'");
    }

    @Test
    public void paretoComparatorTest() {
        Car.setParetoDominationCounts(cars); 
        cars.sort(Car.paretoComparator());
        assertTrue(cars.get(0).getDominationCount() <= cars.get(cars.size() - 1).getDominationCount(), "Expected the car with the least domination count at the beginning");
    }
}
