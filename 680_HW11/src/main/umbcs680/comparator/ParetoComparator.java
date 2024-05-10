package umbcs680.comparator;

import java.util.Comparator;
import java.util.List;

public class ParetoComparator implements Comparator<Car> {
    public void setDominationCounts(List<Car> cars) {
        for (Car car : cars) {
            int dominationCount = 0;
            for (Car other : cars) {
                if (dominates(other, car)) {
                    dominationCount++;
                }
            }
            car.setDominationCount(dominationCount);
        }
    }

    @Override
    public int compare(Car car1, Car car2) {
        return Integer.compare(car1.getDominationCount(), car2.getDominationCount());
    }

    private boolean dominates(Car carA, Car carB) {
        boolean allEqualOrBetter = carA.getPrice() <= carB.getPrice() &&
                                   carA.getYear() >= carB.getYear() &&
                                   carA.getMileage() <= carB.getMileage();
        boolean strictlyBetterInOne = carA.getPrice() < carB.getPrice() ||
                                      carA.getYear() > carB.getYear() ||
                                      carA.getMileage() < carB.getMileage();

        return allEqualOrBetter && strictlyBetterInOne;
    }
}
