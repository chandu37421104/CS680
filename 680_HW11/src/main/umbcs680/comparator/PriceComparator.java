package umbcs680.comparator;

import java.util.Comparator;

public class PriceComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        return Float.compare(car1.getPrice(), car2.getPrice());
    }
}
