package pl.szymonkamil.controllers;

import javafx.fxml.Initializable;
import pl.szymonkamil.models.services.PizzaService;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

PizzaService pizzaService = PizzaService.getPizzaService();

    public void initialize(URL location, ResourceBundle resources) {

        pizzaService.makeCall("cracow");

    }
}
