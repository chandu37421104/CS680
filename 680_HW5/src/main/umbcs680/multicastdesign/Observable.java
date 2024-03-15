package umbcs680.multicastdesign;

import java.util.ArrayList;
import java.util.List;

public interface Observable {
    List<Observer> getObservers();

    default void attach(Observer observer) {
        getObservers().add(observer);
    }

    default void detach(Observer observer) {
        getObservers().remove(observer);
    }

     default int countObservers() {
        return getObservers().size();
    }

    default void clearObservers() {
        getObservers().clear();
    }

    default void notifyObservers(String message) {
        for (Observer observer : getObservers()) {
            observer.update(message);
        }
    }
}

