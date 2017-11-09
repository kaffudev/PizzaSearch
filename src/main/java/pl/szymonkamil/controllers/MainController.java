package pl.szymonkamil.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import pl.szymonkamil.models.services.FoodType;
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
    @FXML
    TextField textRadius;
    @FXML
    ListView listType;



    PizzaService pizzaService = PizzaService.getPizzaService();

    //FoodType foodType = FoodType.BAR;
    FoodType foodType;


    public void initialize(URL location, ResourceBundle resources) {


        listType.getItems().addAll("Pizza", "Bar", "Pub", "Restaurant");
        listType.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        buttonSend.setOnMouseClicked(e -> showPizza());

        pizzaService.registerObserver(this);


        pizzaService.makeCall("Warszawa", 10000, foodType );


    }

    private void showPizza() {

        pizzaService.makeCall(textCity.getText());

    }

    @Override
    public void onPizzaUpdate(Optional<PizzaModel> model) {
        if (model.isPresent()) {

            Platform.runLater(() -> labelResponse.setText(model.get().printPizza()));
        } else {

            Platform.runLater(() -> labelResponse.setText("Wprowadz inne dane."));

        }
        System.out.println(model.isPresent());


    }
}
