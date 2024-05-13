package umbcs680.comparator;
import java.util.Comparator;
import java.util.List;

public class Car {
    private String make, model;
    private int year;
    private float price;
    private int mileage;
    private int dominationCount;

    
    Car(String make, String model, int year, float price, int mileage) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.mileage = mileage;
        this.dominationCount = 0;
    }

    
    public static Car createCar(String make, String model, int year, float price, int mileage) {
        return new Car(make, model, year, price, mileage);
    }

    
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public float getPrice() {
        return price;
    }

    public int getMileage() {
        return mileage;
    }

    public int getDominationCount() {
        return dominationCount;
    }

    public void setDominationCount(int dominationCount) {
        this.dominationCount = dominationCount;
    }

    @Override
    public String toString() {
        return String.format("%s %s (Year: %d, Price: %.2f, Mileage: %d, Domination Count: %d)", 
                             make, model, year, price, mileage, dominationCount);
    }

    public static Comparator<Car> priceComparator() {
        return Comparator.comparingDouble(Car::getPrice);
    }

    public static Comparator<Car> yearComparator() {
        return Comparator.comparingInt(Car::getYear).reversed();
    }

    public static Comparator<Car> mileageComparator() {
        return Comparator.comparingInt(Car::getMileage);
    }

    public static void setParetoDominationCounts(List<Car> cars) {
        cars.forEach(car -> {
            long count = cars.stream()
                             .filter(other -> dominates(other, car))
                             .count();
            car.setDominationCount((int) count);
        });
    }

    public static Comparator<Car> paretoComparator() {
        return Comparator.comparingInt(Car::getDominationCount);
    }

    private static boolean dominates(Car carA, Car carB) {
        boolean allEqualOrBetter = carA.getPrice() <= carB.getPrice() &&
                                   carA.getYear() >= carB.getYear() &&
                                   carA.getMileage() <= carB.getMileage();
        boolean strictlyBetterInOne = carA.getPrice() < carB.getPrice() ||
                                      carA.getYear() > carB.getYear() ||
                                      carA.getMileage() < carB.getMileage();

        return allEqualOrBetter && strictlyBetterInOne;
    }
}
