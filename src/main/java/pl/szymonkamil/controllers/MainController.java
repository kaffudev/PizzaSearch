package pl.szymonkamil.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pl.szymonkamil.models.services.PizzaModel;
import pl.szymonkamil.models.services.PizzaObserver;
import pl.szymonkamil.models.services.PizzaService;


import javax.swing.*;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable, PizzaObserver {

    @FXML
    Button buttonSend;
    @FXML
    TextField textCity;
    @FXML
    Label labelResponse;


PizzaService pizzaService = PizzaService.getPizzaService();

    public void initialize(URL location, ResourceBundle resources) {

        buttonSend.setOnMouseClicked(e -> showPizza());

        pizzaService.registerObserver(this);



    }

    private void showPizza() {

        pizzaService.makeCall(textCity.getText());

    }

    @Override
    public void onPizzaUpdate(Optional<PizzaModel> model) {
        if (model.isPresent()){

            Platform.runLater(()->labelResponse.setText(model.get().printPizza()));
        }else {

            JFrame jFrame = new JFrame("Uwaga !");


        }



    }
}
