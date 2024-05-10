package umbcs680.multicastdesign;

import java.util.List;
import java.util.function.Consumer;

public interface Observable {
    List<Consumer<String>> getObservers();

    default void attach(Consumer<String> observer) {
        getObservers().add(observer);
    }

    default void detach(Consumer<String> observer) {
        getObservers().remove(observer);
    }

    default int countObservers() {
        return getObservers().size();
    }

    default void clearObservers() {
        getObservers().clear();
    }

    default void notifyObservers(String message) {
        getObservers().forEach(observer -> observer.accept(message));
    }
}

