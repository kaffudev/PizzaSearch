package pl.szymonkamil.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import pl.szymonkamil.models.services.PizzaModel;
import pl.szymonkamil.models.services.PizzaObserver;
import pl.szymonkamil.models.services.PizzaService;


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

    public void initialize(URL location, ResourceBundle resources) {


        listType.getItems().addAll("Pizza", "Bar", "Pub", "Restaurant", "Cafe");

        listType.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        buttonSend.setOnMouseClicked(e -> showPizza());

        pizzaService.registerObserver(this);

    }

    private void showPizza() {

        String chosedType = (String)listType.getSelectionModel().getSelectedItem();
        System.out.println(chosedType);
        pizzaService.makeCall(textCity.getText(), Integer.valueOf(textRadius.getText()),chosedType);

    }

    @Override
    public void onPizzaUpdate(Optional<PizzaModel> model) {
        if (model.isPresent()){

            Platform.runLater(()->labelResponse.setText(model.get().printPizza()));
        }else {

            Platform.runLater(()->labelResponse.setText("Wprowadz inne dane."));

        }

    }
}
