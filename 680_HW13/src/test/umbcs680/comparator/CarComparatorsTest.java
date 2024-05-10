
package umbcs680.comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        CarSorter.PriceComparator(cars); 
        assertEquals("Ford", cars.get(0).getMake(), "Expected the cheapest car to be 'Ford'");
        assertEquals("Tesla", cars.get(cars.size() - 1).getMake(), "Expected the most expensive car to be 'Tesla'");
    }

    @Test
    public void priceComparatorDescendingTest() {
        CarSorter.PriceComparator(cars);
        cars.sort(Car.priceComparator().reversed()); 
        assertEquals("Tesla", cars.get(0).getMake(), "Expected the most expensive car to be 'Tesla'");
        assertEquals("Ford", cars.get(cars.size() - 1).getMake(), "Expected the cheapest car to be 'Ford'");
    }

    @Test
    public void yearComparatorDescendingTest() {
        CarSorter.YearComparator(cars);
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
        CarSorter.MileageComparator(cars);
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
        CarSorter.paretoComparator(cars);
        assertEquals("Honda", cars.get(0).getMake(), "Expected the car with the least domination count to be 'Honda'");
        assertTrue(cars.get(cars.size() - 1).getDominationCount() > 0, "Expected the car with the most domination count at the end");
    }
}
