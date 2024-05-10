package umbcs680.comparator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CarSorter {

    public static void PriceComparator(List<Car> cars) {
        Collections.sort(cars, Comparator.comparingDouble(Car::getPrice));
    }

    public static void YearComparator(List<Car> cars) {
        Collections.sort(cars, Comparator.comparingInt(Car::getYear).reversed());
    }

    public static void MileageComparator(List<Car> cars) {
        Collections.sort(cars, Comparator.comparingInt(Car::getMileage));
    }

    public static void paretoComparator(List<Car> cars) {
        Car.setParetoDominationCounts(cars); 
        Collections.sort(cars, Comparator.comparingInt(Car::getDominationCount));
    }
}
