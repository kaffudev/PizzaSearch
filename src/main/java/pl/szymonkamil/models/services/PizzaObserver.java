package pl.szymonkamil.models.services;

import java.util.Optional;

public interface PizzaObserver {
    void onPizzaUpdate(Optional<PizzaModel> model);
}
